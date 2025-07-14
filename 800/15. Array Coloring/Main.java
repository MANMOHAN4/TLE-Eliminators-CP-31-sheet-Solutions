import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        List<String> result = new ArrayList<>();

        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            List<Integer> array = new ArrayList<>();

            int sum = 0;

            for(int j = 0; j < n; j++){
                array.add(sc.nextInt());
                sum += array.get(j);
            }

            if(sum % 2 == 0){
                result.add("Yes");
            }else{
                result.add("No");
            }

        }

        for(String str: result){
            System.out.println(str);
        }
        
        sc.close();
    }
}
