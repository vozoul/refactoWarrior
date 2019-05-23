package warriors.engine;

import warriors.contracts.Hero;

public abstract class Boxe {

    /**
     * Return the number of the case
     * @return current case number
     */
    public abstract int getCaseNumber();

    /**
     * Ste the case number
     * @param caseNumber
     */
    public abstract void setCaseNumber(int caseNumber);

    /**
     * Do the action attached to the position of the player's heroe
     * @param hero
     */
    public abstract void doAction(Hero hero);

    /**
     * return String what explain the curent state
     * @return
     */
    @Override
    public String toString() {
        return "";
    }
}