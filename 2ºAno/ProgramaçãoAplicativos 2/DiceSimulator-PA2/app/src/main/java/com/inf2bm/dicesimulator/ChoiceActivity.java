package com.inf2bm.dicesimulator;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Random;

public class ChoiceActivity extends AppCompatActivity {

    public BottomNavigationView mBottomNavigationView;

    private LoseFragment mLoseFragment = new LoseFragment();
    private WinFragment mWinFragment = new WinFragment();
    private PlayingTimeFragment mPlayingTimeFragment = new PlayingTimeFragment();

    private EmptyFragment mEmptyFragment = new EmptyFragment();

    public int mNumberMatches=0;
    public int mNumberWins=0;
    public long mTimeStart=0;

    private Random rnd = new Random();
    private String mMessageDisplay;

    public ChipGroup mChipGroupOption;

    private int mChipSelected=0;
    private Button mButtonStart;
    public TextView mTextViewDice;
    private ImageView mImageView;

    private void showResult(int value){
        mMessageDisplay="Errou...";
        if(value==mChipSelected ) {
           mMessageDisplay="Acertou";
           mNumberWins++;

        }
        Toast.makeText(this, mMessageDisplay, Toast.LENGTH_SHORT).show();

    }


    private void showImage(int value) {
        switch (value) {
            case 1: mImageView.setImageResource(R.drawable.ic_dice_yellow_1); break;
            case 2: mImageView.setImageResource(R.drawable.ic_dice_yellow_2); break;
            case 3: mImageView.setImageResource(R.drawable.ic_dice_yellow_3); break;
            case 4: mImageView.setImageResource(R.drawable.ic_dice_yellow_4); break;
            case 5: mImageView.setImageResource(R.drawable.ic_dice_yellow_5); break;
            case 6: mImageView.setImageResource(R.drawable.ic_dice_yellow_6); break;

        }

    }


    private void launchDice(){
        mNumberMatches++;
        if(mTimeStart==0 ) {
            mTimeStart= SystemClock.elapsedRealtime();
        }
        int number=rnd.nextInt(6)+1;
        mTextViewDice.setText("" +number);
        showImage(number);
        showResult(number);

    }

    private class FilterChipSelectedInTheGroup implements ChipGroup.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(ChipGroup group, int checkedId) {
            switch (group.getCheckedChipId()){
                case R.id.chip1: mChipSelected=1; break;
                case R.id.chip2: mChipSelected=2; break;
                case R.id.chip3: mChipSelected=3; break;
                case R.id.chip4: mChipSelected=4; break;
                case R.id.chip5: mChipSelected=5; break;
                case R.id.chip6: mChipSelected=6; break;


            }
        }
    }

    public class ClickMyButtonPlay implements View

            .OnClickListener{
        @Override
        public void onClick(View v) {
            launchDice();
        }
    }


    private void setDisableWidGets(boolean value) {
        if(value) {
            mChipGroupOption.setVisibility(View.GONE);
            mButtonStart.setVisibility(View.GONE);
            mImageView.setVisibility(View.GONE);
            mTextViewDice.setVisibility(View.GONE);
        } else {
            mChipGroupOption.setVisibility(View.VISIBLE);
            mButtonStart.setVisibility(View.VISIBLE);
            mImageView.setVisibility(View.VISIBLE);
            mTextViewDice.setVisibility(View.VISIBLE);
        }

    }


    private void setCurrentFragment(Fragment currentFragment , long value) {
        Bundle mBundle = new Bundle();
        mBundle.putLong("message", value);
        currentFragment.setArguments(mBundle);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout_message, currentFragment).commit();


    }


    public class ClickItemBottomNavigationView implements NavigationBarView.OnItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

           switch(item.getItemId()){
               case R.id.item_game: setDisableWidGets(false); setCurrentFragment(mEmptyFragment, mNumberMatches); return true;
               case R.id.item_win: setDisableWidGets(true); setCurrentFragment(mWinFragment, mNumberWins); return true;
               case R.id.item_lose: setDisableWidGets(true); setCurrentFragment(mLoseFragment, (mNumberMatches - mNumberWins)); return true;
               case R.id.item_time: setDisableWidGets(true); setCurrentFragment(mPlayingTimeFragment, mTimeStart); return true;



           }

            return false;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        mChipGroupOption=findViewById(R.id.chipGroup_option);
        mChipGroupOption.setOnCheckedChangeListener(new FilterChipSelectedInTheGroup());


        mButtonStart=findViewById(R.id.button_start);
        mButtonStart.setOnClickListener(new ClickMyButtonPlay());

        mImageView=findViewById(R.id.imageView_dice);
        mImageView.setOnClickListener(new ClickMyButtonPlay());

        mTextViewDice = findViewById(R.id.textView_dice_value);

        mBottomNavigationView=findViewById(R.id.bottomNavigationView);
       mBottomNavigationView.setOnItemSelectedListener(new ClickItemBottomNavigationView());




    }
}
