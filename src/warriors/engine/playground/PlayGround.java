package warriors.engine.playground;

import warriors.contracts.Map;

import java.util.ArrayList;
import java.util.Collections;

public class PlayGround implements Map {

    private String name;
    private int numberOfCase;
    private ArrayList<Rules> rules = new ArrayList<>();
    private ArrayList<Boxe> cases = new ArrayList<>();


    public PlayGround(){

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

}
