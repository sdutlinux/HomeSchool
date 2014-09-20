package com.linuxgroup.homeschool.client.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.linuxgroup.homeschool.client.R;
import com.linuxgroup.homeschool.client.domain.Message;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by tan on 14-9-20.
 */
public class ChatListAdapter extends BaseAdapter {
    private Context context;
    private List<Message> messages;
    LayoutInflater inflater;

    public ChatListAdapter(Context context, List<Message> messages) {
        this.context = context;
        this.messages = messages;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Message getItem(int i) {
        return messages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CacheView cacheView;

        //TODO: 接受的消息和发送的消息分别排列在左右
        if (view == null) {
            view = inflater.inflate(R.layout.chat_listview_item_left, null);

            cacheView = new CacheView(view);

            view.setTag(cacheView);
        } else {
            cacheView = (CacheView) view.getTag();
        }

        Message message = getItem(i);

        cacheView.tv_content.setText(message.getContent());
        cacheView.tv_send_time.setText(message.getTime()+"");


        return view;
    }

    class CacheView {
        @InjectView(R.id.avatar_chat)
        ImageView iv_avatar;

        @InjectView(R.id.content)
        TextView tv_content;

        @InjectView(R.id.time)
        TextView tv_send_time;

        public CacheView(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
