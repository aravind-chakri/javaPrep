package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CoreStreams {
        public static void main(String[] args) {
            List<Integer> nums = List.of(1, 8, 7, 9, 2, 3, 2, 4, 3, 7, 9);

            /*
             * Remove duplicates from a list using streams
             * toList() is introduced in java 16 to collect data into a list.
             * So we use .collect(Collector.toList()) to keep it java 8
             */
            List<Integer> uniqueElements = nums.stream().distinct().collect(Collectors.toList());
            System.out.println("List of Integers after duplicates removal: " + uniqueElements);




            /*
            * Sort a list of Integers in ascending and descending order
            *
            * */
            List<Integer> ascElements = nums.stream().sorted().collect(Collectors.toList());
            System.out.println("Integers in ascending order: " + ascElements);

            List<Integer> descElements = nums.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            System.out.println("Integers in descending order: " + descElements);




            /*
            * Find second-highest number in a list
            * List.of(3, 4, 8); was introduced in java 9, so we use Arrays.asList(); to create a list.
            * findFirst() return Optional
            * */
            List<Integer> numbers = Arrays.asList(1, 8, 7, 2, 5, 3, 6, 4);
            Optional<Integer> secondHighest = numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
            System.out.println(secondHighest.get());





            /*
            * Find Longest String in a list;
            * */
            List<String> names = Arrays.asList("Aravind", "Aditya", "EPAM", "Raj", "aravind");
            Optional<String> longestName = names.stream().sorted(
                    Comparator.comparingInt(String :: length).reversed()).findFirst();
            System.out.println("Longest String is: " + longestName);
            // sorting is o(n log n) so using max will be o(n)
            Optional<String> longest = names.stream().max(Comparator.comparingInt(String :: length));
            System.out.println("Longest String is: " + longest);




            /*
            * Covert a list of Strings to uppercase
            * */
            List<String> upperCaseNames = names.stream().map(String :: toUpperCase).collect(Collectors.toList());
            System.out.println("Uppercase Names: " + upperCaseNames);




            /*
            * Count Strings starting with a specific letter
            * */
            long count = names.stream().filter(name -> name.startsWith("A")).count();
            System.out.println("Count of String starting with A: " + count);


            /*
            * Find first non-repeating element
            * */
            Optional<String> firstNonRepeatedElement = names.stream().filter(e -> Collections.frequency(names, e) == 1).findFirst();
            System.out.println("First Non-repeating element using Collections.frequency: " + firstNonRepeatedElement);
            // Above solution works but it's also o(n^2) and inefficient for large datasets
            // Also not accurate as it's case-sensitive
            Optional<String> firstNonRepeating = names.stream()
                                                .map(String :: toUpperCase)
                                                .collect(Collectors
                                                        .groupingBy(e -> e, LinkedHashMap :: new, Collectors.counting()))
                                                        .entrySet().stream()
                                                        .filter(entry -> entry.getValue() == 1)
                                                        .map(Map.Entry:: getKey)
                                                        .findFirst();
            System.out.println("First Non repeating element using Grouping: " + firstNonRepeating);

            /*
            * Reverse a list using streams
            * */
            List<String> reverseList = names.stream().collect(
                    Collectors.collectingAndThen(Collectors.toList(), list -> {
                        Collections.reverse(list);
                        return list;
                    }));
            System.out.println("Reversed List: " + reverseList);

            List<String> reverse = IntStream.range(0, names.size()).
                                    mapToObj(i -> names.get(names.size() - 1 - i))
                    .collect(Collectors.toList());
            System.out.println("Reverse List: " + reverse);





            /*
            * Merge two lists and remove duplicates
            * */
            List<String> names2 = Arrays.asList("Surya", "Aravind", "adil");
            List<String> mergedList = Stream.concat(names.stream(), names2.stream()).distinct().collect(Collectors.toList());
            System.out.println(mergedList);





            /*
            * convert a list into a comma separated String
            * */
            String text = names.stream().collect(Collectors.joining(","));
            System.out.println("Comma Separated String is: " + text);

            /*
            * Partition Elements by their frequency in sorted order.
            * */

            Map<Integer, Long> frequencyMap = nums.stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            System.out.println(frequencyMap);

           Map<Long, List<Integer>> frequencyWiseElements = frequencyMap.entrySet().stream()
                    .collect(Collectors.groupingBy(Map.Entry::getValue,
                            HashMap::new, Collectors.mapping(Map.Entry::getKey,
                                    Collectors.collectingAndThen(Collectors.toList(), list -> {
                                        Collections.sort(list);
                                        return list;
                                    }))));
            System.out.println(frequencyWiseElements);


        }
}
