package warriors.engine.player;

public class Warrior extends Heroe {

    private String name = "Arthur";
    private String image = "guerrier";
    private int lifeLevel = 15;
    private int maxLifeLevel = 40;
    private int attackLevel = 6;
    private int maxAttackLevel = 30;

    public Warrior(){
        setName(name);
        setImage(image);
        setLife(lifeLevel);
        setMaxLife(maxLifeLevel);
        setAttackLevel(attackLevel);
        setMaxAttackLevel(maxAttackLevel);
    }
}
