package bridge.domain;

import bridge.BridgeMaker;
import bridge.dto.BridgeGameResultDto;
import bridge.dto.PlayLogDto;
import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public final class BridgeGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final Bridge bridge;
    private int triedCount = 0;

    public BridgeGame(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridge = setUpBridge(bridgeMaker);
    }

    private Bridge setUpBridge(BridgeMaker bridgeMaker) {
        try {
            outputView.printInitialMessage();
            outputView.printAskBridgeLength();
            int size = inputView.readBridgeSize();
            return new Bridge(bridgeMaker.makeBridge(size));
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return setUpBridge(bridgeMaker);
        }
    }

    public void play() {
        ControllerCommand playerChoice = ControllerCommand.RETRY;
        Visited result = new Visited();
        while (playerChoice != ControllerCommand.QUIT) {
            result = new Visited();
            playerChoice = playOneGame(result);
            triedCount++;
        }
        finish(result);
    }

    private ControllerCommand playOneGame(Visited visited) {
        while (visited.isRemained(bridge)) {
            move(visited);
        }
        return retry(visited);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void move(Visited visited) {
        Position moving = askMoving();
        visited.move(moving, bridge);
        outputView.printMap(new PlayLogDto(visited.printVisited()));
    }

    private Position askMoving() {
        try {
            outputView.printMoving();
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return askMoving();
        }
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private ControllerCommand retry(Visited visited) {
        if (isGameCleared(visited)) {
            return askRetry();
        }
        return ControllerCommand.QUIT;
    }

    private boolean isGameCleared(Visited visited) {
        return visited.result(bridge) != GameResult.SUCCESS;
    }

    private ControllerCommand askRetry() {
        try {
            outputView.printAskRetry();
            return inputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return askRetry();
        }
    }

    private void finish(Visited visited) {
        PlayLogDto log = new PlayLogDto(visited.printVisited());
        GameResult gameResult = visited.result(bridge);
        outputView.printResult(new BridgeGameResultDto(triedCount, log, gameResult));
    }
}
