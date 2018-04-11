package com.amely.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.amely.myapplication.fragment.AFragment;
import com.amely.myapplication.fragment.BFragment;
import com.amely.myapplication.fragment.CFragment;

public class MainActivity extends AppCompatActivity implements SetOnChangeFragmentListener {
    Fragment fragA, fragB, fragC;
    Context act;
    FragmentTransaction fragmentTransaction;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    private void initData() {
        constraintLayout = findViewById(R.id.lineContainer);
        fragA = AFragment.newInstance();
        fragB = BFragment.newInstance();
        fragC = CFragment.newInstance();
        act = getApplicationContext();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.lineContainer, fragA).commit();
    }


    @Override
    public void onChangeListener(int frag) {
        switch (frag) {
            case 1:
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
                        .add(R.id.lineContainer, fragB)
                        .addToBackStack(null)
                        .commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit).add(R.id.lineContainer, fragC).addToBackStack(null).commit();
                break;
            case 3:
//                getSupportFragmentManager().beginTransaction().add(R.id.lineContainer, fragA).addToBackStack(null).commit();
                getSupportFragmentManager().popBackStack();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            Log.e("MainActivity", "popping backstack");
            getSupportFragmentManager().popBackStack();
        } else {
            Log.e("MainActivity", "nothing on backstack, calling super");
            super.onBackPressed();
        }
    }
}
