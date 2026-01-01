package com.example.dsaprepkotlin.arrays.basics

fun twoSum(nums: IntArray, target: Int): IntArray {

    var resultArr = IntArray(2)

    for(i in nums.indices){
        for(j in i+1..nums.size -1){
            if(target == nums[i] + nums[j]){
                resultArr[0] = i
                resultArr[1] = j
                return resultArr
            }
        }
    }

    return resultArr

}

fun main() {
    val array = intArrayOf(2,7,11,15)
    print(" Two sum indices are : ${twoSum(array, 9).contentToString()}")
}