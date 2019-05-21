package warriors.contracts;

/**
 * This interface contains all data needed by the client about the game map
 */
public interface Map {

	/**
	 * @return The name of the map
	 */
	String getName();

	/**
	 * set the map name
	 */
	void setName(String mapName);
	
	/**
	 * @return the number of case
	 */
	int getNumberOfCase();

	/**
	 * set number of cases on board
	 */
	void setNumberOfCase(int numberOfCase);
}
