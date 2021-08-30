
package com.example.mvvmapp.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmapp.data.Datum
import com.example.mvvmapp.data.Usermodel
import com.example.mvvmapp.data.Welcome7
import com.example.mvvmapp.retrofit.RetroInstance
import com.example.mvvmapp.retrofit.RetroInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewmodel: ViewModel() {
    lateinit var livedatalist:MutableLiveData<List<Datum>>
    init {
        livedatalist= MutableLiveData()
    }

    fun getLiveDataobserver():MutableLiveData<List<Datum>>{
        return livedatalist
    }

    fun MakeApiCall(){
       val retroInstance =RetroInstance.getretroInstance()
        val retroService=retroInstance.create(RetroInterface::class.java)
        var call = retroService.getuserlist()
        call.enqueue(object :Callback<Welcome7>{
            override fun onResponse(call: Call<Welcome7>?, response: Response<Welcome7>?) {
                if (response != null) {
                    livedatalist.postValue(response.body().data)
                }
            }
            override fun onFailure(call: Call<Welcome7>?, t: Throwable?) {
                   livedatalist.postValue(null)
            }

        })
    }

}


