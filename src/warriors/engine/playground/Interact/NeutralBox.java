package warriors.engine.plateau.cases;

import warriors.contracts.Hero;
import warriors.engine.Equipment;
import warriors.engine.plateau.Box;

import java.util.ArrayList;

public class Neutral extends Box {

    protected int caseNumber;
    protected String caseMessage;

    public Neutral(){

    }

    public Neutral(int numberOfCase, String caseMessage){
        this.caseNumber = numberOfCase;
        this.caseMessage = caseMessage;
    }

    @Override
    public void doAction(Hero hero, Equipment currentEquipment) {
        //doNothing...
    }
}
