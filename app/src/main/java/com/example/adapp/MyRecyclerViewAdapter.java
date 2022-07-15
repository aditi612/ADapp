package com.example.adapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    private final ArrayList<Users> mList;

    public MyRecyclerViewAdapter(ArrayList<Users> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String name = "Name: " + mList.get(position).getName();
        holder.nameTextView.setText(name);

        String dob = "DOB: " + mList.get(position).getDob();
        holder.dobTextView.setText(dob);

        String phones = "Phone: " + mList.get(position).getPhones();
        holder.phonesTextView.setText(phones);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameTextView;
        private final TextView dobTextView;
        private final TextView phonesTextView;

        public MyViewHolder(View view) {
            super(view);

            nameTextView = view.findViewById(R.id.textViewName);
            dobTextView = view.findViewById(R.id.textViewDob);
            phonesTextView = view.findViewById(R.id.textViewPhones);
        }
    }
}
