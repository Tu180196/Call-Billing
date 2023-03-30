package com.example.mobilebilling.service;

import java.util.*;

public class a {

//    public static void main(String[] args) {
//        int[] A = {-5,2,3,11,99,101};
//        int maxPrime = -1;
//
//        for (int i = 0; i < A.length; i++) {
//            if (A[i] >= 10 && A[i] <= 99) {
//                if (maxPrime == -1 || A[i] > maxPrime) {
//                    maxPrime = A[i];
//                }
//            }
//        }
//
//        System.out.println("The largest prime number with two digits in the given array is " + maxPrime);
//    }

    // Kiểm tra số nguyên tố
//    public static boolean isPrime(int n) {
//        if (n <= 1) {
//            return false;
//        }
//
//        for (int i = 2; i <= Math.sqrt(n); i++) {
//            if (n % i == 0) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//}

//    MaxTwoDigitNumber
//
//    public static class MaxTwoDigitNumber {
//        public static int findMaxTwoDigitNumber(int[] arr) {
//            int maxTwoDigitNumber = -1;
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[i] >= 10 && arr[i] <= 99 ) {
//                    maxTwoDigitNumber = arr[i];
//                }
//            }
//            return maxTwoDigitNumber;
//        }
//
//        public static void main(String[] args) {
//            int[] arr = {-5, 2,-1, 3, 11, 99, 101};
//            int maxTwoDigitNumber = findMaxTwoDigitNumber(arr);
//            System.out.println(maxTwoDigitNumber); // Output: 99
//        }
//    }


//    public static int findMaxTwoDigitNumber(int[] arr) {
//        OptionalInt maxTwoDigitNumber = Arrays.stream(arr)
//                .filter(num -> num >= 10 && num <= 99)
//                .max();
//        return maxTwoDigitNumber.orElse(-1);
//    }


//----------add Two Numbers
//    class Solution {
//        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//            ListNode dummyHead = new ListNode(0);
//            ListNode p = l1, q = l2, curr = dummyHead;
//            int carry = 0;
//            while (p != null || q != null) {
//                int x = (p != null) ? p.val : 0;
//                int y = (q != null) ? q.val : 0;
//                int sum = carry + x + y;
//                carry = sum / 10;
//                curr.next = new ListNode(sum % 10);
//                curr = curr.next;
//                if (p != null) p = p.next;
//                if (q != null) q = q.next;
//            }
//            if (carry > 0) {
//                curr.next = new ListNode(carry);
//            }
//            return dummyHead.next;
//        }
//    }


//    --------------- Two sum

//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement)) {
//                return new int[] { map.get(complement), i };
//            }
//            map.put(nums[i], i);
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }


    /// Longest Substring Without Repeating Characters
//    public static int lengthOfLongestSubstring(String s) {
//        int n = s.length();
//        int maxLength = 0;
//        int[] index = new int[128];
//        for (int i = 0, j = 0; j < n; j++) {
//            i = Math.max(index[s.charAt(j)], i);
//            maxLength = Math.max(maxLength, j - i + 1);
//            index[s.charAt(j)] = j + 1;
//        }
//        return maxLength;
//    }


//          running sum
//    public static int[] runningSum(int[] nums) {
//        int[] runningSum = new int[nums.length];
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            runningSum[i] = sum;
//        }
//        return runningSum;
//    }


    /// Middle of the Linked List
//    public static ListNode middleNode(ListNode head) {
//        ListNode slow = head, fast = head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }

    //pivot Index

//    public static int pivotIndex(int[] nums) {
//        int sum = 0, leftSum = 0;
//        for (int num : nums) sum += num;
//        for (int i = 0; i < nums.length; i++) {
//            if (leftSum == sum - leftSum - nums[i]) {
//                return i;
//            }
//            leftSum += nums[i];
//        }
//        return -1;
//    }


    //      Longest Palindrome
//    public static int longestPalindrome(String s) {
//        // Create a HashMap to count the frequency of each character
//        HashMap<Character, Integer> freqMap = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
//        }
//
//        // Iterate through the HashMap to calculate the length of the longest palindrome
//        int length = 0;
//        boolean hasOddFreq = false; // A flag to indicate if there is any character with odd frequency
//        for (char c : freqMap.keySet()) {
//            int freq = freqMap.get(c);
//            if (freq % 2 == 0) {
//                length += freq;
//            } else {
//                length += freq - 1;
//                hasOddFreq = true;
//            }
//        }
//
//        return hasOddFreq ? length + 1 : length;
//    }


//revert list


//    public static ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode temp = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = temp;
//        }
//        return pre;
//    }

}