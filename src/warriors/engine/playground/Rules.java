package warriors.engine.playground;

import java.util.ArrayList;

public class Rules {

    private int maxInGame;
    private Boxe myCase;
    private ArrayList<String> spells = new ArrayList<>();
    private ArrayList<String> weapons = new ArrayList<>();

    public Rules (){
        spells.add("Fireball");
        spells.add("Lightning");
        weapons.add("Arc");
        weapons.add("Hammer");
        weapons.add("Sword");
    }

    public int getMaxInGame() {
        return maxInGame;
    }

    public void setMaxInGame(int maxInGame) {
        this.maxInGame = maxInGame;
    }

    public Boxe getMyCase() {
        return myCase;
    }

    public void setMyCase(Boxe myCase) {
        this.myCase = myCase;
    }

    public Rules(int maxInGame, Boxe boxe){
        this.maxInGame = maxInGame;
        this.myCase = boxe;
    }

    public ArrayList<String> getSpells(){
        return spells;
    }

    public ArrayList<String> getWeapons(){
        return weapons;
    }
}
