import org.hibernate.criterion.Example;

import java.util.*;
public class Interview {

	
	
	
	
	public static int fib(int n) {
		//System.out.println(n);
		if(n<=1) {
			return n;
		}else {
			return fib(n-1)+fib(n-2);
		}
		
		
	}
	private static boolean isValid(int i,int j,int[][] array,boolean[] valid) {
		if(valid[array[i][j]-1]) {
			
			return false;
		}else {
			valid[array[i][j]-1]=true;
			return true;
			
		}
		
		
	}
	
	
	public static boolean ku(int[][] array) {
		
		boolean[] validArr=new boolean[9];
			//validate col
			for(int i=0;i<9;i++) {
				Arrays.fill(validArr, false);
			for(int j=0;j<9;j++) {
				if(isValid(i,j,array,validArr)==false) {
					return false;
				}
				
			}
			}
			
			//valid row
			
			for(int j=0;j<9;j++) {
				Arrays.fill(validArr, false);
				for(int i=0;i<9;i++) {
					if(isValid(i, j, array, validArr)==false) {
						return false;
					}
					
				}
			}
			
			//validate 3*3
			
			for(int i=0;i<7;i+=3) {
				for(int j=0;j<7;j+=3) {
					Arrays.fill(validArr, false);
					for(int x=i;x<i+3;x++) {
						for(int y=j;y<j+3;y++) {
							
							if(!isValid(x, y, array, validArr)) {
								return false;
								
							}
							
							
							
						}
						
					}

				}
				
				
			}
			
			
			return true;
	
	}
	
	
	public static void main(String[] args) {
		int[][] border=new int[][] {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,3,4,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,3,2},
			{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
			//1-9
			//0-8
		System.out.println(ku(border));
		
	}
}
