package com.androidstudy.andelamedmanager.util;

import android.content.Context;
import android.graphics.Typeface;

public class TypeFactory {

    final String OXYGEN_REGULAR = "fonts/oxygen_regular.ttf";
    final String OXYGEN_BOLD = "fonts/oxygen_bold.ttf";
    final String OXYGEN_LIGHT = "fonts/oxygen_light.ttf";

    Typeface regular;
    Typeface bold;
    Typeface light;

    public TypeFactory(Context context) {
        regular = Typeface.createFromAsset(context.getAssets(), OXYGEN_REGULAR);
        bold = Typeface.createFromAsset(context.getAssets(), OXYGEN_BOLD);
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
