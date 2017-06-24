/*
 * WARNING: NOT TESTED
 * Check using: http://www.iarcs.org.in/inoi/contests/nov2004/Basic-1-checksoln.c
 */


import java.io.*;
import java.util.*;


class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());

		List<cylinder> list = new ArrayList<>(5000);
		for(int i = 1; i <= N; i++)
		{
			st = new StringTokenizer(f.readLine());
			list.add(new cylinder(Integer.parseInt(st.nextToken()), i));
		}

		Collections.sort(list, new Comparator<cylinder>()
		{
			@Override
			public int compare(cylinder a, cylinder b)
			{
				return a.height - b.height;
			}
		});

		for(int i = 0; i < N; i++)
		{
			System.out.println(list.get(i).id);
		}
	}
}

class cylinder
{
	public int height;
	public int id;

	public cylinder(int height, int id)
	{
		this.height = height;
		this.id = id;
	}
}
