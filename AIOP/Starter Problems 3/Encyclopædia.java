import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("encyin.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("encyout.txt")));
		StringTokenizer st;

		st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int pages[] = new int[10000];
		for(int i = 0; i < n; i++)
		{
			st = new StringTokenizer(f.readLine());
			pages[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < q; i++)
		{
			st = new StringTokenizer(f.readLine());
			out.println(pages[Integer.parseInt(st.nextToken()) - 1]);
		}

		out.close();
	}
}
