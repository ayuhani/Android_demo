package com.ayuhani.demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ayuhani.demo.R;

/**
 * Created by wang on 2018/5/2.
 */

public class NewsContentFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_news_content, container, false);
        return view;
    }

    public void refresh(String title, String content) {
        View llLayout = view.findViewById(R.id.ll_layout);
        llLayout.setVisibility(View.VISIBLE);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        TextView tvContent = view.findViewById(R.id.tv_content);
        tvTitle.setText(title);
        tvContent.setText(content);
    }
}
