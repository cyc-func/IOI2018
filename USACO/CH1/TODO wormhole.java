/*
  ID: IHATEMYSELF
LANG: JAVA
TASK: wormhole
*/

import java.io.*;
import java.util.*;


class Main
{
	static int N;
	static int cycles = 0;
	static Point wormholes[];

	public static void main(String args[]) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		StringTokenizer st;

		st = new StringTokenizer(f.readLine());
		N = Integer.parseInt(st.nextToken());

		wormholes = new Point[N];
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(f.readLine());
			wormholes[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(wormholes, new Comparator<Point>()
		{
			@Override
			public int compare(Point a, Point b)
			{
				if(a.y != b.y)
				{
					return a.y - b.y;
				}
				else
				{
					return a.x - b.x;
				}
			}
		});

		out.println(cycleExists(wormholes));

		/*for(int i = 0; i < N; i++)
		{
			out.print("(" + wormholes[i].x + ", " + wormholes[i].y + ") ");
		}
		out.println();

		List<Point> perm = new ArrayList<Point>(12);
		perm.add(wormholes.get(0));
		for(int i = 1; i < N; i++)
		{
			perm.add(new Point(0, 0));
		}

		permute(perm, 1);
		out.println(cycles);*/
		
		out.close();
	}

	private static int indexOf(Point p, Point list[])
	{
		for(int i = 0; i < N; i++)
		{
			if(p.equals(list[i]))
			{
				return i;
			}
		}
		return -1;
	}

	private static Point nextPoint(Point p)
	{
		int index = indexOf(p, wormholes);

		if(index == N - 1) return null;
		if(wormholes[index + 1].y == p.y)
			return wormholes[index + 1];
		else
			return null;
	}

	private static boolean cycleExists(Point list[])
	{
		for(int i = 0; i < N; i += 2)
		{
			Point match = list[i];
			Point next = nextPoint(list[i + 1]);
			while(next != null)
			{
				if(next.equals(match))
				{
					return true;
				}
				int listIndx = indexOf(next, list);
				listIndx += (listIndx % 2 == 0 ? 1 : -1);
				next = nextPoint(list[listIndx]);
			}
		}
		return false;
	}

	/*private boolean cycleExists()
	{
		for(int i = 0; i < N; i += 2)
		{
			int cur = wormholes.indexOf(A.get(i));
			int neighbourIndx = wormholes.indexOf(A.get(i + 1)) + 1;
			int truindx;
			if(neighbourIndx < N)
			{
				truindx = A.indexOf(wormholes.get(wormholes.indexOf(A.get(i + 1)) + 1));
			}
			else
			{
				continue;
			}
			while(neighbourIndx < N && )
			{

			}
			cycles++;
		}
	}*/

	/*private static void permute(List<Point> perm, int k)
	{
		if(k == N)
		{
			for(int i = 0; i < N; i++)
			{
				int count = 0;
			}
		}
		else
		{
			for(int i = k; i < N; i++)
			{
				Collections.swap(wormholes, i, k);
				perm.set(k, wormholes.get(k));
				permute(wormholes, perm, k + 1);
				Collections.swap(wormholes, i, k);
			}
		}
	}*/
}

class Point
{
	final public int x;
	final public int y;

	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}
