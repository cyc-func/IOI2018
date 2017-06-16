import java.io.*;
import java.util.*;

class WORDLIST
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Set<String> words = new HashSet<String>();

		for(int i = 0; i < n; i++)
		{
			String line = br.readLine().toLowerCase();
			int start = 0;

			for(int j = 0; j < line.length(); j++)
			{
				char c = line.charAt(j);

				if(!Character.isLetter(c))
				{
					if(j - start > 0)
					{
						words.add(line.substring(start, j));
					}

					start = j + 1;
				}
			}

			if(line.length() - start > 0)
			{
				words.add(line.substring(start, line.length()));
			}
		}

		List<String> sortedWords = new ArrayList<String>(words);
		Collections.sort(sortedWords);

		System.out.println(sortedWords.size());

		for(int i = 0; i < sortedWords.size(); i++)
		{
			System.out.println(sortedWords.get(i));
		}

	}
}
