package com.linuxgroup.homeschool.client.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.linuxgroup.homeschool.client.R;
import com.linuxgroup.homeschool.client.ui.CreateClassActivity;
import com.linuxgroup.homeschool.client.ui.SearchActivity;
import com.linuxgroup.homeschool.client.ui.SearchClassActivity;
import com.linuxgroup.homeschool.client.utils.ToastUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClassFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class ClassFragment extends Fragment {

    @InjectView(R.id.create_class)
    Button bt_create_class;

    @InjectView(R.id.search_class)
    Button bt_search_class;

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
        View view = inflater.inflate(R.layout.fragment_class, container, false);

        ButterKnife.inject(this, view);

        bt_create_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CreateClassActivity.class);
                startActivity(intent);

                // 创建完之后,等着接收创建成功的 broadcast, 然后从数据库读取
            }
        });

        bt_search_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchClassActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
