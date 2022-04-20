import java.util.ArrayList;

public class MMN12_Q1 {

    public static void main(String[] args) throws CloneNotSupportedException{

        ArrayList<Animal> zoo = new ArrayList<Animal>();

        Chameleon chameleon = new Chameleon("Chameleon", 2, "green & some more", false, new Owner("Ben", "123"));
        zoo.add(chameleon);
        Dolphin dolphin = new Dolphin("Dolphin", 7, "grey & White", true);
        zoo.add(dolphin);
        Human human = new Human("David", 15, "skin color", new Owner("Moshe", "456"),"male" );
        zoo.add(human);
        Kangaroo kangaroo = new Kangaroo("Kangaroo", 3, "brown", true);
        zoo.add(kangaroo);
        Koala koala = new Koala("koala", 4, "grey", true);
        zoo.add(koala);
        Snake snake = new Snake("Snake", 1, "red", true, new Owner("Chen", "789"), true);
        zoo.add(snake);

        System.out.println("Part 2 of question 1:");
        dayAtTheZoo(zoo);

        // Only after finishing the question did I think to make a new animal sheep and clone it and naming it Dolly.... sorry
        System.out.println("\nPart 3 of question 1:");
        Snake originalSnake = new Snake("Snakey", 3, "Black", true, new Owner("Chen", "789"), false);
        try{
            Snake clonedSnake = (Snake)originalSnake.clone();
            System.out.println("\nPrinting the information on both snakes: ");
            System.out.println(originalSnake);
            System.out.println(clonedSnake);

            System.out.println("Changing owner for cloned snake... ");
            clonedSnake.owner.setName("Ulmar");
            System.out.println("\nPrinting the information again on both snakes to see if the cloning worked: ");
            System.out.println(originalSnake);
            System.out.println(clonedSnake);
            System.out.println("Are the original snake and the cloned snake equal? the answer is: " + originalSnake.equals(clonedSnake));
        } catch (CloneNotSupportedException e){
            System.out.println("Cloning not supported");
        }

    }

    // Loops through the arraylist and prints all the details of each animal, with unique functions
    public static void dayAtTheZoo(ArrayList<Animal> zoo){
        int number = 1; // just for to print the number of the animal
        for (Animal animal : zoo) {
            System.out.println("\nWelcome to animal no." + number +" The animal is: " + animal.getName());
            animal.eats();
            animal.sleeps();
            if (animal instanceof Chameleon) {
                ((Chameleon) animal).changeColor();
            } else if (animal instanceof Dolphin) {
                ((Dolphin) animal).swim();
            } else if (animal instanceof Human) {
                ((Human) animal).programs();
            } else if (animal instanceof Kangaroo) {
                ((Kangaroo) animal).hop();
            } else if (animal instanceof Koala) {
                ((Koala) animal).climb();
            } else if (animal instanceof Snake) {
                ((Snake) animal).poisonous();
            }
            System.out.println(animal);
            number += 1;
        }
    }
}
