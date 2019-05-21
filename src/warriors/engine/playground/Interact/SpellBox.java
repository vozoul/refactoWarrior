package warriors.engine.plateau;

import warriors.contracts.Hero;
import warriors.engine.Equipment;
import warriors.engine.plateau.Box;
import warriors.engine.plateau.equipment.Spell;
import warriors.engine.plateau.equipment.Weapon;

public class SpellBox extends Box {

    protected int dammage = 0;

    protected SpellBox() {

    }

    @Override
    public void doAction(Hero hero, Equipment currentEquipment) {
        Spell spell = new Spell(dammage);
        if (spell.canBeUsedBy(hero)) {
            currentEquipment = spell;
            hero.setAttackLevel(Math.min(hero.getMaxLifeLevel(), hero.getAttackLevel()+spell.getDammage()));
        }
    }


}
