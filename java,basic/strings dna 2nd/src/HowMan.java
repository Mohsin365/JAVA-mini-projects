	public class HowMan {
		public int howMany(String stringA,String stringB) {
			int times=0;
			int index=0;
			int currIndex=0;
			while(true) {
			index=stringB.indexOf(stringA,currIndex);
			if(index==-1) {
				break;
			}
				times+=1;
				
				currIndex=stringB.indexOf(stringA,index+stringA.length());
				
			}
			return times;
		}
		public void testhowMany() {
			String stringA="a";
			String stringB="banana";
			
			System.out.println("no."+howMany(stringA,stringB));

		}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HowMan hm=new HowMan();
		hm.testhowMany();
	}

}
