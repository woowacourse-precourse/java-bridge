package bridge.game;

import bridge.generator.BridgeMaker;
import bridge.generator.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.TotalView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private final GameCharacter character;
    private final TotalView totalView = new TotalView(new InputView(), new OutputView());
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final String RETRY = "R";

    private boolean success = false;
    private int totalTry = 0;
    private int bridgeSize;
    private List<Progress> gameProgress = new ArrayList<>();
    private List<String> bridge;

    public BridgeGame(GameCharacter character) {
        this.character = character;
    }

    public void repeatReadyUntilProperBridgeSize() {
        try {
            totalView.out().enterBridgeSize();
            bridgeSize = totalView.in().readBridgeSize();
        } catch (IllegalArgumentException e) {
            totalView.out().printError(e);
            repeatReadyUntilProperBridgeSize();
        }
    }

    public void ready() {
        totalView.out().start();
        repeatReadyUntilProperBridgeSize();
        setBridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public void play() {
        totalTry++;
        int result = Result.CONTINUE.getStatus();
        while (result == Result.CONTINUE.getStatus()) {
            repeatCycleUntilProperMove();
            result = cycleResult();
        }
        if (result == Result.FAIL.getStatus()) {
            repeatRetryOrQuitUntilProperCommand();
        }
        success = true;
    }

    public void repeatCycleUntilProperMove() {
        try {
            cycle();
        } catch (IllegalArgumentException e) {
            totalView.out().printError(e);
            repeatCycleUntilProperMove();
        }
    }

    public void cycle() {
        totalView.out().enterMove();
        String move = totalView.in().readMoving();
        character.setNextMove(move);
        move();
        saveProgress();
        totalView.out().printMap(this);
    }

    public void move() {
        character.move();
    }

    public int cycleResult() {
        int progressCount = gameProgress.size();
        if (!gameProgress.get(progressCount - 1).isSuccess()) {
            return Result.FAIL.getStatus();
        }
        if (progressCount == bridgeSize) {
            return Result.SUCCESS.getStatus();
        }
        return Result.CONTINUE.getStatus();
    }

    public void repeatRetryOrQuitUntilProperCommand() {
        try {
            retryOrQuit();
        } catch (IllegalArgumentException e) {
            totalView.out().printError(e);
            repeatRetryOrQuitUntilProperCommand();
        }
    }

    public void retryOrQuit() {
        totalView.out().enterGameCommand();
        String gameCommand = totalView.in().readGameCommand();
        if (gameCommand.equals(RETRY)) {
            retry();
        }
    }

    public void saveProgress() {
        String destination = character.showNextDestination();
        Progress progress = makeProgress(destination, isAbleToMove());
        gameProgress.add(progress);
    }

    public Progress makeProgress(String destination, boolean result) {
        return new Progress(destination, result);
    }

    public List<Progress> showCurrentResult() {
        return new ArrayList<>(gameProgress);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        setBridge(bridgeMaker.makeBridge(bridgeSize));
        gameProgress.clear();
        character.reset();
        play();
    }

    public void showResult() {
        totalView.out().printResult(this);
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public String showRightDestinationInArea(int area) {
        return bridge.get(area);
    }

    public boolean isAbleToMove() {
        int nextArea = character.showNextArea();
        String nextMove = character.showNextDestination();
        return showRightDestinationInArea(nextArea).equals(nextMove);
    }

    public String showSuccess() {
        if (success) {
            return Result.SUCCESS.getKorean();
        }
        return Result.FAIL.getKorean();
    }

    public int showTotalTry() {
        return totalTry;
    }
}
