package com.example.model

import com.google.gson.annotations.SerializedName

class Response {
 @SerializedName("user_id")
 var userId: Int? = null
  get() = field
  set(value) {
   field = value
  }
 @SerializedName("user_email")
 var userEmail: String? = null
  get() = field
  set(value) {
   field = value
  }
 @SerializedName("user_name")
 var userName: String? = null
  get() = field
  set(value) {
   field = value
  }
 @SerializedName("user_password")
 var userPassword: String? = null
  get() = field
  set(value) {
   field = value
  }



}


class Model
{
 var status: Boolean? = null
  get() = field
  set(value) {
   field = value
  }
 var message: String? = null
  get() = field
  set(value) {
   field = value
  }

 @SerializedName("data")
 var response: Response? = null
  get() = field
  set(value) {
   field = value
  }
}

