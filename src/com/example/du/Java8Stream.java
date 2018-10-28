package com.example.du;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Stream {
	public static void main(String[] args) {

		List<String> list = new ArrayList<>(
				Arrays.asList("ana", "anad", "mama", "aaa", "ten", "computer", "ala", "apap", "string"));
		List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 3, 6, 9, 4, 2, 56, 78, 1, 46, 1, 23, 43, 1));

		System.out.println("Average is: " + Java8Stream.average(integerList));
		System.out.println("\nList to upper case:" + Java8Stream.toUpperCase(list));
		System.out.println("\nThree letters strings starting with 'a': "
				+ Java8Stream.searchThreeLettersStartsWithLowerCaseA(list));
		System.out
				.println("\nString from list with odd and even: " + Java8Stream.getStringFromIntegersList(integerList));
		System.out.println("\nSum of all numbers from list: " + Java8Stream.addAllNumbers(integerList));
		System.out.println("\nMaximum in list: " + Java8Stream.getMaximumFromList(integerList));
		System.out.println("\nReversed string list: " + Java8Stream.getReversedStringList(list));
		System.out.println("\nIs number present in list: " + Java8Stream.isNumberPresentInList(23, integerList));
		System.out.println(
				"\nHow many times number occured in list: " + Java8Stream.occurencesOfNumberInList(1, integerList));
		System.out.println("\nDigits in list: " + Java8Stream.getDigitsOnly(integerList));
		System.out.println(
				"\nDistinct and ordered digits from list: " + Java8Stream.getDistinctOrderedDigits(integerList));

	}

	public static Double average(List<Integer> list) {
		return list.stream().mapToInt(i -> i).average().getAsDouble();
	}

	public static List<String> toUpperCase(List<String> list) {
		return list.stream().map(String::toUpperCase).collect(Collectors.toList());
	}

	public static List<String> searchThreeLettersStartsWithLowerCaseA(List<String> list) {
		return list.stream().filter(s -> s.length() == 3).filter(s -> s.startsWith("a")).collect(Collectors.toList());
	}

	public static String getStringFromIntegersList(List<Integer> list) {
		return list.stream().map(i -> (i % 2 == 0 ? "e" : "o") + i).collect(Collectors.joining(","));
	}

	public static Integer addAllNumbers(List<Integer> list) {
		return list.stream().mapToInt(i -> i).sum();
	}

	public static Integer getMaximumFromList(List<Integer> list) {
		return list.stream().max(Comparator.comparing(Integer::valueOf)).get();
	}

	public static List<String> getReversedStringList(List<String> list) {
		return list.stream().map(s -> new StringBuilder(s).reverse().toString()).collect(Collectors.toList());
	}

	public static boolean isNumberPresentInList(Integer n, List<Integer> list) {
		return list.stream().anyMatch(i -> i == n ? true : false);
	}

	public static Integer occurencesOfNumberInList(Integer n, List<Integer> list) {
		return (int) list.stream().filter(i -> i.equals(n)).count();
	}

	public static List<Integer> getDigitsOnly(List<Integer> list) {
		return list.stream().filter(i -> (i < 10)).collect(Collectors.toList());
	}

	public static List<Integer> getDistinctOrderedDigits(List<Integer> list) {
		return list.stream().filter(i -> (i < 10)).distinct().sorted().collect(Collectors.toList());
	}
}
