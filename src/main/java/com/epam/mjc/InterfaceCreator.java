package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> list.stream().allMatch(value -> Character.isUpperCase(value.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            List<Integer> evenValues = new ArrayList<>();
            for (Integer value : list) {
                if (value % 2 == 0) {
                    evenValues.add(value);
                }
            }
            list.addAll(evenValues);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> filteredList = new ArrayList<>();
            for (String value : values) {
                if (startsWithUppercase(value) && endsWithDot(value) && containsMoreThanThreeWords(value)) {
                    filteredList.add(value);
                }
            }
            return filteredList;
        };
    }

    private static boolean startsWithUppercase(String value) {
        return Character.isUpperCase(value.charAt(0));
    }

    private static boolean endsWithDot(String value) {
        return value.endsWith(".");
    }

    private static boolean containsMoreThanThreeWords(String value) {
        String[] words = value.split(" ");
        return words.length > 3;
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            Map<String, Integer> resultMap = new HashMap<>();
            for (String value : list) {
                resultMap.put(value, value.length());
            }
            return resultMap;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> resultList = new ArrayList<>(list1);
            resultList.addAll(list2);
            return resultList;
        };
    }
}
