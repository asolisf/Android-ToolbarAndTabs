package com.alansolisflores.toolbarandtabs.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import com.alansolisflores.toolbarandtabs.R;
import com.alansolisflores.toolbarandtabs.Adapters.PagerAdapter;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    private Toolbar customToolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.viewPager = findViewById(R.id.viewPager);
        this.tabLayout = findViewById(R.id.tabLayout);
        this.customToolbar = findViewById(R.id.toolbar);

        this.customToolbar.setTitle(R.string.app_name);
        setSupportActionBar(this.customToolbar);

        this.tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        this.tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        this.tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        this.tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),
                                                     tabLayout.getTabCount());

        this.viewPager.setAdapter(pagerAdapter);
        this.viewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(this.tabLayout)
        );

        this.tabLayout.addOnTabSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.items_menu,menu);
        return true;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int position = tab.getPosition();
        this.viewPager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
