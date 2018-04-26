package com.ayuhani.demo.chatview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ayuhani.demo.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    private static class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder>{

        private List<Msg> datas;

        public MsgAdapter(List<Msg> datas) {
            this.datas = datas;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_msg,parent,false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

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
