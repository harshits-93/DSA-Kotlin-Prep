package com.example.dsaprepkotlin.strings.two_pointers

fun reverseVowels(s: String): String {

    /*
     * We use a Set (HashSet internally) for vowels instead of List or Array.
     *
     * WHY Set?
     * - We check "is this character a vowel?" many times inside a loop.
     * - Set provides O(1) average time for contains() due to hashing.
     *
     * WHY NOT List / Array?
     * - List.contains() or Array search is O(n) (linear scan).
     * - Even though vowel count is small, interviewers expect the
     *   correct data structure choice based on lookup behavior.
     *
     * RULE:
     * - Frequent membership checks → Set
     * - Sequential access / ordering → List
     */
    val vowels = setOf(
        'a','e','i','o','u',
        'A','E','I','O','U'
    )

    /*
     * Convert String to CharArray because:
     * - String is immutable in Kotlin
     * - We need to swap characters in-place
     * - CharArray allows direct index-based mutation
     */
    val arr = s.toCharArray()

    // Two-pointer technique:
    // left starts from beginning, right starts from end
    var left = 0
    var right = arr.size - 1

    /*
     * Outer loop runs until both pointers meet.
     * Once left >= right, all required swaps are done.
     */
    while (left < right) {

        /*
         * Move left pointer forward until a vowel is found.
         *
         * IMPORTANT: left < right check is mandatory because:
         * - Pointer movement can cause left to reach or cross right
         * - Prevents accessing invalid index
         * - Handles edge cases:
         *   - No vowels
         *   - Single vowel
         *   - Odd-length strings
         */
        while (left < right && arr[left] !in vowels) {
            left++
        }

        /*
         * Move right pointer backward until a vowel is found.
         *
         * Again, left < right is checked to:
         * - Avoid index-out-of-bounds
         * - Stop scanning once pointers meet
         */
        while (left < right && arr[right] !in vowels) {
            right--
        }

        /*
         * Even after both inner loops,
         * left and right may point to the SAME index.
         *
         * Example:
         * - String with only one vowel
         * - Or all remaining characters are consonants
         *
         * We swap ONLY when left < right to:
         * - Avoid swapping same index
         * - Avoid unnecessary pointer movement
         * - Maintain correctness
         */
        if (left < right) {
            val temp = arr[left]
            arr[left] = arr[right]
            arr[right] = temp

            // Move inward after a successful swap
            left++
            right--
        }
    }

    /*
     * Convert CharArray back to String.
     *
     * WHY NOT arr.toString()?
     * - toString() prints object reference, not characters
     *
     * WHY String(arr)?
     * - Correct and efficient way to build String from CharArray
     */
    return String(arr)
}

/*
 * Time Complexity: O(n)
 * - Each character is visited at most once by the two pointers.
 *
 * Space Complexity: O(n)
 * - CharArray of size n is created since String is immutable.
 * - Extra space (Set of vowels) is constant: O(1).
 */


fun main(){
    val output = reverseVowels("IceCreAm")
    print(output)
}