package com.linuxgroup.homeschool.client.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.linuxgroup.homeschool.client.R;
import com.linuxgroup.homeschool.client.db.model.RecentChat;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by tan on 14-10-18.
 */
public class RecentChatListAdapter extends LazyListAdapter<RecentChat> {
    private final LayoutInflater inflater;

    public RecentChatListAdapter(LayoutInflater layoutInflater) {
        this.inflater = layoutInflater;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CacheView cacheView = null;

        RecentChat recentChat = getItem(i);

        if (view == null) {
            view = inflater.inflate(R.layout.recent_chat_item, null);

            cacheView = new CacheView(view);

            view.setTag(cacheView);
        } else {
            cacheView = (CacheView) view.getTag();
        }

        // 展示信息
        cacheView.render(recentChat);

        return view;
    }

    class CacheView {
        @InjectView(R.id.account)
        TextView tv_account;

        @InjectView(R.id.content)
        TextView tv_content;

        @InjectView(R.id.time)
        TextView tv_time;

        public CacheView(View view) {
            ButterKnife.inject(this, view);
        }

        public void render(RecentChat recentChat) {
            tv_account.setText(recentChat.getNick());
            tv_content.setText(recentChat.getContent());
            tv_time.setText(recentChat.getTime().toString());
        }
    }
}
