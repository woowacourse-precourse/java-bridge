package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Map {
    private static final String MAP_BEGINNING = "[ ";
    private static final String MAP_END = " ]";
    private static final String DIVISION_LINE = " | ";
    private static final String CORRECT = "O";
    private static final String WRONG = "X";
    private static final String BLANK_SPACE = " ";

    private List<String> map;

    public Map() {
        initializeMap();
    }

    public void initializeMap() {
        this.map = new ArrayList<>(
                Arrays.asList(MAP_BEGINNING, MAP_BEGINNING)
        );
    }

    public void drawMap(String userPath, boolean isCorrectPath) {
        int userChoice = BridgeStatus.convertLetterToNumber(userPath);
        String mark = CORRECT;
        if (!isCorrectPath) {
            mark = WRONG;
        }
        this.map.set(userChoice, this.map.get(userChoice).replace(MAP_END, DIVISION_LINE) + mark + MAP_END);
        this.map.set(Math.abs(userChoice - 1), this.map.get(Math.abs(userChoice - 1)).replace(MAP_END, DIVISION_LINE) + BLANK_SPACE + MAP_END);
    }

    public List<String> getMap() {
        return this.map;
    }
}
