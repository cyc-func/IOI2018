/* THIS IS CRASHING FOR NO REASONNNNN */

import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("tripin.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tripout.txt")));
		StringTokenizer st;

		st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());

		List<Triple> triples = new ArrayList<Triple>(50000);
		for(int i = 1; i <= n; i++)
		{
			st = new StringTokenizer(f.readLine());
			int current = Integer.parseInt(st.nextToken());
			if(current % 3 == 0)
			{
				triples.add(new Triple(i, current));
			}
		}

		if(triples.size() == 0)
		{
			out.println("Nothing here!");
		}
		else
		{
			out.println(triples.size());
			for(int i = 0; i < triples.size(); i++)
			{
				out.print(triples.get(i).index + " ");
			}
		}

		out.close();
	}
}

class Triple
{
	public int index;
	public int value;

	public Triple(int index, int value)
	{
		this.index = index;
		this.value = value;
	}
}
