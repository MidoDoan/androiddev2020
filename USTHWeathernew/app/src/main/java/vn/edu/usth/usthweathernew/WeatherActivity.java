package vn.edu.usth.usthweathernew;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

//import android.support.design.widget.TabLayout;

import com.google.android.material.tabs.TabLayout;

public class WeatherActivity extends AppCompatActivity {

    private static final String TAG = "WeatherActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_activity);
        Log.i(TAG, "This is onCreate");

        PagerAdapter adapter = new HomeFragmentPagerAdapter(
                getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setPageMargin(15);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "This is onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "This is onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "This is onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "This is onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "This is onResume");
    }
}
