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
		int M = Integer.parseInt(st.nextToken());

		boolean isPlus[] = new boolean[10000];
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(f.readLine());
			if(st.nextToken().charAt(0) == '+')
			{
				isPlus[i] = true;
			}
		}

		int position = 1;
		int score = 1;
		for(int i = 0; i < M; i++)
		{
			st = new StringTokenizer(f.readLine());
			int d = Integer.parseInt(st.nextToken());

			if(isPlus[position - 1])
			{
				if(position + d <= N)
				{
					position += d;
				}
			}
			else
			{
				if(position - d >= 1)
				{
					position -= d;
					if(position == 1)
					{
						score++;
					}
				}
			}
		}

		System.out.println(score);
	}
}
