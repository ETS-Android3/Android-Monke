package com.example.nomonkeyingaround;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link calendar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class calendar extends Fragment implements View.OnClickListener {

    Button callMonthView;
    Button callWeekView;
    Button callDayView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public calendar() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment to_do.
     */
    // TODO: Rename and change types and number of parameters
    public static calendar newInstance(String param1, String param2) {
        calendar fragment = new calendar();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_calendar, container, false);

        callMonthView = mView.findViewById(R.id.monthly);
        callMonthView.setOnClickListener(this);

        callWeekView = mView.findViewById(R.id.weekly);
        callWeekView.setOnClickListener(this);

        callDayView = mView.findViewById(R.id.daily);
        callDayView.setOnClickListener(this);

        return mView;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.monthly) {
            Toast.makeText(view.getContext(), "Monthly", Toast.LENGTH_SHORT).show();
        }
        else if (view.getId() == R.id.weekly) {
            Toast.makeText(view.getContext(), "Weekly", Toast.LENGTH_SHORT).show();
        }
        else if (view.getId() == R.id.daily) {
            Toast.makeText(view.getContext(), "Daily", Toast.LENGTH_SHORT).show();
        }
    }
}