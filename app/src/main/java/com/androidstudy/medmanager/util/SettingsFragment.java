package com.androidstudy.medmanager.util;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.util.ObjectsCompat;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceManager;

import com.androidstudy.medmanager.R;


public class SettingsFragment extends PreferenceFragmentCompat
        implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferences_main);
        loadSummaries("");
    }

    private void loadSummaries(String key) {
        ListPreference preference = (ListPreference) findPreference("THEME");
        preference.setSummary(preference.getEntry());

        if (ObjectsCompat.equals(key, "THEME")) {
            getActivity().recreate();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        PreferenceManager.getDefaultSharedPreferences(getActivity()).registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        PreferenceManager.getDefaultSharedPreferences(getActivity()).unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        loadSummaries(s);
    }
}

