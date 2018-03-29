package com.androidstudy.andelamedmanager.base;

import android.support.annotation.StyleRes;

import com.androidstudy.andelamedmanager.R;

import timber.log.Timber;

public class TransparentActivity extends ThemableActivity {
    public static final int[] themes = {R.style.TransparentTheme, R.style.TransparentTheme_Light};

    @StyleRes
    protected int getThemeRes(int index) {
        try {
            return themes[index];
        } catch (Exception e) {
            Timber.e(e);
            return themes[0];
        }
    }
}

