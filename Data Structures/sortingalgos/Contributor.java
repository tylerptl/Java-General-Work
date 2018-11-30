/**
 * A contributor has a name and an integer contribution amount.
 *
 * @author  T.Sergeant
 * @version for Data Structures
*/

public class Contributor implements Comparable<Contributor>
{
	private String firstname,lastname; // name of contributor

	public int getAmount() {
		return amount;
	}

	private int amount;                // amount of contribution

	/**
	 * Constructor takes values of attributes.
	*/
	public Contributor(String firstname, String lastname, int amount) {
		this.firstname= firstname;
		this.lastname= lastname;
		this.amount= amount;
	}


	/**
	 * We provide a formatted string appropriate for pretty columns.
	 *
	 * @param other the contributor we compare this to
	*/
	public String toString() {
		return String.format("%-20s %10s",lastname+", "+firstname,"$"+amount);
	}


	/**
	 * We compare contributors by their contribution amount.
	 *
	 * @param other the contributor we compare this to
	*/
	@Override
	public int compareTo(Contributor other) {
		return this.amount - other.amount;
	}
}
