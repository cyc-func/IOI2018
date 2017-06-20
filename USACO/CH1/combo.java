/*
ID: clubisntthebestplacetofindloverssothebariswhereigo
LANG: JAVA
TASK: combo
*/

import java.io.*;
import java.util.*;


class combo
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("combo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
		StringTokenizer st;

		st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());

		int key1[] = new int[3];
		int key2[] = new int[3];

		st = new StringTokenizer(f.readLine());
		key1[0] = Integer.parseInt(st.nextToken());
		key1[1] = Integer.parseInt(st.nextToken());
		key1[2] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(f.readLine());
		key2[0] = Integer.parseInt(st.nextToken());
		key2[1] = Integer.parseInt(st.nextToken());
		key2[2] = Integer.parseInt(st.nextToken());

		int count = 0;
		for(int i = 1; i <= N; i++)
		{
			for(int j = 1; j <= N; j++)
			{
				for(int k = 1; k <= N; k++)
				{
					int current[] = new int[3];
					current[0] = i;
					current[1] = j;
					current[2] = k;
					if(isTolerable(key1, current, N) || isTolerable(key2, current, N))
					{
						count++;
					}
				}
			}
		}

		out.println(count);
		
		out.close();
	}

	private static boolean isTolerable(int c1[], int c2[], int N)
	{
		for(int i = 0; i < 3; i++)
		{
			if(Math.abs(c1[i] - c2[i]) > 2 && N - Math.abs(c1[i] - c2[i]) > 2)
			{
				return false;
			}
		}
		return true;
	}
}
