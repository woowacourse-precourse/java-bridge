package bridge;


import java.util.List;


/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private BridgeGame bridgeGame = new BridgeGame();
    InputView inputview = new InputView();
    private int i =1;


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int bridgeSize, List<String> makeBridge) {
        for (int i = 1; i <= bridgeSize; i++) {
            String move = inputview.readMoving();
            List<String> upBridge = bridgeGame.move(move, makeBridge, i);
            List<String> downBridge = bridgeGame.downMove(move, makeBridge, i);
            System.out.println(String.join("", upBridge));
            System.out.println(String.join("", downBridge));
            if (upBridge.contains(" X ") || downBridge.contains(" X ")) {
                break;
            }
            if (i == bridgeSize) {
                break;
            }
            upBridge.add(2 * i, "|");
            downBridge.add(2 * i, "|");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println(Message.RESULT);
        System.out.println(String.join("", bridgeGame.upBridge));
        System.out.println(String.join("", bridgeGame.downBridge));
    }

    public void printSuccess() {
        if (!bridgeGame.upBridge.contains(" X ") && !bridgeGame.downBridge.contains(" X ")) {
            System.out.println(Message.SUCCESS);
        }
        if (bridgeGame.upBridge.contains(" X ") || bridgeGame.downBridge.contains(" X ")) {
            System.out.println(Message.FAIL);
        }
        System.out.println(Message.COUNT + Game_Control.count + "\n");
    }


    public String printFail(String check) {
        if (bridgeGame.upBridge.contains(" X ") || bridgeGame.downBridge.contains(" X ")) {
            System.out.println(Message.RETRY);
            check = inputview.readGameCommand();
        }
        if (!bridgeGame.upBridge.contains(" X ") && !bridgeGame.downBridge.contains(" X ")) {
            check = "Q";
        }
        return check;
    }

    public void restart() {
        bridgeGame.upBridge.clear();
        bridgeGame.downBridge.clear();
        bridgeGame.upBridge.add("[");
        bridgeGame.upBridge.add("]");
        bridgeGame.downBridge.add("[");
        bridgeGame.downBridge.add("]");
    }
}
