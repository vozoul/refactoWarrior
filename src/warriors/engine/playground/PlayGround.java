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
        rules.add(new Rules( 5, new WeaponBox("Arc", 2, "")));
        rules.add(new Rules(3, new WeaponBox("Massue", 3, "")));
        rules.add(new Rules(2, new WeaponBox("Epee", 5, "")));
        rules.add(new Rules(5, new SpellBox("Lgnthning", 2, "")));
        rules.add(new Rules( 2, new SpellBox("Fireeball", 7, "")));
        rules.add(new Rules( 5, new PotionBox("Potion Mineur", 1, "")));
        rules.add(new Rules( 3, new PotionBox("Potion", 2, "")));
        rules.add(new Rules( 1, new PotionBox("Potion Majeure", 5, "")));
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
