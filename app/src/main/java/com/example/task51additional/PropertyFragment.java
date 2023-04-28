package com.example.task51additional;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;

public class PropertyFragment extends Fragment {

    private PropertyItem propertyItem;

    public PropertyFragment() {
        this.propertyItem = propertyItem;
    }

    public static PropertyFragment newInstance(PropertyItem propertyItem) {
        PropertyFragment fragment = new PropertyFragment();
        Bundle args = new Bundle();
        args.putSerializable("data", (Serializable) propertyItem);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            //get data sent from recyclerview
            propertyItem = (PropertyItem) getArguments().getSerializable("data");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_property, null);

        if(getArguments() != null) {

            //attach items from view to variables
            TextView propertyAddressTextView = view.findViewById(R.id.propertyAddressTextView);
            ImageView propertyImageView = view.findViewById(R.id.propertyImageView);
            TextView propertyDescriptionTextView = view.findViewById(R.id.propertyDescriptionTextView);
            TextView bathroomsTextView = view.findViewById(R.id.bathroomsTextView);
            TextView carparksTextView = view.findViewById(R.id.carparksTextView);
            TextView bedroomsTextView = view.findViewById(R.id.bedroomsTextView);
            FloatingActionButton floatingActionButton =view.findViewById(R.id.floatingActionButton);

            //show data in view
            Glide.with(requireContext()).load(propertyItem.getImageUrl()).into(propertyImageView);
            propertyAddressTextView.setText(propertyItem.getAddress());
            propertyDescriptionTextView.setText(propertyItem.getDescription());
            bathroomsTextView.setText(propertyItem.getBathrooms() + "Bathrooms");
            carparksTextView.setText(propertyItem.getCarparks() + " Carparks");
            bedroomsTextView.setText(propertyItem.getBedrooms() + " Bedrooms");


            //set floating action button to send back to previous fragment
            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getParentFragmentManager().popBackStack();
                }
            });

        }
        return view;
    }
}