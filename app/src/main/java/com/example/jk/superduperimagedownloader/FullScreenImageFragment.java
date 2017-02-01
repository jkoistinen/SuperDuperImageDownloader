package com.example.jk.superduperimagedownloader;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by jk on 2017-02-01.
 */

public class FullScreenImageFragment extends DialogFragment {
    int position;

    static FullScreenImageFragment newInstance(int position) {
        FullScreenImageFragment fullScreenImageFragment = new FullScreenImageFragment();

        Bundle args = new Bundle();
        args.putInt("position", position);
        fullScreenImageFragment.setArguments(args);

        return fullScreenImageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("position");
        this.setStyle(DialogFragment.STYLE_NO_TITLE, 0);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.single_image_fullscreen_dialog_fragment, container, false);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageViewFullScreen);

        Picasso
                .with(getActivity().getApplicationContext())
                .load("http://d39kbiy71leyho.cloudfront.net/wp-content/uploads/2016/05/09170020/cats-politics-TN.jpg")
                .into(imageView);

        return v;
    }
}
