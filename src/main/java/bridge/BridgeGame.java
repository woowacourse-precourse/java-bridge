package bridge;

import domain.Bridge;
import enums.InputEnum;
import enums.ResultMessage;
import view.InputView;
import view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    final InputView inputView = new InputView();
    final OutputView outputView = new OutputView();
    final Bridge bridge = new Bridge();
    BridgeGame(){
        System.out.println(InputEnum.START_BRIDGE_GAME.getValue());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(final List<String> bridgeAnswer, int position) {
        while (true) {
            final String moving = inputView.readMoving();
            if( bridgeAnswer.get(position).equals(moving) ){
                outputView.printMap();
                position++;
                continue;
            }

            outputView.printMapWhenFail();
            retry();
            // 틀리면 -> 틀린 다리 상태 출력 & RETRY() 호출
        }

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        String retrial = inputView.readGameCommand();
        if(retrial.equals("Q")) {
            System.out.println(ResultMessage.RESULT_INTRO_TEXT.getText());
            outputView.printResult();
            return;
        }
        start();
    }

    public void start() {
        final int size = inputView.readBridgeSize();
        final List<String> bridgeAnswer = bridgeMaker.makeBridge(size);
        move(bridgeAnswer, 1);

    }
}
