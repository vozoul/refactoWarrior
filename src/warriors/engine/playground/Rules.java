package warriors.engine.playground;

public class Rules {

    private int maxInGame;
    private Boxe myCase;

    public int getMaxInGame() {
        return maxInGame;
    }

    public void setMaxInGame(int maxInGame) {
        this.maxInGame = maxInGame;
    }

    public Boxe getMyCase() {
        return myCase;
    }

    public void setMyCase(Boxe myCase) {
        this.myCase = myCase;
    }

    public Rules(int maxInGame, Boxe boxe){
        this.maxInGame = maxInGame;
        this.myCase = boxe;
    }
}
