package warriors.engine;

import warriors.contracts.Hero;

public class Heroe implements Hero, Cloneable {

    private int id;
    private String heroName;
    private String heroImage;
    private int heroLife;
    private int heroAtkLevel;
    private int heroMaxLife;
    private int heroMaxAtkLevel;


    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    @Override
    public String getName() {
        return heroName;
    }

    @Override
    public void setName(String name) {
        this.heroName = name;
    }

    @Override
    public String getImage() {
        return heroImage;
    }

    @Override
    public void setImage(String image) {
        this.heroImage = image;
    }

    @Override
    public int getLife() {
        return heroLife;
    }

    @Override
    public void setLife(int life) {
        this.heroLife = life;
    }

    @Override
    public int getMaxLife() {
        return heroMaxLife;
    }

    @Override
    public void setMaxLife(int life) {
        this.heroMaxLife = life;
    }

    @Override
    public int getAttackLevel() {
        return heroAtkLevel;
    }

    @Override
    public void setAttackLevel(int attackLevel) {
        this.heroAtkLevel = attackLevel;
    }

    @Override
    public int getMaxAttackLevel() {
        return heroMaxAtkLevel;
    }

    @Override
    public void setMaxAttackLevel(int maxAttackLevel) {
        this.heroMaxAtkLevel = maxAttackLevel;
    }

    public Object clone(){
        try{
            return super.clone();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
