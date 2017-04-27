package com.lvjian.android.lvjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ListView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView main_listview;
    private List<String> nums;
    private MyAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nums = new ArrayList<>();
        nums.add("登录");
        nums.add("支付");
        nums.add("分享");
        nums.add("其他");
        initView();

    }

    private void initView() {
        main_listview = (ListView) findViewById(R.id.main_listview);
        adapter = new MyAdapter();
        main_listview.setAdapter(adapter);

    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return nums.size();
        }

        @Override
        public Object getItem(int i) {
            return nums.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View contentview, ViewGroup viewGroup) {
            ViewHolder holder = null;
            if (contentview == null) {
                holder = new ViewHolder();
                contentview = LayoutInflater.from(MainActivity.this).inflate(R.layout.main_listview_item, null);
                holder.main_item_content_txt = (TextView) contentview.findViewById(R.id.main_item_content_txt);
                contentview.setTag(holder);
            } else {
                holder = (ViewHolder) contentview.getTag();
            }
            holder.main_item_content_txt.setText(nums.get(position));
            return contentview;
        }

        class ViewHolder {
            TextView main_item_content_txt;
        }
    }

}
