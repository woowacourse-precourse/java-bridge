package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.MoveResults;

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

    public void printResult(final BridgeGame bridgeGame) {
        System.out.println(outputViewFormatter.resultFormat(bridgeGame));
    }
}
