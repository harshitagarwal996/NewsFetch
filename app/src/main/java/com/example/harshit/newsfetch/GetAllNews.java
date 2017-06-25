package com.example.harshit.newsfetch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class GetAllNews extends AppCompatActivity {
    ArrayList<News> NewsList=new ArrayList<News>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_news);
        Log.d("Harshit","in GetAllNews onCreate");
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view_all_news_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final NewsAdapter NewsAdapter = new NewsAdapter(NewsList);
        recyclerView.setAdapter(NewsAdapter);

        Log.d("Harshit","I am here");

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        String url=Config.URL_GET_ALL_NEWS;
        JsonObjectRequest request=new JsonObjectRequest(url,new JSONObject(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("Harshit",response.toString());
                NewsList.clear();
                try{
                    if (response.length()>0){
                        JSONArray jsonArray=response.getJSONArray("result");
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject=jsonArray.getJSONObject(i);
                            Log.d("Harshit",jsonObject.getString("name").toString());
                            News News=new News();
                            if (!jsonObject.isNull("name")) {
                                News.name=jsonObject.getString("name");
                                News.designation=jsonObject.getString("desg");
                                News.salary=jsonObject.getString("salary");
                            }
                            NewsList.add(News);
                            Log.d("Harshit","reached here");
                        }
                        NewsAdapter.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Harshit", error+"");

            }
        });
        requestQueue.add(request);
        Log.d("Harshit","After request queue");
    }
}

