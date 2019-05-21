package warriors.engine.player;

public class Warrior extends Heroe {



    private String name = "Arthur";
    private String image = "guerrier";
    private int lifeLevel = 5;
    private int maxLifeLevel = 10;
    private int attackLevel = 5;
    private int maxAttackLevel = 10;

    public Warrior(){
        setName(name);
        setImage(image);
        setLife(lifeLevel);
        setMaxLife(maxLifeLevel);
        setAttackLevel(attackLevel);
        setMaxAttackLevel(maxAttackLevel);
    }
}
