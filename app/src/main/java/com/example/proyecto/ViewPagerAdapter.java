package com.example.proyecto;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(FragmentActivity fa) {
        super(fa);
    }

    @Override
    public Fragment createFragment(int position) {
        // Crear un fragmento diferente para cada página
        switch (position) {
            case 0:
                return new FactoFragment();
            case 1:
                return new FavoritesFragment();

            default:
                return new FactoFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

