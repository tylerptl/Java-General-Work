/**
* A class for storing a word together with its frequency.
*
* @author	Terry Sergeant
* @version for Data Structures Homework
*
*/

public class BibleWord implements Comparable<BibleWord>
{
	private int count;
	private String word;

	public BibleWord(String word) { this.word= word; count= 1; }
	public BibleWord(String word, int c) { this.word= word; count= c; }
	public void increment() { count++; }
	//public String toString() { return String.format("%8d %s",count,word); }
	public String toString() { return String.format(" %s",word); }

	public int getCount() { return count; }

	@Override
	public int compareTo(BibleWord other)
	{
		return this.word.compareTo(other.word);
	}
}

