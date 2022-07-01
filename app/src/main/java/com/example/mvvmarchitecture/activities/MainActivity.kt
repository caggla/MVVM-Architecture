package com.example.mvvmarchitecture.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmarchitecture.R
import com.example.mvvmarchitecture.adapters.UsersAdapter
import com.example.mvvmarchitecture.models.User
import com.example.mvvmarchitecture.viewmodels.UserViewModel
import com.example.mvvmarchitecture.viewmodelsfactories.UserViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var listUsers: MutableList<User>
    private lateinit var adapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_main.layoutManager = LinearLayoutManager(this@MainActivity)
        listUsers = mutableListOf<User>()
        adapter = UsersAdapter(this,
            listUsers
        )
        recycler_main.adapter = adapter

        val userViewModel = ViewModelProvider(this,UserViewModelFactory(this)).get(UserViewModel::class.java)

        userViewModel.getData().observe(this,object:Observer<ArrayList<User>>{
            override fun onChanged(t: ArrayList<User>?) {
                listUsers.clear()
                t?.let { listUsers.addAll(it) }
                adapter.notifyDataSetChanged()
            }

        })

    }
}