package answer;

public class Answer1 {
	private static final long value = 111233748172L;
	
	public static void main(String[] args) {

		System.out.println("----------start------------");

		long startTime = System.currentTimeMillis();
		//fool(value);
		long endTime = System.currentTimeMillis();
		System.out.println("ǿ�� ����ʱ��:"+(endTime-startTime)/1000/60+"min");

		startTime = System.currentTimeMillis();
		algorithm(value);
		endTime = System.currentTimeMillis();
		System.out.println("�㷨 ����ʱ��:"+(endTime-startTime)+"ms");
	}
	
	public static void fool(long k){
		long count = 0;
		for (long i = k; i > 0; i--) {
			for(long t = i;t>0;t=t/10){
				long a = t%10;
				if(a==1) count ++;
			}
		}
		System.out.println("ǿ�У�f("+k+")="+count);
	}
	
	public static void algorithm(long k){
		long count = recursiveAlg(k);
		System.out.println("�㷨��f("+k+")="+count);
	}
	
	public static long recursiveAlg(long k){
		if(k<10 && k>=1)
			return 1;
		else if(k<1)
			return 0;
		else{
			long basic = 1;
			for(int i=0;i<(k+"").length()-1;i++) basic=basic*10;

			long firstNo = k/basic;
			long topNum = firstNo==1?(k%basic+1):basic;
			return topNum + recursiveAlg(basic-1)*firstNo+ recursiveAlg(k-firstNo*basic);
		}
	}
}



