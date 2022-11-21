package bridge.view;

import bridge.Util;
import bridge.controller.BridgeGame;
import bridge.enums.BridgeFrame;
import bridge.enums.Message;
import bridge.enums.UpDown;
import bridge.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        List<String> answerBridge = bridgeGame.getAnswerBridge();
        List<String> playerBridge = bridgeGame.getPlayerBridge();
        List<String> upSpace = getUpSpace(answerBridge, playerBridge);
        List<String> downSpace = getDownSpace(answerBridge, playerBridge);
        System.out.println(getBridgeFormat(upSpace));
        System.out.println(getBridgeFormat(downSpace));
    }

    private List<String> getUpSpace (List<String> answer, List<String> player) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < player.size(); i++) {
            if (UpDown.isDown(player.get(i))) {
                result.add(BridgeFrame.BLANK.getValue());
            } else if (UpDown.isUp(player.get(i)) && Util.valueEqualCheck(answer, player, i)) {
                result.add(BridgeFrame.TRUE.getValue());
            } else if (UpDown.isUp(player.get(i)) && !Util.valueEqualCheck(answer, player, i)) {
                result.add(BridgeFrame.FALSE.getValue());
            }
        }
        return result;
    }

    private List<String> getDownSpace (List<String> answer, List<String> player) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < player.size(); i++) {
            if (UpDown.isUp(player.get(i))) {
                result.add(BridgeFrame.BLANK.getValue());
            } else if (UpDown.isDown(player.get(i)) && Util.valueEqualCheck(answer, player, i)) {
                result.add(BridgeFrame.TRUE.getValue());
            } else if (UpDown.isDown(player.get(i)) && !Util.valueEqualCheck(answer, player, i)) {
                result.add(BridgeFrame.FALSE.getValue());
            }
        }
        return result;
    }

    private String getBridgeFormat(List<String> space) {
        String separateSpace = String.join(BridgeFrame.DIV.getValue(), space);
        return BridgeFrame.FRONT.getValue() + separateSpace + BridgeFrame.BACK.getValue();
    }


//    public void printMap(List<String> bridge, Player player) {
//        StringBuilder upSpace = new StringBuilder();
//        StringBuilder downSpace = new StringBuilder();
//        List<String> playerBridge = player.getBridge();
//        upSpace.append(BridgeFrame.FRONT.getValue());
//        downSpace.append(BridgeFrame.FRONT.getValue());
//        for (int i = 0; i < playerBridge.size(); i++) {
//            String playerDirection = playerBridge.get(i);
//            if (playerDirection.equals(UpDown.UP.getStrValue()) && playerDirection.equals(bridge.get(i))) {
//                upSpace.append(BridgeFrame.TRUE.getValue());
//                downSpace.append(BridgeFrame.BLANK.getValue());
//            } else if (playerDirection.equals(UpDown.DOWN.getStrValue()) && playerDirection.equals(bridge.get(i))) {
//                downSpace.append(BridgeFrame.TRUE.getValue());
//                upSpace.append(BridgeFrame.BLANK.getValue());
//            } else if (playerDirection.equals(UpDown.UP.getStrValue()) && !playerDirection.equals(bridge.get(i))) {
//                upSpace.append(BridgeFrame.FALSE.getValue());
//                downSpace.append(BridgeFrame.BLANK.getValue());
//                break;
//            } else if (playerDirection.equals(UpDown.DOWN.getStrValue()) && !playerDirection.equals(bridge.get(i))) {
//                downSpace.append(BridgeFrame.FALSE.getValue());
//                upSpace.append(BridgeFrame.BLANK.getValue());
//                break;
//            }
//        }
//    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) { // TODO 수정 필요
        System.out.println(Message.GAME_RESULT_PREV_MSG.getMessage());
        printMap(bridgeGame);
        System.out.println();
        System.out.println(Message.GAME_RESULT_STATE_MSG );
    }

    public void printStatusResult() { // TODO 수정 필요
        System.out.println(Message.GAME_RESULT_STATE_MSG.getMessage() + "");
        System.out.println(Message.GAME_RESULT_TRY_MSG.getMessage() + "");
    }


    public void printMessage(Message message){
        System.out.println(message.getMessage());
    }
}
