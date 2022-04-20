package com.dalwadibrothers.firebasedemo;

import android.os.Bundle;

import com.dalwadibrothers.firebasedemo.databinding.MainActivityBinding;
import com.dalwadibrothers.firebasedemo.model.Blog;
import com.dalwadibrothers.firebasedemo.model.BlogAdapter;
import com.dalwadibrothers.firebasedemo.viewmodel.MainActivityViewModel;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

public class MainActivity extends AppCompatActivity {
    
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String USERS = "users";
    private FirebaseFirestore db;
    
    private MainActivityBinding mMainActivityBinding;
    private BlogAdapter mBlogAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        
        getSupportActionBar().setTitle("Firebase Demo with MVVM");
        
        //Connect ViewModel
        MainActivityViewModel mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        
        mMainActivityBinding.rvBlogList.setLayoutManager(new LinearLayoutManager(this));
        mMainActivityBinding.rvBlogList.setHasFixedSize(true);
        
        mainActivityViewModel.getBlogListMutableLiveData().observe(this, new Observer<List<Blog>>() {
            @Override
            public void onChanged(List<Blog> blogs) {
                
                mBlogAdapter = new BlogAdapter(blogs);
                mMainActivityBinding.rvBlogList.setAdapter(mBlogAdapter);
                mBlogAdapter.notifyDataSetChanged();
            }
        });
    }
    
   // You can only delete a document inside a collection from Android app.
    //You can NOT delete a collection on firestore from android app.
    
}