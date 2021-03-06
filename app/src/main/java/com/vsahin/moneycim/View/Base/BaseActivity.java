package com.vsahin.moneycim.View.Base;

import android.os.Bundle;

import com.vsahin.moneycim.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import butterknife.Unbinder;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    protected Unbinder unbinder;

    protected FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragmentManager = getSupportFragmentManager();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    protected void showRootFragment(Fragment fragment) {
        if(getFragmentBackStackCount() == 0) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    public void showFragment(Fragment nextFragment) {
        //be sure to not load same fragment
        if(isLastFragmentInBackstack(nextFragment)) {
            return;
        }

        fragmentManager.beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.fragment_container, nextFragment)
                .addToBackStack(nextFragment.getClass().getName())
                .commit();
    }

    private boolean isLastFragmentInBackstack(Fragment fragment) {
        String nextFragmentName = fragment.getClass().getName();

        return getFragmentBackStackCount() != 0 && getLastFragmentNameInBackStack().equals(nextFragmentName);
    }

    private String getLastFragmentNameInBackStack() {
        return fragmentManager.getBackStackEntryAt(getFragmentBackStackCount() - 1).getName();
    }

    protected int getFragmentBackStackCount() {
        return fragmentManager.getBackStackEntryCount();
    }
}
