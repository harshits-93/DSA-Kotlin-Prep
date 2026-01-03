package com.example.dsaprepkotlin.arrays.two_pointers

import com.example.dsaprepkotlin.arrays.basics.findMaxConsecutiveOnes

/**
 * Problem: Two Sum II – Input Array Is Sorted
 * Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * Difficulty: Medium
 * NeetCode 150: Two Pointers #2
 * Date Solved: 03-Jan-2026
 *
 * PATTERN:
 * Two Pointers (Sorted Array)
 *
 * APPROACH:
 * - Use two pointers: `left` at start, `right` at end.
 * - Since the array is sorted:
 *   - If current sum < target → move `left` rightwards.
 *   - If current sum > target → move `right` leftwards.
 * - When sum == target, return indices (1-based as required).
 *
 * DRY RUN:
 * numbers = [2, 7, 11, 15], target = 9
 *
 * left = 0 (2), right = 3 (15) → sum = 17 > 9 → right--
 * left = 0 (2), right = 2 (11) → sum = 13 > 9 → right--
 * left = 0 (2), right = 1 (7)  → sum = 9 == target
 * return [1, 2]
 *
 * TIME COMPLEXITY:
 * O(n)
 * - Each pointer moves at most `n` times.
 *
 * SPACE COMPLEXITY:
 * O(1)
 * - No extra data structures used.
 *
 * KEY INSIGHT:
 * - Sorting enables eliminating one pointer on every comparison.
 * - Works correctly for both positive and negative numbers as long as the array is sorted.
 * - Avoid mutating pointers while forming the result; use `+1` for 1-based indexing.
 */

fun twoSum(numbers: IntArray, target: Int): IntArray {

    var left = 0
    var right = numbers.size-1

    while(left < right){
        if(target == (numbers[left] + numbers[right])){
            return intArrayOf(left + 1, right + 1)
        }
        if(target > (numbers[left] + numbers[right])){
            left++
        }
        else{
            right--
        }
    }

    return intArrayOf()
}

fun main(){
    val array = intArrayOf(2,7,11,15)
    val result = twoSum(array, 9)
    print(result.contentToString())
}