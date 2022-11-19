package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final String BLANK = " ";
    private List<List<String>> playing;
    private String success;
    private int location;


    public Game() {
        location = 0;
        success = "실패";
        playing = new ArrayList<>();
        List<String> up = new ArrayList<>();
        List<String> down = new ArrayList<>();
        playing.add(up);
        playing.add(down);
    }

    public void write(String direction, String answer) {
        if (direction.equals("U")) {
            playing.get(0).add(answer);
            playing.get(1).add(BLANK);
            return;
        }
        playing.get(1).add(answer);
        playing.get(0).add(BLANK);
    }

    public void setPlaying(List<List<String>> playing) {
        this.playing = playing;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void forward() { this.location += 1;}

    public List<List<String>> getPlaying() {
        return playing;
    }
}
