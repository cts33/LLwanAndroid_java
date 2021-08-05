package com.lll.android.ui.fragment;

import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lll.android.MyAdapter;
import com.lll.android.R;
import com.lll.android.base.BaseFragment;
import com.lll.android.bean.MotoBean;
import com.lll.android.viewmodel.MotoViewModel;


public class MyFragment extends BaseFragment {


    private RecyclerView mRecycler;
    private MyAdapter myAdapter;
    private MotoViewModel motoViewModel;

    @Override
    protected void initView() {
        mRecycler = root.findViewById(R.id.recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(context));
        myAdapter = new MyAdapter(context);
        mRecycler.setAdapter(myAdapter);
    }

    @Override
    protected void loadingDialog() {

    }

    @Override
    protected void initData() {
        motoViewModel = new ViewModelProvider(this) .get(MotoViewModel.class);
        motoViewModel.getMotoBeanMutableLiveData().observe(this, new Observer<MotoBean>() {
            @Override
            public void onChanged(MotoBean motoBean) {
                myAdapter.submitData(this,);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_my;
    }


}