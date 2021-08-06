package com.lll.android;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.lll.android.base.BaseActivity;
import com.lll.android.ui.fragment.HomeFragment;
import com.lll.android.ui.fragment.KnowledgeFragment;
import com.lll.android.ui.fragment.MyFragment;
import com.lll.android.ui.fragment.NavigationFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ViewPager2 mViewpager;
    private TabLayout mTabLayout;


    @Override
    protected void loadingDialog() {

    }

    @Override
    protected void initData() {

    }
    @Override
    protected void initView() {

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new KnowledgeFragment());
        fragmentList.add(new NavigationFragment());
        fragmentList.add(new MyFragment());

        mViewpager = (ViewPager2) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewpager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
//            @org.jetbrains.annotations.NotNull
            @Override
            public Fragment createFragment(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getItemCount() {
                return 4;
            }

        });

        List<String> titles = new ArrayList<>();
        titles.add("HOME");
        titles.add("Knowleder");
        titles.add("XXX");
        titles.add("HOME");

        //tablayout attach viepager2
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(mTabLayout, mViewpager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull   TabLayout.Tab tab, int position) {
                tab.setText(titles.get(position));
            }
        });

        tabLayoutMediator.attach();

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }
}