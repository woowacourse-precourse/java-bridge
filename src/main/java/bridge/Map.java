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
    private static final boolean IS_USER_CHOICE = true;

    private final List<String> userPath;
    private List<String> map;

    public Map(List<String> userPath, boolean isCorrectPath) {
        this.userPath = userPath;
        this.map = initializeMap();
        drawMap(isCorrectPath);
    }

    private List<String> initializeMap() {
        List<String> map = new ArrayList<>(
                Arrays.asList(MAP_BEGINNING, MAP_BEGINNING)
        );

        return map;
    }

    private String prepareMidMap(boolean isUserChoice) {
        if (isUserChoice) {
            return CORRECT + DIVISION_LINE;
        }
        return BLANK_SPACE + DIVISION_LINE;
    }

    private String prepareEndMap(boolean isUserChoice, boolean isCorrectPath) {
        if (!isUserChoice) {
            return BLANK_SPACE + MAP_END;
        }
        else if (isCorrectPath) {
            return CORRECT + MAP_END;
        }
        return WRONG + MAP_END;
    }

    private void drawMidMap(int userChoice) {
        this.map.set(userChoice, this.map.get(userChoice) + prepareMidMap(IS_USER_CHOICE));
        this.map.set(Math.abs(userChoice - 1), this.map.get(Math.abs(userChoice - 1)) + prepareMidMap(!IS_USER_CHOICE));
    }

    private void drawEndMap(int userChoice, boolean isCorrectPath) {
        this.map.set(userChoice, this.map.get(userChoice) + prepareEndMap(IS_USER_CHOICE, isCorrectPath));
        this.map.set(Math.abs(userChoice - 1), this.map.get(Math.abs(userChoice - 1)) + prepareEndMap(!IS_USER_CHOICE, isCorrectPath));
    }

    private void drawMap(boolean isCorrectPath) {
        for (int i = 0; i < this.userPath.size(); i++) {
            int userChoice = BridgeStatus.convertLetterToNumber(this.userPath.get(i));

            if (i < this.userPath.size() - 1) {
                drawMidMap(userChoice);
            }
            else if (i == this.userPath.size() - 1) {
                drawEndMap(userChoice, isCorrectPath);
            }
        }
    }
}
