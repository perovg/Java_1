public class RecordContact {
    private String name;
    private String email;
    public RecordContact(String name, String email){
        int x = email.lastIndexOf('@');
        if (email.substring(x).equals("@gmail.com")){
            this.name = name;
            this.email = email;
            System.out.println("Контакт сохранён");
        }
        else{
            System.out.println("Неверный e-mail");
        }
    }
    public RecordContact(String name){
        this.name = name;
        this.email = "@gmail.com";
    }
    public void sayHello(){
        System.out.printf("Привет! Меня зовут %s. Теперь мы можем звоонить друг другу.", name);
    }
    public void info(){
        System.out.println("Имя: " + name);
        System.out.println("e-mail: " + email);
    }
}
