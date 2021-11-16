package com.example.model

import com.google.gson.annotations.SerializedName

class Data {

    var id: Int? = null
        get() = field
        set(value) {
            field = value
        }
    var name: String? = null
        get() = field
        set(value) {
            field = value
        }
    var email: String? = null
        get() = field
        set(value) {
            field = value
        }
    var phoneNumber: String? = null
        get() = field
        set(value) {
            field = value
        }
    var profile: Any? = null
        get() = field
        set(value) {
            field = value
        }
    var city: Any? = null
        get() = field
        set(value) {
            field = value
        }
    var state: Any? = null
        get() = field
        set(value) {
            field = value
        }
    var address: Any? = null
        get() = field
        set(value) {
            field = value
        }


}


class LoginModel {
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

    @SerializedName("result")
    var data: Data? = null
        get() = field
        set(value) {
            field = value
        }
    var token: String? = null
        get() = field
        set(value) {
            field = value
        }
}
