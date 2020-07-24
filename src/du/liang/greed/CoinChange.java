package du.liang.greed;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] a){
        int[] b ={25,20,5,1};
        coinchanege(b,41);


    }
    static void coinchanege(int[] face,int money){
        Arrays.sort(face);
        int  coins = 0;
        for (int i = face.length - 1; i >= 0; i--) {
            while (money >= face[i]){
                money = money - face[i];
                coins++;
                System.out.println(face[i]);
            }
        }
        System.out.println("coins = "+coins);
    }
}
