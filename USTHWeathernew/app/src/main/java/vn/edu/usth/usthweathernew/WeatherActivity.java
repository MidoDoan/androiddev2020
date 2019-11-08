package vn.edu.usth.usthweathernew;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WeatherActivity extends AppCompatActivity {

    private static final String TAG ="WeatherActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "This is onCreate" );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "This is onPause" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "This is onDestroy" );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "This is onStart" );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "This is onStop" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "This is onResume" );
    }
}
