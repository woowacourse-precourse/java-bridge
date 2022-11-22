package bridge;

import java.util.*;

public class Game {
    private static final String BLANK = " ";
    private List<List<String>> playing;
    private String success;
    private int location;

    public Game() {
        location = 0;
        success = "실패";
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void forward() {
        this.location += 1;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
