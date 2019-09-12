package com.example.android.quakereport;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private static String TAG = EarthquakeLoader.class.getSimpleName();

    private String mUrl;

    EarthquakeLoader(Context context, String mUrl) {
        super(context);
        this.mUrl = mUrl;
    }

    @Override
    protected void onStartLoading() {
        Log.i(TAG, "Inside onStartLoading...");
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        Log.i(TAG, "Inside LoadInBackground...");

        if (mUrl == null) {
            return null;
        }

        List<Earthquake> result = QueryUtils.fetchEarthquakeData(mUrl);
        return result;
    }


}
