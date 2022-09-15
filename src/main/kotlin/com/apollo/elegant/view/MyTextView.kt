package com.apollo.elegant.view

class MyTextView : TextView() {

    override fun addListener() {
        println("MyTextView addListener")
    }

    override fun setText(){
        println("MyTextView init")
//        text = "MyTextView"
    }

    override fun setView() {
//        super.setView()
        println("MyTextView view")
    }
}