package com.example.guest.soloboggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {
    private TextView mBoggleTextView;

    public static final String TAG = PlayActivity.class.getSimpleName();

    public static String newBoggleString(){
        ArrayList<String> boggleOutputArray = new ArrayList<String>();
        String[] vowels = {"a","e","i","o","u"};
        String[] consonants = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        for(int i=1; i<9; i++){
            if(i < 3) {
                int vowel = (int) Math.floor(Math.random() * 5);
                boggleOutputArray.add(vowels[vowel]);
            } else{
                int consonant = (int) Math.floor(Math.random() * 25);
                boggleOutputArray.add(consonants[consonant]);
            }
        };
        return boggleOutputArray.toString()
                .replace(",", "")
                .replace("[", "")
                .replace("]", "");
    };

    private String testOutput = newBoggleString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        Log.d(TAG, newBoggleString());
        mBoggleTextView = (TextView) findViewById(R.id.boggleTextView);
        mBoggleTextView.setText(testOutput);
    }
}
