package answer;

/**
 * Created by Dono on 2017/08/28 0028.
 */
public class Answer3 {
    private static final long value = 50L;

    public static void main(String[] arg){
        System.out.println("----------start------------");

        long startTime = System.currentTimeMillis();
        fool();
        long endTime = System.currentTimeMillis();
        System.out.println("强行实现花费时间:"+(endTime-startTime)+"ms");

        startTime = System.currentTimeMillis();
        algorithm();
        endTime = System.currentTimeMillis();
        System.out.println("算法实现花费时间:"+(endTime-startTime)+"ms");
    }

    public static void fool(){
        long a = fibonacci4fool(value);
        System.out.println("fool:"+a);
    }

    public static long fibonacci4fool(long n){
        if(n==1||n==2) return 1;
        return fibonacci4fool(n-1)+fibonacci4fool(n-2);
    }

    public static void algorithm(){
        long a = fibonacci4alg(1, 0, value);
        System.out.println("algorithm:"+a);
    }

    public static long fibonacci4alg(long a, long b, long n){
        if(n>0) return fibonacci4alg(b,a+b,n-1);
        return b;
    }
}
