package com.example.guest.soloboggle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class PlayActivity extends AppCompatActivity {

    public static final String TAG = PlayActivity.class.getSimpleName();

    private TextView mBoggleTextView;
    private Button mSubmitWordButton;
    private EditText mInputBoggleWord;


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
        final String boggleLetters = testOutput;
        mBoggleTextView.setText(boggleLetters);
        mInputBoggleWord = (EditText) findViewById(R.id.inputBoggleWord);
        mSubmitWordButton = (Button) findViewById(R.id.submitWordButton);
        mSubmitWordButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String word = mInputBoggleWord.getText().toString();

                ArrayList<String> checkBoggleString = new ArrayList<String>(Arrays.asList(boggleLetters.split(" ")));
                ArrayList<String> checkWordString = new ArrayList<String>(Arrays.asList(word.split("")));
                checkWordString.remove(0);

                Boolean continueOn = false;

                for (String letter : checkWordString) {
                    if (letter.equals(checkBoggleString.get(0)) || letter.equals(checkBoggleString.get(1)) || letter.equals(checkBoggleString.get(2)) || letter.equals(checkBoggleString.get(3)) || letter.equals(checkBoggleString.get(4)) || letter.equals(checkBoggleString.get(5)) || letter.equals(checkBoggleString.get(6)) || letter.equals(checkBoggleString.get(7))) {
                        continueOn = true;
                    } else {
                        Toast.makeText(PlayActivity.this, "Does not contain boggle letters!", Toast.LENGTH_LONG).show();
                        break;

                    }
                }
                if (continueOn == true) {
                    Intent intent = new Intent(PlayActivity.this, BoggleActivity.class);
                    intent.putExtra("word", word);
                    intent.putExtra("boggleLetters", boggleLetters);
                    startActivity(intent);
                }

            }
        });
    }
}


