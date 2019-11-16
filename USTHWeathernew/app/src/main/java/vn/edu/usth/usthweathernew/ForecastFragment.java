package vn.edu.usth.usthweathernew;


import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastFragment extends Fragment {

    private final String date[] = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
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

    private final String weather[] = {
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


    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forecast, container, false);

        ScrollView scrollView = new ScrollView(getActivity());
        LinearLayout llvertical = new LinearLayout(getActivity());
        llvertical.setOrientation(LinearLayout.VERTICAL);
        llvertical.setPadding(10, 10, 10, 10);
        llvertical.setBackgroundResource(R.drawable.gradient);

        int i;
        Random randImage = new Random();

        for (i = 0; i < 30; i++) {
            int input = randImage.nextInt(imageArray.length);
            llvertical.addView(addLinearLayoutHorizontal(date[i % 7], input));
        }
        scrollView.setVerticalScrollBarEnabled(true);
        scrollView.setHorizontalScrollBarEnabled(false);
        scrollView.setSmoothScrollingEnabled(true);
        scrollView.addView(llvertical);
        return scrollView;
    }


    private LinearLayout addLinearLayoutHorizontal(String date, int input) {
        LinearLayout llhorizontal = new LinearLayout(getActivity());
        llhorizontal.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 4
        );
        llParams.setMargins(10, 10, 10, 10);
        llhorizontal.setGravity(Gravity.CENTER_VERTICAL);
        //llhorizontal.setPadding(10, 10, 10, 20);
        llhorizontal.setLayoutParams(llParams);
        llhorizontal.addView(addTextView1(date));
        llhorizontal.addView(addImageView(input));
        llhorizontal.addView(addTextView2(input));
        return llhorizontal;
    }

    private TextView addTextView1(String text) {
        TextView textView = new TextView(getActivity());
        textView.setText(text);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(10);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setTypeface(Typeface.DEFAULT_BOLD);

        LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(
                80,
                80, 1

        );
        textViewParams.setMargins(10, 10, 10, 10);
        textView.setLayoutParams(textViewParams);
        return textView;
    }


    private ImageView addImageView(int input) {
        ImageView imageView = new ImageView(getActivity());
        /*Random choose image weather*/

        imageView.setImageResource(imageArray[input]);

        imageView.setScaleType(ImageView.ScaleType.FIT_START);
        LinearLayout.LayoutParams imageViewParams = new LinearLayout.LayoutParams(
                120,
                80, 1

        );
        //imageViewParams.weight=1;
        imageViewParams.setMargins(10, 10, 10, 10);
        imageView.setLayoutParams(imageViewParams);
        return imageView;
    }

    private TextView addTextView2(int input) {
        TextView textView = new TextView(getActivity());
        Random r = new Random();
        int rInt = r.nextInt(10);
        String temperature = (10 + rInt) + "\u00B0C" + " - " + (20 + rInt) + "\u00B0C";
        if (weather[input].contains("snow"))
            temperature = "5\u00B0C - 7\u00B0C";
        textView.setText(weather[input] + "\n" + temperature);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(10);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(
                200,
                80, 2
        );
        //textViewParams.weight=1;
        textViewParams.setMargins(20, 10, 10, 10);
        textView.setLayoutParams(textViewParams);
        return textView;
    }

}
