package com.example.dsaprepkotlin.arrays.basics


/**
 * Problem: Two Sum
 * Link: https://leetcode.com/problems/two-sum/
 * Difficulty: Easy
 * NeetCode 150: Arrays & Hashing #3
 * Date Solved: 02-Jan-2026
 *
 * PATTERN:
 * - HashMap (Value → Index mapping)
 * - One-pass lookup
 *
 * KEY INSIGHT:
 * - For each element, check if its complement (target - current element)
 *   has already been seen.
 * - Store elements in a HashMap while iterating so lookup is O(1).
 * - This avoids the need for a nested loop.
 *
 * APPROACH:
 * - Create a HashMap to store number → index.
 * - Iterate through the array using indices.
 * - For each element:
 *     - Compute difference = target - nums[i].
 *     - If difference exists in the map:
 *         - Return indices of difference and current element.
 *     - Otherwise, store nums[i] with its index in the map.
 * - Return result array once the pair is found.
 *
 * DRY RUN:
 * Input: nums = [2, 7, 11, 15], target = 9
 *
 * Step 1:
 * i = 0 → nums[0] = 2
 * difference = 9 - 2 = 7
 * map = {} → 7 not found
 * map = {2 → 0}
 *
 * Step 2:
 * i = 1 → nums[1] = 7
 * difference = 9 - 7 = 2
 * map contains 2 → index = 0
 * result = [0, 1] → return
 *
 * EDGE CASES:
 * - Exactly one valid solution is guaranteed by the problem.
 * - Same element cannot be used twice.
 *
 * TIME COMPLEXITY:
 * - O(n), where n is the number of elements in the array.
 * - Each element is processed once.
 *
 * SPACE COMPLEXITY:
 * - O(n), due to the HashMap storing elements and their indices.
 */

fun twoSum(nums: IntArray, target: Int): IntArray {

    val resultArr = IntArray(2)
    val map = HashMap<Int, Int>()

    for(i in nums.indices){
        var difference = target - nums[i]

        if(map.containsKey(difference)){
            resultArr[0] = map.getOrDefault(difference,0)
            resultArr[1] = i

            return resultArr
        }
        map.put(nums[i], i)
    }
    return resultArr
}


//My initial approach
//here iterating through each element, hence complexity is O(n)
fun twoSumBruteForce(nums: IntArray, target: Int): IntArray {

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