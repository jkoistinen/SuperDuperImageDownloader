package com.example.jk.superduperimagedownloader;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView imageview1;

    ArrayList<String> imageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageUrls.add(0, "http://d39kbiy71leyho.cloudfront.net/wp-content/uploads/2016/05/09170020/cats-politics-TN.jpg");
        imageUrls.add(1, "http://d39kbiy71leyho.cloudfront.net/wp-content/uploads/2016/05/09170020/cats-politics-TN.jpg");
        imageUrls.add(2, "http://d39kbiy71leyho.cloudfront.net/wp-content/uploads/2016/05/09170020/cats-politics-TN.jpg");

        ListView listview = (ListView) findViewById(R.id.listView);

        //ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.single_image_item_layout, imageUrls);

        ImageListViewAdapter imagelistviewadapter = new ImageListViewAdapter(this, R.layout.single_image_item_layout, imageUrls);

        listview.setAdapter(imagelistviewadapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Toasty!", Toast.LENGTH_SHORT).show();
            }
        });

//        imageview1 = (ImageView) findViewById(R.id.imageView1);

        //imageview1.setBackgroundColor(R.color.colorAccent);

//        Picasso.with(this).load("http://d39kbiy71leyho.cloudfront.net/wp-content/uploads/2016/05/09170020/cats-politics-TN.jpg")
//                .centerCrop()
//                .resizeDimen(R.dimen.activity_image_width, R.dimen.activity_image_height)
//                .into(imageview1);

    }
}
