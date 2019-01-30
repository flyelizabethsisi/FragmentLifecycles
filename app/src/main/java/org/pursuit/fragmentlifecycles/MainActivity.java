package org.pursuit.fragmentlifecycles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        MainFragment mainFragment = MainFragment.newInstance(); // Yes
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, MainFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void showFirstFragment(String text) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, FirstFragment.newInstance(1, text))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void showSecondFragment() {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, //SecondFragment.newInstance would go here))
                .addToBackStack(null)
                .commit();
    }
}
