import java.io.*;
import java.util.*;

class TILES01
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int p2 = 1, p1 = 2;

		for(int i = 3; i <= N; i++)
		{
			int p3 = p2 + p1;
			p2 = p1 % 15746;
			p1 = p3 % 15746;
		}
		
		if(N == 1)
		{
			System.out.println(1);
		}
		else
		{
			System.out.println(p1);
		}
	}
}
