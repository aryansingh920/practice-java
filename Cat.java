
public class Cat extends Animal {
    

    String name;
    int age;


    public Cat(String name, int age) {
        super(4);
        this.name = name;
        this.age = age;
    }
    
    public void getName(){
        System.out.println(this.name);
    }
    // public static void doSomething() {
    //     System.out.println("Meoww");
    // }
}
