package com.example.jk.superduperimagedownloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private ImageView imageview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageview1 = (ImageView) findViewById(R.id.imageView1);

        imageview1.setBackgroundColor(R.color.colorAccent);

        Picasso.with(this).load("http://d39kbiy71leyho.cloudfront.net/wp-content/uploads/2016/05/09170020/cats-politics-TN.jpg")
                .centerCrop()
                .resizeDimen(R.dimen.activity_image_width, R.dimen.activity_image_height)
                .into(imageview1);

    }
}
