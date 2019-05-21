package warriors.engine.playground;

import warriors.contracts.Hero;

public abstract class Boxe {

    public abstract int getCaseNumber();

    public abstract void setCaseNumber(int caseNumber);

    public abstract void doAction(Hero hero);
}
