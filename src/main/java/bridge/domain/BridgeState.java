package bridge.domain;

import static bridge.command.LocationCommand.*;
import static bridge.util.Constant.*;

import bridge.command.LocationCommand;
import java.util.ArrayList;
import java.util.List;

public class BridgeState {
    private List<String> map;
    private final Round round;

    public BridgeState(Round round) {
        this.map = new ArrayList<>(List.of(INIT_MAP, INIT_MAP));
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
    private void convertResultFirstRound(String userInput, List<String> bridge) {
        if (compareBridgeRootToUserInput(userInput, bridge)) {
            convertCorrectResultFirstRound(userInput);
        } else if (!compareBridgeRootToUserInput(userInput, bridge)) {
            convertWrongResultFirstRound(userInput);
        }
    }

    // 첫 라운드 이후의 결과
    private void convertResultAfterFirstRound(String userInput, List<String> bridge) {
        if (compareBridgeRootToUserInput(userInput, bridge)) {
            convertCorrectResultAfterFirstRound(userInput);
        } else if (!compareBridgeRootToUserInput(userInput, bridge)) {
            convertWrongResultAfterFirstRound(userInput);
        }
    }

    // 첫 라운드 이후에 사용자가 맞춘 경우
    private void convertCorrectResultAfterFirstRound(String userInput) {
        if (LocationCommand.isUpDirection(userInput)) {
            map.set(Up.getLocationNumber(), map.get(Up.getLocationNumber()).replace(MAP_END, OTHER_ROUND_CORRECT));
            map.set(Down.getLocationNumber(), map.get(Down.getLocationNumber()).replace(MAP_END, OTHER_ROUND_END));
        } else if (LocationCommand.isDownDirection(userInput)) {
            map.set(Up.getLocationNumber(), map.get(Up.getLocationNumber()).replace(MAP_END, OTHER_ROUND_END));
            map.set(Down.getLocationNumber(), map.get(Down.getLocationNumber()).replace(MAP_END, OTHER_ROUND_CORRECT));
        }
    }
}
