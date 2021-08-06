package com.lll.android.ui.fragment;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lll.android.pager3.MyAdapter;
import com.lll.android.R;
import com.lll.android.base.BaseFragment;
import com.lll.android.pager3.MotoViewModel;


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
        motoViewModel.getMotoBeanMutableLiveData().observe(this,datamPagingData -> {

            myAdapter.submitData(getLifecycle(),datamPagingData);
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_my;
    }


}