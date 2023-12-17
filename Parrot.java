import java.lang.Math;
public class Parrot extends Pet{
    private final String name;
    private int weight;
    private int age;
    private String owner;
    private final String country;
    private boolean docs;
    public Parrot(String name, String country, int age, int weight, String owner, boolean docs){
        this.name = name;
        this.country = country;
        this.owner = owner;
        this.age = age;
        this.weight = weight;
        this.docs = docs;
    }
    @Override
    public void say(){
        System.out.println("Piastrrrres");
    }
    public void fly(){
        int x = (int) (Math.random() * 61);
        System.out.printf("%s улетел, но обещал вернуться через %s минут", this.name, x);
        System.out.println();
    }
}