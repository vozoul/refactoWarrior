package warriors.engine.playground.Interact;

import warriors.contracts.Hero;
import warriors.engine.player.Warrior;
import warriors.engine.playground.Boxe;

public class WeaponBox extends Boxe {

    private int caseNumber;
    private String type;
    private int dammage = 0;
    private String text;

    public WeaponBox() {}

    public WeaponBox(String type, int damages, String text) {
        this.dammage = damages;
        this.text = text;
    }

    @Override
    public int getCaseNumber() {
        return caseNumber;
    }

    @Override
    public void setCaseNumber(int caseNumber) {
        this.caseNumber = caseNumber;
    }

    private boolean canBeUsedBy(Hero hero){
        return (hero instanceof Warrior);
    }

    @Override
    public void doAction(Hero hero) {
        if(canBeUsedBy(hero)){

        }
    }
}
