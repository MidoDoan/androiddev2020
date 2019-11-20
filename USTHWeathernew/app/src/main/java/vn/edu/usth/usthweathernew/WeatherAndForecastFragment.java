package vn.edu.usth.usthweathernew;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherAndForecastFragment extends Fragment {


    public WeatherAndForecastFragment() {
        // Required empty public constructor
    }

    // newInstance constructor for creating fragment with arguments
    public static Fragment newInstance(int page, String title) {
        WeatherAndForecastFragment fragment1= new WeatherAndForecastFragment();
        Bundle args = new Bundle();
        args.putInt("page", page);
        args.putString("title",title);
        fragment1.setArguments(args);
        return fragment1;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_and_forecast, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle args = getArguments();
        ((TextView) view.findViewById(R.id.location))
                .setText(args.getString("title"));
    }

}

