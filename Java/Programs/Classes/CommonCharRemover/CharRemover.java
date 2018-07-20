public class CharRemover
{
	public static void main (String args[])
	{
		String inp1 = args[0];
		String inp2 = args[1];
		
		for (int i = 0; i < inp2.length(); i++) {
			for (int j = 0; j < inp1.length(); j++) {
				if (inp2.charAt(i) == inp1.charAt(j)) {
					inp1 = inp1.substring (0, j) + inp1.substring (j + 1);
				}
			}
		}
		System.out.println(inp1);
	}
}
