package com.example.task51additional;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;

public class PropertyAdaptor extends RecyclerView.Adapter<PropertyAdaptor.MyViewHolder> {

    Context mContext;
    ArrayList<PropertyItem> propertyList;

    //constructor for use in MainAcitivty
    public PropertyAdaptor(Context mContext, ArrayList<PropertyItem> propertyList) {
        this.mContext = mContext;
        this.propertyList = propertyList;
    }

    @NonNull
    @Override
    public PropertyAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating the layout
        View view = LayoutInflater.from(mContext).inflate(R.layout.propertyrecyclerview_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PropertyAdaptor.MyViewHolder holder, int position) {
        //attach data to the layout
        holder.propertyAddressTextView.setText(propertyList.get(position).getAddress());
        Glide.with(holder.propertyImageView).load(propertyList.get(position).getImageUrl()).into(holder.propertyImageView);
        holder.propertyDescriptionTextView.setText(propertyList.get(position).getDescription());
        holder.costTextView.setText("$" + propertyList.get(position).getCost() + " Per Week");
        holder.bedroomsTextView.setText(propertyList.get(position).getBedrooms() + " Bedrooms");
        holder.carparksTextView.setText(propertyList.get(position).getCarparks() + " Carparks");
        holder.bathroomsTextView.setText(propertyList.get(position).getBathrooms() + " Bathrooms");
    }

    @Override
    public int getItemCount() {
        //get the size of the arrayList
        return propertyList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView propertyAddressTextView;
        ImageView propertyImageView;

        TextView propertyDescriptionTextView;

        TextView costTextView, bedroomsTextView, carparksTextView, bathroomsTextView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //attach view items to variables
            propertyAddressTextView = itemView.findViewById(R.id.propertyAddressTextView);
            propertyImageView = itemView.findViewById(R.id.propertyImageView);
            propertyDescriptionTextView = itemView.findViewById(R.id.propertyDescriptionTextView);
            costTextView = itemView.findViewById(R.id.costTextView);
            bedroomsTextView = itemView.findViewById(R.id.bedroomsTextView);
            carparksTextView = itemView.findViewById(R.id.carparksTextView);
            bathroomsTextView = itemView.findViewById(R.id.bathroomsTextView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            Fragment propertyFragment = new PropertyFragment();

            //settings up bundle to send data of specific recyclerview clicked item to fragment
            Bundle args = new Bundle();
            int position = getLayoutPosition();
            args.putSerializable("data", (Serializable) propertyList.get(position));

            propertyFragment.setArguments(args);

            //show fragment with animation
            activity.getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in,  // enter
                            R.anim.fade_out,  // exit
                            R.anim.fade_in,   // popEnter
                            R.anim.slide_out  // popExit
                    )
                    .replace(R.id.frameLayout, propertyFragment)
                    .addToBackStack(null)
                    .commit();

        }
    }
}
