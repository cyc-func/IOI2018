import java.io.*;
import java.util.*;


class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(f.readLine());
		int M1 = Integer.parseInt(st.nextToken());
		int M2 = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		char ins1[] = new char[50];
		char ins2[] = new char[50];

		for(int i = 0; i < M1; i++)
		{
			ins1[i] = (char) f.read();
		}
		f.read();	// omit newline
		for(int i = 0; i < M2; i++)
		{
			ins2[i] = (char) f.read();
		}
		f.read();

		char last = ' ';
		char msg[] = new char[5000];
		int len = 0;
		for(int i = 0; i < N; i++)
		{
			char c = (char) f.read();
			if(last != c)
			{
				msg[len++] = c;
				last = c;
			}
		}

		String msg1 = "NO";
		String msg2 = "NO";

		for(int i = 0; i < len - M1; i++)
		{
			for(int j = 0; j < M1; j++)
			{

				if(ins1[j] != msg[j + i])
				{
					break;
				}

				if(j == M1 - 1)
				{
					msg1 = "YES";
				}
			}
		}

		for(int i = 0; i < len - M2; i++)
		{
			for(int j = 0; j < M2; j++)
			{

				if(ins2[j] != msg[j + i])
				{
					break;
				}

				if(j == M2 - 1)
				{
					msg2 = "YES";
				}
			}
		}

		System.out.println(msg1);
		System.out.println(msg2);
	}
}
