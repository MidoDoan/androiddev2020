package vn.edu.usth.usthweathernew;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.contentcapture.ContentCaptureCondition;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastFragment extends Fragment {

    public ForecastFragment() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forecast, container, false);
        String date[] = getContext().getResources().getStringArray(R.array.weekdays);
        WeatherDescription weather = new WeatherDescription();
        weather.setResource(getContext());
        weather.setWeather();
        weather.setImageArr();

        LinearLayout llvertical = view.findViewById(R.id.linear_layout);

        int i;
        Random r = new Random();

        for (i = 0; i < 30; i++) {
            View view1 = inflater.inflate(R.layout.row, container, false);
            int rInt = r.nextInt(13);

            TextView txt1 = view1.findViewById(R.id.text1);
            txt1.setText(date[i % 7]);

            ImageView img = view1.findViewById(R.id.weather_icon);
            img.setImageResource(weather.getImageId(rInt));

            TextView txt2 = view1.findViewById(R.id.text2);
            txt2.setText(weather.getWeather(rInt) + "\n" + weather.getTemperatureRange(rInt));

            llvertical.addView(view1);
        }
        return view;
    }
}

