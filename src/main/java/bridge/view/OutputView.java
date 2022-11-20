package bridge.view;

import bridge.BridgeGame;
import bridge.GameResult;
import bridge.constant.Message;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String BEGINING_BRIDGE = "[ ";
    private static final String END_BRIDGE = " ]";
    private static final String BLOCK_SEPERATOR = " | ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        GameResult gameResult = bridgeGame.getGameResult();
        System.out.println(makeBridgeFormat(gameResult.getUpperBridge().getBridge()));
        System.out.println(makeBridgeFormat(gameResult.getLowerBridge().getBridge()));
    }

    private String makeBridgeFormat(List<String> bridgeResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BEGINING_BRIDGE);
//        int i = 0;
//        while(i < bridgeResult.size() - 1) {
//            stringBuilder.append(bridgeResult.get(i));
//            stringBuilder.append(BLOCK_SEPERATOR);
//            i++;
//        }
//        stringBuilder.append(END_BRIDGE);
        for (int i = 0; i < bridgeResult.size(); i++) {
            stringBuilder.append(bridgeResult.get(i));
            if (i == bridgeResult.size() - 1) {
                stringBuilder.append(END_BRIDGE);
                break;
            }
            stringBuilder.append(BLOCK_SEPERATOR);
        }
        return stringBuilder.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printStart() {
        System.out.println(Message.START_MESSAGE);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
