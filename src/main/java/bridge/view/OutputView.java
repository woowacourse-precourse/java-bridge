package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStartMessage () {
        GameMessages startMessage = GameMessages.START_MESSAGE;
        startMessage.print();
    }

    public void printInputBridgeLengthMessage () {
        GameMessages inputBridgeLengthMessage = GameMessages.INPUT_BRIDGE_LENGTH_MESSAGE;
        inputBridgeLengthMessage.print();
    }

    public void printInputMoveMessage () {
        GameMessages inputMoveMessage = GameMessages.INPUT_MOVE_MESSAGE;
        inputMoveMessage.print();
    }

    public void printInputRetrialMessage () {
        GameMessages inputRetrialMessage = GameMessages.INPUT_RETRIAL_MESSAGE;
        inputRetrialMessage.print();
    }


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> userBridge) {
        printUpperBridge(userBridge);
        printLowerBridge(userBridge);
    }

    private void printLowerBridge(List<String> userBridge) {
        System.out.print("[ ");
        for (String bridgeType : userBridge.subList(0, userBridge.size() - 1)) {
            isDownBridge(bridgeType);
            System.out.print(" | ");
        }
        isDownBridge(userBridge.get(userBridge.size() - 1));
        System.out.println(" ]");
    }

    private void printUpperBridge(List<String> userBridge) {
        System.out.print("[ ");
        for (String bridgeType : userBridge.subList(0, userBridge.size() - 1)) {
            isUpperBridge(bridgeType);
            System.out.print(" | ");
        }
        isUpperBridge(userBridge.get(userBridge.size() - 1));
        System.out.println(" ]");
    }

    private void isUpperBridge(String bridgeType) {
        if (bridgeType.equals("U")) {
            System.out.print("O");
            return ;
        }
        System.out.print(" ");
    }

    private void isDownBridge(String bridgeType) {
        if (bridgeType.equals("D")) {
            System.out.print("O");
            return ;
        }
        System.out.print(" ");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
