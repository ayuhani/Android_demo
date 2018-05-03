package com.ayuhani.demo.chatview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ayuhani.demo.R;
import com.ayuhani.demo.broadcast.BaseActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private EditText etInput;
    private Button btnSend;
    private Button btnLogout;

    private MsgAdapter msgAdapter;
    private List<Msg> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        msgAdapter = new MsgAdapter(datas);
        recyclerView.setAdapter(msgAdapter);
        etInput = findViewById(R.id.et_input);
        btnSend = findViewById(R.id.btn_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = etInput.getText().toString().trim();
                if (TextUtils.isEmpty(content))
                    return;
                Msg msg = new Msg(content, Msg.TYPE_SENT);
                datas.add(msg);
                msgAdapter.notifyItemInserted(datas.size() - 1);
                recyclerView.scrollToPosition(datas.size() - 1);
                etInput.setText("");
            }
        });
        btnLogout = findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent("com.ayuhani.broadcast.FORCE_OFFLINE");
                sendBroadcast(it);
            }
        });
    }

    private void initMsgs() {
        datas = new ArrayList<>();
        datas.addAll(Arrays.asList(
                new Msg("你好，基佬", Msg.TYPE_RECEIVED),
                new Msg("你有病吧，你是谁啊？", Msg.TYPE_SENT),
                new Msg("我是你爸爸！", Msg.TYPE_RECEIVED)
        ));
    }


    private static class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

        private List<Msg> datas;

        public MsgAdapter(List<Msg> datas) {
            this.datas = datas;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_msg, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Msg msg = datas.get(position);
            if (msg.getType() == Msg.TYPE_RECEIVED) {
                holder.layoutRight.setVisibility(View.GONE);
                holder.layoutLeft.setVisibility(View.VISIBLE);
                holder.tvLeft.setText(msg.getContent());
            } else {
                holder.layoutRight.setVisibility(View.VISIBLE);
                holder.layoutLeft.setVisibility(View.GONE);
                holder.tvRight.setText(msg.getContent());
            }
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            LinearLayout layoutLeft;
            LinearLayout layoutRight;
            TextView tvLeft;
            TextView tvRight;

            public ViewHolder(View itemView) {
                super(itemView);
                layoutLeft = itemView.findViewById(R.id.layout_left);
                layoutRight = itemView.findViewById(R.id.layout_right);
                tvLeft = itemView.findViewById(R.id.tv_left);
                tvRight = itemView.findViewById(R.id.tv_right);
            }
        }
    }
}
