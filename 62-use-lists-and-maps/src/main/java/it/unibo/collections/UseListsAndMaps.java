package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        
        List<Integer> arrayInt = new ArrayList<Integer>();
        for(int i = 1000; i<2000; i++) {
            arrayInt.add(i);
        }

        System.out.println(arrayInt.toString());
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> listInt = new LinkedList<>();
        listInt.addAll(arrayInt);
        
        System.out.println(listInt.toString());

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int temp = arrayInt.getFirst();
        arrayInt.set(0, arrayInt.getLast());
        arrayInt.set(arrayInt.size()-1, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer i : arrayInt) {
            System.out.println(i.toString());
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        Test1(arrayInt);
        Test1(listInt);
        
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        Test2(arrayInt);
        Test2(listInt);
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Long> continentMap = new HashMap<String, Long>();
        continentMap.put("Africa", 1110635000L);
        continentMap.put("Americas", 1110635000L);
        continentMap.put("Antartica", 1110635000L);
        continentMap.put("Asia", 1110635000L);
        continentMap.put("Europe", 1110635000L);
        continentMap.put("Oceania", 1110635000L);
        /*
         * 8) Compute the population of the world
         */
        long sum = 0;
        for(String key : continentMap.keySet()) {
            sum = continentMap.get(key);
        }

        System.out.println("World Population: " + sum);
    }

    private static void Test1(List<Integer> list) {

        long time = System.nanoTime();

        for (int i = 1; i <= 100000; i++) {
            list.add(i);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Adding 100.000 elements "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
    }

    private static void Test2(List<Integer> list) {

        long time = System.nanoTime();

        for (int i = 1; i <= 1000; i++) {
            list.get((list.size()-1) / 2);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Reading 1000 elements "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
    }
}
