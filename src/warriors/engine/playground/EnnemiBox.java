package warriors.engine.playground;

import warriors.contracts.Hero;
import warriors.engine.playground.Boxe;

public class EnnemiBox extends Boxe {

    private int caseNumber;
    private String type;
    private int ennemiLife;
    private int ennemiAtk;
    private String text;

    public EnnemiBox(){
    }

    public EnnemiBox(String ennemi, int life,int  atk, String text){
        this.type = ennemi;
        this.ennemiLife = life;
        this.ennemiAtk = atk;
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEnnemiLife() {
        return ennemiLife;
    }

    public int getEnnemiAtk() {
        return ennemiAtk;
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
        boolean combat = true;
        while(combat) {
            ennemiLife -= (hero.getAttackLevel());
            if (ennemiLife > 0) {
                hero.setLife(hero.getLife() - this.ennemiAtk);
            }
            combat = (ennemiLife <= 0 || hero.getLife() <= 0) ? false : true;
        }
    }

    public String toString() {
        return "\n" + "Vous combattez un " + type;
    }
}
