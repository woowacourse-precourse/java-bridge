package bridge.domain;

import static bridge.command.LocationCommand.*;
import static bridge.util.Constant.*;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private List<String> map;
    private Round round;

    public Result(Round round) {
        this.map = new ArrayList<>(List.of("[ ]", "[ ]"));
        this.round = round;
    }

    // 첫 라운드에 사용자가 맞춘 경우
    public void convertCorrectResultFirstRound(String userInput) {
        if (userInput.equals(Up.getDirection())) {
            map.set(Up.getLocationNumber(), map.get(Up.getLocationNumber()).replace(BLANK, FIRST_ROUND_CORRECT));
            map.set(Down.getLocationNumber(), map.get(Down.getLocationNumber()).replace(MAP_END, FIRST_ROUND_END));
        } else if (userInput.equals(Down.getDirection())) {
            map.set(Up.getLocationNumber(), map.get(Up.getLocationNumber()).replace(MAP_END, FIRST_ROUND_END));
            map.set(Down.getLocationNumber(), map.get(Down.getLocationNumber()).replace(BLANK, FIRST_ROUND_CORRECT));
        }
    }

    public List<String> getMap() {
        return map;
    }
}
