package com.duyhoang.piccasodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private ImageView imgMyImage;
    private Button btnLoading;

    private String mUrl = "http://i.imgur.com/DvpvklR.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgMyImage = findViewById(R.id.image_demo);
        btnLoading = findViewById(R.id.button_load_image);
        btnLoading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadImage();
            }
        });
    }

    private void loadImage() {
        Picasso.get()
                .load(mUrl)
                .resize(50,100)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(imgMyImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        btnLoading.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
    }
}
