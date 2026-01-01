package com.example.dsaprepkotlin.arrays.basics

/**
 * Problem: Contains Duplicate
 * Link: https://leetcode.com/problems/contains-duplicate/description/
 * Difficulty: Easy
 * NeetCode 150: Arrays & Hashing #1
 * Date Solved: 01-Jan-2026
 *
 * PATTERN:
 * - Hashing / Set lookup
 * - Detect duplicates while traversing the array
 *
 * KEY INSIGHT:
 * - If an element has already been seen, it will exist in the HashSet.
 * - HashSet.add() returns false when the element is already present,
 *   allowing early detection of duplicates in O(1) average time.
 *
 * APPROACH:
 * - Create an empty HashSet to store visited elements.
 * - Iterate through the array once.
 * - Try adding each element to the HashSet.
 * - If add() returns false, a duplicate is found → return true.
 * - If the loop finishes, return false.
 *
 * DRY RUN:
 * Input: nums = [1, 2, 3, 1]
 *
 * Step 1: set = {}
 *         num = 1 → add → set = {1}
 *
 * Step 2: num = 2 → add → set = {1, 2}
 *
 * Step 3: num = 3 → add → set = {1, 2, 3}
 *
 * Step 4: num = 1 → already in set → return true
 *
 * EDGE CASES:
 * - Empty array → no iteration → return false
 * - Single element → no duplicate → return false
 *
 * TIME COMPLEXITY:
 * - O(n), where n is the number of elements in the array.
 *
 * SPACE COMPLEXITY:
 * - O(n), due to storing elements in the HashSet in the worst case.
 */

//Final and clean solution
fun containsDuplicate(nums: IntArray): Boolean {
    val set = HashSet<Int>()

    for (num in nums) {
        if (!set.add(num)) {
            return true
        }
    }
    return false
}


//My initial solution - Brute force, but complexity is same as final solution.
fun containsDuplicateInitial(nums: IntArray): Boolean {
    if(nums.isNotEmpty())
    {
        var hashSet = HashSet<Int>()
        hashSet.add(nums[0])
        for(i in 1 until nums.size)
        {
            if(hashSet.contains(nums[i]))
            { return true }
            else{ hashSet.add(nums[i]) }
        }
    }
    return false
}

fun main() {
    val array = intArrayOf(1, 2, 3, 1)
    print("Contains Duplicate : ${containsDuplicate(array)}")
}