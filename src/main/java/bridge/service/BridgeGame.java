package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.Constants;
import bridge.domain.RoundResult;
import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final BridgeMapMaker bridgeMapMaker;

    private RoundResult roundResult;
    private String command;
    private int round = 0;
    private int trial = 1;

    public BridgeGame() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        this.bridge = new Bridge(bridgeMaker);
        this.bridgeMapMaker = new BridgeMapMaker();
    }

    public void run() {
        proceedRound();
        OutputView.printResult();
    }

    private void proceedRound() {
        while (!bridge.isArriveEnd(round) || bridge.isCorrectCell(command, round)) {
            if (!move()) break;
            round++;

            if (round == bridge.getBridgeSize()) break;
            bridgeMapMaker.renewBridgeMap(roundResult);
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        command = InputView.readMoving();
        roundResult = RoundResult.valueOf(command, bridge.getCorrectCell(round));
        OutputView.printMap(bridgeMapMaker, roundResult);

        if (!roundResult.equals(RoundResult.SELECTED_UPPER_CASE_IF_CORRECT)
                && !roundResult.equals(RoundResult.SELECTED_LOWER_CASE_IF_CORRECT)) return retry();

        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private boolean retry() {
        if (InputView.readGameCommand()
                .equals(Constants.RETRY_COMMAND)) {

            trial++;
            return move();
        }

        return false;
    }
}
