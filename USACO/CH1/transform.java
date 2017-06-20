/*
ID: youcanmakethefuturebutitstartsfromleavingthepast
LANG: JAVA
TASK: transform
*/

import java.io.*;
import java.util.*;


class transform
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));

		int N = Integer.parseInt((new StringTokenizer(f.readLine())).nextToken());

		char matrix1[][] = new char[10][10];
		char matrix2[][] = new char[10][10];

		for(int i = 0; i < N; i++)
		{
			char line[] = f.readLine().toCharArray();
			for(int j = 0; j < N; j++)
			{
				matrix1[i][j] = line[j];
			}
		}

		for(int i = 0; i < N; i++)
		{
			char line[] = f.readLine().toCharArray();
			for(int j = 0; j < N; j++)
			{
				matrix2[i][j] = line[j];
			}
		}

		matrix1 = rotate90(matrix1, N);
		if(equals(matrix1, matrix2, N))
		{
			out.println(1);
			out.close();
			return;
		}

		matrix1 = rotate90(matrix1, N);
		if(equals(matrix1, matrix2, N))
		{
			out.println(2);
			out.close();
			return;
		}

		matrix1 = rotate90(matrix1, N);
		if(equals(matrix1, matrix2, N))
		{
			out.println(3);
			out.close();
			return;
		}

		matrix1 = rotate90(matrix1, N);
		matrix1 = reflect(matrix1, N);
		if(equals(matrix1, matrix2, N))
		{
			out.println(4);
			out.close();
			return;
		}

		matrix1 = rotate90(matrix1, N);
		if(equals(matrix1, matrix2, N))
		{
			out.println(5);
			out.close();
			return;
		}

		matrix1 = rotate90(matrix1, N);
		if(equals(matrix1, matrix2, N))
		{
			out.println(5);
			out.close();
			return;
		}

		matrix1 = rotate90(matrix1, N);
		if(equals(matrix1, matrix2, N))
		{
			out.println(5);
			out.close();
			return;
		}

		matrix1 = rotate90(matrix1, N);
		matrix1 = reflect(matrix1, N);
		if(equals(matrix1, matrix2, N))
		{
			out.println(6);
			out.close();
			return;
		}

		out.println(7);
		
		out.close();
	}

	private static boolean equals(char A[][], char B[][], int N)
	{
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				if(A[i][j] != B[i][j])
				{
					return false;
				}
			}
		}
		return true;
	}

	private static char[][] reflect(char matrix[][], int N)
	{
		char reflected[][] = new char[10][10];

		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				reflected[i][j] = matrix[i][N - j - 1];
			}
		}

		return reflected;
	}

	private static char[][] rotate90(char matrix[][], int N)
	{
		char rotated[][] = new char[10][10];

		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				rotated[i][j] = matrix[j][i];
			}
		}

		return reflect(rotated, N);
	}
}
