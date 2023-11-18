import java.io.BufferedReader;
import java.io.InputStreamReader;


class SWEA1206
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0 ; i<10; i++){
			int result = 0;
			int buildingNumber = Integer.parseInt(br.readLine());
			String[] bString = br.readLine().split(" ");
			for(int j=2; j< bString.length-2; j++){
				int currentBuilding = Integer.parseInt(bString[j]);
				int nextBuilding = Integer.parseInt(bString[j+1]);
				int next2Building = Integer.parseInt(bString[j+2]);
				int prevBuilding = Integer.parseInt(bString[j-1]);
				int prev2Building = Integer.parseInt(bString[j-2]);
				if(currentBuilding >  max(nextBuilding,next2Building,prevBuilding,prev2Building)  ){
					result += currentBuilding - max(nextBuilding,next2Building,prevBuilding,prev2Building);
					j=j+2;
				}
			}
			System.out.println("#"+(i+1)+" "+result);
		}

	}

	public static int max(int a, int b, int c, int d) {
		return Math.max(d,Math.max(c, Math.max(a, b)));
	}
}