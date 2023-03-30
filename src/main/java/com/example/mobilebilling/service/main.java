package com.example.mobilebilling.service;

import java.util.*;

public class main {

    //two sum

//    public static int[] twoSum(int[] nums, int target) {
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
//


//    public static int findAngle(int x, int y, int a, int b) {
//        int dx = x - a;
//        int dy = y - b;
//        double angle = Math.atan2(dy, dx);
//        double angleDegrees = Math.toDegrees(angle);
//        return (int) Math.round(angleDegrees);
//    }
//
//    public static boolean withinRadius(int x, int y, int radius, int a, int b) {
//        double distance = Math.sqrt(Math.pow(x - a, 2) + Math.pow(y - b, 2));
//        if (distance <= radius) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public static int solution(String direction, int radius, int[] X, int[] Y) {
//        int res = 0;
//        if (direction.equals("U")) {
//            for (int i = 0; i < X.length; i++) {
//                if (withinRadius(0, 0, radius, X[i], Y[i]) && findAngle(0, 0, X[i], Y[i]) >= -135 && findAngle(0, 0, X[i], Y[i]) <= -45) {
//                    res += 1;
//                }
//            }
//        } else if (direction.equals("D")) {
//            for (int i = 0; i < X.length; i++) {
//                if (withinRadius(0, 0, radius, X[i], Y[i]) && findAngle(0, 0, X[i], Y[i]) >= 45 && findAngle(0, 0, X[i], Y[i]) <= 135) {
//                    res += 1;
//                }
//            }
//        } else if (direction.equals("R")) {
//            for (int i = 0; i < X.length; i++) {
//                if (withinRadius(0, 0, radius, X[i], Y[i]) && ((findAngle(0, 0, X[i], Y[i]) >= 135 && findAngle(0, 0, X[i], Y[i]) <= 180) || (findAngle(0, 0, X[i], Y[i]) >= -180 && findAngle(0, 0, X[i], Y[i]) <= -135))) {
//                    res += 1;
//                }
//            }
//        } else if (direction.equals("L")) {
//            for (int i = 0; i < X.length; i++) {
//                if (withinRadius(0, 0, radius, X[i], Y[i]) && findAngle(0, 0, X[i], Y[i]) >= -45 && findAngle(0, 0, X[i], Y[i]) <= 45) {
//                    res += 1;
//                }
//            }
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        int[] x1 = {-1, -2, 4, 1, 3, 0};
//        int[] y1 = {5, 4, 3, 3, 1, -1};
//        int[] x2 = {0,-3,2,0};
//        int[] y2 = {-10, -3, -7, -5};
//        int[] x3 = {-2,3};
//        int[] y3 = {0,1};
//        System.out.println(solution("U", 5, x1, y1));
//        System.out.println(solution("D", 10, x2, y2));
//        System.out.println(solution("R", 3, x3, y3));
//    }


//    public static void main(String[] args){
//        test2("U", 5, new int[] { -1, -2, 4, 1, 3, 0}, new int[] {5, 4, 3, 3, 1, -1});
//        test2("D", 10, new int[] { 0,-3,2,0,-3,4,-5,-5}, new int[] {-10,-3,-7,-5,-5,-2,0,-8});
////        test2("R", 3, new int[] {-3}, new int[] {-5});
//    }
//
//    public static void test2(String d, int r, int[] X, int[] Y) {
//        System.out.printf("Direction: %s, radius: %s, X: %s, Y: %s\n", d, r, Arrays.toString(X), Arrays.toString(Y));
//        System.out.println("Output: " + countEnemies(d, r, X, Y));
//    }
//
//    public static int countEnemies(String direction, int radius, int[] X, int[] Y) {
//            int enemies = 0;
//            int len = X.length;
//            int x, y;
//
//            for (int i = 0; i < len; i++) {
//                x = X[i];
//                y = Y[i];
//
//                if (Math.sqrt(x*x + y*y) <= radius) {
//                    switch (direction) {
//                        case "U":
//                            if (y > 0 && Math.abs(x) <= y) {
//                                enemies++;
//                            }
//                            break;
//                        case "D":
//                            if (y < 0 && Math.abs(x) <= -y) {
//                                enemies++;
//                            }
//                            break;
//                        case "L":
//                            if (x < 0 && Math.abs(y) <= -x) {
//                                enemies++;
//                            }
//                            break;
//                        case "R":
//                            if (x > 0 && Math.abs(y) <= x) {
//                                enemies++;
//                            }
//                            break;
//                    }
//                }
//            }
//
//            return enemies;
//        }
//
//    }


//    public static void main(String[] args){
//        test1(new int[] { 1,1,3,4,4,4 });
//        test1(new int[] { 1, 2, 2, 2, 5, 5, 5, 8 });
//        test1(new int[] { 1, 1, 1, 1, 3, 3, 4, 4, 4, 4, 4 });
//        test1(new int[] { 10,10,10 });
//    }
//
//    public static void test1(int[] input) {
//        System.out.println("Input: " + Arrays.toString(input));
//        System.out.println("Custom: " + solution1(input));
////        System.out.println("Expected: " + solution2(input));
//        System.out.println("-------------------\n");
//    }
//
//    public static int solution1(int[] A) {
//        if (A.length == 0) {
//            return 0;
//        }
//        int ans = 0;
//        int freq = 1;
//        for (int i = 1; i < A.length; i++) {
//            if (A[i] == A[i - 1]) {
//                freq++;
//            } else {
//                ans += Math.min(Math.abs(A[i - 1] - freq), freq);
//                freq = 1;
//            }
//        }
//        ans += Math.min(Math.abs(A[A.length - 1] - freq), freq);
//        return ans;
//    }
//
//    public static int solution2(int[] A) {
//        int ans = 0;
//        Map<Integer, Integer> freqMap = new HashMap<>();
//        for (int value : A) {
//            freqMap.put(value, freqMap.getOrDefault(value, 0) + 1);
//        }
//        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
//            int value = entry.getKey();
//            int freq = entry.getValue();
//            if (value != freq) {
//                ans += Math.min(Math.abs(value - freq), freq);
//            }
//        }
//        return ans;
//    }


//public class main {
//    public static void main(String[] args) {
//        System.out.println(solution(1765));
//
//
//    }
//
//    public static int solution(int N) {
//        for (int i = N + 1; ; i++) {
//            if (hasNoConsecutiveDigits(i)) {
//                return i;
//            }
//        }
//    }
//
//    private static boolean hasNoConsecutiveDigits(int n) {
//        String str = String.valueOf(n);
//        for (int i = 1; i < str.length(); i++) {
//            if (str.charAt(i) == str.charAt(i - 1)) {
//                return false;
//            }
//        }
//        return true;
//    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

//    public static ListNode deleteDuplicates(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode curr = head;
//        while (curr != null & curr.next != null) {
//            if (curr.val == curr.next.val) {
//                curr.next = curr.next.next;
//            } else {
//                curr = curr.next;
//            }
//        }
//        return head;
//    }

//
//    public static int singleNumber(int[] nums) {
//        int result = 0;
//        for (int i = 0; i < nums.length; i++) {
//            result ^= nums[i];
//        }
//        return result;
//    }

    //    public static TreeNode invertTree(TreeNode root) {
//        if(root == null){
//            return null;
//        }
//
//        TreeNode left = invertTree(root.left);
//        TreeNode right = invertTree(root.right);
//
//        root.left = right;
//        root.right = left;
//
//        return root;
//
//    }
//    public static class MyStack {
//
//        private Queue<Integer> q1;
//        private Queue<Integer> q2;
//        private int top;
//
//        public MyStack() {
//            q1 = new LinkedList<>();
//            q2 = new LinkedList<>();
//        }
//
//        public void push(int x) {
//            q1.offer(x);
//            top = x;
//        }
//
//        public int pop() {
//            while (q1.size() > 1) {
//                top = q1.remove();
//                q2.offer(top);
//            }
//            int res = q1.remove();
//            Queue<Integer> temp = q1;
//            q1 = q2;
//            q2 = temp;
//            return res;
//        }
//
//        public int top() {
//            return top;
//        }
//
//        public boolean empty() {
//            return q1.isEmpty();
//        }
//    }


    //    public static int mySqrt(int x) {
//        if (x == 0) {
//            return 0;
//        }
//        int left = 1;
//        int right = x;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (mid == x / mid) {
//                return mid;
//            } else if (mid < x / mid) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//
//        }
//        return right;
//
//    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if( p == null && q == null){
            return true;
        }

        if(p == null || q == null){
            return false;
        }

        if(p.val != q.val){
            return false;
        }

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

}


