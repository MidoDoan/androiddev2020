package vn.edu.usth.usthweathernew;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment {


    public WeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_weather, container, false);
        Random r = new Random();
        int rInt = r.nextInt(13);

        TextView text1 = v.findViewById(R.id.text3);
        WeatherDescription weather = new WeatherDescription();
        text1.setText(weather.getTemperature(rInt)+"\n"+weather.getWeather(rInt));

        ImageView image = v.findViewById(R.id.weather_icon2);
        image.setImageResource(weather.getImageId(rInt));

        return v;
    }

}
