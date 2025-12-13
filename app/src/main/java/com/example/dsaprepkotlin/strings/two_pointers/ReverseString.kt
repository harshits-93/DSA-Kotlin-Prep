package com.example.dsaprepkotlin.strings.two_pointers

fun reverseString(s: CharArray): Unit {

    if(s.isNotEmpty()){
        var start = 0
        var end = s.size -1

        while(start < end){
            var temp = s[start]
            s[start] = s[end]
            s[end] = temp
            start++
            end--
        }
    }

    print(s.joinToString())
}

fun main(){
    reverseString("hannaH".toCharArray())
}