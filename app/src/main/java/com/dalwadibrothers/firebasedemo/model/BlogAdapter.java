package com.dalwadibrothers.firebasedemo.model;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.dalwadibrothers.firebasedemo.databinding.BlogRowView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.BlogViewHolder> {
   
   private List<Blog> blogs;
   
   public BlogAdapter(List<Blog> blogs) {
      this.blogs = blogs;
   }
   
   @NonNull
   @Override
   public BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
   
      BlogRowView blogRowView = BlogRowView.inflate(LayoutInflater.from(parent.getContext()), parent, false);
      BlogViewHolder blogViewHolder = new BlogViewHolder(blogRowView);
      
      return blogViewHolder;
   }
   
   @Override
   public void onBindViewHolder(@NonNull BlogViewHolder holder, int position) {
      
      Glide.with(holder.mBlogRowView.getRoot()).load(blogs.get(position).imageUrl).centerCrop().into(holder.mBlogRowView.ivImage);
      holder.mBlogRowView.tvTitle.setText(blogs.get(position).title);
      holder.mBlogRowView.tvDescription.setText(blogs.get(position).description);
      
   }
   
   @Override
   public int getItemCount() {
      return blogs.size();
   }
   
   static class BlogViewHolder extends RecyclerView.ViewHolder {
      
      private BlogRowView mBlogRowView;
      
      public BlogViewHolder(@NonNull BlogRowView blogRowView) {
         super(blogRowView.getRoot());
         
         this.mBlogRowView = blogRowView;
      }
   }
}
