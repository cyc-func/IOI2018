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

		while(!(isPalindrome(N) && isPrime(N)))
		{
			N++;
		}

		System.out.println(N);
	}

	private static boolean isPalindrome(int N)
	{
		int org = N;
		int rev = 0;
		while(N > 0)
		{
			rev = (rev*10) + (N%10);
			N /= 10;
		}
		return rev == org;
	}

	private static boolean isPrime(int N)
	{
		if(N % 2 == 0) return false;
		for(int i = 3; i <= Math.sqrt(N); i += 2)
		{
			if(N % i == 0) return false;
		}
		return true;
	}
}
