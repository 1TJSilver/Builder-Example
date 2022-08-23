import javax.swing.text.html.Option;
import java.util.OptionalInt;
import java.util.function.IntConsumer;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String city;

    public Person (String name, String surname, Integer age){
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
        this.city = null;
    }
    public Person (String name, String surname){
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.empty();
        this.city = null;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return hasAge()? age.getAsInt() : null;
    }

    public String getCity() {
        return city;
    }

    public String getSurname() {
        return surname;
    }
    public void happyBirthday(){
        IntConsumer consumer = (x -> x++);
        if (hasAge()){
            age.ifPresent(consumer);
        }
    }
    public boolean hasAddress(){
        return city != null;
    }
    public PersonBuilder newChildBuilder (){
        PersonBuilder builder = new PersonBuilder();
        builder
                .setAge(0)
                .setSurname(surname)
                .setCity(city);
        return builder;
    }
    public boolean hasAge(){
        return age.isPresent();
    }
}
