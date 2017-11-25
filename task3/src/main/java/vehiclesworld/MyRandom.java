package vehiclesworld;

import java.util.Date;
import java.util.Random;

public class MyRandom {
    private static MyRandom myRandom;
    private static Random random;
    private MyRandom(){
        random = new Random(new Date().getTime());
    }
    public static MyRandom getInstance(){
        if(myRandom==null)myRandom=new MyRandom();
        return myRandom;
    }
    public int nextInt(int mod){
        return Math.abs(random.nextInt())%mod;
    }
}
