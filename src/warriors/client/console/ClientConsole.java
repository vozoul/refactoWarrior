package warriors.client.console;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

import warriors.config.Cfg;
import warriors.contracts.GameState;
import warriors.contracts.GameStatus;
import warriors.contracts.Hero;
import warriors.contracts.Map;
import warriors.contracts.WarriorsAPI;
import warriors.database.MysqlDatabase;
import warriors.engine.Warriors;

public class ClientConsole {

    private static String MENU_COMMENCER_PARTIE = "1";
    private static String DEBUG_MODE = "2";
    private static String MENU_QUITTER = "3";
    private static String TEST_CON = "4";


    private static Hero backUpHero;

    public static void main(String[] args) {

        WarriorsAPI warriors = new Warriors();
        WarriorsAPI debug = new Warriors("debug");
        Scanner sc = new Scanner(System.in);
        String menuChoice = "";
        do {
            menuChoice = displayMenu(sc);
            if (menuChoice.equals(MENU_COMMENCER_PARTIE)) {
                startGame(warriors, sc);
            } else if (menuChoice.equals(DEBUG_MODE)) {
                startGame(debug, sc);
            } else if (menuChoice.equals(TEST_CON)){
                new MysqlDatabase();
                MysqlDatabase.connectTest();
            }
        } while (!menuChoice.equals(MENU_QUITTER));
        sc.close();
        System.out.println("à bientôt");
    }

    private static void startGame(WarriorsAPI warriors, Scanner sc) {
        System.out.println();
        System.out.println("Entrez votre nom:");
        String playerName = sc.nextLine();
        int firstRound = 0;
        System.out.println("Choisissez votre héro:");
        for (int i = 0; i < warriors.getHeroes().size(); i++) {
            Hero heroe = warriors.getHeroes().get(i);
            System.out.println(i + 1 + " - " + heroe.getName());
            System.out.println("    Niveau de vie : " + heroe.getLife());
            System.out.println("    Force d'attaque : " + heroe.getAttackLevel());
        }
        Hero chosenHeroe = warriors.getHeroes().get(Integer.parseInt(sc.nextLine()) - 1);

        backUpHero = ((Hero) chosenHeroe.clone());


        System.out.println("Choisissez votre map:");
        for (int i = 0; i < warriors.getMaps().size(); i++) {
            Map map = warriors.getMaps().get(i);
            System.out.println(i + 1 + " - " + map.getName());
        }
        Map choosenMap = warriors.getMaps().get(Integer.parseInt(sc.nextLine()) - 1);

        GameState gameState = warriors.createGame(playerName, chosenHeroe, choosenMap);
        String gameId = gameState.getGameId();
        while (gameState.getGameStatus() == GameStatus.IN_PROGRESS) {
            System.out.println(gameState.getLastLog());
            if(gameState.getLastLog() == "DEBUG MODE") {

            }else {
                System.out.println("\nAppuyer sur une touche pour lancer le dé");
                if (sc.hasNext()) {
                    sc.nextLine();
                    gameState = warriors.nextTurn(gameId);
                }
            }
        }


        resetHero(gameState.getHero());
        System.out.println(gameState.getLastLog());
    }

    private static String displayMenu(Scanner sc) {
        System.out.println();
        System.out.println("================== Java Warriors ==================");
        System.out.println("1 - Commencer une partie");
        System.out.println("2 - Debug mode");
        System.out.println("3 - Quitter");
        if (sc.hasNext()) {
            String choice = sc.nextLine();
            return choice;
        }

        return "";
    }

    /**
     * Rest the heroe's stats
     * @param currentHero
     */
    private static void resetHero(Hero currentHero){
        currentHero.setLife(backUpHero.getLife());
        currentHero.setAttackLevel(backUpHero.getAttackLevel());
    }
}

