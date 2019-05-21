package warriors.engine.plateau;

import warriors.contracts.Hero;
import warriors.engine.Equipment;

public class PotionBox extends Box {

    protected int heal = 0;

    protected PotionBox() {

    }

    @Override
    public void doAction(Hero hero, Equipment currentEquipment) {
        int newHeal = Math.min(hero.getMaxLifeLevel(), hero.getLife() + heal);
        hero.setLife(newHeal);
    }


}
