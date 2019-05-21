package warriors.engine.playground.Interact;

import warriors.contracts.Hero;
import warriors.engine.playground.Boxe;

public class NeutralBox extends Boxe {

    private int caseNumber;

    public NeutralBox(){

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
        //doNothing...
    }
}
