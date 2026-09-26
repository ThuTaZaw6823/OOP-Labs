package lab2.q4;



public class FamilyTest {

    public static void main(String[] args) {

        System.out.println("===== PERSON TEST =====");

        Person person = new Person("John", "Smith");

        System.out.println("First name: " + person.getFirstname());
        System.out.println("Last name: " + person.getLastname());

        person.setFirstname("David");
        person.setLastname("Brown");

        System.out.println("New first name: " + person.getFirstname());
        System.out.println("New last name: " + person.getLastname());


        System.out.println();
        System.out.println("===== CHILD TEST =====");

        Child child = new Child("Tom", "Brown", 10, 140, 35.5);

        System.out.println("First name: " + child.getFirstname());
        System.out.println("Last name: " + child.getLastname());

        child.setFirstname("Tim");
        child.setLastname("Smith");

        System.out.println("New first name: " + child.getFirstname());
        System.out.println("New last name: " + child.getLastname());

        child.setGuardian(person);

        System.out.println("Guardian first name: "
                + child.getGuardian().getFirstname());

        System.out.println("Guardian last name: "
                + child.getGuardian().getLastname());


        System.out.println();
        System.out.println("===== PARENT TEST =====");

        Parent parent = new Parent("Michael", "Smith", 5000);

        System.out.println("First name: " + parent.getFirstname());
        System.out.println("Last name: " + parent.getLastname());

        parent.setFirstname("Mike");
        parent.setLastname("Johnson");

        System.out.println("New first name: " + parent.getFirstname());
        System.out.println("New last name: " + parent.getLastname());

        parent.setChild(child);

        System.out.println("Child first name: "
                + parent.getChild().getFirstname());

        System.out.println("Child last name: "
                + parent.getChild().getLastname());


        System.out.println();
        System.out.println("===== MOTHER TEST =====");

        Mother mother = new Mother("Mary", "Smith", 4000);

        System.out.println("First name: " + mother.getFirstname());
        System.out.println("Last name: " + mother.getLastname());

        mother.setFirstname("Anna");
        mother.setLastname("Brown");

        System.out.println("New first name: " + mother.getFirstname());
        System.out.println("New last name: " + mother.getLastname());

        mother.setChild(child);

        System.out.println("Mother's child first name: "
                + mother.getChild().getFirstname());

        System.out.println("Mother's child last name: "
                + mother.getChild().getLastname());
    }
}
