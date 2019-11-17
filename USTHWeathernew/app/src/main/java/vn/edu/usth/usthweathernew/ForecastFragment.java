package vn.edu.usth.usthweathernew;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastFragment extends Fragment {

    private String date[] = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    WeatherDescription weather = new WeatherDescription();

    public ForecastFragment() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forecast, container, false);
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
            txt2.setText(weather.getWeather(rInt)+"\n"+weather.getTemperatureRange(rInt));

            llvertical.addView(view1);
        }
        return view;
    }
}
