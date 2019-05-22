package warriors.engine;

import warriors.contracts.*;
import warriors.engine.player.Heroe;
import warriors.engine.player.Magic;
import warriors.engine.player.Warrior;
import warriors.engine.playground.*;

import java.util.ArrayList;
import java.util.List;

public class Warriors implements WarriorsAPI {

    private GameState game;
    private String info = null;
    private String infoPlus = null;
    private ArrayList<Hero> heroesList = new ArrayList<>();
    private ArrayList<Map> mapsList = new ArrayList<>();
    private Hero backUpHero;

    public Warriors() {
        seed();
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
        backUpHero = hero;
        this.game = new State(playerName, hero, map);
        ((PlayGround) game.getMap()).createMap();
        game.setLastLog(map.getName() + " La partie commence");
        game.setGameStatus(GameStatus.IN_PROGRESS);
        return game;
    }

    @Override
    public GameState nextTurn(String gameID) {
        game.setLastLog("");
        info = "";
        infoPlus = "";
        int dice = 1 + (int) (Math.random() * ((6 - 1) + 1));
        int newCase = Math.min(game.getMap().getNumberOfCase(), game.getCurrentCase() + dice);
        String diceLog = "les dés ont fait : " + dice + " Vous avancez a la case : " + newCase;
        game.setCurrentCase(newCase);
        if(newCase < game.getMap().getNumberOfCase()) {
            Boxe maCase = ((PlayGround) game.getMap()).getMyCases(game.getCurrentCase());
            maCase.doAction(game.getHero());
            info = diceLog + "\n";
            checkBoxe(maCase);
            info += infoPlus;
            game.setLastLog(info);
        }else{
            info = "Bien jouer belle partie vous avez occi tout les dragons sorciers et gobelins... FELICITATION !!";
            game.setGameStatus(GameStatus.FINISHED);
        }
        return game;
    }

    public void checkBoxe(Boxe maCase){
        if (maCase instanceof EnnemiBox) {
            infoPlus = "\n" + maCase + "\n\n" +
                        game.getHero().getName() + "\n" +
                        "   - PDV : " + Math.max(game.getHero().getLife(), 0) + "\n" +
                        "   - PDA : " + game.getHero().getAttackLevel() + "\n\n" +
                        "Le " + ((EnnemiBox) maCase).getType() + "\n" +
                        "   - PDV : " + Math.max(((EnnemiBox) maCase).getEnnemiLife(), 0) + "\n" +
                        "   - PDA : " + ((EnnemiBox) maCase).getEnnemiAtk() + "\n";
            if (game.getHero().getLife() <= 0) {
                infoPlus += "\n\nVous avez PERDU ce combat";
                this.resetHero(game.getHero());
                game.setGameStatus(GameStatus.GAME_OVER);
            } else if (((EnnemiBox) maCase).getEnnemiLife() <= 0) {
                infoPlus += "Vous avez GAGNER ce combat";
                game.setGameStatus(GameStatus.IN_PROGRESS);
            }
        }else if(maCase instanceof EquipsBox){
            if(((EquipsBox) maCase).getType() != "Neutral") {
                infoPlus = "\n" + maCase + "\n\n" +
                        game.getHero().getName() + "\n" +
                        "   - PDV : " + Math.max(game.getHero().getLife(), 0) + "\n" +
                        "   - PDA : " + game.getHero().getAttackLevel() + "\n\n";
                this.resetHero(game.getHero());
            }else {
                infoPlus = "\nPetite promenade dans de vertes prairies";
            }
            game.setGameStatus(GameStatus.IN_PROGRESS);
        }
    }

    private void resetHero(Hero hero){
        hero = backUpHero;
    }

    private void seed(){
        Heroe arthur = new Warrior();
        Heroe merlin = new Magic();
        Map map1 = new PlayGround("Les terres du milieu \"64 cases\"", 64);
        Map map2 = new PlayGround("Le Mordor \"128 cases\"", 128);
        Map map3 = new PlayGround("La petite maison dans la prairie \"256 épisodes\"", 256);
        Map map4 = new PlayGround("Scenario", 40);
        heroesList.add(arthur);
        heroesList.add(merlin);
        mapsList.add(map1);
        mapsList.add(map2);
        mapsList.add(map3);
        mapsList.add(map4);
    }
}

