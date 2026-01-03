package com.example.dsaprepkotlin.arrays.basics


/**
 * Definition:
 * Two words are anagrams if they contain the same characters with the same
 * frequency, but in a different order.
 *
 * Examples
 *
 * listen → silent
 * evil → vile
 *
 * */

/**
 * Problem: Valid Anagram
 * Link: https://leetcode.com/problems/valid-anagram/
 * Difficulty: Easy
 * NeetCode 150: Arrays & Hashing #2
 * Date Solved: 03-Jan-2026
 *
 * PATTERN:
 * HashMap + Frequency Count
 *
 * APPROACH:
 * - If lengths of both strings are not equal, return false immediately.
 * - Use a HashMap to store the frequency of each character in string `s`.
 * - Traverse string `t`:
 *   - If character exists in the map, decrease its frequency.
 *   - Remove the character from map if frequency becomes zero.
 *   - If character does not exist, return false.
 * - If all characters are processed successfully, return true.
 *
 * DRY RUN:
 * s = "anagram", t = "nagaram"
 *
 * Step 1: Build frequency map from `s`
 * map = {a=3, n=1, g=1, r=1, m=1}
 *
 * Step 2: Process `t`
 * n → freq 1 → remove
 * a → freq 3 → 2
 * g → freq 1 → remove
 * a → freq 2 → 1
 * r → freq 1 → remove
 * a → freq 1 → remove
 * m → freq 1 → remove
 *
 * Final map = {}
 * return true
 *
 * TIME COMPLEXITY:
 * O(n)
 * - Two linear passes over the strings.
 *
 * SPACE COMPLEXITY:
 * O(n)
 * - HashMap stores frequency of characters.
 *
 * KEY INSIGHT:
 * - Two strings are anagrams if each character appears the same number of times.
 * - HashMap helps track and balance character frequencies between both strings.
 */
fun isAnagram(s: String, t: String): Boolean {

    var hashmap = HashMap<Char, Int>()

    if (s.length != t.length) {
        return false
    }

    for (ch in s) {
        hashmap.put(ch, hashmap.getOrDefault(ch, 0) + 1)
    }

    for (ch in t) {
        if (hashmap.containsKey(ch)) {
            var reducedFreqOfChar = hashmap.getOrDefault(ch, 0) - 1
            if (reducedFreqOfChar <= 0) {
                hashmap.remove(ch)
            } else {
                hashmap.put(ch, reducedFreqOfChar)
            }
        } else {
            return false
        }
    }

    return true
}

fun main() {
    println("Is Anagram : ${isAnagram("anagram", "nagaram")}")
    print("Is Anagram : ${isAnagram("aacc", "ccac")}")
}
