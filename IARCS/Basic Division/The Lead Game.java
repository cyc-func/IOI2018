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

		int player1Score = 0, player2Score = 0;
		int player1Lead = 0, player2Lead = 0;
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(f.readLine());
			player1Score += Integer.parseInt(st.nextToken());
			player2Score += Integer.parseInt(st.nextToken());
			if(player1Score - player2Score > player1Lead)
			{
				player1Lead = player1Score - player2Score;
			}
			if(player2Score - player1Score > player2Lead)
			{
				player2Lead = player2Score - player1Score;
			}
		}

		if(player1Lead > player2Lead)
		{
			System.out.println("1 " + player1Lead);
		}
		else
		{
			System.out.println("2 " + player2Lead);
		}
	}
}
