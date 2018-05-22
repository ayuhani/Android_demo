package com.ayuhani.demo.design;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.ayuhani.demo.R;
import com.bumptech.glide.Glide;

public class FruitActivity extends AppCompatActivity {

    public static final String FRUIT_NAME = "fruit_name";
    public static final String FRUIT_IMAGE_URL = "furit_image_url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);

        Intent it = getIntent();
        String fruitName = it.getStringExtra(FRUIT_NAME);
        String fruitUrl = it.getStringExtra(FRUIT_IMAGE_URL);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        ImageView ivFruit = findViewById(R.id.iv_fruit);
        TextView tvContent = findViewById(R.id.tv_content);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        collapsingToolbarLayout.setTitle(fruitName);
        Glide.with(this).load(fruitUrl).into(ivFruit);
        String fruitContent = generateFruitContent(fruitName);
        tvContent.setText(fruitContent);
    }

    private String generateFruitContent(String fruitName) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            builder.append(fruitName + " ");
        }
        return builder.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
