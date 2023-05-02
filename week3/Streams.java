package week3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        
        int[] numbers = {2,7,4,9,1,5,8,3,6};

        Arrays.stream(numbers).filter(n -> n > 6).forEach(x -> System.out.println(x));

        // numbers.stream().filter(n -> n > 6).reduce(0,(ans,i)->ans+i);

        List<String> str = Arrays.asList("nine", "pavani");

        long count = str.stream().filter(s -> s.contains("ni")).count();
        System.out.println(count);

        // create a list of strings, filter out the strings that have length greater than 4

        List<String> str1 = Arrays.asList("hi", "hello", "world");
        List<String> fil = str1.stream().filter(s -> s.length() > 4).sorted().collect(Collectors.toList());
        System.out.println(fil);
        System.out.println(fil.size());



    }

}
