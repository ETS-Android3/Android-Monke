// ViewPagerAdapter class is an adapter which allows different fragments to be presented when certain tabs are used

package com.example.nomonkeyingaround;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch(position) {
            case 0:
                return new Settings();

            case 1:
                return new ActivityTracker();

            case 2:
                return new GrowATree();

            case 3:
                return new Calendar();

            default:
                return new TreeCollection();
        }
    }
    @Override
    public int getItemCount() {
        return 5;
    }
}