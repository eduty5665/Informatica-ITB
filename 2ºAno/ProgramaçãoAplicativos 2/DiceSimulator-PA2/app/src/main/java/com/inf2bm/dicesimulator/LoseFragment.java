package com.inf2bm.dicesimulator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoseFragment extends Fragment {

    private TextView mTextViewLoseFragment;

    public LoseFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView=inflater.inflate(R.layout.fragment_lose, container, false);
        mTextViewLoseFragment = mView.findViewById(R.id.textView_lose_fragment);

        long value = getArguments().getLong("message");
        mTextViewLoseFragment.setText("" + value);

        return mView;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
