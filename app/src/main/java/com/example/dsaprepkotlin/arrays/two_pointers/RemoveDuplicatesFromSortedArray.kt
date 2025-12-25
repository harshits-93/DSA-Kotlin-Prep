package com.example.dsaprepkotlin.arrays.two_pointers

import com.example.dsaprepkotlin.strings.two_pointers.reverseVowels

//Question - Remove Duplicates from Sorted Array
//Link - https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that
 * each unique element appears only once. The relative order of the elements should be kept the same.
 *
 * Consider the number of unique elements in nums to be k. After removing duplicates, return the number
 * of unique elements k.
 *
 * The first k elements of nums should contain the unique numbers in sorted order. The remaining
 * elements beyond index k - 1 can be ignored.
 *
 * Custom Judge:
 *
 * The judge will test your solution with the following code:
 *
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 *
 * int k = removeDuplicates(nums); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2
 * respectively.It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * */

//Best approach, as space complexity is constant here
fun removeDuplicates(nums: IntArray): Int {

    /*
     PROBLEM:
     Given a sorted array, remove duplicates IN-PLACE
     such that each unique element appears only once.

     APPROACH:
     Two Pointers Technique (O(n) time, O(1) space)

     Pointer k:
     - Tracks the position of last unique element
     - Initially points to index 0 (first element is always unique)

     Pointer i:
     - Traverses the array from index 1 to end
    */

    var k = 0   // Index of last unique element

    // Start from index 1 because nums[0] is always unique
    for (i in 1 until nums.size) {

        // If current element is different from last unique element
        if (nums[k] != nums[i]) {

            // Move k forward to place next unique element
            k = k + 1

            // Copy current unique element to position k
            nums[k] = nums[i]
        }
    }

    // k is index-based, number of unique elements = k + 1
    return k + 1
}

/*
    DRY RUN
    --------
    Input: nums = [1, 1, 2]

    Initial:
        k = 0
        nums = [1, 1, 2]

    Step 1:
        i = 1
        nums[k] = 1
        nums[i] = 1
        -> Equal, skip

        k = 0
        nums = [1, 1, 2]

    Step 2:
        i = 2
        nums[k] = 1
        nums[i] = 2
        -> Not equal

        k = k + 1 = 1
        nums[1] = nums[2]

        nums = [1, 2, 2]

    End Loop

    Return:
        k + 1 = 2

    Result:
        First k elements => [1, 2]
*/

fun main() {
    val numOfUniqueElements = removeDuplicates(intArrayOf(1, 1, 2))
    println("Unique elements : $numOfUniqueElements")
    print("Result Array : ")
    for (i in 0..<numOfUniqueElements) {
        print("$i ")
    }
}
