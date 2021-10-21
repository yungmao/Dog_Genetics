package com.company;

import java.util.*;

public class DogGenetics {
    public static Random rand = new Random();
    private static final int MAX_BREEDS = 5;
    private static final String[] breeds_of_dogs = {
            "German Shepherd",
            "Labrador Retriever",
            "French Bulldog",
            "Bulldog",
            "Poodle ",
            "Beagle",
            "Rottweiler"
    };

    public static ArrayList<Integer> getRandomPercentage() {
        ArrayList<Double> array_double = new ArrayList<Double>();
        ArrayList<Integer> array_int = new ArrayList<Integer>();
        double sum = 0;
        int sum_of_array = 0;
        for (int i = 0; i < MAX_BREEDS; i++) {
            double _random_number = rand.nextDouble();
            array_double.add(_random_number);
            sum += _random_number;
        }
        for (int j = 0; j < MAX_BREEDS - 1; j++) {
            double fraction = array_double.get(j) / sum;
            int percentage = (int) Math.ceil(fraction * 100);
            sum_of_array += percentage;
            array_int.add(percentage);
        }
        int last_percentage = 100 - sum_of_array;
        array_int.add(last_percentage);
        array_int.sort(Collections.reverseOrder());
        return array_int;
    }

    public static void getAndPrintName() {
        Scanner input = new Scanner(System.in);
        System.out.print("What is your dog's name? ");
        String dog_name = input.nextLine();
        System.out.println("Well then, I have this highly reliable report on " + dog_name + "'s prestigious background right here.\n");
        System.out.println(dog_name + " is:");
    }

    public static Integer[] getRandomBreedsIndex() {
        Set<Integer> random_index_set = new LinkedHashSet<Integer>();
        while (random_index_set.size() < MAX_BREEDS) {
            Integer next = rand.nextInt(breeds_of_dogs.length);
            random_index_set.add(next);
        }
        // Converting the above Map to an array
        Integer[] random_indexes = new Integer[random_index_set.size()];
        random_indexes = random_index_set.toArray(random_indexes);
        return random_indexes;
    }

    public static void printBackground() {
        Integer[] randomBreedIndex = getRandomBreedsIndex();
        ArrayList<Integer> randomPercentage = getRandomPercentage();
        for (int i = 0; i < MAX_BREEDS; i++) {
            int index = randomBreedIndex[i];
            System.out.println(randomPercentage.get(i)+"% "+breeds_of_dogs[index]);
        }
//        System.out.println(breeds_with_percentages);
    }

    /*hMapNumbers.entrySet().forEach( entry -> {
            System.out.println( entry.getKey() + " => " + entry.getValue() );
        });*/
    public static void makeReport() {
        getAndPrintName();
        printBackground();
        System.out.println("\nWow, that's QUITE the dog!    ");
    }
}
