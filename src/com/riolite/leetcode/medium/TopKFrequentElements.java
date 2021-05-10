package com.riolite.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) { //Hashmap Approach
        HashMap<Integer, Integer> frequencyMap = createFrequencyMap(nums);

        Map.Entry<Integer, Integer>[] frequencyArray = frequencyMap.entrySet().toArray(new Map.Entry[0]);
        Arrays.sort(frequencyArray, (o1, o2) -> o2.getValue() - o1.getValue());
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = frequencyArray[i].getKey();
        }
        return result;
    }

    private HashMap<Integer, Integer> createFrequencyMap(int[] nums) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.putIfAbsent(num, 0);
            frequencyMap.put(num, frequencyMap.get(num) + 1);
        }
        return frequencyMap;
    }

    public int[] topKFrequentStreamApi(int[] nums, int k) { //Hashmap Approach
        return Arrays.stream(nums).boxed()
                .collect(Collectors.toMap(Function.identity(), o -> 1, Integer::sum))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    public static void main(String[] args) {
        System.out.println("Top Frequent: " + Arrays.toString(new TopKFrequentElements().topKFrequent(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 1, 9, 2}, 3)));
    }
}
