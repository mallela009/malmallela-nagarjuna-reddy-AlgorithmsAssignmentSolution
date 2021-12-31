package services;

public class binSearch {
	public boolean Search(double ar[], double key)
	{
		int min=0, max=ar.length;
		
		while(min<=max)
		{
			int mid=(min+max)/2;
			if(key==ar[mid])
				return true;
			else if (key<ar[mid])
				max=mid-1;
			else
				min=mid+1;
		}
		return false;
	}
}
