package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeType;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.LinkedList;
import java.util.List;

public class RoundController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    private final List<String> upperBridge = new LinkedList<>();
    private final List<String> downBridge = new LinkedList<>();

    public boolean start(int roundCnt, Bridge bridge){
        outputView.printInputMoveOptionGuide();
        String movingOption = inputView.readMoving();

        boolean result = bridge.isCorrect(roundCnt, movingOption);

        updateBridge(movingOption, result);
        outputView.printMap(upperBridge, downBridge);

        return result;
    }

    private void updateBridge(String movingOption, boolean result){
        String option = getInputString(result);
        if(movingOption.equals(BridgeType.UPPER_BRIDGE.getEngNotation())){
            upperBridge.add(option);
            downBridge.add(" ");
        }
        else if(movingOption.equals(BridgeType.DOWN_BRIDGE.getEngNotation())){
            upperBridge.add(" ");
            downBridge.add(option);
        }
    }

    private String getInputString(boolean result){
        if(result){
            return "O";
        }
        return "X";
    }

}
