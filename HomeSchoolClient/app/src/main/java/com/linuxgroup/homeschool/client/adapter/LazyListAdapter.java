package com.linuxgroup.homeschool.client.adapter;

import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by tan on 14-9-26.
 */
abstract public class LazyListAdapter<T> extends BaseAdapter {
    List<T> lazyList = null;

    public LazyListAdapter() {

    }

    public LazyListAdapter(List<T> initialList) {
        this.lazyList = initialList;
    }

    public void replaceLazyList(List<T> newList) {
        lazyList = newList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return lazyList == null ? 0 : lazyList.size();
    }

    @Override
    public T getItem(int i) {
        return lazyList == null ? null : lazyList.get(i);
    }
}
