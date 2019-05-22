package warriors.engine.player;

public class Magic extends Heroe {

    private String name = "Merlin";
    private String image = "magicien";
    private int lifeLevel = 3;
    private int maxLifeLevel = 6;
    private int attackLevel = 8;
    private int maxAttackLevel = 15;

    public Magic(){
        setName(name);
        setImage(image);
        setLife(lifeLevel);
        setMaxLife(maxLifeLevel);
        setAttackLevel(attackLevel);
        setMaxAttackLevel(maxAttackLevel);
    }
}
