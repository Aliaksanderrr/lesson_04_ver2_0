package java2.Task2ListOfWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Task2ListOfWords {

	private static final String[] WORDS = new String[]{
			"world", "year", "people", "time", "child",
			"people", "power", "system", "door", "door",
			"word", "place", "face", "friend", "friend",
			"system", "world", "country", "world", "child",
			"door", "child", "power", "end", "power",
			"system", "people", "door", "door", "power"};
	private static final String SEPARATOR = ", ";

	private final ArrayList<String> wordsList = new ArrayList<>();

	{
		Collections.addAll(wordsList, WORDS);
	}

	public static void main(String[] args) {

		//TASK2_1
		System.out.println("\nTASK2_1");
		Task2ListOfWords task2_1 = new Task2ListOfWords();
		int step = 3;
		for (int i = 0; i < task2_1.wordsList.size(); i += step) {
			System.out.println("Position " + i + ": " + task2_1.wordsList.get(i));
		}

		//TASK2_2
		System.out.println("\nTASK2_2");
		Task2ListOfWords task2_2 = new Task2ListOfWords();
		StringBuilder sb = new StringBuilder();
		for (String word : task2_2.wordsList) {
			sb.append(task2_2.firstUpperCase(word));
			sb.append(SEPARATOR);
		}
		sb.setLength(sb.length() - SEPARATOR.length());
		System.out.println(sb);

		//TASK2_3
		System.out.println("\nTASK2_3");
		Task2ListOfWords task2_3 = new Task2ListOfWords();
		ArrayList<Pair<String, Integer>> wordList = new ArrayList<>();
		for (String word : task2_3.wordsList) {
			boolean checkContains = false;
			for (Pair<String, Integer> wordPair : wordList) {
				if (wordPair.getKey().equals(word)) {
					wordPair.setValue(wordPair.getValue() + 1);
					checkContains = true;
					break;
				}
			}
			if (!checkContains) {
				wordList.add(new Pair<>(word, 1));
			}
		}
		Pair<String, Integer>[] arr = new Pair[0];
		Pair<String, Integer>[] pairArr = wordList.toArray(arr);
		//Bubble sort
		bubbleSort(pairArr, (pair1, pair2) -> {
			if (pair1.getValue() > pair2.getValue()) {
				return 1;
			} else if (pair1.getValue() < pair2.getValue()) {
				return -1;
			} else {
				return pair2.getKey().compareTo(pair1.getKey());
			}
		});

		System.out.println(Arrays.deepToString(pairArr));
	}

	private String firstUpperCase(String word) {
		return word.substring(0, 1).toUpperCase() + word.substring(1);
	}

	private static <T> void bubbleSort(T[] array, Comparator<T> comparator) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (comparator.compare(array[i], array[j]) < 0) {
					T tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
	}
}