package com.androidstudy.andelamedmanager.util;

import android.content.Context;
import android.graphics.Typeface;

public class TypeFactory {

    private Typeface regular;
    private Typeface bold;
    private Typeface light;

    public TypeFactory(Context context) {
        String OXYGEN_REGULAR = "fonts/oxygen_regular.ttf";
        regular = Typeface.createFromAsset(context.getAssets(), OXYGEN_REGULAR);
        String OXYGEN_BOLD = "fonts/oxygen_bold.ttf";
        bold = Typeface.createFromAsset(context.getAssets(), OXYGEN_BOLD);
        String OXYGEN_LIGHT = "fonts/oxygen_light.ttf";
        light = Typeface.createFromAsset(context.getAssets(), OXYGEN_LIGHT);
    }

    public Typeface getRegular() {
        return regular;
    }

    public Typeface getBold() {
        return bold;
    }

    public Typeface getLight() {
        return light;
    }
}
