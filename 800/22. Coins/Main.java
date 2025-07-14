import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            long n =sc.nextLong();
            long k =sc.nextLong();

            if((n % k == 0) || (n % 2 == 0)){
                result.add("Yes");
            }
            else if(((n - k) % 2 == 0) || ((n - 2) % k == 0)){
                result.add("Yes");
            }
            else{
                result.add("No");
            }
            
        }

        for(String str: result){
            System.out.println(str);
        }
    }
}
