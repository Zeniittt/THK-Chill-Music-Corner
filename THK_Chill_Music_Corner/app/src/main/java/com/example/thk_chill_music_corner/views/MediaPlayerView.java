package com.example.thk_chill_music_corner.views;

import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.IdRes;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.thk_chill_music_corner.R;


public class MediaPlayerView {
    public static final int STATE_NORMAL = 0;
    public static final int STATE_PARTIAL = 1;
    private final View mRootView;
    private int mState;

    private FrameLayout mBottomSheet;
    private ConstraintLayout mControlsContainer;

    public MediaPlayerView(View RootView) {
        this.mRootView = RootView;

        this.mBottomSheet = findViewById(R.id.media_player_bottom_sheet_behavior);
        this.mControlsContainer = findViewById(R.id.media_player_controls_container);
        this.mRootView.setAlpha(0.0f);
    }

    public void onSliding(float slideOffset, int state){
        float fadeStart = 0.25f;
        float alpha = (slideOffset -fadeStart) * (1F / (1F - fadeStart));

        if(state == STATE_NORMAL){
            this.mRootView.setAlpha(alpha);
            this.mControlsContainer.setAlpha(1F);
        }else {
            this.mControlsContainer.setAlpha(1F-alpha);
        }
        this.mState = state;
    }

    public <T extends View> T  findViewById(@IdRes int id){
        return this.mRootView.findViewById(id);
    }
}
