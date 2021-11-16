package com.example.retrofitkotlin

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ApiInterface
import com.example.model.Model
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val request = ServiceBuilder.buildService(ApiInterface::class.java)
//        val call = request.getData("pb@gmail.com", "12345678")
//
//        call.enqueue(object : Callback<Model> {
//            override fun onResponse(call: Call<Model>, response: Response<Model>) {
//                if (response.isSuccessful) {
//                    Log.e("Rest response", "" + response)
//                    progress_bar.visibility = View.GONE
//                    Log.d("TAG", "onResponse: " + response.body())
//                    Log.d("TAG", "onResponse: " + response.body()!!.results)
//
//                    //  title = response.body()!!.results.first_name
////                    recyclerView.apply {
////                        setHasFixedSize(true)
////                        layoutManager = LinearLayoutManager(this@MainActivity)
////                        adapter = response.body()?.results?.let { MyAdapter(it) }
////                    }
//                }
//            }
//
//            override fun onFailure(call: Call<Model>, t: Throwable) {
//
//                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
//            }
//        })


        Log.d("TAG", "onCreate:   before call")
      postData();


    }


    private fun postData() {
        Log.d("TAG", "onCreate:   after call")
       /* //creating retrofit object
        val retrofit = Retrofit.Builder()
            .baseUrl("https://copyclikker.framework.infowindtech.biz/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()*/

        val retrofit = ServiceBuilder.buildService(ApiInterface::class.java)

       /* //creating object of our interface
        val jsonPlaceHolderApi: ApiInterface = retrofit.create(ApiInterface::class.java)
*/
        //creating call object
        val call: Call<Model?> = retrofit.getData("pb@gmail.com", "12345678")
        Log.d(TAG, "postData: Called  ")
        call.enqueue(object : Callback<Model?> {
            override fun onResponse(call: Call<Model?>, response: Response<Model?>) {
                Log.d("TAG", "onResponse1: $response")

                if (response.isSuccessful()) {


                    Log.d("TAG", "onResponse1: "+ (response.body()?.status))
                    Log.d("TAG", "onResponse1: "+ (response.body()?.message))
                    Log.d("TAG", "onResponse1: "+ (response.body()?.response?.userId))
                    Log.d("TAG", "onResponse1: "+ (response.body()?.response?.userName))
                    Log.d("TAG", "onResponse1: "+ (response.body()?.response?.userEmail))
                    Log.d("TAG", "onResponse1: "+ (response.body()?.response?.userPassword))

                    return }

            }
            override fun onFailure(call: Call<Model?>, t: Throwable) {
                Log.d("TAG", "onFailure: " + t.localizedMessage)
            }

        })


    }


}


