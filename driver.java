package main;


import java.util.*;

import services.Counter;
import services.Display;
import services.MergeSort;
import services.binSearch;

public class driver 
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		Counter c=new Counter();
		binSearch b=new binSearch();
		MergeSort ms=new MergeSort();
		Display d=new Display();
		
		System.out.println("Enter the number of companies");
		int n=sc.nextInt();
		
		double sharePrice[]=new double[n];
		boolean priceIncrease[]=new boolean[n];
		
		//Share price and share increase entry
		for(int x=0;x<n;x++)
		{
			System.out.println("Enter current stock price of the company : "+(x+1));
			sharePrice[x]=sc.nextDouble();
			sc.nextLine();
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			String s=sc.nextLine();
			
			if(s.equalsIgnoreCase("true"))
				priceIncrease[x]=true;
			else if(s.equalsIgnoreCase("false"))
				priceIncrease[x]=false;
			else
			{
				System.out.println("Invalid Entry \nRe-enter");
				x--;
				continue;
			}
		}
		
		//sorting both arrays in Ascending order based on value of the array "sharePrice"
		ms.Sort(sharePrice, priceIncrease, 0, n-1);
		
		boolean repeat=true;
		do {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Enter the operation that you want to perform");
			System.out.println("1. Display the companies stock prices in ascending order");
			System.out.println("2. Display the companies stock prices in descending order");
			System.out.println("3. Display the total no of companies for which stock prices rose today");
			System.out.println("4. Display the total no of companies for which stock prices declined today");
			System.out.println("5. Search a specific stock price");
			System.out.println("6. press 0 to exit");
			System.out.println("--------------------------------------------------------------------------");
			int choice=sc.nextInt();
			
			switch(choice)
			{
				case 1:	//display in Ascending order
					System.out.println("Stock prices in ascending order are :");
					d.displayAsc(sharePrice);
					break;
				
				case 2: //display in Descending order
					System.out.println("Stock prices in descending order are :");
					d.displayDes(sharePrice);
					break;
				
				case 3: //display stock increase count
					System.out.println("Total no of companies whose stock price rose today : "+c.count(priceIncrease, true));
					break;
				
				case 4: //display stock decrease count
					System.out.println("Total no of companies whose stock price declined today : "+c.count(priceIncrease, false));
					break;
				
				case 5: //search stock price in array
					System.out.println("\nEnter the key value");
					double key=sc.nextDouble();
					if(b.Search(sharePrice, key))
						System.out.println("Stock of value "+key+" is present");
					else
						System.out.println("Value not found");
					break;
				
				case 0: 
					repeat=false;
					System.out.println("Exited successfully");
					break;
				
				default:
					System.out.println("Invalid Input");
			}
			System.out.println();
			Thread.sleep(800);
			
		}while(repeat);
	}
}