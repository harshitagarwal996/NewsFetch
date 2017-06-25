package com.example.harshit.newsfetch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Harshit on 30-05-2017.
 */
class News{
    String name;
    String designation;
    String salary;
}

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    List<News> News;
    NewsAdapter(List<News> News){
        this.News=News;
    }
    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycler_view_news_list, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.NewsListName.setText(News.get(position/2).name);//News.get(position).name.toString());
        holder.NewsListDesignation.setText(News.get(position/2).designation);//News.get(position).name.toString());
        holder.NewsListSalary.setText(News.get(position/2).salary.toString());//News.get(position).name.toString());

        holder.NewsListName2.setText(News.get(position/2+1).name);//News.get(position).name.toString());
        holder.NewsListDesignation2.setText(News.get(position/2+1).designation);//News.get(position).name.toString());
        holder.NewsListSalary2.setText(News.get(position/2+1).salary.toString());
    }

    @Override
    public int getItemCount() {
        if (News != null) {
            return News.size();
        }
        return 0;
    }


    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView NewsListName;
        TextView NewsListName2;
        TextView NewsListDesignation;
        TextView NewsListDesignation2;
        TextView NewsListSalary;
        TextView NewsListSalary2;

        public NewsViewHolder(View itemView) {
            super(itemView);
            NewsListName=(TextView)itemView.findViewById(R.id.list_news_name);
            NewsListName2=(TextView)itemView.findViewById(R.id.list_news_name2);
            NewsListDesignation=(TextView)itemView.findViewById(R.id.list_news_designation);
            NewsListDesignation2=(TextView)itemView.findViewById(R.id.list_news_designation2);
            NewsListSalary=(TextView)itemView.findViewById(R.id.list_news_salary);
            NewsListSalary2=(TextView)itemView.findViewById(R.id.list_news_salary2);
        }
    }
}
