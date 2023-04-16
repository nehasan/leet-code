import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RBCPrep {
    private static int count = 0;

    public static Stream<String> streamOf(List<String> list) {
        return (list == null || list.isEmpty()) ? Stream.empty() : list.stream();
    }

    public static void wasCalled() {
        count++;
    }

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("HELLO");
//        list.add("HELLO1");
//        list.add("HELLO2");
//        list.add("HELLO3");
//        System.out.println(Arrays.toString(streamOf(list).toArray()));

        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> stream = collection.stream();
        System.out.println(Arrays.toString(stream.toArray()));

        Stream<String> streamOne = Arrays.stream(new String[] {"a", "b", "c", "d"});
        System.out.println(Arrays.toString(streamOne.toArray()));

//        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
        Stream<Integer> integerStream = Stream.iterate(40, n -> n + 2).limit(20);
        System.out.println(Arrays.toString(integerStream.toArray()));

        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        Stream<String> filteredStream = list.stream().filter( elm -> {
            wasCalled();
            return elm.contains("2");
        });

        System.out.println(count);
        System.out.println(Arrays.toString(filteredStream.toArray()));

        Optional<Integer> optInt = Stream.of(1,2,3,4).reduce((a, b) -> a + b);

        int reducedTwoParams = IntStream.range(1,5).reduce(10, (a,b) -> a + b);

        System.out.println(optInt);
        System.out.println(reducedTwoParams);
    }
}
