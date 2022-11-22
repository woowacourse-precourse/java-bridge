package view;

import bridge.BridgeGame;
import enumCollections.GameStatus;
import enumCollections.GuideMessage;
import enumCollections.UserInterfaceSymbol;

import java.util.List;

public class OutputView {
    public void printWelcomeMessage() {
        printGuideMessage(GuideMessage.START);
    }

    public void printProgress(BridgeGame bridgeGame) {
        printMap(bridgeGame.getMap());
    }

    public void printResult(GameStatus gameResult, BridgeGame bridgeGame) {
        printNewline();
        printGuideMessage(GuideMessage.RESULT_PRINT);
        printMap(bridgeGame.getMap());
        printNewline();
        printResult(gameResult);
        printGuideMessage(GuideMessage.GAME_TRIAL, bridgeGame.getTrial());
    }

    public void printAskGameCommand() {
        printNewline();
        printGuideMessage(GuideMessage.GET_GAME_COMMAND);
    }

    public void printAskBridgeLength() {
        printNewline();
        printGuideMessage(GuideMessage.GET_BRIDGE_LENGTH);
    }

    public void printAskMoving() {
        printNewline();
        printGuideMessage(GuideMessage.GET_MOVING);
    }

    public void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    private void printResult(GameStatus gameStatus) {
        printGuideMessage(GuideMessage.GAME_RESULT, gameStatus.getMessage());
    }

    private void printGuideMessage(GuideMessage situation) {
        System.out.println(situation.getMessage());
    }

    private void printGuideMessage(GuideMessage situation, String gameStatus) {
        System.out.printf(situation.getMessage(), gameStatus);
    }

    private void printNewline() {
        System.out.println();
    }

    private void printMap(List<List<String>> map) {
        map.stream().forEach(line -> {
            printBridge(String.join(UserInterfaceSymbol.BRIDGE_DELIMITER.getSymbol(), line));
        });
    }

    private void printBridge(String line) {
        System.out.println(
                UserInterfaceSymbol.START_OF_BRIDGE.getSymbol()
                        .concat(line)
                        .concat(UserInterfaceSymbol.END_OF_BRIDGE.getSymbol())
        );
    }
}