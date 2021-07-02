package com.lll.android.base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        loadingDialog();
        initData();
    }

    protected abstract void loadingDialog();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayout();
}