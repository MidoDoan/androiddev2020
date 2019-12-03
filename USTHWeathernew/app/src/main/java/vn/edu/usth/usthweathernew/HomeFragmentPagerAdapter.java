package vn.edu.usth.usthweathernew;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
    private final int PAGE_COUNT = 3;

    Context context;
    private String[] titles;

    public HomeFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int page) {
        // returns an instance of Fragment corresponding to the specified page
        switch (page) {
            case 0:
                return WeatherAndForecastFragment.newInstance(0, titles[0]);
            case 1:
                return WeatherAndForecastFragment.newInstance(1, titles[1]);
            case 2:
                return WeatherAndForecastFragment.newInstance(2, titles[2]);
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int page) {
        titles = getContext().getResources().getStringArray(R.array.city);
        // returns a tab title corresponding to the specified page
        return titles[page];
    }

    public void setResource(Context context) {
        this.context = context;
    }

    private Context getContext() {
        return context;
    }
}
