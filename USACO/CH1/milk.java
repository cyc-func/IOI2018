/*
ID: theycallyoujabbathehutforareason
LANG: JAVA
TASK: milk
*/

import java.io.*;
import java.util.*;


class milk
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("milk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));

		StringTokenizer st = new StringTokenizer(f.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Farmer> list = new ArrayList<Farmer>(5000);
		for(int i = 0; i < M; i++)
		{
			st = new StringTokenizer(f.readLine());
			list.add(new Farmer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(list, new Comparator<Farmer>()
		{
			@Override
			public int compare(Farmer A, Farmer B)
			{
				return A.cost - B.cost;
			}
		});

		int farmerIndx = 0;
		int minCost = 0;

		while(N > 0)
		{
			if(list.get(farmerIndx).amount < N)
			{
				minCost += list.get(farmerIndx).amount * list.get(farmerIndx).cost;
				N -= list.get(farmerIndx).amount;
				farmerIndx++;
			}
			else
			{
				minCost += N * list.get(farmerIndx).cost;
				N = 0;
			}
		}

		out.println(minCost);
		
		out.close();
	}

	
}

class Farmer
{
	public int cost, amount;

	public Farmer(int cost, int amount)
	{
		this.cost = cost;
		this.amount = amount;
	}
}
