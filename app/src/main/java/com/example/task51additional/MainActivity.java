package com.example.task51additional;

/* --------------- STUDENT DETAILS ----------------
Name: Kane Landolina
ID: 218692411
UNIT Code: SIT708
 */

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.task51additional.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    ArrayList<PropertyItem> propertyList;

    RecyclerView.LayoutManager propertyLayoutManager;

    PropertyAdaptor propertyAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating binding for using items from view
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //add the data to the data models manually for use in the recyclerviews and fragments.
        propertyList = new ArrayList<>();
        propertyList.add(new PropertyItem("Cornes Street",
                "Beautiful double storey home on the waterfront.",
                "https://img.freepik.com/free-photo/house-isolated-field_1303-23773.jpg?w=1060&t=st=1682139101~exp=1682139701~hmac=c340bfbf55ae9a6cb4eba23fc065fd7fe51c425932c525e81d47e69824893b4c",
                "500",
                "6",
                "4",
                "3"));
        propertyList.add(new PropertyItem("Trentham Road",
                "Old style cottage in quite part of country.",
                "https://cdn.pixabay.com/photo/2017/11/16/19/29/cottage-2955582_960_720.jpg",
                "270",
                "2",
                "2",
                "1"));
        propertyList.add(new PropertyItem("Potomac Grove",
                "A perfect home in an affordable suburb.",
                "https://cdn.pixabay.com/photo/2016/11/29/03/53/house-1867187_960_720.jpg",
                "320",
                "3",
                "2",
                "2"));
        propertyList.add(new PropertyItem("Esteem River",
                "An amazing property with exemplary features for summer activities.",
                "https://cdn.pixabay.com/photo/2014/07/10/17/18/large-home-389271_960_720.jpg",
                "710",
                "7",
                "4",
                "5"));

        //setting up the layoutmanager and adaptor for the recyclerview on the main activity
        propertyLayoutManager = new LinearLayoutManager(this);

        propertyAdaptor = new PropertyAdaptor(this, propertyList);

        binding.propertyRecyclerView.setAdapter(propertyAdaptor);
        binding.propertyRecyclerView.setLayoutManager(propertyLayoutManager);


    }
}