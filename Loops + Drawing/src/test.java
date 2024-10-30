
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i=1; i<=1000;i++){
		    if(i%2!=0){
		        sum+=i;
		    }
		}
		System.out.println(sum);



		int i =1;
		int sum2 = 0;
		while(i<=1000){
			if(i%2!=0){
				//System.out.println("in");
		        sum2+=i;
		    }
			//System.out.println(i);
			i++;
		}
		System.out.println(sum2);

		

	}

}
