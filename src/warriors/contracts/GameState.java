package warriors.contracts;

/**
 * This interface describes the game state which should be return after each game turn
 */
public interface GameState {

	/**
	 * @return the player name
	 */
	String getPlayerName();
	
	/**
	 * @return the game unique ID
	 */
	String getGameId();
	
	/**
	 * @return the game status 
	 */
	GameStatus getGameStatus();
	
	/**
	 * @return the current hero
	 */
	Hero getHero();
	
	/**
	 * @return the current map
	 */
	Map getMap();
	
	/**
	 * @return the last log of the game. This log is displayed by the client after each game turn
	 */
	String getLastLog();
	
	/**
	 * @return the current case
	 */
	int getCurrentCase();

	//  ========  SETTERS    ========

	/**
	 * Set the name player
	 */
	void setPlayerName(String playerName);

	/**
	 *Set the gameID
	 */
	void setGameID(String gameID);

	/**
	 * Set the game status
	 */
	void setGameStatus(GameStatus status);

	/**
	 * Set the heroe
	 */
	void setHero(Hero hero);

	/**
	 *Set the map
	 */
	void setMap(Map map);

	/**
	 * Set the log
	 */
	void setLastLog(String log);

	/**
	 * Set the current position of player
	 */
	void setCurrentCase(int currentCase);
}
