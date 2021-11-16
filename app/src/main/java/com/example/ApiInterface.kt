package com.example

import com.example.model.BillPaymentModel
import com.example.model.LoginModel
import com.example.model.Model
import com.example.model.PracticeModel
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    //Clikker Login API
    @FormUrlEncoded
    @POST("?action=login")

    fun getData(// @Field("user_id") userId: String,
            //     @Field("user_email") userEmail: String,
                 @Field("user_name") userName: String,
                 @Field("user_password") userPassword: String): Call<Model?>


    //bill payment API
    @Headers(
        "Content-Type: application/json",
        "access-token: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InRlc2dAdGVzdGluZy5jb20iLCJuYW1lIjoiVXlpb3NhIiwiaWQiOjU3LCJpYXQiOjE2MzQ5OTczMTQsImV4cCI6MTYzNTYwMjExNH0.CrAbGx35cwG32vXC6jRHebt8LYocz6rQFriGvirSPjM"
    )
    @POST("add-bill-payments-history/")
  //  fun getBillData( ): Call<BillPaymentModel?>?
    fun getBillData(@Body  billPaymentModel: BillPaymentModel ) :Call<BillPaymentModel?>?


    //shopazo Login API

    @POST("login")
    fun loginUser(
            @Body jsonObject: JSONObject
    ): Call<LoginModel?>


    //newAPI
    @Headers(
        "Content-Type: application/json",
        "x-auth-token: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoiNjE5MWZmZDRhMzM5NzU1MmZkOWEyZjE0In0sImlhdCI6MTYzNjk1ODE3OX0.eqP7jhvbFj3ciwPnfPnS185s_ka-9HjmgHAglllbQ7k"
    )
    @GET("get-wheel")
    fun getData(@Query ("id") userId :Int ) : Call<PracticeModel?>
}