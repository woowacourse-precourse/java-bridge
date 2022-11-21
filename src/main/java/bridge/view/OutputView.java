package bridge.view;

import static bridge.util.Message.*;

import bridge.model.BridgeGame;
import bridge.util.MessageMatch;

/**
 제공된 OutputView 클래스를 활용해 구현해야 한다.
 OutputView의 패키지는 변경할 수 있다.
 OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 public class OutputView {
 */
public class OutputView {
    public void startGame(){
        System.out.println(START_GAME);
    }
    public void printMap(BridgeGame bridgeGame) {
        System.out.println(bridgeGame.getBridgeMap());
    }

    public void printResult(BridgeGame bridgeGame, boolean flag, int totalAttempt) {
        StringBuilder sb = new StringBuilder("\n");
        sb.append(END_GAME);
        sb.append(bridgeGame.getBridgeMap());
        sb.append(MessageMatch.of(flag));
        sb.append(String.format(GAME_ATTEMPT_COUT,totalAttempt));

        System.out.println(sb.toString());
    }
}
