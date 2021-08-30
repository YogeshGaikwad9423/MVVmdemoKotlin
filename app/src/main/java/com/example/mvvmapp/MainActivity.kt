package com.example.mvvmapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmapp.Adapter.UserlistAdapter
import com.example.mvvmapp.viewmodel.MainActivityViewmodel
import com.example.mvvmapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var recyclerAdapter: UserlistAdapter
    lateinit var  binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
       // binding=ActivityMainBinding.inflate(layoutInflater)
        initrecyclerView()
        initviewmodel()
        //();
    }

 private fun initrecyclerView(){
     binding.userlistrecyclerView.layoutManager=LinearLayoutManager(this)
     recyclerAdapter= UserlistAdapter(this)
     binding.userlistrecyclerView.adapter=recyclerAdapter

    }
    private fun initviewmodel(){
       val viewmodel:MainActivityViewmodel = ViewModelProvider(this).get(MainActivityViewmodel::class.java)
        viewmodel.MakeApiCall()
        viewmodel.getLiveDataobserver().observe(this,{
            if (it != null){
                recyclerAdapter.setUserlist(it)
                recyclerAdapter.notifyDataSetChanged()
                binding.progressBar.setVisibility(View.GONE);


            }else{
                Toast.makeText(this,"Error in getting list",Toast.LENGTH_SHORT).show()
            }
        })
    }
}
