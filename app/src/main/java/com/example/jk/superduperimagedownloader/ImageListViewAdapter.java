package com.example.jk.superduperimagedownloader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jk on 2017-02-01.
 */

public class ImageListViewAdapter extends ArrayAdapter<String> {

    private Context context;
    private ArrayList<String> imageUrls;

    private LayoutInflater inflater;

    public ImageListViewAdapter(Context context, int resource, ArrayList<String> objects) {
        super(context, resource, objects);
        this.context = context;
        this.imageUrls = objects;

        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.single_image_item_layout, parent, false);
        }

        String url = getItem(position);

        Picasso
                .with(context)
                .load(url)
                .centerCrop()
                .resizeDimen(R.dimen.activity_image_width, R.dimen.activity_image_height)
                .into((ImageView) convertView);

        return convertView;
    }
}
