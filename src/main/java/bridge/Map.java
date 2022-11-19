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

    private final List<String> userPath;
    private List<String> map;

    public Map(List<String> userPath) {
        this.userPath = userPath;
        this.map = initializeMap();
    }

    private List<String> initializeMap() {
        List<String> map = new ArrayList<>(
                Arrays.asList(MAP_BEGINNING, MAP_BEGINNING)
        );

        return map;
    }
}
