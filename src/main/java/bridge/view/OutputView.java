package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.move_result.MoveResults;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * TODO 메서드의 이름은 변경 불가!!!
 * TODO 인자와 반환 타입은 필요에 따라 추가하거나 변경 가능
 * TODO 메서드 추가 가능
 */
public class OutputView {

    private final OutputViewFormatter outputViewFormatter;

    public OutputView(OutputViewFormatter outputViewFormatter) {
        this.outputViewFormatter = outputViewFormatter;
    }

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printMap(final MoveResults moveResults) {
        System.out.println(outputViewFormatter.bridgeFormat(moveResults));
    }

    public void printResult(final BridgeGame bridgeGame, final String gameResult) {
        System.out.println(outputViewFormatter.resultFormat(bridgeGame, gameResult));
    }
}
