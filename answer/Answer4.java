package answer;

/**
 * Created by Dono on 2017/08/28 0028.
 */
public class Answer4 {
    private static final int value = 100;

    public static void main(String[] arg){
        System.out.println("----------start------------");

        double[] a = getValue();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            fool(a);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("强行实现花费时间:"+(endTime-startTime)+"ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            algorithm(a);
        }
        endTime = System.currentTimeMillis();
        System.out.println("算法实现花费时间:"+(endTime-startTime)+"ms");
    }

    public static void fool(double[] d){
        for (int i = 0; i < d.length; i++) {
            if(d[i]==(double)i){
                //System.out.println("fool:"+i);
                return;
            }
        }
    }

    

    public static void algorithm(double[] d){
        int a = alg(0,d.length,d);
        //System.out.println("algorithm:"+(a==-1?null:a));
    }

    public static int alg(int start, int end, double[] d){
        int i = (end-start)/2+start;
        if(i==0) return -1;
        double a = d[i]-i;

        if(a==0){
            return i;
        }else if(a>0){
            return alg(start, i ,d);
        }else
            return alg(i, end, d);

//        if(d[i]==(double)i){
//            return
//        }
    }

    public static double[] getValue(){
        double[] s = new double[value];
        for(int i=0;i<value;i++){
            s[i] = i<value/5*2?Math.random()+i-1:Math.random()+i;
        }

        s[value/5*2]=value/5*2;
        return s;
    }
    
}
