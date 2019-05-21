package warriors.engine.playground;
import warriors.contracts.Map;
import warriors.engine.playground.Interact.*;


import java.util.ArrayList;

public class PlayGround implements Map {

    private String name;
    private int numberOfCase;
    private ArrayList<Rules> rules = new ArrayList<>();


    public PlayGround(){

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumberOfCase() {
        return numberOfCase;
    }

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
        rules.add(new Rules( 5, new EquipsBox("Potion Mineur", 0, 1, "")));
        rules.add(new Rules( 3, new EquipsBox("Potion", 0, 2, "")));
        rules.add(new Rules( 1, new EquipsBox("Potion Majeure", 0, 5, "")));
        int nbNeutral = extractNeutral();
        rules.add(new Rules( nbNeutral, new NeutralBox()));
    }

    private int extractNeutral(){
        int caseUtil = 0;
        for(Rules rule :rules){
            caseUtil += rule.getMaxInGame();
        }
        int nbNeutral = numberOfCase - caseUtil;
        return nbNeutral;
    }

}
