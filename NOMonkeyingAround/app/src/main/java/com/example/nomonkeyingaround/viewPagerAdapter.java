// ViewPagerAdapter class is an adapter which allows different fragments to be presented when certain tabs are used

package com.example.nomonkeyingaround;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class viewPagerAdapter extends FragmentStateAdapter {

    public viewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch(position) {
            case 0:
                return new settings();

            case 1:
                return new activity_tracker();

            case 2:
                return new grow_a_tree();

            default:
                return new to_do();

        }
    }
    @Override
    public int getItemCount() {
        return 4;
    }
}