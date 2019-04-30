package com.udacity.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.Collections;

public class DetailActivity extends AppCompatActivity {
    public static final String MOVIE_DETAILS = "movie_details";

//    public static final String EXTRA_POSITION = "extra_position";
//    private static final int DEFAULT_POSITION = -1;
//
//    ImageView ingredientsIv;
//    TextView origin_tv;
//    TextView also_known_tv;
//    TextView ingredients_tv;
//    TextView description_tv;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detail);
//
//        ingredientsIv = findViewById(R.id.image_iv);
//        origin_tv = findViewById(R.id.origin_tv);
//        also_known_tv = findViewById(R.id.also_known_tv);
//        ingredients_tv = findViewById(R.id.ingredients_tv);
//        description_tv = findViewById(R.id.description_tv);
//
//        Intent intent = getIntent();
//        if (intent == null) {
//            closeOnError();
//            return;
//        }
//
//        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
//        if (position == DEFAULT_POSITION) {
//            // EXTRA_POSITION not found in intent
//            closeOnError();
//            return;
//        }
//
//        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
//        ArrayList<Sandwich> sandwichArrayList = new ArrayList<>();
//        for (String sandwichJson : sandwiches) {
//            sandwichArrayList.add(JsonUtils.parseSandwichJson(sandwichJson));
//        }
//        Collections.sort(sandwichArrayList);
//        Sandwich sandwich = sandwichArrayList.get(position);
//        if (sandwich == null) {
//            // Sandwich data unavailable
//            closeOnError();
//            return;
//        }
//
//        populateUI(sandwich);
//        Picasso.with(this)
//                .load(sandwich.getImage())
//                .placeholder(R.drawable.placeholder)
//                .error(R.drawable.error)
//                .into(ingredientsIv);
//
//        setTitle(sandwich.getName().getMainName());
//    }
//
//    private void closeOnError() {
//        finish();
//        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
//    }
//
//    private void populateUI(Sandwich sandwich) {
//        if (sandwich.getPlaceOfOrigin() != null) {
//            origin_tv.setText(sandwich.getPlaceOfOrigin());
//        }
//
//        if (sandwich.getName().getAlsoKnownAs() != null && !sandwich.getName().getAlsoKnownAs().isEmpty()) {
//            StringBuilder sb = new StringBuilder();
//            for (String val : sandwich.getName().getAlsoKnownAs()) {
//                sb.append(val).append("\n");
//            }
//            also_known_tv.setText(sb.toString());
//        }
//
//        if (sandwich.getIngredients() != null && !sandwich.getIngredients().isEmpty()) {
//            StringBuilder sb = new StringBuilder();
//            for (String val : sandwich.getIngredients()) {
//                sb.append("- ").append(val).append("\n");
//            }
//            ingredients_tv.setText(sb.toString());
//        }
//
//        if (sandwich.getDescription() != null) {
//            description_tv.setText(sandwich.getDescription());
//        }
//    }
}
