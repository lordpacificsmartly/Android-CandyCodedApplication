package com.pluralsight.candycoded;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);


    }

    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    // ***

    public void createMapIntent(View view){
        // Create a Uri from an intent string. Use the result to create an Intent.
        // Create an Intent from Uri. Set the action to ACTION_VIEW
        Uri uriAddress = Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uriAddress);
        // Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null){
            // Attempt to start an activity that can handle the Intent
            startActivity(mapIntent);
        }
    }

    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***

    public void createPhoneIntent(View view){
        Uri uriPhone = Uri.parse("tel:0123456789");
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL, uriPhone);
        startActivity(phoneIntent);
    }

}
