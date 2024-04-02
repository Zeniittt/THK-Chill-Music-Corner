package com.example.thk_chill_music_corner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.thk_chill_music_corner.views.panels.RootMediaPlayerPanel;
import com.example.thk_chill_music_corner.views.panels.RootNavigationBarPanel;
import com.google.android.material.navigation.NavigationView;
import com.realgear.multislidinguppanel.Adapter;
import com.realgear.multislidinguppanel.MultiSlidingUpPanelLayout;
import com.realgear.multislidinguppanel.PanelStateListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        MultiSlidingUpPanelLayout panelLayout = findViewById(R.id.root_sliding_up_panel);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        // handle Toolbar toggle
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // handle click item in NavigationView (Sidebar)
        navigationView.setNavigationItemSelectedListener(this);

        List<Class<?>> items = new ArrayList<>();

        // You add your panels here it can be different classes with different layouts
        // but they all should extend the BasePanelView class with same constructors
        // You can add 1 or more then 1 panels

        RootMediaPlayerPanel rootMediaPlayerPanel = new RootMediaPlayerPanel(this,panelLayout);

        //items.add(RootMediaPlayerPanel.class);
        items.add(rootMediaPlayerPanel.getClass());
        items.add(RootNavigationBarPanel.class);


        // This is to listen on all the panels you can add methods or extend the class
        panelLayout.setPanelStateListener(new PanelStateListener(panelLayout));

        // The adapter handles the items you can also extend it but I don't recommend for
        // beginners
        //panelLayout.setAdapter(new Adapter(getBaseContext(),items));
        panelLayout.setAdapter(new Adapter(this, items));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.tab_home) {

        } else if(id == R.id.tab_library) {

        } else if(id == R.id.tab_settings) {

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    }

}