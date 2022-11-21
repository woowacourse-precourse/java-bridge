package bridge.view;

import bridge.model.Result;
import bridge.model.Step;

import java.util.ArrayList;
import java.util.List;

import static bridge.utils.GameMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<Step> steps) {
        List<String> upBridge = new ArrayList<>();
        List<String> downBridge = new ArrayList<>();
        makeUpAndDownBridge(steps, upBridge, downBridge);
        System.out.println(convertBridgeToMessage(upBridge, downBridge));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Result result) {
        List<String> upBridge = new ArrayList<>();
        List<String> downBridge = new ArrayList<>();
        System.out.println(NEW_LINE.message);
        System.out.println(RESULT_HEADER.message);
        makeUpAndDownBridge(result.getSteps(), upBridge, downBridge);
        System.out.println(convertBridgeToMessage(upBridge, downBridge));
        System.out.println(NEW_LINE.message);
        System.out.println(String.format(RESULT_IS_SUCCESS.message, result.getIsSuccess()));
        System.out.println(String.format(RESULT_TOTAL_TRIAL.message, result.getTrial()));
    }

    public void printStart() {
        System.out.println(GAME_START.message);
    }

    public void printBridgeSize() {
        System.out.println(NEW_LINE.message);
        System.out.println(BRIDGE_MAKER.message);
    }

    public void printMoving() {
        System.out.println(NEW_LINE.message);
        System.out.println(MOVING.message);
    }

    public void printRetry() {
        System.out.println(NEW_LINE.message);
        System.out.println(RETRY.message);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    private void makeUpAndDownBridge(List<Step> steps, List<String> upBridge, List<String> downBridge) {
        for (Step step : steps) {
            if (step.name().contains("UP")) {
                upBridge.add(step.value);
                downBridge.add("   ");
            }
            if (step.name().contains("DOWN")) {
                upBridge.add("   ");
                downBridge.add(step.value);
            }
        }
    }

    private String convertBridgeToMessage(List<String> upBridge, List<String> downBridge) {
        String upBridgeMessage = "[" + String.join("|", upBridge) + "]";
        String downBridgeMessage = "[" + String.join("|", downBridge) + "]";
        return upBridgeMessage + "\n" + downBridgeMessage;
    }
}
