package com.inf2bm.dicesimulator;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PlayingTimeFragment extends Fragment {

    private Chronometer mChronometer;


public PlayingTimeFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View mView=inflater.inflate(R.layout.fragment_playing_time, container, false);
        mChronometer=mView.findViewById(R.id.chronometer_time);
        long value = getArguments().getLong("message");
        long deltaTime = SystemClock.elapsedRealtime()-value;

        if(deltaTime>=1000 && value>0){
            mChronometer.setBase(value);
            mChronometer.start();
        }
        return mView;

        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
