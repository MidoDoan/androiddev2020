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
    private Integer[] imageArray = {
            R.drawable.bitcloudy,
            R.drawable.bitsnow,
            R.drawable.cloudy,
            R.drawable.cloudysunny,
            R.drawable.drizzle,
            R.drawable.heavyrain,
            R.drawable.partialsnow,
            R.drawable.rainy,
            R.drawable.snowy,
            R.drawable.storm,
            R.drawable.suncloud,
            R.drawable.sunny,
            R.drawable.thunder};

    private String weather[] = {
            "A bit cloudy",
            "A bit snow",
            "Cloudy",
            "Sunny and cloudy",
            "Drizzle",
            "Heavy rain",
            "Partial snow",
            "Rainy",
            "Shower snow",
            "Storm",
            "Sunny and a bit cloudy",
            "Sunny",
            "Thunder and lightning"
    };

    public ForecastFragment() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forecast, container, false);
        LinearLayout llvertical = view.findViewById(R.id.linear_layout);

        int i;
        Random r = new Random();
        String temperature;

        for (i = 0; i < 30; i++) {
            View view1 = inflater.inflate(R.layout.row, container, false);
            int rInt = r.nextInt(13);

            TextView txt1 = view1.findViewById(R.id.text1);
            txt1.setText(date[i % 7]);

            ImageView img = view1.findViewById(R.id.weather_icon);
            img.setImageResource(imageArray[rInt]);

            /*random description and temperature*/
            temperature = (10 + rInt) + "\u00B0C" + " - " + (20 + rInt) + "\u00B0C";
            if (weather[rInt].contains("snow"))
                temperature = "5\u00B0C - 7\u00B0C";

            TextView txt2 = view1.findViewById(R.id.text2);
            txt2.setText(weather[rInt] + "\n" + temperature);

            llvertical.addView(view1);
        }
        return view;
    }
}
