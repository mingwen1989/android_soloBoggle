package com.example.guest.soloboggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {

    public static final String TAG = PlayActivity.class.getSimpleName();

    public static String newArray(){
        ArrayList<String> boggleOutputArray = new ArrayList<String>();
        String[] vowels = {"a","e","i","o","u"};
        String[] consonants = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        for(int i=1; i<9; i++){
            if(i < 2) {
                int vowel = (int) Math.ceil(Math.random() * 5);
                boggleOutputArray.add(vowels[vowel]);
            } else{
                int consonant = (int) Math.ceil(Math.random() * 26);
                boggleOutputArray.add(consonants[consonant]);
            }
            Log.d(TAG, boggleOutputArray.toString());

        };
        return boggleOutputArray.toString();
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        newArray();
    }
}
