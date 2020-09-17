package datastructures;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BubbleSort {
	public static void main(String[] args) throws ParseException {
		String data = "1102021222";
		List<Integer> dataList = new ArrayList<>();
		for (int i = 0; i < data.length(); i++) {
			for (int j = 0; j < data.length(); j++) {
				Map<String, Integer> dataMap = new HashMap<>();
				if (i < j) {
					char[] dataArray = data.substring(i, j).toCharArray();
					for (int p = 0; p < dataArray.length; p++) {
						if (dataMap.containsKey(String.valueOf(dataArray[p]))) {
							dataMap.put(String.valueOf(dataArray[p]), dataMap.get(String.valueOf(dataArray[p])) + 1);
						} else {
							dataMap.put(String.valueOf(dataArray[p]), 1);
						}
					}
					System.out.println(dataMap);
					dataMap.entrySet().stream().forEach(predicate -> {
						if (predicate.getValue() == 2) {
							dataList.add(1);
						}
					});
				}
			}
		}
		System.out.println(dataList.stream().reduce(0, Integer::sum));
	}

	private static void doBubbleSort(int[] array) throws ParseException {
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy G");
		Date p = s.parse("30/01/-2020 AD");
		System.out.println(s.format(p));

	}
}