public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setCity("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom.getName() + " есть сын, " + son.getName());

        try {
            new PersonBuilder().build();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}