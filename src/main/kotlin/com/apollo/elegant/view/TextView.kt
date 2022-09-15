package com.apollo.elegant.view

open class TextView {

    var text : String? = null

    init {
        setText()
//        println("TextView init")
        addListener()
    }

    open fun addListener() {
        println("MyTextView addListener")
    }


    open fun setText(){
        println("TextView init")
//        text = "TextView"
    }

    open fun setView(){
        println("TextView view")
    }
}