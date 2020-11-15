import static java.lang.System.out;
public class Hw {
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
			String stringA="an";
			String stringB="banana";
			 int many=howMany(stringA,stringB);
			 out.println("no."+many);

		}
		public static void main(String[] args) {
			HowMany hm=new HowMany();
			hm.testhowMany();
		}
	}



