package warriors.engine.plateau;

import warriors.contracts.Hero;
import warriors.engine.Equipment;
import warriors.engine.plateau.Box;
import warriors.engine.plateau.equipment.Weapon;

public class WeaponBox extends Box {

    public int dammage = 0;

    protected WeaponBox() {

    }

    @Override
    public void doAction(Hero hero, Equipment currentEquipment) {
        Weapon weapon = new Weapon(dammage);
        if (weapon.canBeUsedBy(hero)) {
            currentEquipment = weapon;
            hero.setAttackLevel(Math.min(hero.getMaxLifeLevel(), hero.getAttackLevel()+weapon.getDammage()));
        }
    }
}
