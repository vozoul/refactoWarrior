package warriors.engine;

import warriors.contracts.Map;

import java.util.ArrayList;
import java.util.Collections;

public class PlayGround implements Map {

    private String name;
    private int numberOfCase;
    private ArrayList<Rules> rules = new ArrayList<>();
    private ArrayList<Boxe> cases = new ArrayList<>();


    public PlayGround(){
        debugMap();
    }

    public PlayGround(String name, int numberOfCase){
        this.name = name;
        this.numberOfCase = numberOfCase;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumberOfCase() {
        return numberOfCase;
    }

    public ArrayList<Boxe> getCases(){ return cases; }

    public Boxe getMyCases(int numberOfCase){ return cases.get(numberOfCase); }

    @Override
    public void setName(String mapName) {
        this.name = mapName;
    }

    @Override
    public void setNumberOfCase(int numberOfCase) {
        this.numberOfCase = numberOfCase;
    }

    private void setRules(){
        rules.add(new Rules(4, new EnnemiBox("Dragon",15, 4,"")));
        rules.add(new Rules( 10, new EnnemiBox("Sorcier",15, 4,"")));
        rules.add(new Rules( 10, new EnnemiBox("Gobelin",15, 4,"")));
        rules.add(new Rules( 5, new EquipsBox("Arc", 2, 0,"")));
        rules.add(new Rules(3, new EquipsBox("Massue", 3, 0, "")));
        rules.add(new Rules(2, new EquipsBox("Epee", 5, 0,"")));
        rules.add(new Rules(5, new EquipsBox("Ligthning", 2, 0, "")));
        rules.add(new Rules( 2, new EquipsBox("Fireball", 7, 0, "")));
        rules.add(new Rules( 5, new EquipsBox("Potion Mineure", 0, 1, "")));
        rules.add(new Rules( 3, new EquipsBox("Potion", 0, 2, "")));
        rules.add(new Rules( 1, new EquipsBox("Potion Majeure", 0, 5, "")));
        int nbNeutral = extractNeutral();
        rules.add(new Rules( nbNeutral, new EquipsBox()));
    }

    private int extractNeutral(){
        int caseUtil = 0;
        for(Rules rule :rules){
            caseUtil += rule.getMaxInGame();
        }
        int nbNeutral = numberOfCase - caseUtil;
        return nbNeutral;
    }

    public void createMap(){
        setRules();
        for(Rules rule:rules){
            for (int i = 0; i < rule.getMaxInGame(); i++){
                Boxe maCase = ((Rules) rule).getMyCase();
                cases.add(maCase);
            }
        }
        Collections.shuffle(cases);
        int numCase = 0;
        for(Boxe carre:cases){
            carre.setCaseNumber(numCase);
            numCase++;
        }
    }

    public void debugMap(){
        for(int i=0; i<numberOfCase; i++){
            switch(i){
                case 45: case 52: case 56: case 62:
                    cases.add(new EnnemiBox("Dragon", 15, 4, ""));
                    break;
                case 10: case 20: case 25: case 32: case 35: case 36: case 37: case 40: case 44: case 47:
                    cases.add(new EnnemiBox("Sorcier", 9, 2, ""));
                    break;
                case 3: case 6: case 9: case 12: case 15: case 18: case 21: case 24: case 27: case 30:
                    cases.add(new EnnemiBox("Gobelin", 6, 1, ""));
                    break;
                case 2: case 11: case 14: case 19: case 26:
                    cases.add(new EquipsBox("Arc", 2, 0, ""));
                    break;
                case 5: case 22: case 38:
                    cases.add(new EquipsBox("Massue", 3, 0, ""));
                    break;
                case 42: case 53:
                    cases.add(new EquipsBox("Epee", 5, 0, ""));
                    break;
                case 1:case 4:case 8:case 17: case 23:
                    cases.add(new EquipsBox("Lightning", 2, 0, ""));
                    break;
                case 48: case 49:
                    cases.add(new EquipsBox("Fireball", 9, 0, ""));
                    break;
                case 7: case 13: case 28: case 29:case 33:
                    cases.add(new EquipsBox("Potion mineure", 0, 1, ""));
                    break;
                case 31: case 39:case 43:
                    cases.add(new EquipsBox("Potion", 0, 2, ""));
                    break;
                case 41:
                    cases.add(new EquipsBox("Potion majeure", 0, 5, ""));
                    break;
                default:
                    cases.add(new EquipsBox("Neutral", 0, 0, ""));
                    break;

            }
        }
    }
}
