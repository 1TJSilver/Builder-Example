import java.util.OptionalInt;

public class PersonBuilder implements Builder{
    protected String name;
    protected String surname;
    protected OptionalInt age;
    protected String city;

    public PersonBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException{
        if (age >= 0) {
            this.age = OptionalInt.of(age);
        } else {
            throw new IllegalArgumentException("Incorrect age");
        }
        return this;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    @Override
    public Person build() throws IllegalArgumentException{
        Person person;
        if (name == null || surname == null){
            throw new IllegalArgumentException("Name or surname not specified");
        }
        if (age.isPresent()){
            person = new Person(name, surname, age.getAsInt());
        } else {
            person = new Person(name, surname);
        }
        if (city != null){
            person.setCity(city);
        }
        return person;
    }
}
