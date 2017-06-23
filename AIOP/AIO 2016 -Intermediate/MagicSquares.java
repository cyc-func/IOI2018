import java.io.*;
import java.util.*;


class Solution
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("magicin.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("magicout.txt")));

		StringTokenizer st;

		int grid[][] = new int[3][3];

		st = new StringTokenizer(f.readLine());
		grid[0][0] = Integer.parseInt(st.nextToken());
		grid[0][1] = Integer.parseInt(st.nextToken());
		grid[1][0] = Integer.parseInt(st.nextToken());

		for(int i = 1; i <= 20; i++)
		{
			for(int j = 1; j <= 20; j++)
			{
				grid[1][1] = i;
				grid[2][1] = j;
				int rowSum = grid[0][1] + grid[1][1] + grid[2][1];

				grid[2][0] = rowSum - grid[0][0] - grid[1][0];
				grid[0][2] = rowSum - grid[0][0] - grid[0][1];
				grid[1][2] = rowSum - grid[1][0] - grid[1][1];
				grid[2][2] = rowSum - grid[0][2] - grid[1][2];

				if(isValid(grid))
				{
					for(int r = 0; r < 3; r++)
					{
						for(int c = 0; c < 3; c++)
						{
							out.print(grid[r][c] + " ");
						}
						out.println();
					}
					out.close();
					return;
				}
			}
		}
		
		out.close();
	}

	private static boolean isValid(int grid[][])
	{
		for(int r = 0; r < 3; r++)
		{
			for(int c = 0; c < 3; c++)
			{
				if(grid[r][c] < 1 || grid[r][c] > 20)
				{
					return false;
				}
			}
		}
		return true;
	}
}
