public class Pet {
    private final String name;
    private int weight;
    private int age;
    private String owner;
    public Pet(){
        name = "Pet";
    }

    public Pet(String name, int weight, int age, String owner){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.owner = owner;
    }
    public void say(){
        System.out.println("I'm the best pet!");
    }
}
