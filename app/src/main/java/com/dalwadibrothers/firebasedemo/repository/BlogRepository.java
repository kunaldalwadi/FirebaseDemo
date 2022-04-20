package com.dalwadibrothers.firebasedemo.repository;

import com.dalwadibrothers.firebasedemo.model.Blog;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

public class BlogRepository {
   
   private static final String TAG = BlogRepository.class.getSimpleName();
   public static final String BLOG = "Blog";
   
   MutableLiveData<List<Blog>> mBlogListMutableLiveData;
   MutableLiveData<Blog> mBlogMutableLiveData;
   FirebaseFirestore mFirestore;
   
   public BlogRepository() {
      
      mBlogListMutableLiveData = new MutableLiveData<>();
      mBlogMutableLiveData = new MutableLiveData<>();
      mFirestore = FirebaseFirestore.getInstance();
      
   }
   
   public MutableLiveData<List<Blog>> getBlogListMutableLiveData() {
      
      mFirestore.collection(BLOG)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                   @Override
                   public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
   
                      ArrayList<Blog> blogList = new ArrayList<>();
                      for (QueryDocumentSnapshot doc : value) {
                         if (doc.exists()) {
                            blogList.add(doc.toObject(Blog.class));
                         }
                      }
                      
                      mBlogListMutableLiveData.postValue(blogList);
                   }
                });
      
      return mBlogListMutableLiveData;
   }
}
