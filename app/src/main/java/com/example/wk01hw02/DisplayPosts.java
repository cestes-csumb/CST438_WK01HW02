/*
Title: DisplayPosts.java
Purpose: Use retrofit to get results back from API and display only the ones that match the userId passed in
 */
package com.example.wk01hw02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DisplayPosts extends AppCompatActivity {
    //Layout elements
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_posts);
        textViewResult = findViewById(R.id.text_view_result);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Get the extras passed in
        Bundle extras = getIntent().getExtras();
        Integer userId = extras.getInt("USER_ID");
        String username = extras.getString("USERNAME");
        //retrofit creates a bunch of code for us, we just need to supply it the interface
        JsonPlaceHolderAPI jsonPlaceHolderAPI = retrofit.create(JsonPlaceHolderAPI.class);
        Call<List<Post>> call = jsonPlaceHolderAPI.getPosts();
        /*since network access is required, enqueue is a method offered by retrofit so that this process
        is moved to the back. if we did execute() it would execute on the main process. we don't want this
         */
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                //If we don't get a successful response from our API call we want to output the error
                if (!response.isSuccessful()){
                    textViewResult.setText("Code : " + response.code());
                    return;
                }
                //this will give us our data from the API
                List<Post> posts = response.body();
                String postsContent = "";
                //Display welcome message
                postsContent += "Welcome " + username + "!\n\n";
                textViewResult.append(postsContent);
                //go through all posts and show only the posts with the specified userId
                for(Post post : posts){
                    if(post.getUserId() == userId){
                        postsContent = "";
                        postsContent += "Post ID: " + post.getId() + "\n";
                        postsContent += "Title: " + post.getTitle() + "\n";
                        postsContent += "Message: " + post.getBody() + "\n\n";
                        textViewResult.append(postsContent);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}