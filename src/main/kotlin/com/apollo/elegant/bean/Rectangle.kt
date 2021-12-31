package com.apollo.elegant.bean

data class Rectangle (var with: Int){
    var length : Int = 0
    var breadth : Int = 3
    var color : String = "ffffff"

    override fun toString(): String {
        return "with = ${with}, length = $length , breadth = $breadth, color = $color"
    }
}