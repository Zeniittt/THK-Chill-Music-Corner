package com.example.thk_chill_music_corner.views.panels;

import static com.realgear.multislidinguppanel.MultiSlidingUpPanelLayout.COLLAPSED;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;


import com.example.thk_chill_music_corner.R;
import com.example.thk_chill_music_corner.ui.adapters.StateFragmentAdapter;
import com.example.thk_chill_music_corner.ui.fragments.FragmentCorner;
import com.example.thk_chill_music_corner.ui.fragments.FragmentHome;
import com.example.thk_chill_music_corner.ui.fragments.FragmentLibrary;
import com.example.thk_chill_music_corner.ui.fragments.FragmentForYou;
import com.example.thk_chill_music_corner.ui.fragments.FragmentProfile;
import com.realgear.multislidinguppanel.BasePanelView;
import com.realgear.multislidinguppanel.MultiSlidingUpPanelLayout;
import com.realgear.readable_bottom_bar.ReadableBottomBar;

public class RootNavigationBarPanel extends BasePanelView {

    private ViewPager2 rootViewPager;
    private ReadableBottomBar rootNavigationBar;
    public RootNavigationBarPanel(@NonNull Context context, MultiSlidingUpPanelLayout panelLayout) {
        super(context, panelLayout);
        getContext().setTheme(R.style.Theme_THK_Chill_Music_Corner);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_root_navigation_bar, this, true);
    }

    @Override
    public void onCreateView() {
        // The panel will be collapsed on start of application
        this.setPanelState(COLLAPSED);
        // The panel will slide up and down
        this.setSlideDirection(MultiSlidingUpPanelLayout.SLIDE_VERTICAL);
        // Sets the panels peak height
        this.setPeakHeight(getResources().getDimensionPixelSize(R.dimen.navigation_bar_height));
    }

    @Override
    public void onBindView() {
        rootViewPager = getMultiSlidingUpPanel().findViewById(R.id.root_view_pager);
        rootNavigationBar = findViewById(R.id.root_navigation_bar);

        StateFragmentAdapter adapter = new StateFragmentAdapter(getSupportFragmentManager(),getLifecycle());
        adapter.addFragment(new FragmentHome());
        adapter.addFragment(new FragmentForYou());
        adapter.addFragment(new FragmentCorner());
        adapter.addFragment(new FragmentLibrary());
        adapter.addFragment(new FragmentProfile());

        rootViewPager.setAdapter(adapter);
        rootNavigationBar.setupWithViewPager2(rootViewPager);
    }

    @Override
    public void onPanelStateChanged(int i) {

    }
}
