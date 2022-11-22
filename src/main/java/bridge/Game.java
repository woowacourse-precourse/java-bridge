package bridge;

import java.util.*;

public class Game {
    private static final String BLANK = " ";
    private List<List<String>> runningList;
    private String success;
    private int location;

    public Game() {
        location = 0;
        success = "실패";

        runningList = new ArrayList<>();
        List<String> up = new ArrayList<>();
        List<String> down = new ArrayList<>();

        runningList.add(up);
        runningList.add(down);
    }

    public List<List<String>> getRunningList() {
        return runningList;
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
