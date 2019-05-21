package warriors.contracts;

import java.util.List;

/**
 * This interface describes the Warriors Game API
 */
public interface WarriorsAPI {
	
	/**
	 * Called by the client to retrieve the list of available heroes.
	 * @return the list of available heroes
	 */
	List<Hero> getHeroes();

	/**
	 * @param hero
	 */
	void setHero(Hero hero);
	
	/**
	 * Called by the client to retrieve the list of available maps.
	 * @return the list of available maps
	 */
	List<Map> getMaps();
	
	/**
	 * Called by the client to create a new game.
	 * @param playerName the name of the player
	 * @param hero the chosen hero for the game
	 * @param map the chosen map for the game
	 * @return the initial game state
	 */
	GameState createGame(String playerName, Hero hero, Map map);
	
	/**
	 * Called by the client to execute a new turn in the game. The game engine has to return the new game state. 
	 * @param gameID the ID of the game
	 * @return the current game state
	 */
	GameState nextTurn(String gameID); 
}
