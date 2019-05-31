package warriors.contracts;

/**
 * This interface contains all data needed by the client about the hero
 */
public interface Hero {

	/**
	 * @return the name of the hero
	 */
	String getName();

	/**
	 * set the name of the hero
	 */
	void setName(String name);

	/**
	 * @return the image of the hero
	 */
	String getImage();

	/**
	 * set the image of the hero
	 */
	void setImage(String image);

	/**
	 * @return the life level of the hero
	 */
	int getLife();

	/**
	 * set the life of the hero
	 */
	void setLife(int life);

	/**
	 * @return the life level of the hero
	 */
	int getMaxLife();

	/**
	 * set the life of the hero
	 */
	void setMaxLife(int life);

	/**
	 * @return the attack level of the hero
	 */
	int getAttackLevel();

	/**
	 * set the attack level of the hero
	 */
	void setAttackLevel(int attackLevel);

	/**
	 * @return the attack level of the hero
	 */
	int getMaxAttackLevel();

	/**
	 * set the attack level of the hero
	 */
	void setMaxAttackLevel(int attackLevel);

	Object clone();
}