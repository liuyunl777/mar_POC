import java.util.HashMap;
import java.util.Map;

public class tes {
	
	int[] arr;
	
	public tes(int[] a) {
		this.arr=a;
	}
	
	public int name(int[] arr) {
		int ans=0;
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++) {
			//if(map.put(arr[i], 1)!=null) ans=arr[i];
			if(map.containsKey(arr[i])) {
				return ans=arr[i];
			}else map.put(arr[i], 1);
		}
		
		return ans;
	}
	
	
	public static void main(String[] args) {
		int[] a= {1,4,6,7,12,23,54,65,75,85,75};
		tes t=new tes(a);
		Integer aa=1;
		String aaaString="sds";
		aa.equals(1);
		String bString=aaaString;
		aaaString.equals(bString);
		int ans=t.name(t.arr);
		System.out.println(aaaString==bString);
	}
}
