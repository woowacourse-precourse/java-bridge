package bridge.view;

import bridge.domain.BridgeGame;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private BridgeGame bridgeGame = new BridgeGame();

    public void printMap(List<String> correctBridge) {
        for(int i=0; i<correctBridge.size(); i++) {
            String playerMove = InputView.readMoving();
            bridgeGame.move(correctBridge.get(i), playerMove);
            String strUp =  String.join("|", bridgeGame.getUpBridge());
            String strDown =  String.join("|", bridgeGame.getDownBridge());
            System.out.println("["+strUp+"]");
            System.out.println("["+strDown+"]");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
