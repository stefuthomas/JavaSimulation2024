import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("What is your name? ");
        String name = reader.nextLine();

        System.out.print("How old are you? ");
        int age = Integer.parseInt(reader.nextLine());

        System.out.println("Hello " + name + ", you are " + age + " years old!");
    }
}
