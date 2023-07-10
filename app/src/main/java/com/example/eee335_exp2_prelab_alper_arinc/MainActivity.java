package com.example.eee335_exp2_prelab_alper_arinc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_search; // define the android id of EditText
    Button b_search; // define the android id of Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_search = findViewById(R.id.et_search); // defining the EditText et_search to our variable et_search
        b_search = findViewById(R.id.b_search);  // defining the Button b_search to our variable b_search

        b_search.setOnClickListener(new View.OnClickListener() {  // Executes the following when clicked on the button.
            @Override
            public void onClick(View v) {
                String searchTerms = et_search.getText().toString();  // define a string, when its written down in edit text, we get it and convert it to string.
                if(!searchTerms.equals("")) {  // search everything unless its a blank search
                    searchNetCompat(searchTerms); // jump to searchNetCompat with searchTerms string
                }
            }
        });
    }


    // search internet with the default search app
    // private void searchNet(String words) {
    //    try {
    //        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
    //        intent.putExtra(SearchManager.QUERY, words);
    //        startActivity(intent);
    //    } catch (ActivityNotFoundException e) {
    //        e.printStackTrace();
    //        searchNetCompat(words);
    //    }
    // }
    // search internet with the browser if there's no default search app


    private void searchNetCompat(String words) {
        try {
            // Uri uri = Uri.parse("http://google.com/#q=" + words);  We could have used this to search something by default.
            Uri uri = Uri.parse("https://www.google.com/search?tbm=isch&q=" + words); // Search something in images, google
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(getBaseContext(), "Error!", Toast.LENGTH_SHORT).show();
        }

    }


}