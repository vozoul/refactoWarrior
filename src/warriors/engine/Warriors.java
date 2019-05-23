package warriors.engine;

import warriors.contracts.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

public class Warriors implements WarriorsAPI {

    private GameState game;
    private String log;
    private String info = null;
    private String infoPlus = null;
    private ArrayList<Hero> heroesList = new ArrayList<>();
    private ArrayList<Map> mapsList = new ArrayList<>();
    private Hero backUpHero;

    public Warriors() {
        seed();
    }

    public Warriors(String debug){
        Heroe arthur = new Warrior();
        Map maps = new PlayGround();
        heroesList.add(arthur);
        mapsList.add(maps);
        log = "DEBUG MODE";
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
        if(log.equals("DEBUG MODE")){
            game.setLastLog(log);
            try
            {
                String chemin = "./src/warriors/engine/Scenario.csv";
                BufferedReader fichier_source = new BufferedReader(new FileReader(chemin));
                String chaine = fichier_source.readLine();
                while((chaine)!= null){
                    String[] resultats = chaine.split(",");
                    for(String res:resultats){
                        int jet = Integer.parseInt(res);
                        System.out.println(jet);
                    }
                }
                fichier_source.close();
                this.game.setGameStatus(GameStatus.FINISHED);
            }
            catch (FileNotFoundException e)
            {
                System.out.println("Le fichier est introuvable !");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            game.setLastLog("");
            info = "";
            infoPlus = "";
            int dice = 1 + (int) (Math.random() * ((6 - 1) + 1));
            int newCase = Math.min(game.getMap().getNumberOfCase(), game.getCurrentCase() + dice);
            String diceLog = "les dés ont fait : " + dice + " Vous avancez a la case : " + newCase;
            game.setCurrentCase(newCase);
            if (newCase < game.getMap().getNumberOfCase()) {
                Boxe maCase = ((PlayGround) game.getMap()).getMyCases(game.getCurrentCase());
                maCase.doAction(game.getHero());
                info = diceLog + "\n";
                checkBoxe(maCase);
                info += infoPlus;
                game.setLastLog(info);
            } else {
                info = "Bien jouer belle partie vous avez occi tout les dragons sorciers et gobelins... FELICITATION !!";
                game.setGameStatus(GameStatus.FINISHED);
            }
        }
        return game;
    }


    /**
     * check the case to return the result of action
     * @param maCase
     */
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
                resetHero(game.getHero());
            }else {
                infoPlus = "\nPetite promenade dans de vertes prairies";
            }
            game.setGameStatus(GameStatus.IN_PROGRESS);
        }
    }


    /**
     * Rest the heroe's stats
     * @param currentHero
     */
    private void resetHero(Hero currentHero){
        currentHero = this.backUpHero;
    }


    /**
     * Generate heroes and maps
     */
    private void seed(){
        Heroe arthur = new Warrior();
        Heroe Thomas = new Magic("Thomas", "", 15, 25, 6, 25);
        Heroe merlin = new Magic();
        Map map1 = new PlayGround("Les terres du milieu \"64 cases\"", 64);
        Map map2 = new PlayGround("Le Mordor \"128 cases\"", 128);
        Map map3 = new PlayGround("La petite maison dans la prairie \"256 épisodes\"", 256);
        heroesList.add(arthur);
        heroesList.add(Thomas);
        heroesList.add(merlin);
        mapsList.add(map1);
        mapsList.add(map2);
        mapsList.add(map3);
    }


}

