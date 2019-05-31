package warriors.engine;

public class Warrior extends Heroe {

    private String name = "Bouhh";
    private String image = "sayan";
    private int lifeLevel = 3500;
    private int maxLifeLevel = 90000;
    private int attackLevel = 60000;
    private int maxAttackLevel = 90000;

    public Warrior(){
        setName(name);
        setImage(image);
        setLife(lifeLevel);
        setMaxLife(maxLifeLevel);
        setAttackLevel(attackLevel);
        setMaxAttackLevel(maxAttackLevel);
    }
}
