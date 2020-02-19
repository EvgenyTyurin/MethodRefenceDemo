import java.time.LocalDate;
import java.util.Arrays;

/**
 * Instead of creating comparator we pass reference of Person::compareByAge
 * to Arrays.sort()
 */

public class MethodReferenceDemo {

    // Run point
    public static void main(String[] args) {
        Person[] people = {
                new Person("John", LocalDate.of(1978, 12, 1)),
                new Person("Mary", LocalDate.of(1977, 12, 20))
        };
        System.out.println(Arrays.toString(people)); // John, Mary
        Arrays.sort(people, Person::compareByAge);
        System.out.println(Arrays.toString(people)); // Mary, John
    }

    static class Person {
        String name;
        LocalDate birthday;

        public Person(String name, LocalDate birthday) {
            this.name = name;
            this.birthday = birthday;
        }

        public static int compareByAge(Person person1, Person person2) {
            return person1.birthday.compareTo(person2.birthday);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", birthday=" + birthday +
                    '}';
        }
    }

}
