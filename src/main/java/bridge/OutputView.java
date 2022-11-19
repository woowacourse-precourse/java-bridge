package bridge;

import static bridge.MessageForOutput.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printMap(List<String> bridgeTrack, List<String> answerBridge) {
        printBridgeMap(makeBridgeMap(bridgeTrack, answerBridge));
    }
    private List<List<String>> makeBridgeMap(List<String> bridgeTrack, List<String> answerBridge) {
        List<List<String>> bridgeMap = new ArrayList<>();
        bridgeMap.add(makeUpperBridge(bridgeTrack, answerBridge));
        bridgeMap.add(makeDownBridge(bridgeTrack, answerBridge));
        return bridgeMap;
    }
    private List<String> makeUpperBridge(List<String> bridgeTrack, List<String> answerBridge) {
        return makeBridgeMapOneSide(bridgeTrack, answerBridge, BridgeState.UP.getBridgeMark());
    }
    private List<String> makeDownBridge(List<String> bridgeTrack, List<String> answerBridge) {
        return makeBridgeMapOneSide(bridgeTrack, answerBridge, BridgeState.DOWN.getBridgeMark());
    }
    private List<String> makeBridgeMapOneSide(List<String> bridgeTrack, List<String> answerBridge, String bridgeMark) {
        List<String> oneSideMap = new ArrayList<>();
        for (int i = 0; i < bridgeTrack.size(); i++) {
            oneSideMap.add(createBody(bridgeTrack.get(i), answerBridge.get(i), bridgeMark));
        }
        return oneSideMap;
    }
    private String createBody(String bridgeTrack, String answerBridge, String bridgeMark) {
        if (bridgeTrack.equals(bridgeMark)) {
            if (!bridgeTrack.equals(answerBridge)) {
                return FAIL_MARK.getMessage();
            }
            return SUCCESS_MARK.getMessage();
        }
        return MAP_BLANK.getMessage();
    }

    private void printBridgeMap(List<List<String>> bridgeMap) {
        for (List<String> oneSideBridgeMap : bridgeMap) {
            printStarting();
            printOneSide(oneSideBridgeMap);
            printEnding();
            System.out.print("\n");
        }
    }
    private void printStarting() {
        System.out.print(MAP_STARTING.getMessage());
    }
    private void printOneSide(List<String> oneSideBridgeMap) {
        printBody(oneSideBridgeMap.get(0));
        for (int i = 1; i < oneSideBridgeMap.size(); i++) {
            printSeparator();
            printBody(oneSideBridgeMap.get(i));
        }
    }
    private void printBody(String bridgeBody) {
        printBlank();
        System.out.print(bridgeBody);
        printBlank();
    }
    private void printSeparator() {
        System.out.print(SEPARATOR.getMessage());
    }
    private void printBlank() {
        System.out.print(MAP_BLANK.getMessage());
    }
    private void printEnding() {
        System.out.print(MAP_ENDING.getMessage());
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
