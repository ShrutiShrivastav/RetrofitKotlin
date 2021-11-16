package com.example.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
class BillPaymentModel  {
    constructor(userId: String?, mobileId: String?, type: String?, total: String?, responseDetail: String?, creditToken: String?, reference: String?) {
        this.userId = userId
        this.mobileId = mobileId
        this.type = type
        this.total = total
        this.responseDetail = responseDetail
        this.creditToken = creditToken
        this.reference = reference
    }

    @SerializedName("user_id")
    @Expose
    var userId: String? = null
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("mobile_id")
    @Expose
    var mobileId: String? = null
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("type")
    @Expose
    var type: String? = null
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("total")
    @Expose
    var total: String? = null
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("response_detail")
    @Expose
    var responseDetail: String? = null
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("creditToken")
    @Expose
    var creditToken: String? = null
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("reference")
    @Expose
    var reference: String? = null
        get() = field
        set(value) {
            field = value
        }

}