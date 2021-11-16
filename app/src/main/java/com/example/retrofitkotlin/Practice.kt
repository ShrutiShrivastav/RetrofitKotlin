package com.example.retrofitkotlin

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ApiInterface
import com.example.model.BillPaymentModel
import com.example.model.PracticeModel
import kotlinx.android.synthetic.main.activity_bill_payment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Practice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice)

        getData()
    }

    fun getData(){
        //creating retrofit object
        val retrofit = Retrofit.Builder()
            .baseUrl("http://18.221.196.189/api/wheel/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //creating object of our interface
        val apiInterface: ApiInterface = retrofit.create(ApiInterface::class.java)


        // passing parameter using model object
        var practiceModel = PracticeModel()



        //creating call object and passing data in model
        val call: Call<PracticeModel?> = apiInterface.getData(10)

        call.enqueue(object : Callback<PracticeModel?> {
            override fun onResponse(
                call: Call<PracticeModel?>,
                response: Response<PracticeModel?>
            ) {
                Log.d("TAG", "onResponse1: $response")
                if (response.isSuccessful) {

                    practiceModel = response.body()!!
                    //  tv_response.setText("Code" + response.code());
                    Log.d("TAG", "PracticeResponse1: " + (response.body()?.userWheel  ))
                    Log.d("TAG", "PracticeResponse2: " +practiceModel.userWheel?.get(0)?.id)
                    Log.d("TAG", "PracticeResponse2: " +practiceModel.userWheel?.get(0)?.user)
                    Log.d("TAG", "PracticeResponse2: " +practiceModel.userWheel?.get(0)?.mood)

                    Log.d("TAG", "PracticeResponse2: " +practiceModel.userWheel?.get(1)?.id)
                    Log.d("TAG", "PracticeResponse2: " +practiceModel.userWheel?.get(1)?.user)
                    Log.d("TAG", "PracticeResponse2: " +practiceModel.userWheel?.get(1)?.mood)

                    Log.d("TAG", "PracticeResponse2: " +practiceModel.userWheel?.get(2)?.id)
                    Log.d("TAG", "PracticeResponse2: " +practiceModel.userWheel?.get(2)?.user)
                    Log.d("TAG", "PracticeResponse2: " +practiceModel.userWheel?.get(2)?.mood)

                    Log.d("TAG", "PracticeResponse2: " +practiceModel.userWheel?.get(3)?.id)
                    Log.d("TAG", "PracticeResponse2: " +practiceModel.userWheel?.get(3)?.user)
                    Log.d("TAG", "PracticeResponse2: " +practiceModel.userWheel?.get(3)?.mood)

                }
            }

            override fun onFailure(call: Call<PracticeModel?>, t: Throwable) {
                Log.d("TAG", "onFailure: " + t.localizedMessage)
                tv_response.setText(t.message)
            }
        })

    }
}