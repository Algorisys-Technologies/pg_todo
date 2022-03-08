package com.todo.demo;

import java.util.*;
import java.util.stream.Collectors;

//import java.lang.reflect.Method;
//import java.lang.reflect.Parameter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import lombok.NonNull;

//interface Sayable {
//	default void hello() {
//		System.out.println("Hello from interface.");
//	}
//
//	// abstract function now this interface is functional interface
//	void sayHello();
//
//	static void world() {
//		System.out.println("This is programing world!");
//	}
//}
//
//abstract class AbstractClass {
//	AbstractClass() {
//		System.out.println("This is a constructor of Abstract class.");
//	}
//
//	void hello(String str) {
//		System.out.println(str);
//	}
//}
//
//class MethodParameter {
//	String showString(String a, String b) {
//		return a + b;
//	}
//
//	Integer showInt(int a, int b) {
//		return a + b;
//	}
//}

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
//		TodoApplication.showArrayList();
//		TodoApplication.showLinkedList();
//		TodoApplication.showHashSet();
//		TodoApplication.showLinkedHashSet();
//		TodoApplication.showTreeSet();
//		TodoApplication.showPriorityQueue();
//		TodoApplication.showArrayDeque();
		
//		Sayable sayable = TodoApplication::showHashMap;
//		sayable.sayHello();
//
//		Thread t2=new Thread(TodoApplication::showBase64EncodeDecode);
//		t2.start();
//		
//		Sayable sayable2=new TodoApplication()::show;
//		sayable2.sayHello();
		
//		TodoApplication.showStringJoiner();
//		TodoApplication.showOptional();
//		TodoApplication.showParallelArray();
//		TodoApplication.showTypeInference(new ArrayList<>());
//		TodoApplication.showMethodParameter();

//		TodoApplication todoApplication = new TodoApplication();
//		todoApplication.hello("pavan");
//		todoApplication.hello();
//		todoApplication.sayHello();
//		Sayable.world();
//		System.out.println(todoApplication.showTypeInference1(new ArrayList<>()));

//		System.out.println("--------------------------");

		SpringApplication.run(TodoApplication.class, args);
	}

	void show() {
		System.out.println("This is instance method");
	}
	
	static void showArrayList() {
		ArrayList<String> list = new ArrayList<>();
		list.add("Angular");
		list.add("SpringBoot");
		list.add("Nodejs");
		list.add("Java");
		System.out.println("This is ArrayList:" + list);

		ListIterator<String> itr = list.listIterator();
		while (itr.hasNext()) {
			System.out.println("This is ArrayList Traversing::" + itr.next());
		}

		System.out.println("-----------------------");

		while (itr.hasPrevious()) {
			System.out.println("This is ArrayList Reverse Traversing::" + itr.previous());
		}

		System.out.println("-------------------------");

		for (String str : list) {
			System.out.println("This is Traversing using for:" + str);
		}

		System.out.println("------------------------------");
		list.forEach(System.out::println);

		System.out.println("----------------------------");
		System.out.println("ArrayList get method:" + list.get(2));
		list.set(2, "Java");
		System.out.println("This is updated ArrayList:" + list);

		Collections.sort(list, (a, b) -> {
			return b.compareTo(a);
		});

		System.out.println("This is Sorted reverse ArrayList:" + list);
		Collections.sort(list);

		System.out.println("This is sorted ArrayList:" + list);
	}

	static void showLinkedList() {
		LinkedList<Integer> ll = new LinkedList<>();
		ll.add(5);
		ll.addFirst(6);
		ll.addLast(6);
		ll.add(9);

		LinkedList<Integer> ll2 = new LinkedList<>();
		ll2.add(10);
		ll.addAll(2, ll2);

		System.out.println("This is LinkedList:" + ll);
		System.out.println("This is LinkedList getFirst:" + ll.getFirst());
		System.out.println("This is LinkedList getLast:" + ll.getLast());
		System.out.println("This is LinkedList get:" + ll.get(2));
		System.out.println("This is LinkedList indexOf(Obejct):" + ll.indexOf(1512));
		System.out.println("This is LinkedList indexOf(index):" + ll.indexOf(5));
		System.out.println("This is LinkedList poll:" + ll.poll());
		System.out.println("This is LinkedList peek:" + ll.peek());
		System.out.println("This is LinkedList size:" + ll.size());
		System.out.println("This is LinkedList isEmpty:" + ll.isEmpty());

		for (Integer n : ll) {
			System.out.println("This is LinkedList Traversing:" + n);
		}
	}

	static void showHashSet() {
		HashSet<String> set = new HashSet<>();

		// allow unique value only and not maintains insertion order
		// duplicate not allow in set
		set.add(null);
		set.add(null);
		set.add("javaScript");
		set.add("Java");
		set.add("Java");
		System.out.println("This is HashSet:" + set);
	}

	static void showLinkedHashSet() {
		LinkedHashSet<String> set = new LinkedHashSet<>();

		// allow unique value only and maintains insertion order
		set.add(null);
		set.add(null);
		set.add("javaScript");
		set.add("Java");
		set.add("Java");
		System.out.println("This is LinkedHashSet:" + set);
	}

	static void showTreeSet() {
		TreeSet<String> set = new TreeSet<>();

//		set.add(null); TreeSet does not allow null value and maintains ascending order and unique value only allowed,
//	    duplicate not allow in set
		set.add("javaScript");
		set.add("java");
		set.add("java");
		set.add("Java");
		set.add("angular");
		set.add("nodejs");
		set.add("springBoot");
		System.out.println("This is TreeSet:" + set);
		System.out.println("Reverse Set: " + set.descendingSet());
		System.out.println("Head Set: " + set.headSet("javaScript", true));
		System.out.println("SubSet: " + set.subSet("Java", false, "springBoot", true));
		System.out.println("TailSet: " + set.tailSet("nodejs", false));
		System.out.println("TailSet: " + set.tailSet("nodejs", true));
	}

	static void showPriorityQueue() {
		PriorityQueue<String> queue = new PriorityQueue<>();

		// does not maintains insertion order and null not allowed
		// we can only add/remove from the head of queue
		queue.add("html");
		queue.add("css");
		queue.add("bootstrap");
		queue.add("material");
		System.out.println("PriorityQueue:" + queue);
		System.out.println("head:" + queue.element());
		System.out.println("head:" + queue.peek());
		System.out.println("remove:" + queue.remove());
		System.out.println("PriorityQueue:" + queue);
		System.out.println("poll:" + queue.poll());
		System.out.println("After elements removed PriorityQueue:" + queue);
	}

	static void showArrayDeque() {
		ArrayDeque<String> deque = new ArrayDeque<>();

		// maintains the insertion order and does not allow the null value
		// we can remove/add element from both end
		deque.add("html");
		deque.add("css");
		deque.add("bootstrap");
		deque.add("material");
		System.out.println("ArrayDeque:" + deque);
		deque.pollLast();
		System.out.println("ArrayDeque after pollLast:" + deque);
		deque.addLast("Reactjs");
		System.out.println("ArrayDeque after addLast:" + deque);
		System.out.println("ArrayDeque after pollFirst:" + deque.pollFirst());
		deque.addFirst("angular");
		System.out.println("ArrayDeque after addFirst:" + deque);
		System.out.println("ArrayDeque after peek:" + deque.peek());
		System.out.println("ArrayDeque after peekFirst:" + deque.peekFirst());
		System.out.println("ArrayDeque after peekLast:" + deque.peekLast());
	}

	public static void showHashMap() {
		HashMap<Integer, String> map = new HashMap<Integer, String>();

		// HashMap follow key value pair,key is always unique but value can duplicate
		map.put(2, "Angular");
		map.put(1, "Reactjs");
		map.put(0, "SpringBoot");
		map.put(3, "Nodejs");
		map.put(4, "javaScript");
		System.out.println("This is the map:" + map);

		map.put(1, "React");
		System.out.println("This is updated the map:" + map);
		System.out.println("This is the map size:" + map.size());

		for (Map.Entry<Integer, String> m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

		System.out.println("------------------------------");

		map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(e -> {
			System.out.println(e);
		});

		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(e -> {
			System.out.println(e);
		});

		map.putIfAbsent(5, "BootStrap");
		map.putIfAbsent(5, "mySql");
		System.out.println("This is the map after putIfAbsent:" + map);

		map.remove(1);
		map.remove(5, "BootStrap");
		map.replace(3, "mySql");

		System.out.println("------------------------------");
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(e -> {
			System.out.println(e);
		});

		System.out.println("------------------------------");
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> {
			System.out.println(e);
		});

		System.out.println("------------------------------");
		(map.entrySet().stream().filter(p -> p.getKey() > 2)).forEach(e -> {
			System.out.println(e);
		});

		System.out.println("------------------------------");
		Long n = map.entrySet().stream().count();
		System.out.println(n);

		System.out.println("------------------------------");
		System.out.println(map.entrySet().stream().findAny());
		System.out.println(map.entrySet().stream().findFirst());
		(map.entrySet().stream().limit(2)).forEachOrdered(e -> System.out.println(e));
		System.out.println(map);

		System.out.println("------------------------------");
		// implemented the method reference and skip method ...
		(map.entrySet().stream().skip(2)).forEachOrdered(System.out::println);

		System.out.println("------------------------------");
		List<String> map1 = map.entrySet().stream().filter(p -> p.getKey() > 2).map(p->p.getValue())
				.collect(Collectors.toList());
		System.out.println(map1);

		System.out.println("------------------------------");
		Set<String> map2 = map.entrySet().stream().map(p -> p.getValue()).collect(Collectors.toSet());
		System.out.println(map2);

		System.out.println("------------------------------");
		String maxKeyValue = Collections.max(map.values());
		System.out.println("This is the max value in the map:" + maxKeyValue);

		System.out.println("------------------------------");
		Integer sumIdInt = map.entrySet().stream().collect(Collectors.summingInt(p -> p.getKey()));
		System.out.println("This is sum of all id:" + sumIdInt);
		Double sumIdDouble = map.entrySet().stream().collect(Collectors.summingDouble(p -> p.getKey()));
		System.out.println("This is sum of all id:" + sumIdDouble);
		Long sumIdLong = map.entrySet().stream().collect(Collectors.summingLong(p -> p.getKey()));
		System.out.println("This is sum of all id:" + sumIdLong);
		Double averageIdInt = map.entrySet().stream().collect(Collectors.averagingInt(p -> p.getKey()));
		System.out.println("This is average of id:" + averageIdInt);
		Long countingOfElement = map.entrySet().stream().collect(Collectors.counting());
		System.out.println("This is counting of id:" + countingOfElement);
		System.out.println("------------------------------");
	}

	static void showBase64EncodeDecode() {
		Base64.Encoder encoder = Base64.getEncoder();
		String str = encoder.encodeToString("Java.".getBytes());
		System.out.println("Encoded String:" + str);

		Base64.Decoder decoder = Base64.getDecoder();
		String dStr = new String(decoder.decode(str));
		System.out.println("Decoded String:" + dStr);

		Base64.Encoder encoder1 = Base64.getUrlEncoder();
		String strUrl = encoder1.encodeToString("www.google.com/java/encode-decoding/".getBytes());
		System.out.println("Encoded url:" + strUrl);

		Base64.Decoder decoder1 = Base64.getUrlDecoder();
		String dStrUrl = new String(decoder1.decode(strUrl));
		System.out.println("Decoded url:" + dStrUrl);

		Base64.Encoder encoder2 = Base64.getMimeEncoder();
		String str1 = encoder2.encodeToString("Java.\n Java is good.".getBytes());
		System.out.println("Encoded String with MimeIncoder:" + str1);

		Base64.Decoder decoder2 = Base64.getMimeDecoder();
		String dStr1 = new String(decoder2.decode(str1));
		System.out.println("Decoded String with MimeDecoder:" + dStr1);
	}

	static void showStringJoiner() {
		StringJoiner stringJoiner = new StringJoiner(",");
		stringJoiner.add(null);
		stringJoiner.add("Angular");
		stringJoiner.add("SpringBoot");
		stringJoiner.add("javaScript");
		stringJoiner.add("Java");
		System.out.println("String joiner only with delimiter:" + stringJoiner);

		StringJoiner stringJoiner2 = new StringJoiner(",", "{", "}");
		stringJoiner2.add("SpringBoot");
		stringJoiner2.add("Angular");
		stringJoiner2.add("javaScript");
		stringJoiner2.add("Java");
		System.out.println("---------------------------");
		System.out.println("String Joiner with prefix and suffix:" + stringJoiner2);

		System.out.println("---------------------------");
		stringJoiner2.merge(stringJoiner);
		System.out.println(stringJoiner2);

		System.out.println("---------------------------");
		stringJoiner2.setEmptyValue("mySql");
		System.out.println(stringJoiner2);
		System.out.println("---------------------------");
		System.out.println("This is the length of stringJoiner2:" + stringJoiner2.length());
		System.out.println("---------------------------");
		String str = stringJoiner2.toString();
		System.out.println(str);
		System.out.println("This is a character on index 6 of stringJoiner2:" + str.charAt(6));
	}

	static void showOptional() {
		String str[] = new String[10];
		str[2] = "Java is good for programming.";
		Optional<String> checkNull = Optional.ofNullable(str[2]);
		Optional<String> empty = Optional.empty();
		System.out.println("Empty Optinal<>:" + empty);
		if (checkNull.isPresent()) {
			String lowercaseString = str[2].toLowerCase();
			System.out.println("lowerCase:" + lowercaseString);
			System.out.println("str[2]:" + str[2]);
			checkNull.ifPresent(System.out::println);
			System.out.println(checkNull.get());
			System.out.println("Filtered value:" + checkNull.filter(p -> p.equals(lowercaseString)));
			System.out.println("Filtered value:" + checkNull.filter(p -> p.equals("Java is good for programming.")));
			System.out.println("Hash code of string:" + checkNull.hashCode());
			System.out.println("orElse:" + checkNull.orElse("Value is not present."));
			System.out.println("orElse:" + empty.orElse("Value is not present in empty."));
			System.out.println("Length of str[2]:" + str[2].length());
		} else
			System.out.println("string value is not present");
	}

	static void showParallelArray() {
		int[] arr = { 2, 5, 7, 3, 8, 9, 0, 1, 2, 4, 5, 8, 7 };
		for (int i : arr) {
			System.out.print(i + "");
		}
		Arrays.parallelSort(arr);
		System.out.println("\nAfter the parallel sort array:");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("\nAfter the parallel sort array:");
		int[] arr2 = { 2, 5, 1, 0, 7, 8, 9, 3, 4, 2, 10, 1, 0, 1 };
		Arrays.parallelSort(arr2, 0, 6);
		for (Integer i : arr2) {
			System.out.print(i + " ");
		}

		System.out.println("\nAfter the parallel sort string array:");
		String[] arr3 = { "javaScript", "angular", "springBoot", "Angular", "1", "0" };
		Arrays.parallelSort(arr3);
		for (String i : arr3) {
			System.out.print(i + " ");
		}
	}

	static void showTypeInference(ArrayList<String> list) {
		list.add("TypeInference");
		list.add("ArrayList");
		System.out.println("This is a list:" + list);
	}

	ArrayList<String> showTypeInference1(ArrayList<String> list) {
		list.add("TypeInference");
		list.add("ArrayList");
		list.add(null);
		return list;
	}

//	static void showMethodParameter() {
//		MethodParameter methodParameter = new MethodParameter();
//		Class methodCls = methodParameter.getClass();
//		@NonNull
//		Method[] method = methodCls.getDeclaredMethods();
//		for (Method method2 : method) {
//			System.out.print(method2.getName());
//			Parameter[] parameter = method2.getParameters();
//			for (Parameter parameter2 : parameter) {
//				System.out.print(" " + parameter2.getParameterizedType());
//				System.out.print(" " + parameter2.getName());
//			}
//			System.out.println();
//		}
//	}
//
}
