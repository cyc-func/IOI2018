import java.io.*;
import java.util.*;

class VOTERS
{
	private static int[] read(int len, BufferedReader br) throws IOException
	{
		int A[] = new int[len];

		for(int i = 0; i < len; i++)
		{
			A[i] = Integer.parseInt(br.readLine());
		}

		return A;
	}

	private static int overlaps(int A[], int index, int V1[], int V2[])
	{
		int l1 = 0, l2 = 0;

		while(l1 < V1.length && l2 < V2.length)
		{
			if(V1[l1] > V2[l2])
			{
				l2++;
			}
			else if(V1[l1] < V2[l2])
			{
				l1++;
			}
			else
			{
				A[index++] = V1[l1];
				l1++;
				l2++;
			}
		}

		return index;
	}

	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line[] = br.readLine().split(" ");
		int N1 = Integer.parseInt(line[0]);
		int N2 = Integer.parseInt(line[1]);
		int N3 = Integer.parseInt(line[2]);

		int N1Voters[] = read(N1, br);
		int N2Voters[] = read(N2, br);
		int N3Voters[] = read(N3, br);

		int finalVoters[] = new int[150000];
		int finalVotersIndex = 0;

		finalVotersIndex = overlaps(finalVoters, finalVotersIndex, N1Voters, N2Voters);
		finalVotersIndex = overlaps(finalVoters, finalVotersIndex, N2Voters, N3Voters);
		finalVotersIndex = overlaps(finalVoters, finalVotersIndex, N3Voters, N1Voters);

		Arrays.sort(finalVoters, 0, finalVotersIndex);

		int finalVotersRepFree[] = new int[50000];
		int fIndex = 0;

		int last = -1;
		for(int i = 0; i < finalVotersIndex; i++)
		{
			if(finalVoters[i] != last)
			{
				last = finalVoters[i];
				finalVotersRepFree[fIndex++] = finalVoters[i];
			}
		}

		System.out.println(fIndex);

		for(int i = 0; i < fIndex; i++)
		{
			System.out.println(finalVotersRepFree[i]);
		}
	}
}
