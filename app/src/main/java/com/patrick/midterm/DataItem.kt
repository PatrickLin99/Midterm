package com.patrick.midterm

//class DataItem {
//}

//data class InfoList(
//    var infoList: ArrayList<PersonItem> = arrayListOf()
//)
//
//data class PersonItem(
//    var email: String = "",
//    var id:String = "",
//    var name: String = ""
//)

data class Info(
    var author: String="",
    var content: String = "",
    var createdTime: String = "",
    var id: String = "",
    var tag: String = "",
    var title: String = ""
)

data class Author(
    var email: String = "",
    var id: String = "",
    var name: String = ""
)