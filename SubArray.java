import java.util.*;

public class SubArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine(); 
		//input = [1,2,3,10,4,2,3,5]
		//= [5,4,3,2,1] [1,2,3,4,5]
		String strArr[] = str.replace("[", "").replace("]", "").split(",");		
		int arr[] = new int[strArr.length];
		for(int i=0;i<arr.length;i++) {
			arr[i]= Integer.parseInt(strArr[i]);
		}
		LinkedList<Integer> ls = new LinkedList<Integer>();
		
		int first = arr[0];
		int last = arr[arr.length-1];
		int temp1= Integer.MIN_VALUE;
		boolean flag = false;
		if(first!=last) {
			if(first<last) {
				for(int i=arr.length-1;i>0;i--) {
					if(!flag) {
						if(!(arr[i]>arr[i-1])) {
							temp1 = arr[i];
							flag = true;
						}
					} else {
						if(!(arr[i]<=temp1)) {
							ls.add(arr[i]);
						} else {
							flag = false;
						}
					}
				}
			} else {
				int offIndex = 0;
				boolean isDec = true;
				for(int i=0;i<arr.length-1;i++) {
					if(!(arr[i]>arr[i+1])) {
						isDec = false;
						offIndex = i;
						break;
					}
				}
				if(isDec) {
					for(int i=0;i<arr.length-1;i++) {
						ls.add(arr[i]);
					}
				} else {
					for(int i=offIndex;i<arr.length;i++) {
						ls.add(arr[i]);
					}
				}
			}
		}

		Collections.reverse(ls);
		System.out.println(ls.size());
		
	}

}
