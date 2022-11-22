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


}
