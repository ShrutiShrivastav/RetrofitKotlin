package com.example.retrofitkotlin

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.ApiInterface
import com.example.model.BillPaymentModel
import kotlinx.android.synthetic.main.activity_bill_payment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BillPayment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill_payment)

        getBillData()
    }

    fun getBillData(){
        Log.d("TAG", "onCreate:   after call")

        //creating retrofit object
        val retrofit = Retrofit.Builder()
                .baseUrl("http://app.shopazo.com:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        //creating object of our interface
        val apiInterface: ApiInterface = retrofit.create(ApiInterface::class.java)

        // passing parameter using model object
        val billPaymentModel = BillPaymentModel("1", "2","Type","120","Okay","90","bye")

        //creating call object and passing data in model
        val call: Call<BillPaymentModel?>? = apiInterface.getBillData(billPaymentModel)

        call!!.enqueue(object : Callback<BillPaymentModel?> {
            override fun onResponse(
                    call: Call<BillPaymentModel?>,
                    response: Response<BillPaymentModel?>
            ) {
                Log.d("TAG", "onResponse1: $response")
                if (response.isSuccessful) {

                    //  tv_response.setText("Code" + response.code());

                        Log.d(TAG, "onResponse: "+ billPaymentModel.userId)
                    Log.d(TAG, "onResponse: "+ billPaymentModel.mobileId)
                    Log.d(TAG, "onResponse: "+ billPaymentModel.type)
                    Log.d(TAG, "onResponse: "+ billPaymentModel.total)
                    Log.d(TAG, "onResponse: "+ billPaymentModel.responseDetail)
                    Log.d(TAG, "onResponse: "+ billPaymentModel.creditToken)
                    Log.d(TAG, "onResponse: "+ billPaymentModel.reference)



                }
            }

            override fun onFailure(call: Call<BillPaymentModel?>, t: Throwable) {
                Log.d("TAG", "onFailure: " + t.localizedMessage)
                tv_response.setText(t.message)
            }
        })


    }


}