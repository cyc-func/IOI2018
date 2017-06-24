import java.io.*;
import java.util.*;


class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(f.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		List<candidate> list = new ArrayList<>(10000);
		for(int i = 1; i <= C; i++)
		{
			list.add(new candidate(i));
		}

		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(f.readLine());
			list.get(Integer.parseInt(st.nextToken()) - 1).votes++;
		}

		Collections.sort(list, new Comparator<candidate>()
		{
			@Override
			public int compare(candidate a, candidate b)
			{
				return b.votes - a.votes;
			}
		});

		System.out.println(list.get(2).id);
	}
}

class candidate
{
	public int id;
	public int votes = 0;

	public candidate(int id)
	{
		this.id = id;
	}
}
