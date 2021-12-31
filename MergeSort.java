package services;



public class MergeSort 
{
	public void Sort(double sharePrice[], boolean priceIncrease[], int left , int right)
	{
		if(left<right)
		{
			int mid=(left+right)/2;
			Sort(sharePrice, priceIncrease, left, mid);
			Sort(sharePrice, priceIncrease, mid+1,right);
			merge(sharePrice, priceIncrease, left, mid, right);
		}
	}
	void merge(double sharePrice[], boolean priceIncrease[], int left , int mid, int right)
	{
		int l1=mid-left+1;
		int l2=right-mid;
		
		double leftShare[]=new double[l1];
		boolean leftPrice[]=new boolean[l1];
		double rightShare[]=new double[l2];
		boolean rightPrice[]=new boolean[l2];
		
		for(int x=0;x<l1;x++)
		{
			leftShare[x]= sharePrice[x+left];
			leftPrice[x]= priceIncrease[x+left];
		}
		for(int x=0;x<l2;x++)
		{
			rightShare[x]= sharePrice[x+mid+1];
			rightPrice[x]= priceIncrease[x+mid+1];
		}
		
		int i=0,j=0,k=left;
		
		while(i<l1 && j<l2)
		{
			if(leftShare[i]<=rightShare[j])
			{
				sharePrice[k]=leftShare[i];
				priceIncrease[k]=leftPrice[i];
				i++;
				k++;
			}
			else
			{
				sharePrice[k]=rightShare[j];
				priceIncrease[k]=rightPrice[j];
				j++;
				k++;
			}
		}
		while(i<l1)
		{
			sharePrice[k]=leftShare[i];
			priceIncrease[k]=leftPrice[i];
			i++;
			k++;
		}
		while(j<l2)
		{
			sharePrice[k]=rightShare[j];
			priceIncrease[k]=rightPrice[j];
			j++;
			k++;
		}
	}
}