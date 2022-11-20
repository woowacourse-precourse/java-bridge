package bridge.domain;


public class Player  {
    private int temp;

    public Player() {
        this.temp = 0;
    }


    public void tryGame() {
        this.temp++;
    }

    public int getTryGameCount() {
        return temp;
    }

}
