package com.example.retrofitkotlin

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ApiInterface
import com.example.model.BillPaymentModel
import com.example.model.LoginModel
import kotlinx.android.synthetic.main.activity_bill_payment.*
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        loginUser()
    }

    private fun loginUser(){

        val retrofit = Retrofit.Builder()
                .baseUrl("http://app.shopazo.com:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val apiInterface : ApiInterface = retrofit.create(ApiInterface :: class.java)

        //PASSING PARAMETER USING JSON
         val paramObject = JSONObject()
            paramObject.put("username", "guestmadhu");
            paramObject.put("password", "909090");
            paramObject.put("device_id", "deviceId");
            paramObject.put("login_type", "guest");
            paramObject.put("mobile_id", "m_androidId");

        val call: Call<LoginModel?> = apiInterface.loginUser(paramObject)

        call.enqueue(object : Callback<LoginModel?> {
            override fun onResponse(
                    call: Call<LoginModel?>,
                    response: Response<LoginModel?>
            ) {
                Log.d("TAG", "onResponse1: $response")
                if (response.isSuccessful) {

                      tv_title.setText("Code" +(response.body()?.data?.email ));

                    Log.d(ContentValues.TAG, "onResponse: "+ (response.body()?.status))
                    Log.d(ContentValues.TAG, "onResponse: "+ (response.body()?.message))
                    Log.d(ContentValues.TAG, "onResponse: "+ (response.body()?.data?.id  ))
                    Log.d(ContentValues.TAG, "onResponse: "+ (response.body()?.data?.name  ))
                    Log.d(ContentValues.TAG, "onResponse: "+ (response.body()?.data?.email  ))
                    Log.d(ContentValues.TAG, "onResponse: "+ (response.body()?.data?.phoneNumber  ))
                    Log.d(ContentValues.TAG, "onResponse: "+ (response.body()?.data?.profile  ))
                    Log.d(ContentValues.TAG, "onResponse: "+ (response.body()?.data?.city))
                    Log.d(ContentValues.TAG, "onResponse: "+ (response.body()?.data?.state  ))
                    Log.d(ContentValues.TAG, "onResponse: "+ (response.body()?.data?.address  ))

                    return

                }
            }

            override fun onFailure(call: Call<LoginModel?>, t: Throwable) {
                Log.d("TAG", "onFailure: " + t.localizedMessage)
                tv_response.setText(t.message)
            }
        })



    }


    }
