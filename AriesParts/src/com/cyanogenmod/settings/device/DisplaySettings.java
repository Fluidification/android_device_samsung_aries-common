package com.cyanogenmod.settings.device;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;

public class DisplaySettings extends PreferenceActivity  {

    public static final String KEY_MDNIE = "mdnie";
    public static final String KEY_BACKLIGHT_TIMEOUT = "backlight_timeout";
    public static final String KEY_HSPA = "hspa";
    public static final String KEY_HSPA_CATEGORY = "category_radio";
    public static final String KEY_VOLUME_BOOST = "volume_boost";
    public static final String KEY_VOLUME_CATEGORY = "category_volume_boost";
    public static final String KEY_CARDOCK_AUDIO = "cardock_audio";
    public static final String KEY_DESKDOCK_AUDIO = "deskdock_audio";
    public static final String KEY_DOCK_AUDIO_CATEGORY = "category_dock_audio";

    private ListPreference mMdnie;
    
    private BroadcastReceiver mHeadsetReceiver = new BroadcastReceiver() {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.main);

        mMdnie = (ListPreference) findPreference(KEY_MDNIE);
        mMdnie.setEnabled(Mdnie.isSupported());
        mMdnie.setOnPreferenceChangeListener(new Mdnie());
    }

}
