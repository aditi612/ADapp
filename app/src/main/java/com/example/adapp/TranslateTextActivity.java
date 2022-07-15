package com.example.adapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;

import java.io.IOException;
import java.io.InputStream;


public class TranslateTextActivity extends AppCompatActivity implements View.OnClickListener{
    private static String TAG = "TRANSLATEFILE";
    //TextView textView;
    //private EditText editText;
    //private TextView textView;
    private TextView dispText;

    private Translator translatorHindi;
    private Translator translatorKorean;
    private Translator translatorFrench;

    private Boolean booleanHindi=false;
    private Boolean booleanKorean=false;
    private Boolean booleanFrench=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.translate_text);


                //editText = findViewById(R.id.editText);
                //textView = findViewById(R.id.textView);
                dispText = findViewById(R.id.textView2);
                findViewById(R.id.button).setOnClickListener((View.OnClickListener) this);
                TranslatorOptions optionsHindi = new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.HINDI)
                        .build();
                TranslatorOptions optionsKorean = new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.KOREAN)
                        .build();
                TranslatorOptions optionsFrench = new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.KANNADA)
                        .build();

                translatorHindi = Translation.getClient(optionsHindi);
                translatorKorean = Translation.getClient(optionsKorean);
                translatorFrench = Translation.getClient(optionsFrench);

                downloadModel();
            }
            public void getTextFile(View view) {

                String data = "";
                try {
                    InputStream inputStream = getAssets().open("data.txt");
                    int size = inputStream.available();
                    byte[] buffer = new byte[size];
                    inputStream.read(buffer);
                    data = new String(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                dispText.setText(data);

            }



            private void downloadModel(){
                DownloadConditions conditions = new DownloadConditions.Builder()
                        .requireWifi()
                        .build();

                translatorHindi.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Log.d(TAG, "Hindi Model ");
                                Toast.makeText(TranslateTextActivity.this,"Hello",Toast.LENGTH_LONG).show();
                                booleanHindi=true;
                            }

                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d(TAG, "Hindi Model download failed");
                                booleanHindi=false;
                            }
                        });

                translatorKorean.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                booleanKorean=true;
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                booleanKorean=false;
                            }
                        });


                translatorFrench.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                booleanFrench=true;
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                booleanFrench=false;
                            }
                        });
            }

            public void buttonDownloadModel(View view){

                downloadModel();
            }
//            public void buttonHindi(View view){
//                if(booleanHindi){
//                    translatorHindi.translate(dispText.getText().toString())
//                            .addOnSuccessListener(new OnSuccessListener<String>() {
//                                @Override
//                                public void onSuccess(String s){
//                                    dispText.setText(s);
//
//                                }
//                            })
//                            .addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//                                    dispText.setText(e.toString());
//                                }
//                            });
//                }
//
//            }
            public void buttonKorean(View view){
                if(booleanKorean){
                    translatorKorean.translate(dispText.getText().toString())
                            .addOnSuccessListener(new OnSuccessListener<String>() {
                                @Override
                                public void onSuccess(String s) {
                                    dispText.setText(s);

                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    dispText.setText(e.toString());
                                }
                            });
                }
            }
            public void buttonFrench(View view){
                if(booleanFrench){
                    translatorFrench.translate(dispText.getText().toString())
                            .addOnSuccessListener(new OnSuccessListener<String>() {
                                @Override
                                public void onSuccess(String s) {
                                    dispText.setText(s);

                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    dispText.setText(e.toString());
                                }
                            });
                }
            }

            public void onClick(View view) {
                if (view.getId() == R.id.button) {
                    translatorHindi.translate(dispText.getText().toString())
                            .addOnSuccessListener(new OnSuccessListener<String>() {
                                @Override
                                public void onSuccess(String s) {
                                    dispText.setText(s);
                                    Log.d(TAG, "Hindi Model Translation");
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    dispText.setText(e.toString());
                                    Log.d(TAG, "Hindi Model Translation failed");
                                }
                            });
                }
            }
        }





