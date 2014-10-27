package com.linuxgroup.homeschool.client.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linuxgroup.homeschool.client.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClassFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class ClassFragment extends Fragment {

    public static ClassFragment newInstance() {
        ClassFragment fragment = new ClassFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }
    public ClassFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_class, container, false);
    }
}
