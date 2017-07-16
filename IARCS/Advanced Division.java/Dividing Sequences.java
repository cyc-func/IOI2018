import java.io.*;
import java.util.*;


class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());

		Num list[] = new Num[10000];

		int globalMaxima = 0;
		for(int i = 0; i < n; i++)
		{
			st = new StringTokenizer(f.readLine());
			list[i] = new Num(Integer.parseInt(st.nextToken()));

			for(int j = i-1; j >= 0; j--)
			{
				if(list[i].v % list[j].v == 0 && list[j].subseq + 1 > list[i].subseq)
				{
					list[i].subseq = list[j].subseq + 1;
				}
			}

			if(list[i].subseq > globalMaxima) globalMaxima = list[i].subseq;
		}

		System.out.println(globalMaxima);
	}

	static class Num
	{
		int v;
		int subseq = 1;

		Num(int v)
		{
			this.v = v;
		}
	}
}
