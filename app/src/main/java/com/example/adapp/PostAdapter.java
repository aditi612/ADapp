package com.example.adapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder>
{
    private final ArrayList<Posts> postsList;

    public PostAdapter(ArrayList<Posts> postsList)
    {
        this.postsList = postsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        String name = "Name: " + postsList.get(position).getName();
        holder.nameTextView.setText(name);

        String dob = "DOB: " + postsList.get(position).getDob();
        holder.dobTextView.setText(dob);

        String phones = "Phone: " + postsList.get(position).getPhones();
        holder.phonesTextView.setText(phones);

        String address = "Address: " + postsList.get(position).getAddress();
        holder.addressTextView.setText(address);
    }

    @Override
    public int getItemCount()
    {
        return postsList.size();
    }

    @Override
    public int getItemViewType(int position)
    {
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView nameTextView;
        private final TextView dobTextView;
        private final TextView phonesTextView;
        private final TextView addressTextView;

        public MyViewHolder(View view)
        {
            super(view);

            nameTextView = view.findViewById(R.id.textViewName);
            dobTextView = view.findViewById(R.id.textViewDob);
            phonesTextView = view.findViewById(R.id.textViewPhones);
            addressTextView = view.findViewById(R.id.textViewAddress);
        }
    }
}

