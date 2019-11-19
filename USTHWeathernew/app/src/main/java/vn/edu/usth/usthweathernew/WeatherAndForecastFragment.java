package vn.edu.usth.usthweathernew;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherAndForecastFragment extends Fragment {


    public WeatherAndForecastFragment() {
        // Required empty public constructor
    }

    // newInstance constructor for creating fragment with arguments
    public static Fragment newInstance(int page) {
        WeatherAndForecastFragment fragment1= new WeatherAndForecastFragment();
        Bundle args = new Bundle();
        args.putInt("page", page);
        fragment1.setArguments(args);
        return fragment1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_and_forecast, container, false);
    }

}
