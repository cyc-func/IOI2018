/*
ID: beatsbysuprimoforallofmypeoplenegroesandlatinoes
LANG: JAVA
TASK: skidesign
*/

import java.io.*;
import java.util.*;


class skidesign
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));

    int N = Integer.parseInt((new StringTokenizer(f.readLine())).nextToken());

    int elevation[] = new int[1000];
    for(int i = 0; i < N; i++)
    {
    	elevation[i] = Integer.parseInt((new StringTokenizer(f.readLine())).nextToken());
    }

    int minCost = 1000000;
    for(int i = 1; i <= 100; i++)
    {
    	int currentCost = cost(i, elevation, N);
    	if(currentCost < minCost) minCost = currentCost;
    }

    out.println(minCost);

    out.close();
	}

	private static int cost(int minHeight, int elevation[], int N)
	{
		int totalCost = 0;
		int maxHeight = minHeight + 17;

		for(int i = 0; i < N; i++)
		{
			if(elevation[i] < minHeight)
			{
				totalCost += (minHeight - elevation[i]) * (minHeight - elevation[i]);
			}

			if(elevation[i] > maxHeight)
			{
				totalCost += (elevation[i] - maxHeight) * (elevation[i] - maxHeight);
			}
		}

		return totalCost;
	}
}
