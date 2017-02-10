package com.example.jk.superduperimagedownloader;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> imageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageUrls.add(0, "http://d39kbiy71leyho.cloudfront.net/wp-content/uploads/2016/05/09170020/cats-politics-TN.jpg");
        imageUrls.add(1, "http://cfa.org/portals/0/Images/breeds/DRex/profile2.jpg");
        imageUrls.add(2, "http://s2.dmcdn.net/eINkN/1280x720-Oee.png");

        ListView listview = (ListView) findViewById(R.id.listView);

        ImageListViewAdapter imagelistviewadapter = new ImageListViewAdapter(this, R.layout.single_image_item_layout, imageUrls);

        listview.setAdapter(imagelistviewadapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                if (prev != null){
                    ft.remove(prev);
                }
                ft.addToBackStack(null);

                DialogFragment fullScreenImageFragment = FullScreenImageFragment.newInstance(position);
                fullScreenImageFragment.show(ft, "dialog");
            }
        });
    }

    @Override
    protected void onDestroy() {
        imageUrls.clear();
        super.onDestroy();
    }
}
