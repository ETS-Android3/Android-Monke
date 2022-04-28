package com.example.nomonkeyingaround;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.FirebaseAppLifecycleListener;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GrowATree#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GrowATree extends Fragment {

    public TextView timerText;
    public Button startButton;
    public Button resetButton;

    Timer timer;
    TimerTask timerTask;
    double time = 0.0;

    boolean timerStarted = false;
    boolean isInBackground;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GrowATree() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment grow_a_tree.
     */
    // TODO: Rename and change types and number of parameters
    public static GrowATree newInstance(String param1, String param2) {
        GrowATree fragment = new GrowATree();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_grow_a_tree, container, false);

        timerText = (TextView) mView.findViewById(R.id.timerText);
        startButton = (Button) mView.findViewById(R.id.startButton);
        resetButton = (Button) mView.findViewById(R.id.resetButton);

        timer = new Timer();


        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View mView) {
                if (!timerStarted) {
                    timerStarted = true;
                    setButtonUI("STOP");
                    startTimer();
                } else {
                    timerStarted = false;
                    setButtonUI("START");

                    timerTask.cancel();
                }
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View mView) {

                if (timerTask != null) {
                    timerTask.cancel();
                    setButtonUI("START");
                    time = 0;
                    timerStarted = false;
                    timerText.setText(formatTime(0, 0, 0));
                }
            }
        });

        return mView;
    }
    private void setButtonUI(String text) {
        startButton.setText(text);
    }

    private void startTimer()
    {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time++;
                        timerText.setText(getTimerText());
                    }
                });

            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    private String getTimerText()
    {

        int rounded = (int) Math.round(time);

        int seconds = ((rounded % 86400) % 3600) % 60;
        int minutes = ((rounded % 86400) % 3600) / 60;
        int hours = ((rounded % 86400) / 3600);


        return formatTime(seconds, minutes, hours);
    }

    private  String formatTime(int seconds, int minutes, int hours) {
        return String.format("%02d", hours) + ":"
                + String.format("%02d", minutes) + ":"
                + String.format("%02d", seconds);
    }

}