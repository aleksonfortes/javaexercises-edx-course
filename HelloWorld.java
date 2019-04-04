import javax.swing.*;
import java.util.ArrayList;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(8);
        list.add(2);
        list.add(9);
        list.add(7);
        list.add(4);
        test(list);




        //System.out.println("result = " + factorial(5));
        //System.out.println(fibonacci(7));

        /*Fibonacci
        int a = 0;
        int b = 1;

        for(int i = 0; i <= 8; i++){
            int c = a+b;
            System.out.println(c);
            a = b;
            b = c;
        }*/

    }

    public static void test(ArrayList<Integer> list) {
         for(int i = list.size() - 1; i >= 0; i--){
                if( i % 2 == 0)
                    list.add(list.get(i));
                else
                    list.add(0, list.get(i));
         }
         System.out.println(list);
    }


    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int fibonacci(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }

    }
}
