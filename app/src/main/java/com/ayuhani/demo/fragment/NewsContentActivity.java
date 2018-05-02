package com.ayuhani.demo.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ayuhani.demo.R;

/**
 * Created by wang on 2018/5/2.
 */

public class NewsContentActivity extends AppCompatActivity {

    public static void actionStart(Context context, String title, String content) {
        Intent it = new Intent(context, NewsContentActivity.class);
        it.putExtra("news_title", title);
        it.putExtra("news_content", content);
        context.startActivity(it);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        String title = getIntent().getStringExtra("news_title");
        String content = getIntent().getStringExtra("news_content");

        NewsContentFragment fragment = (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id
                .news_content_fragment);
        fragment.refresh(title, content);
    }
}
