package warriors.engine.plateau;

import warriors.contracts.Hero;
import warriors.engine.Equipment;

import java.util.Scanner;

public class EnnemiBox extends Box {
    protected Scanner sc = new Scanner(System.in);
    protected int ennemiLife = 0;
    protected int ennemiAtk = 0;
    protected char response;
    protected EnnemiBox ennemi = this;

    protected EnnemiBox(){
    }
    public String getCaseResult(Hero hero, EnnemiBox ennemi){
        String result = null;
        System.out.println("Case : " + ennemi + " voulez vous combattre cet ennemi ? (C)ombatre / (F)uir");
        response = sc.nextLine().charAt(0);
        if(response == 'C') {
            result = "\nVotre hero : " + hero.getName() + "\n" +
                    "PDV = " + hero.getLife() + " ;\n" +
                    "PDA = " + hero.getAttackLevel() + " ;\n" +
                    "combat contre " + "\n" +
                    "Votre ennemi : " + ennemi + "\n" +
                    "PDV = " + ennemiLife + " ;\n" +
                    "PDA = " + ennemiAtk + " ;\n";
        }else{
            result = "vous etes un couart !!";
        }
        return result;
    }


    @Override
    public void doAction(Hero hero, Equipment currentEquipment){
        if (response == 'C') {
            ennemiLife -= (hero.getAttackLevel());
            if (ennemiLife > 0) {
                hero.setLife(hero.getLife() - this.ennemiAtk);
            }
        }

    }
}
