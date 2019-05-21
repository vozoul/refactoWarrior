package warriors.engine.playground.Interact;

import warriors.contracts.Hero;
import warriors.engine.playground.Boxe;

public class EnnemiBox extends Boxe {

    private int caseNumber;
    private String ennemi;
    private int ennemiLife;
    private int ennemiAtk;
    private String text;
    private char response;

    public EnnemiBox(){
    }

    public EnnemiBox(String ennemi, int life,int  atk, String text){
        this.ennemi = ennemi;
        this.ennemiLife = life;
        this.ennemiAtk = atk;
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
    public void doAction(Hero hero){
        if (response == 'C') {
            ennemiLife -= (hero.getAttackLevel());
            if (ennemiLife > 0) {
                hero.setLife(hero.getLife() - this.ennemiAtk);
            }
        }

    }
}
