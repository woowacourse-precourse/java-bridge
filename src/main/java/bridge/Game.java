package bridge;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<List<String>> playing;

    private int location;

    public Game() {
        location = 0;
        playing = new ArrayList<>();
        List<String> up = new ArrayList<>();
        List<String> down = new ArrayList<>();
        playing.add(up);
        playing.add(down);
    }

    public int getLocation() {
        return location;
    }

    public void forward(){
        this.location += 1;
    }

    public List<List<String>> getPlaying() {
        return playing;
    }
}
