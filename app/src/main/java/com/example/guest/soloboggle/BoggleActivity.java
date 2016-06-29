package com.example.guest.soloboggle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BoggleActivity extends AppCompatActivity {
    @Bind(R.id.boggleGuesses) ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boggle);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String word = intent.getStringExtra("word");
        ArrayList<String> word2 = new ArrayList<>();
        word2.add(word);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, word2);
        mListView.setAdapter(adapter);

    }
}
