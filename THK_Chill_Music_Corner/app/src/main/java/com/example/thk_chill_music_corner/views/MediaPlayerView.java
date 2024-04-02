package com.example.thk_chill_music_corner.views;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.IdRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.thk_chill_music_corner.R;


public class MediaPlayerView {
    public static final int STATE_NORMAL = 0;
    public static final int STATE_PARTIAL = 1;
    private final View mRootView;
    private Context mContext;
    private int mState;

    private FrameLayout mBottomSheet;
    private ConstraintLayout mControlsContainer;

    public MediaPlayerView(View RootView , Context mContext) {
        this.mRootView = RootView;
        this.mContext = mContext;

        this.mBottomSheet = findViewById(R.id.media_player_bottom_sheet_behavior);
        this.mControlsContainer = findViewById(R.id.media_player_controls_container);
        this.mRootView.setAlpha(0.0f);
    }

    public void onSliding(float slideOffset, int state) {
        float fadeStart = 0.25f;
        float alpha = (slideOffset - fadeStart) * (1F / (1F - fadeStart));

        if (state == STATE_NORMAL) {
            this.mRootView.setAlpha(alpha);
            this.mControlsContainer.setAlpha(1F);
        } else {
            this.mControlsContainer.setAlpha(1F - alpha);
        }
        this.mState = state;


/*        // Get the activity from the view's context
        Activity activity = (Activity) mContext;

        // Show the action bar (toolbar)
        if (activity instanceof AppCompatActivity) {
            ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (actionBar != null) {
                actionBar.hide();
            }
        }*/
    }

    public <T extends View> T findViewById(@IdRes int id) {
        return this.mRootView.findViewById(id);
    }
}
