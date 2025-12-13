package com.example.dsaprepkotlin.arrays.basics

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var count = 0
    var maxCons = 0
    for((index, value) in nums.withIndex()){
        if(value == 1){
            count +=1
        }
        else{
            if(maxCons < count){
                maxCons =  count
            }
            count = 0
        }

        if(index == nums.size -1){
            if(maxCons < count){
                maxCons =  count
            }
        }
    }
    return maxCons
}

fun main(){
    val array = intArrayOf(1, 1, 0, 1, 1, 1)
    val findMaxConsecutiveOnes = findMaxConsecutiveOnes(array)
    print(findMaxConsecutiveOnes)
}