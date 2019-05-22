package warriors.engine.playground;

import warriors.contracts.Hero;
import warriors.engine.player.*;
import warriors.engine.playground.*;

public class EquipsBox extends Boxe {

    private int caseNumber;
    private String type = "";
    protected int damage = 0;
    private int heal = 0;
    private String text;
    Rules rules = new Rules();
    private String retour = "Case bonus !! " + type + "\n";
    Hero hero = null;

    public EquipsBox(){
        this.type = "Neutral";
        this.damage = 0;
        this.heal = 0;
        this.text = "";
    }


    public EquipsBox(String type,int damage, int heal, String text) {
        this.type = type;
        this.damage = damage;
        this.heal = heal;
        this.text = text;
    }

    public String getType() {
        return type;
    }

    @Override
    public int getCaseNumber() {
        return 0;
    }

    @Override
    public void setCaseNumber(int caseNumber) {

    }

    private boolean canBeUsedBy(Hero hero){
        this.hero = hero;
        if(rules.getSpells().contains(type)) {
            retour += "\n Vous pouvez utiliser cegt objet";
            return (hero instanceof Magic);
        }else if(rules.getWeapons().contains(type)){
            retour += "\n Vous pouvez utiliser cegt objet";
            return (hero instanceof Warrior);
        }else{
            retour += "\n A votre santé !";
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

    @Override
    public String toString() {
        return (canBeUsedBy(hero)) ? "\n" + "Vous avez trouver un " + type : "Oh !? un " + type + " . Vraiment pas utile !!";
    }
}
