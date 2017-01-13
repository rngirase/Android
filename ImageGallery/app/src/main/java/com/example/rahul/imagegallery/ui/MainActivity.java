package com.example.rahul.imagegallery.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rahul.imagegallery.R;
import com.example.rahul.imagegallery.adapter.ImageAdapter;
import com.example.rahul.imagegallery.model.ImageData;
import com.example.rahul.imagegallery.model.ImageList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ImageAdapter.ItemClickCallback {

    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String IMAGEID = "IMAGEID";
    private static final String LOCATION = "LOCATION";
    private static final String DATE = "DATE";
    private RecyclerView recView;
    private ImageAdapter adapter;
    private ArrayList imageData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageData = (ArrayList) ImageData.getListData();

        recView = (RecyclerView) findViewById(R.id.id_list);
        recView.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));

        adapter = new ImageAdapter(ImageData.getListData(), this);
        recView.setAdapter(adapter);
        adapter.setItemClickCallback(this);
    }

    /**
     * @param p position
     */
    public void onItemClick(int p) {
        ImageList item = (ImageList) imageData.get(p);

        Intent i = new Intent(this, DetailsActivity.class);

        Bundle extras = new Bundle();
        extras.putInt(IMAGEID, item.getImageResId());
        extras.putString(LOCATION, item.getLocation());
        extras.putString(DATE, item.getDate());
        i.putExtra(BUNDLE_EXTRAS, extras);

        startActivity(i);
    }
}
