package com.dalwadibrothers.firebasedemo.viewmodel;

import android.app.Application;


import com.dalwadibrothers.firebasedemo.model.Blog;
import com.dalwadibrothers.firebasedemo.repository.BlogRepository;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
   
   MutableLiveData<List<Blog>> blogListMutableLiveData;
   FirebaseFirestore mFirestore;
   BlogRepository mBlogRepository;
   
   public MainActivityViewModel() {
      
      mBlogRepository = new BlogRepository();
      blogListMutableLiveData = mBlogRepository.getBlogListMutableLiveData();
      mFirestore = FirebaseFirestore.getInstance();
   }
   
   public MutableLiveData<List<Blog>> getBlogListMutableLiveData() {
      return blogListMutableLiveData;
   }
}
