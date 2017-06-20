/*
ID: howselfishisityoujustwantmejustcuzimakeyoufeelbetter
LANG: JAVA
TASK: barn1
*/

import java.io.*;
import java.util.*;


class barn1
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));

		StringTokenizer st = new StringTokenizer(f.readLine());

		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int stalls[] = new int[200];
		for(int i = 0; i < C; i++)
		{
			stalls[i] = Integer.parseInt((new StringTokenizer(f.readLine())).nextToken());
		}
		Arrays.sort(stalls, 0, C);

		int bridges[] = new int[199];
		int nBridges = C - 1;
		for(int i = 0; i < nBridges; i++)
		{
			bridges[i] = stalls[i + 1] - stalls[i];
		}
		Arrays.sort(bridges, 0, nBridges);

		if(C <= M)
		{
			out.println(C);
		}
		else
		{
			int boardsCount = M;
			for(int i = 0; i < C - M; i++)
			{
				boardsCount += bridges[i];
			}
			out.println(boardsCount);
		}
		
		out.close();
	}
}
