import java.io.*;
import java.util.*;

class NEXTPERM
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(line[0]);
		int K = Integer.parseInt(line[1]);

		int permutation[] = new int[N];

		for(int i = 0; i < K; i++)
		{
			line = br.readLine().split(" ");
			for(int j = 0; j < N; j++)
			{
				permutation[j] = Integer.parseInt(line[j]);
			}

			nextPermutation(permutation, N);

			for(int elem : permutation)
			{
				System.out.print(elem + " ");
			}
			System.out.println();
		}
		
	}

	private static void nextPermutation(int permutation[], int N)
	{
		for(int i = N - 2; i >= 0; i--)
		{
			if(permutation[i] < permutation[i+1])
			{
				int smallestLarge = N+1;
				int index = -1;

				for(int j = i+1; j < N; j++)
				{
					if(permutation[i] < permutation[j] && permutation[j] < smallestLarge)
					{
						smallestLarge = permutation[j];
						index = j;
					}
				}

				int temp = permutation[i];
				permutation[i] = permutation[index];
				permutation[index] = temp;

				Arrays.sort(permutation, i + 1, N);

				break;
			}
		}
	}
}
