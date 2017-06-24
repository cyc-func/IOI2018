import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("dictin.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dictout.txt")));
		StringTokenizer st;

		st = new StringTokenizer(f.readLine());
		int d = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		Map<Integer, Integer> translate = new HashMap<Integer, Integer>(1000);
		for(int i = 0; i < d; i++)
		{
			st = new StringTokenizer(f.readLine());
			translate.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		for(int i = 0; i < w; i++)
		{
			st = new StringTokenizer(f.readLine());
			Integer translated = translate.get(Integer.parseInt(st.nextToken()));
			if(translated == null)
			{
				out.println("C?");
			}
			else
			{
				out.println(translated);
			}
		}

		out.close();
	}
}
