package com.example.oo_vko12;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.oo_vko12.sampledata.Etusivu;
import com.example.oo_vko12.sampledata.Info;
import com.example.oo_vko12.sampledata.LisaaUusi;
import com.example.oo_vko12.sampledata.Lista;


public class TabPagerAdapter extends FragmentStateAdapter {


    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Etusivu();
            case 1:
                return new Lista();
            case 2:
                return new LisaaUusi();
            default:
                return new Info();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
