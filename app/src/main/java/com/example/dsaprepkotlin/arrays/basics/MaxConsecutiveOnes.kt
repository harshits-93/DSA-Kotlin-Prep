package com.example.dsaprepkotlin.arrays.basics

/**
Given a binary array nums, return the maximum number of consecutive 1's in the array.

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
The maximum number of consecutive 1s is 3.

Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2

*/
fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var count = 0
    var maxConsecutive = 0
    for((index, value) in nums.withIndex()){
        if(value == 1){
            count +=1
        }
        else{
            if(maxConsecutive < count){
                maxConsecutive =  count
            }
            count = 0
        }

        if(index == nums.size -1){
            if(maxConsecutive < count){
                maxConsecutive =  count
            }
        }
    }
    return maxConsecutive
}

fun main(){
    val array = intArrayOf(1, 1, 0, 1, 1, 1)
    val findMaxConsecutiveOnes = findMaxConsecutiveOnes(array)
    print(findMaxConsecutiveOnes)
}