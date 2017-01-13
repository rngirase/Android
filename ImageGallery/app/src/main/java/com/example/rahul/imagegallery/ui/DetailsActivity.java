package com.example.rahul.imagegallery.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rahul.imagegallery.R;

public class DetailsActivity extends AppCompatActivity {
    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String LOCATION = "LOCATION";
    private static final String DATE = "DATE";
    private static final String IMAGEID="IMAGEID";
   private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageView= (ImageView)findViewById(R.id.locationimage);
        Bundle extras = getIntent().getBundleExtra(BUNDLE_EXTRAS);

        ((TextView)findViewById(R.id.DateValue)).setText(extras.getString(DATE));
        ((TextView)findViewById(R.id.locationValue)).setText(extras.getString(LOCATION));
        imageView.setImageResource(extras.getInt(IMAGEID));
    }
}
