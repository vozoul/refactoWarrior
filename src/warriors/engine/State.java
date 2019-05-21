package warriors.engine;

import warriors.contracts.GameState;
import warriors.contracts.GameStatus;
import warriors.contracts.Hero;
import warriors.contracts.Map;

import java.util.UUID;

public class State implements GameState {

    private String playerName;
    private String gameID;
    private GameStatus status;
    private Hero hero;
    private Map map;
    private String lastLog;
    private int currentCase;

    public State(String playerName, Hero hero, Map map){
        this.gameID = UUID.randomUUID().toString();
        this.playerName = playerName;
        this.hero = hero;
        this.map = map;
    }


    @Override
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public String getGameId() {
        return gameID;
    }

    @Override
    public GameStatus getGameStatus() {
        return status;
    }

    @Override
    public Hero getHero() {
        return hero;
    }

    @Override
    public Map getMap() {
        return map;
    }

    @Override
    public String getLastLog() {
        return lastLog;
    }

    @Override
    public int getCurrentCase() {
        return currentCase;
    }

    @Override
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    @Override
    public void setGameStatus(GameStatus status) {
        this.status = status;
    }

    @Override
    public void setHero(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public void setLastLog(String log) {
        this.lastLog = log;
    }

    @Override
    public void setCurrentCase(int currentCase) {
        this.currentCase = currentCase;
    }
}
