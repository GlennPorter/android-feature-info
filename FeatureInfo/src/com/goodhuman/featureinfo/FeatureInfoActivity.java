package com.goodhuman.featureinfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FeatureInfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feature_info_activity);
        
        List<String> features = new ArrayList<String>();
        PackageManager packageManager = getPackageManager();
        FeatureInfo[] featuresList = packageManager.getSystemAvailableFeatures();
        for (FeatureInfo feature : featuresList) {
        	if (!TextUtils.isEmpty(feature.name)) {
        		features.add(feature.name);
        	}
        }
        Collections.sort(features);
        
        ArrayAdapter<String> featureAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, features);
        ListView featuresListView = (ListView) findViewById(R.id.featureListView);
        featuresListView.setAdapter(featureAdapter);
    }
}
