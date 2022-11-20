package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player  {
    private final int bridgeLength;
    private int temp;

    public Player(int length) {
        this.temp = 0;
        this.bridgeLength = length;
    }


    public void tryGame() {
        this.temp++;
    }

    public int getTryGameCount() {
        return temp;
    }

}
