package services;


public class Display {
	
	public void displayAsc(double ar[])
	{
		for(int x=0;x<ar.length;x++)
		{
			System.out.print(ar[x]+" ");
		}
		System.out.println();
	}
	
	public void displayDes(double ar[])
	{
		for(int x=ar.length-1;x>=0;x--)
		{
			System.out.print(ar[x]+" ");
		}
		System.out.println();
	}
}