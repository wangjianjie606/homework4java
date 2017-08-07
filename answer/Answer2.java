package answer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dono on 2017/08/07 0007.
 */
public class Answer2 {
    private static final long value = 89999901L;

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        fool();
        long endTime = System.currentTimeMillis();
        System.out.println("时间:"+(endTime-startTime)+"ms");
        System.out.println("-----------");

        startTime = System.currentTimeMillis();
        algorithm();
        endTime = System.currentTimeMillis();
        System.out.println("算法实现花费时间:"+(endTime-startTime)+"ms");

    }

    public static void fool(){
        boolean flag = false;
        for (long i = 1; i < 1+value/2; i++) {
            List<Long> list = new ArrayList<>();
            for (long j=i, total=0; total<value; j++) {
                total += j;
                list.add(j);
                if(total==value){
                    System.out.println("循环实现: "+list);
                }
            }
        }
        if(flag) System.out.println("循环实现未找到");
    }

    public static void algorithm(){
        boolean flag = false;
        for (long i = 1; i < value/2+1 ; i++) {
            List<Long> list = new ArrayList<>();
            if(value%i==0){
                if(value/i%2==1 && i-(value/i-1)/2>0)
                    for (long j = i-(value/i-1)/2,t=0; t < value/i; j++,t++)
                        list.add(j);
            }else if(value%(i+i+1)==0) {
                if (i - value / (i + i + 1) > 0)
                    for (long j = i - value / (i + i + 1) + 1, t = 0; t < value / (i + i + 1) * 2; j++, t++)
                        list.add(j);
            }else continue;
            if(list.size()>0)
                System.out.println("算法实现: "+list);
        }
        if(flag) System.out.println("算法实现未找到");
    }
}
