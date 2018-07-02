package javaStudy.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class test1 {
	Map<String, String> map = new HashMap<String, String>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> strings = new ArrayList<String>();
		while (scanner.hasNextInt()) {
			strings.add(Integer.toString(scanner.nextInt()));
		}
		TreeSet<String> set = new TreeSet<String>(new Comparator<String>() {
			@Override
			public int compare(String String1, String String2) {
				return (int) (Integer.parseInt(String1) - Integer.parseInt(String2));
			}
		});
		for (String String : strings) {
			set.add(String);
		}
		strings.clear();
		strings.addAll(set);
		for (int i = 0; i < strings.size(); i++) {
			System.err.println(i + ":" + strings.get(i));
		}
	}
}
