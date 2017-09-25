import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;


class Person {
    String firstName;
    String lastName;

    Person() {}

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

public class StreamTest {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        int sum = Arrays.stream(arr).reduce(0,(x, y)->x+y);
        System.out.println(" Sun is = "+sum);
        Arrays.stream(arr).sorted().forEach(System.out::println);

        List<Integer> listVales = Arrays.stream(arr).map(x -> x+1).collect(Collectors.toList() );
        int num = 1;
        Converter <Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);

        String converted = stringConverter.convert(2);
        System.out.println(converted);

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Supplier <Person> personSupplier = Person::new;

        System.out.println(" "+ personSupplier.get() );
        //Arrays.stream(x->x+y);
    }
}
