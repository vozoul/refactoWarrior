package warriors.engine.playground.Interact;

import warriors.contracts.Hero;
import warriors.engine.player.*;
import warriors.engine.playground.*;

public class EquipsBox extends Boxe {

    private int caseNumber;
    private String type;
    protected int damage = 0;
    private int heal = 0;
    private String text;
    Rules rules = new Rules();


    public EquipsBox(String type,int damage, int heal, String text) {
        this.type = type;
        this.damage = damage;
        this.heal = heal;
        this.text = text;
    }


    @Override
    public int getCaseNumber() {
        return 0;
    }

    @Override
    public void setCaseNumber(int caseNumber) {

    }

    private boolean canBeUsedBy(Hero hero){
        if(rules.getSpells().contains(type)) {
            return (hero instanceof Magic);
        }else if(rules.getWeapons().contains(type)){
            return (hero instanceof Warrior);
        }else{
            return true;
        }
    }

    @Override
    public void doAction(Hero hero) {
        if(canBeUsedBy(hero)){
            hero.setLife(Math.min(hero.getMaxLife(), hero.getLife()+heal));
            hero.setAttackLevel(Math.min(hero.getMaxAttackLevel(), hero.getAttackLevel()+damage));
        }
    }
}
