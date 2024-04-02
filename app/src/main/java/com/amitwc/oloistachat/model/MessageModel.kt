package com.amitwc.oloistachat.model

data class MessageModel(
    var message:String? = "",
    var senderId: String ? = "",
    var timeStamp: Long ?  =0
)
