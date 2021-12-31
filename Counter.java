package services;




public class Counter 
{
	public int count(boolean ar[],boolean key)
	{
		int c=0;
		for(int x=0;x<ar.length;x++)
		{
			if(ar[x]==key)
				c++;
		}
		return c;
	}
}
