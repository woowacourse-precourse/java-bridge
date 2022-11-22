package bridge;

public class Player {
    public static Bridges bridges;

    public Player(Bridges bridge){
        this.bridges = bridge;
    }
    public Bridges getPlayerBridges(){
        return this.bridges;
    }

}

