package warriors.engine.playground.Interact;

import warriors.contracts.Hero;
import warriors.engine.playground.Boxe;

public class PotionBox extends Boxe {
    private int caseNumber;
    private String type;
    private int heal = 0;
    private String text;

    public PotionBox(String type, int heal, String text) {
        this.type = type;
        this.heal = heal;
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

    @Override
    public void doAction(Hero hero) {
        int newHeal = Math.min(hero.getMaxLife(), hero.getLife() + heal);
        hero.setLife(newHeal);
    }


}
