import java.io.*;
import java.util.*;

class Main
{
	static int N;

	public static void main(String args[]) throws IOException
	{
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(f.readLine());
		N = Integer.parseInt(st.nextToken());

		List<List<Integer>> rows = new ArrayList<List<Integer>>(1000);
		for(int i = 0; i < N; i++)
		{
			rows.add(new ArrayList<Integer>(50));

			st = new StringTokenizer(f.readLine());
			int current = Integer.parseInt(st.nextToken());
			while(current != -1)
			{
				rows.get(i).add(current);
				current = Integer.parseInt(st.nextToken());
			}
		}

		Collections.sort(rows, new Comparator<List<Integer>>()
		{
			public int compare(List<Integer> a, List<Integer> b)
			{
				int aIndx = 0;
				int bIndx = 0;

				while(aIndx < a.size() && bIndx < b.size())
				{
					if(a.get(aIndx) != b.get(bIndx))
					{
						return a.get(aIndx) - b.get(bIndx);
					}

					aIndx++;
					bIndx++;
				}

				return a.size() - b.size();
			}
		});

		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < rows.get(i).size(); j++)
			{
				System.out.print(rows.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}
