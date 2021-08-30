package com.example.mvvmapp.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapp.data.Datum
import com.example.mvvmapp.databinding.ListItemBinding


class UserlistAdapter (var context: Context): RecyclerView.Adapter<UserlistAdapter.MyViewHolder>(){
    private  var userlist: List<Datum>?=null
    fun setUserlist(userlist: List<Datum>?){
        this.userlist=userlist
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserlistAdapter.MyViewHolder {
        var binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserlistAdapter.MyViewHolder, position: Int) {
     holder.bind(userlist?.get(position))
    }

    override fun getItemCount(): Int {
        if (userlist==null)return 0
        else return userlist?.size!!
    }


    inner class MyViewHolder(public  val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(uermodel: Datum?) {
            binding.listItem=uermodel
        }
    }
    }