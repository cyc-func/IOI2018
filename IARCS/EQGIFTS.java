import java.io.*;
import java.util.*;

class Main
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());

		int bookDif[] = new int[150];
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(f.readLine());
			bookDif[i] = Math.abs(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));
		}

		boolean possibleSums1[] = new boolean[44851];
		boolean possibleSums2[] = new boolean[44851];
		possibleSums1[bookDif[0]] = true;

		for(int i = 1; i < N; i++)
		{
			for(int j = 0; j < 44851; j++)
			{
				if(possibleSums1[j])
				{
					possibleSums1[j] = false;

					possibleSums2[j + bookDif[i]] = true;
					possibleSums2[Math.abs(j - bookDif[i])] = true;
				}
			}

			boolean temp[] = possibleSums1;
			possibleSums1 = possibleSums2;
			possibleSums2 = temp;
		}

		for(int i = 0; i < 44851; i++)
		{
			if(possibleSums1[i])
			{
				System.out.println(i);
				break;
			}
		}
	}
}
