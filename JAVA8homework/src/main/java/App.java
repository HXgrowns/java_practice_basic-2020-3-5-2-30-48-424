import entity.MasterNumber;
import entity.Person;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        //TODO: print Person data that masterNumber is 1 and 2
        // print Person data that masterNumber is 3
        Stream<Person> person = personService.getPersonByMasterNumbers(Arrays.asList(new MasterNumber("1"), new MasterNumber("2")));
        Iterator<Person> iterator = person.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("-------------------------------");
        person = personService.getPersonByMasterNumbers(Arrays.asList(new MasterNumber("3")));
        Iterator<Person> iterator1 = person.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }

}
