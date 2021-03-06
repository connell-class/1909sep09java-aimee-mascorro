package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j = 0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		char[] acro = new char[phrase.length()];
		int counter = 0;
	//	System.out.println("phrase=" + phrase);
		acro[counter] = phrase.charAt(0);
		counter++;
		for (int i = 0; i < acro.length; i++) {
			if (phrase.charAt(i) == ' ' || phrase.charAt(i) == '-') {
				acro[counter] = phrase.charAt(i + 1);
				counter++;
		//		System.out.println("char was " + phrase.charAt(i + 1));
			}
		}
		String str = new String(acro).toUpperCase();
		//System.out.println(str);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(0) == ' ') {
				counter = i;
			}

		}
		return str.substring(0, counter);
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			double a = this.sideOne;
			double b = this.sideTwo;
			double c = this.sideThree;

			if (a == b && b == c && c == a) {
				return true;
			} else {
				return false;
			}
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			double a = this.sideOne;
			double b = this.sideTwo;
			double c = this.sideThree;

			if (a == b || b == c || c == a) {
				return true;
			} else {
				return false;
			}
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			double a = this.sideOne;
			double b = this.sideTwo;
			double c = this.sideThree;

			if (a == b || b == c || c == a) {
				return false;
			} else {
				return true;
			}
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		int score = 0;
		char letter = 'A';
		// = new char[string.length()];

		for (int i = 0; i < string.length(); i++) {
			letter = string.toUpperCase().charAt(i);
//			System.out.println("letter was " + letter);
			switch (letter) {
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
			case 'L':
			case 'N':
			case 'R':
			case 'S':
			case 'T':
				score++;
				break;
			case 'D':
			case 'G':
				score += 2;
				break;
			case 'B':
			case 'C':
			case 'M':
			case 'P':
				score += 3;
				break;
			case 'F':
			case 'H':
			case 'V':
			case 'W':
			case 'Y':
				score += 4;
				break;
			case 'K':
				score += 5;
				break;
			case 'J':
			case 'X':
				score += 8;
				break;
			case 'Q':
			case 'Z':
				score += 10;
				break;

			}
//			System.out.println("score so far " + score);
		}

		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		/*
		 * Solved this problem with this info:
		 * https://stackoverflow.com/questions/4047808/what-is-the-best-way-to-tell-if-a
		 * -character-is-a-letter-or-number-in-java-withou
		 */

		// TODO Write an implementation for this method declaration
		/*
		 * String card[] = string.split(" "); String card2 = card[1] + card[3];
		 */

		/*
		 * int[] ary = new int[4];
		 * 
		 * int i = 0; Scanner sc = new Scanner(string); System.out.println(sc);
		 * while(sc.hasNextInt()) { if (ary[0] == 1) { i++; }else { ary[i++] =
		 * sc.nextInt();
		 * 
		 * } } String answer = ary.toString(); System.out.println("string is " +
		 * answer);
		 */

		/*
		 * String answer = string.replaceAll("[^0-9]", "");
		 * System.out.println("the number is " + answer); return answer;
		 * 
		 * // youtu.be/NQOK2cam3js 01234567890123 "(223) 456-7890" 012 345 6789
		 * 
		 */
		int skip = 0;
		int j = 0;
		char[] digits = new char[10];
//		System.out.println("length " + string.length());
		if (string.charAt(0) == '1') {
			skip++;
		}
		for (int i = skip; i < string.length(); i++) {
//			System.out.print("digits is at ");
			if (Character.isDigit(string.charAt(i))) {
//				System.out.print(j + " i is " + string.charAt(i));
				if (j > 9) {
//					System.out.println("ran out of space");
					throw new IllegalArgumentException();

				} else {
					digits[j] = string.charAt(i);
//					System.out.println(" curr digit " + digits[j]);
					j++;
				}
			} else {
//				System.out.println("char was " + string.charAt(i));
			}
		}

		String answer = new String(digits);
		if (j < 10) {
//			System.out.println("number too short ");
			throw new IllegalArgumentException();
		}
//		System.out.println(answer);
		return answer;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration

		HashMap<String, Integer> incidence = new HashMap<String, Integer>();
		String[] words;
		String splitChar = " ";
		if (string.contains(",")) {
			splitChar = ",";
		} else if (string.contains("[/]")) {
			splitChar = "[/]";
		} else if (string.contains("[.]")) {
			splitChar = "[.]";
		} else if (string.contains("[\n]")) {
			splitChar = "[\n]";
		}
		words = string.split(splitChar);
//		System.out.println(Arrays.toString(words));
		// int i = words.length;
//		System.out.println("the test word is " + words[0]);

		for (int i = 0; i < words.length - 1; i++) {
//			System.out.println("the Sarray is this long " + i);
//			System.out.println("the current word is " + words[i]);
			if (incidence.containsKey(words[i])) {
				int counter = incidence.get(words[i]);
				incidence.put(words[i], (counter + 1));
//				System.out.println("the word " + words[i] + " was found " + counter);
			} else {
				incidence.put(words[i], 1);
//				System.out.println("the word added was " + words[i] + " counter is at " + incidence.get(words[i]));
			}

		}
//		System.out.println(incidence);
		return incidence;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;
		int index = 0;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			// T numToCompare;
			int sizeOfList = sortedList.size();
			int middleIs = sizeOfList / 2;
			int counter = 0;
			int comparing = 0;
			int toCompare = 0;
//			System.out.println("Size of list is " + sizeOfList + " therefore " + sizeOfList / 2);
			// int toCompare = Integer.parseInt((String) t);
			// String toCompare = (String) sortedList.get(middleIs);
			if (t instanceof String) {
//				System.out.println("It was a string");
				comparing = Integer.parseInt((String) (t));
				toCompare = Integer.parseInt((String) sortedList.get(middleIs));
//				System.out.println("comparing is " + comparing + " toCompare is " + toCompare);

				while (comparing != toCompare) {
//					System.out.println("in while string");
					if (toCompare < comparing) {
//						System.out.println(toCompare + " < " + comparing);
						middleIs++;
						if (middleIs > sizeOfList - 1) {
//							System.out.println("not found");
							return 0;
						}
						toCompare = Integer.parseInt((String) sortedList.get(middleIs));
//						System.out.println("moved one forward");
					} else {
						// Integer.parseInt(toCompare) < Integer.parseInt((String) t)
//						System.out.println(toCompare + ">" + comparing);
						middleIs--;
						if (middleIs < 0) {
//							System.out.println("Not found");
							return 0;
						}
						toCompare = Integer.parseInt((String) sortedList.get(middleIs));
					} /*
						 * else if (toCompare > comparing) { toCompare = Integer.parseInt((String)
						 * sortedList.get(middleIs--)); System.out.println("new num to compare is " +
						 * toCompare);
						 */
				}
			} else if (t instanceof Integer) {
				// Integer.parseInt((String) t);
//				System.out.println("it was an int");
				comparing = (int) t;
				toCompare = (int) sortedList.get(middleIs);
//				System.out.println("comparing " + comparing + " to " + toCompare);
				while (comparing != toCompare) {
//					System.out.println("in while number");
					if (toCompare < comparing) {
//						System.out.println(toCompare + " < " + comparing);
						middleIs++;
						toCompare = (int) sortedList.get(middleIs);
					} else if (toCompare > comparing) {
//						System.out.println(toCompare + " > " + comparing);
						middleIs--;
						toCompare = (int) sortedList.get(middleIs);
					}

				}
			}
//			System.out.println("Found it at " + middleIs + " !!");
			return middleIs;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration

		String[] arrayOfStrings = string.split(" ");
		int sizeOfArray = arrayOfStrings.length;
		StringBuilder pigLatin = new StringBuilder();
		char temp;
		String answer;
		for (int i = 0; i < sizeOfArray; i++) {
			answer = arrayOfStrings[i];
			temp = arrayOfStrings[i].charAt(0);
			switch (temp) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				pigLatin.append(arrayOfStrings[i] + "ay");
				break;
			case 'b':
				pigLatin.append(answer.substring(1) + "bay");
				break;
			case 'c':
				pigLatin.append(answer.substring(1) + "cay");
				break;
			case 'd':
				pigLatin.append(answer.substring(1) + "day");
				break;
			case 'f':
				pigLatin.append(answer.substring(1) + "fay");
				break;
			case 'g':
				pigLatin.append(answer.substring(1) + "gay");
				break;
			case 'j':
				pigLatin.append(answer.substring(1) + "jay");
				break;
			case 'k':
				pigLatin.append(answer.substring(1) + "kay");
				break;
			case 'l':
				pigLatin.append(answer.substring(1) + "lay");
				break;
			case 'm':
				pigLatin.append(answer.substring(1) + "may");
				break;
			case 'n':
				pigLatin.append(answer.substring(1) + "nay");
				break;
			case 'p':
				pigLatin.append(answer.substring(1) + "pay");
				break;
			case 'q':
				if (answer.charAt(1) == 'u')
					pigLatin.append(answer.substring(2) + "quay");
				else
					pigLatin.append(answer.substring(1) + "qay");
				break;
			case 'r':
				pigLatin.append(answer.substring(1) + "ray");
				break;
			case 's':
				if (answer.charAt(1) == 'h')
					pigLatin.append(answer.substring(2) + "shay");
				else
					pigLatin.append(answer.substring(1) + "say");
				break;
			case 't':
				if (answer.charAt(1) == 'h')
					pigLatin.append(answer.substring(2) + "thay");
				else
					pigLatin.append(answer.substring(1) + "tay");
				break;
			case 'v':
				pigLatin.append(answer.substring(1) + "vay");
				break;
			case 'w':
				pigLatin.append(answer.substring(1) + "way");
				break;
			case 'x':
				pigLatin.append(answer.substring(1) + "xay");
				break;
			case 'y':
				pigLatin.append(answer.substring(1) + "yay");
				break;
			case 'z':
				pigLatin.append(answer.substring(1) + "zay");
				break;

			}
//			System.out.println("i = " + i);
			if (i < sizeOfArray - 1) {
				pigLatin.append(" ");
//				System.out.println("i is now " + i);
			}

		}
//		System.out.println(pigLatin);
		return pigLatin.toString();
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		// int counter = 0;
		String num = Integer.toString(input);
		int lengthOfString = num.length();
		int[] arrayOfNums = new int[lengthOfString];
		int temp = 0;
		double temp2;
		// Integer.parseInt(num, num.charAt(counter)
//		System.out.println("input = " + input + " string lenght= " + lengthOfString);
		// counter = 0;
		for (int i = 0; i <= lengthOfString - 1; i++) {
			arrayOfNums[i] = Character.getNumericValue(num.charAt(i));
//			System.out.println("curr char is " + num.charAt(i));
//			System.out.println("elevating " + arrayOfNums[i] + " to the " + lengthOfString + " power");
			temp2 = Math.pow(arrayOfNums[i], lengthOfString);
//			System.out.println("temp2 = " + temp2);
			temp += temp2;

		}
//		System.out.println("temp " + temp + "stringSize= " + lengthOfString);
		if (temp == input) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
//		System.out.println("L =" + l);
		List<Long> answers = new ArrayList<>();
		long counter = 2;
		long halfOfL = l;
//		System.out.println("half of L =" + halfOfL);
		// boolean keepGoing = true;
		do {
			if (halfOfL % counter == 0) {
				answers.add(counter);
//				System.out.println(halfOfL + " was successfully divided by " + counter);
				halfOfL = halfOfL / counter;
//				System.out.println("halfOfL is now " + halfOfL);
			} else {
//				System.out.println("tried to divide " + halfOfL + " with " + counter);
				counter++;
			}
//			System.out.println("Half of L = " + halfOfL + answers);

		} while (halfOfL != 1);
		return answers;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			StringBuilder rotation = new StringBuilder();
			int lengthOfString = string.length();
			String answer = null;
			int temp;
			for (int i = 0; i < lengthOfString; i++) {
				temp = string.charAt(i);
//				System.out.print("got " + temp + " = " + (char) temp);
				if ((temp >= 65) && (temp <= 90)) {

					temp = temp + key;
//					System.out.println(" which became a: " + (char) temp);
					if (temp > 90) {
						temp = temp - 26;
//						System.out.println("but is too big...");
					}
//					System.out.println(" so it became a: " + (char) temp);
					rotation.append((char) temp);
				} else if (temp >= 97 && temp <= 122) {

					temp = temp + key;
//					System.out.print(" is now a: " + (char) temp);
					if (temp > 122) {
						temp = temp - 26;
//						System.out.println("but since is too big...");
					}
//					System.out.println(" and became a " + (char) temp + " " + temp);
					rotation.append((char) temp);
//					System.out.println(rotation);
				} else {
					rotation.append((char) temp);
				}
			}

			return rotation.toString();
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		
		if( i > 1000 || i < 1) {
			throw new IllegalArgumentException();
		}
		List<Integer> answers = new ArrayList<>(i);
		answers.add(2);
		answers.add(3);
		int counter = 2;
		int number = 4;
		int test = 2;
		int answer = 0;
	//	System.out.println("finding the " + i + "th");
		// long halfOfL = l;
//		System.out.println("half of L =" + halfOfL);
		// boolean keepGoing = true;
		do {
		//	System.out.println("curr num " + number + "vs " + test);
			if (number % test == 0) {
			//	System.out.println("testing " + number + "%" + test);
				
				if (answers.contains(test)) {
				//	System.out.println("not a prime");
				//	System.out.println("RESET");
					test=1;
					number++;
				}else if (number == test) {
					answers.add(test);
					counter++;
				//	System.out.println("founda  prime!   RSEET" + test);
					test=1;
					number++;
				}
				//	break;				
				
			}
			test++;
		} while (counter < i);
		//System.out.println("out");
//			System.out.println("Half of L = " + halfOfL + answers);
		//System.out.println(i - 1);
		answer = answers.get(i - 1);
		//System.out.println(answer);
		return answer;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			StringBuilder cypherT = new StringBuilder();
//			cypherT.append("test");
			// char[] cypherT = new char[string.length()];

			char c;
			int n = 0;
			string = string.toLowerCase();
			for (int i = 0; i < string.length(); i++) {
				c = string.charAt(i);
				n++;
				if ((n % 5) == 0) {
					decode(string);
					// cypherT.append(' ');
				}
//				System.out.println("got " + c + " = " + (char) c);
				switch (c) {
				case 'a':
					// cypherT.append("z");
					cypherT.append('z');
					break;
				case 'b':
					cypherT.append('t');
					break;
				case 'c':
					cypherT.append('x');
					break;
				case 'd':
					cypherT.append('w');
					break;
				case 'e':
					cypherT.append('v');
					break;
				case 'f':
					cypherT.append('u');
					break;
				case 'g':
					cypherT.append('t');
					break;
				case 'h':
					cypherT.append('s');
					break;
				case 'i':
					cypherT.append('r');
					break;
				case 'j':
					cypherT.append('q');
					break;
				case 'k':
					cypherT.append('p');
					break;
				case 'l':
					cypherT.append('o');
					break;
				case 'm':
					cypherT.append('n');
					break;
				case 'n':
					cypherT.append('m');
					break;
				case 'o':
					cypherT.append('l');
					break;
				case 'p':
					cypherT.append('k');
					break;
				case 'q':
					cypherT.append('j');
					break;
				case 'r':
					cypherT.append('i');
					break;
				case 's':
					cypherT.append('h');
					break;
				case 't':
					cypherT.append('g');
					break;
				case 'u':
					cypherT.append('f');
					break;
				case 'v':
					cypherT.append('e');
					break;
				case 'w':
					cypherT.append('d');
					break;
				case 'x':
					cypherT.append('c');
					break;
				case 'y':
					cypherT.append('b');
					break;
				case 'z':
					cypherT.append('a');
					break;
				default:
					break;
				}

			}
			String test = new String(cypherT);
//			System.out.println("String so far: " + test);
			return test;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {

			StringBuilder cypherT = new StringBuilder();
//			cypherT.append("test");
			// char[] cypherT = new char[string.length()];

			char c;
			int n = 0;
			string = string.toLowerCase();
			for (int i = 0; i < string.length(); i++) {
				c = string.charAt(i);
				n++;
				// if (((n%5) == 0) && c == ' ') {
				// decode(string);
				// cypherT.append(' ');
				// }
//				System.out.println("got " + c + " = " + (char) c);
				switch (c) {
				case 'a':
					// cypherT.append("z");
					cypherT.append('z');
					break;
				case 'b':
					cypherT.append('t');
					break;
				case 'c':
					cypherT.append('x');
					break;
				case 'd':
					cypherT.append('w');
					break;
				case 'e':
					cypherT.append('v');
					break;
				case 'f':
					cypherT.append('u');
					break;
				case 'g':
					cypherT.append('t');
					break;
				case 'h':
					cypherT.append('s');
					break;
				case 'i':
					cypherT.append('r');
					break;
				case 'j':
					cypherT.append('q');
					break;
				case 'k':
					cypherT.append('p');
					break;
				case 'l':
					cypherT.append('o');
					break;
				case 'm':
					cypherT.append('n');
					break;
				case 'n':
					cypherT.append('m');
					break;
				case 'o':
					cypherT.append('l');
					break;
				case 'p':
					cypherT.append('k');
					break;
				case 'q':
					cypherT.append('j');
					break;
				case 'r':
					cypherT.append('i');
					break;
				case 's':
					cypherT.append('h');
					break;
				case 't':
					cypherT.append('g');
					break;
				case 'u':
					cypherT.append('f');
					break;
				case 'v':
					cypherT.append('e');
					break;
				case 'w':
					cypherT.append('d');
					break;
				case 'x':
					cypherT.append('c');
					break;
				case 'y':
					cypherT.append('b');
					break;
				case 'z':
					cypherT.append('a');
					break;
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
				case '0':
					cypherT.append(string.charAt(i));
				default:
					break;
				}

			}
			String test = new String(cypherT);
//			System.out.println("String so far: " + test);
			return test;

		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		// double[] nums = new double[10];
		char temp;
		int counter = 10;
		int total = 0;
		for (int i = 0; i < string.length(); i++) {
			temp = string.charAt(i);
//			System.out.println("temp is: " + temp);
			if (Character.isDigit(temp) || temp == 'X') {
//				System.out.println("counter is at " + counter);
				if (counter == 1 && string.charAt(i) == 'X') {
					total = total + 10;
//					System.out.println("found an X and it became a 10 " + total);
				} else {
//					System.out.println("i = " + i);
//					System.out.print("total is now=" + temp + "x" + counter);
					total = (Character.getNumericValue(temp) * counter) + total;
					// ]=Character.getNumericValue(temp);
//					System.out.println("=" + total);
					counter--;
				}
				// return false;
			}

		}
//		System.out.println("got out with a " + total);
		total = total % 11;
//		System.out.println(" mod 11 = " + total);
		if (total == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration

		LinkedList<Character> charList = new LinkedList<Character>();
		charList.add('a');
		charList.add('b');
		charList.add('c');
		charList.add('d');
		charList.add('e');
		charList.add('f');
		charList.add('g');
		charList.add('h');
		charList.add('i');
		charList.add('j');
		charList.add('k');
		charList.add('l');
		charList.add('m');
		charList.add('n');
		charList.add('o');
		charList.add('p');
		charList.add('q');
		charList.add('r');
		charList.add('s');
		charList.add('t');
		charList.add('u');
		charList.add('v');
		charList.add('w');
		charList.add('x');
		charList.add('y');
		charList.add('z');
		if (string.isEmpty()) {
			return false;
		}
		String testString = string.toLowerCase();
//		System.out.println(testString);
		char testChar;
		for (int i = 0; i < testString.length(); i++) {
			if (testString.charAt(i) != ' ') {
				testChar = testString.charAt(i);
//				System.out.println("comparing " + testChar + " to " + testString.charAt(i));
				if (charList.contains(testChar)) {
//					System.out.println(charList.remove(charList.indexOf(testChar)));
//					System.out.println("list is " + charList.size() + " long");
				} else {
//					System.out.println("that char was already found");
				}
			}
		}
//		System.out.println("counter is " + charList.size());
		if (charList.size() == 0) {
			return true;
		}

		return false;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		int sum = 0;
		int multiples = 0;
		Set<Integer> multipleSet = new HashSet<Integer>();
//		System.out.println("looking for multiples below " + i);
		for (int j = 0; j < set.length; j++) {
			while (multiples < i) {
				// multiples = set[j];
//				System.out.print(multiples + " + " + set[j]);
				multiples = multiples + set[j];
//				System.out.println(" = " + multiples);
				if (multiples < i) {
					multipleSet.add(multiples);
//					System.out.println(multiples + " was added");
				}
			}
			multiples = 0;
		}
		/*
		 * Iterator<String> iterator=list.iterator(); while(iterator.hasNext()){ // *
		 * System.out.print(iterator.next()+" "); }
		 */

		for (int x : multipleSet) {
			sum = sum + x;
//			System.out.println("sum = " + sum);
		}
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		int sum = 0;
		int temp = 0;
		if (string.length() <= 1) {
			return false;
		}
//		String card[] = string.split(" ");
//		String card2 = card[1] + card[3];
		StringBuilder validating = new StringBuilder();
		for (int i = 0; i < string.length(); i++) {
//			System.out.print("digits at ");
//			System.out.println(i + " is " + string.charAt(i) + ".");
			if (Character.isDigit(string.charAt(i))) {
				validating.append(string.charAt(i));
			} else if (string.charAt(i) != ' ') {
				return false;
			}
		}
//		System.out.println(validating + " with size " + validating.length());
		for (int i = 0; i < validating.length(); i++) {
//			System.out.print("i = ");
//			System.out.println(i);
			temp = i;
			temp = (temp + 1) % 2;
//			System.out.println("remainder= " + temp);
			if (temp == 0) {
//				System.out.print("doubling ");
//				System.out.print(Character.getNumericValue(validating.charAt(i)) + " = ");
				temp = Character.getNumericValue(validating.charAt(i));
				temp = temp * 2;
//				System.out.println(temp);
				if (temp >= 9) {
//					System.out.print(temp + " - 9 = ");
					temp -= 9;
//					System.out.println(temp);
				}
				sum = sum + temp;
			} else {
				temp = Character.getNumericValue(validating.charAt(i));
//				System.out.println("temp = " + temp);
				sum = sum + temp;
			}
//			System.out.println("sum so far= " + sum);
		}
//		System.out.println("sum%10=" + sum % 10);
		if ((sum % 10) == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5? int x = parseFirstNumber int y = parsedSecondNumber token
	 * = parsedToken
	 * 
	 * if (token = -) int x - y 2
	 * 
	 * What is 6 multiplied by 4? 0 1 2 3 4 5 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		/*
		 * String str = string; Scanner scan = new Scanner(string); if
		 * (str.contains("divided")){
		 * 
		 * }
		 */
		// Scanner scan = new Scanner(string);
		// int next = scan.nextInt();
		StringBuilder number = new StringBuilder();
		String arr[] = string.split(" ");
		int x = 0;
		int y = 0;
		int counter = 0;
		char caseLetter = ' ';
		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
			if ((arr[i].charAt(0) == '-' || Character.isDigit(arr[i].charAt(0))) && counter == 0) {
				// x = Integer.getInteger(arr[i]);
				x = Integer.parseInt(arr[i]);
//				System.out.println(x);
				counter++;
//				System.out.println("counter is " + counter);
			} else if (arr[i].contains("plus")) {
//				System.out.println(arr[i]);
				caseLetter = '+';
			} else if (arr[i].contains("minus")) {
//				System.out.println(arr[i]);
				caseLetter = '-';
			} else if (arr[i].contains("multiplied")) {
//				System.out.println(arr[i]);
				caseLetter = 'x';
			} else if (arr[i].contains("divided")) {
//				System.out.println(arr[i]);
				caseLetter = '/';
			} else if ((arr[i].charAt(0) == '-' || Character.isDigit(arr[i].charAt(0))) && counter == 1) {
//				System.out.println("is a -, i= " + i);
				// y = Integer.parseInt(arr[i]);
				String temp = arr[i];
//				System.out.println(temp);
				for (int j = 0; j < temp.length(); j++) {
					if (temp.charAt(j) == '-') {
						number.append(temp.charAt(j));
//						System.out.println("added a -");
					} else if (Character.isDigit(temp.charAt(j))) {
						number.append(temp.charAt(j));
//						System.out.println(number);
					}
				}
				// number.append(arr[i].charAt(0));
				temp = number.toString();
//				System.out.println(temp);
				y = Integer.parseInt(temp);
//				System.out.println(y);
			}
		}
		// int x = Integer.parseInt(arr[2]);
		// System.out.println("in it" + arr[2]);
		// int y = Integer.parseInt(arr[5]);
		int z = 0;
//		System.out.println("x = " + x);
//		System.out.println("y = " + y);
		switch (caseLetter) {
		case 'x':
			z = x * y;
			break;
		case '/':
			z = x / y;
			break;
		case '-':
			z = x - y;
			break;
		case '+':
			z = x + y;
		}
//		System.out.println(z);
		return z;
	}

}
