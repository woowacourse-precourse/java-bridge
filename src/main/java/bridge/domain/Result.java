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

    // 이동한 칸이 건널 수 있으면 O 아니면 X를 나타내는 기능
    public List<String> convertResult(String userInput, List<String> bridge) {
        if (round.checkRoundFirst()) {
            convertResultFirstRound(userInput, bridge);
        } else if (!round.checkRoundFirst()) {
            convertResultAfterFirstRound(userInput, bridge);
        }
        return map;
    }

    // 첫 번째 라운드 결과
    public void convertResultFirstRound(String userInput, List<String> bridge) {
        if (compareBridgeRootToUserInput(userInput, bridge)) {
            convertCorrectResultFirstRound(userInput);
        } else if (!compareBridgeRootToUserInput(userInput, bridge)) {
            convertWrongResultFirstRound(userInput);
        }
    }

    // 첫 라운드 이후의 결과
    public void convertResultAfterFirstRound(String userInput, List<String> bridge) {
        if (compareBridgeRootToUserInput(userInput, bridge)) {
            convertCorrectResultAfterFirstRound(userInput);
        } else if (!compareBridgeRootToUserInput(userInput, bridge)) {
            convertWrongResultAfterFirstRound(userInput);
        }
    }

    // 첫 라운드 이후에 사용자가 맞춘 경우
    public void convertCorrectResultAfterFirstRound(String userInput) {
        if (userInput.equals(Up.getDirection())) {
            map.set(Up.getLocationNumber(), map.get(Up.getLocationNumber()).replace(MAP_END, OTHER_ROUND_CORRECT));
            map.set(Down.getLocationNumber(), map.get(Down.getLocationNumber()).replace(MAP_END, OTHER_ROUND_END));
        } else if (userInput.equals(Down.getDirection())) {
            map.set(Up.getLocationNumber(), map.get(Up.getLocationNumber()).replace(MAP_END, OTHER_ROUND_END));
            map.set(Down.getLocationNumber(), map.get(Down.getLocationNumber()).replace(MAP_END, OTHER_ROUND_CORRECT));
        }
    }

    // 첫 라운드 이후에 사용자가 틀린 경우
    public void convertWrongResultAfterFirstRound(String userInput) {
        if (userInput.equals(Up.getDirection())) {
            map.set(Up.getLocationNumber(), map.get(Up.getLocationNumber()).replace(MAP_END, OTHER_ROUND_WRONG));
            map.set(Down.getLocationNumber(), map.get(Down.getLocationNumber()).replace(MAP_END, OTHER_ROUND_END));
        } else if (userInput.equals(Down.getDirection())) {
            map.set(Up.getLocationNumber(), map.get(Up.getLocationNumber()).replace(MAP_END, OTHER_ROUND_END));
            map.set(Down.getLocationNumber(), map.get(Down.getLocationNumber()).replace(MAP_END, OTHER_ROUND_WRONG));
        }
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

    // 첫 라운드에 사용자가 틀린 경우
    public void convertWrongResultFirstRound(String userInput) {
        if (userInput.equals(Up.getDirection())) {
            map.set(Up.getLocationNumber(), map.get(Up.getLocationNumber()).replace(BLANK, FIRST_ROUND_WRONG));
            map.set(Down.getLocationNumber(), map.get(Down.getLocationNumber()).replace(MAP_END, FIRST_ROUND_END));
        } else if (userInput.equals(Down.getDirection())) {
            map.set(Up.getLocationNumber(), map.get(Up.getLocationNumber()).replace(MAP_END, FIRST_ROUND_END));
            map.set(Down.getLocationNumber(), map.get(Down.getLocationNumber()).replace(BLANK, FIRST_ROUND_WRONG));
        }
    }

    // 사용자의 입력값과 다리의 건널 수 있는 위치의 일치 여부
    public boolean compareBridgeRootToUserInput(String userInput, List<String> bridge) {
        return userInput.equals(bridge.get(round.getRound()));
    }

    public List<String> getMap() {
        return map;
    }
}
