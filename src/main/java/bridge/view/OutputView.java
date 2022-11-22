package bridge.view;

import bridge.constant.OutputMessage;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameResults;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final OutputViewConverter outputViewConverter;

    public OutputView(OutputViewConverter outputViewConverter) {
        this.outputViewConverter = outputViewConverter;
    }

    public void printStartMessage() {
        System.out.println(OutputMessage.START_MESSAGE.getMessage());
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(final BridgeGameResults bridgeGameResults) {
        System.out.println(outputViewConverter.bridgeFormat(bridgeGameResults));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println(outputViewConverter.finalResultFormat(bridgeGame));
    }
}
