package bridge;

import static bridge.MessageForOutput.*;

import java.util.ArrayList;
import java.util.List;

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
                return MAP_FAIL_MARK.getMessage();
            }
            return MAP_SUCCESS_MARK.getMessage();
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
        System.out.print("\n");
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
        System.out.print(MAP_SEPARATOR.getMessage());
    }
    private void printBlank() {
        System.out.print(MAP_BLANK.getMessage());
    }
    private void printEnding() {
        System.out.print(MAP_ENDING.getMessage());
    }

    public void printResult(List<String> bridgeTrack, List<String> answerBridge, int tryCount) {
        printGameEndingHead();
        printMap(bridgeTrack, answerBridge);
        printGameSuccessStatus(bridgeTrack, answerBridge);
        System.out.print("\n");
        printTryCount(tryCount);
    }
    private void printGameEndingHead() {
        System.out.print(GAME_ENDING_HEAD.getMessage() + "\n");
    }
    private void printGameSuccessStatus(List<String> bridgeTrack, List<String> answerBridge) {
        System.out.print(GAME_SUCCESS_STATUS.getMessage());
        if (isGameSuccess(bridgeTrack, answerBridge)) {
            printGameSuccess();
            return;
        }
        if (isGameFail(bridgeTrack, answerBridge)) {
            printGameFail();
        }
    }
    private boolean isGameSuccess(List<String> bridgeTrack, List<String> answerBridge) {
        return bridgeTrack.equals(answerBridge);
    }
    private boolean isGameFail(List<String> bridgeTrack, List<String> answerBridge) {
        return !bridgeTrack.equals(answerBridge);
    }
    private void printGameSuccess() {
        System.out.print(GAME_SUCCESS.getMessage());
    }
    private void printGameFail() {
        System.out.print(GAME_FAIL.getMessage());
    }
    private void printTryCount(int tryCount) {
        System.out.print(GAME_TRY_COUNT.getMessage());
        System.out.print(tryCount);
    }
}
