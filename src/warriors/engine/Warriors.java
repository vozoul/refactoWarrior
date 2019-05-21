package warriors.engine;

import warriors.contracts.GameState;
import warriors.contracts.Hero;
import warriors.contracts.Map;
import warriors.contracts.WarriorsAPI;

import java.util.ArrayList;
import java.util.List;

public class Warriors implements WarriorsAPI {

    private GameState gameInCourse;

    private ArrayList<Hero> heroesList = new ArrayList<>();
    private ArrayList<Map> mapsList = new ArrayList<>();

    public Warriors (){

    }

    @Override
    public List<Hero> getHeroes() {
        return heroesList;
    }

    @Override
    public void setHero(Hero hero) {
        this.heroesList.add(hero);
    }

    @Override
    public List<Map> getMaps() {
        return mapsList;
    }

    @Override
    public GameState createGame(String playerName, Hero hero, Map map) {
        gameInCourse = new State(playerName, hero, map);

        return gameInCourse;
    }

    @Override
    public GameState nextTurn(String gameID) {
        return null;
    }
}
