import javax.lang.model.element.Name;

abstract class Animal {
    private String name;
    private int age;
    private double weight;

    public Animal() {

    }

    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    public interface AnimalBehavior {
        void sleep();
    }

    public interface AnimalMove {
        default void move() {
            System.out.println(this.getClass().getSimpleName() + " move");
        }
    }

    public interface AnimalName {
        static void name(String name) {
            System.out.println("Name: " + name);
        }
    }


    public abstract void eat();

    public abstract String getVoice();

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
class Mammal extends Animal {
    public Mammal() {
    }

    public Mammal(String name, int age, double weight) {
        super(name, age, weight);
    }

    public Mammal(String name) {
        super(name, 0, 0);
    }

    @Override
    public void eat() {
        System.out.println("Mammal is eating.");
    }

    @Override
    public String getVoice() {
        return "Mammal voice";
    }

    public void bark() {
        System.out.println("Bark!");
    }
}
class Dog extends Mammal implements Animal.AnimalBehavior, Animal.AnimalMove, Animal.AnimalName {
    public Dog() {
    }
    @Override
    public void sleep() {
        System.out.println("Dog sleeps");
    }

    @Override
    public void move() {
        System.out.println("Dog runs");
    }

    public String getName() {
        return "Dog";
    }
    public Dog(String name, int age, double weight) {
        super(name, age, weight);
    }

    public Dog(String name) {
        super(name, 0, 0);
    }

    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }

    @Override
    public String getVoice() {
        return "Woof!";
    }

    public void fetch() {
        System.out.println("Fetch the ball!");
    }
}

class Fish extends Animal {
    public Fish() {
    }

    public Fish(String name, int age, double weight) {
        super(name, age, weight);
    }

    public Fish(String name) {
        super(name, 0, 0);
    }

    @Override
    public void eat() {
        System.out.println("Fish is eating.");
    }

    @Override
    public String getVoice() {
        return "Fish voice";
    }

    public void swim() {
        System.out.println("Swim!");
    }
}
class Blowfish extends Fish implements Animal.AnimalName, Animal.AnimalMove, Animal.AnimalBehavior {
    public Blowfish() {
    }
    @Override
    public void sleep() {
        System.out.println("Blowfish sleeps");
    }

    @Override
    public void move() {
        System.out.println("Blowfish swims");
    }

    public String getName() {
        return "Blowfish";
    }

    public Blowfish(String name, int age, double weight) {
        super(name, age, weight);
    }

    public Blowfish(String name) {
        super(name, 0, 0);
    }

    @Override
    public void eat() {
        System.out.println("Blowfish is eating.");
    }

    @Override
    public String getVoice() {
        return "No voice.";
    }

}
class Bird extends Animal {
    private String featherColor;

    public Bird() {

    }

    public Bird(String name, int age, double weight, String featherColor) {
        super(name, age, weight);
        this.featherColor = featherColor;
    }

    public String getFeatherColor() {
        return featherColor;
    }

    public void setFeatherColor(String featherColor) {
        this.featherColor = featherColor;
    }

    @Override
    public void eat() {
        System.out.println("The bird is eating.");
    }

    @Override
    public String getVoice() {
        return "Cheep!";
    }

    public void fly() {
        System.out.println("Fly!");
    }

}

class Pigeon extends Bird implements Animal.AnimalBehavior, Animal.AnimalMove, Animal.AnimalName {
    private String species;

    public Pigeon() {

    }
    @Override
    public void sleep() {
        System.out.println("Pigeon sleeps");
    }

    @Override
    public void move() {
        System.out.println("Pigeon flies");
    }

    public String getName() {
        return "Pigeon";
    }
    public Pigeon(String name, int age, double weight, String featherColor, String species) {
        super(name, age, weight, featherColor);
        this.species = species;

    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}


public class task2 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[4];
        animals[0] = new Dog("Fido", 5, 25.0);
        animals[1] = new Blowfish("Blowie", 2, 0.5);
        animals[2] = new Pigeon("Pepper", 1, 0.2, "gray", "Rock Dove");
        animals[3] = new Bird("buddy",10,0.8,"black and white");
        System.out.println(animals[0]);
        System.out.println(animals[1]);
        System.out.println(animals[2]);
        System.out.println(animals[3]);
    }
}

