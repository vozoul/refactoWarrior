package warriors.engine.playground.Interact;

import warriors.contracts.Hero;
import warriors.engine.player.Magic;
import warriors.engine.playground.Boxe;

public class SpellBox extends Boxe {

    private String type;
    protected int dammage = 0;
    private String text;
    private int caseNumber;

    protected SpellBox() {}


    public SpellBox(String type, int damages, String text) {
        this.type = type;
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
        return (hero instanceof Magic);
    }

    @Override
    public void doAction(Hero hero) {
        if(canBeUsedBy(hero)){

        }
    }


}
