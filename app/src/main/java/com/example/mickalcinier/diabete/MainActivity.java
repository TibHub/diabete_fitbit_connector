package com.example.mickalcinier.diabete;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.content.SharedPreferences;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.preference.PreferenceManager;



public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL ="https://api.fitbit.com/";
    public final String TAG = MainActivity.this.getClass().getSimpleName();
    //private FitBitEndpointInterface apiService;
    //public ArrayList<Device> myDevices = new ArrayList<>();
    private SharedPreferences sharedPreferences;
    private String trackerId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this);
        //sharedPreferences.edit().remove(QuickPreferences.HAVE_AUTHORIZATION).commit();
        boolean haveToken = sharedPreferences.getBoolean(QuickPreferences.HAVE_AUTHORIZATION, false);

        if (!haveToken) {
            LoginActivity loginFragment = new LoginActivity();
            openFragment(loginFragment);

        } else {
            Boolean haveDeviceID = sharedPreferences.getBoolean(QuickPreferences.HAVE_DEVICE_ID, false);
            String fullAuthToken = sharedPreferences.getString(QuickPreferences.FULL_AUTHORIZATION, null);
        }
    }
        public void openFragment(Fragment myFragment) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(
                    R.animator.slide_in_left,
                    R.animator.slide_out_right,
                    R.animator.slide_out_left,
                    R.animator.slide_in_right);
            fragmentTransaction.replace(R.id.content_main, myFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
}
