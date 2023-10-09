class Cat extends Pet{
    private final String name;
    private int weight;
    private int age;
    private String owner;
    private final String breed;
    public enum FeedType{Expensive, Cheap}
    private FeedType feed;

    public Cat(String name, String breed, int weight, int age, String owner, FeedType feed){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.owner = owner;
        this.breed = breed;
        this.feed = feed;
    }
    public void walk(){
        System.out.printf("%s is walkihg with owner", name);
        System.out.println();
    }
    public void walk(String name){
        System.out.printf("%s is walking with %s", this.name, name);
        System.out.println();
    }
    @Override
    public void say(){
        System.out.println("Meow");
    }
}
