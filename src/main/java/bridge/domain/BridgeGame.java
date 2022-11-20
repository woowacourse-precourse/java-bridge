package bridge.domain;

import bridge.domain.calculator.BridgeCalculator;
import bridge.domain.converter.ResultConverter;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String UP = "U" ;
    private static final String DOWN = "D" ;
    private final List<String> bridge;
    private final BridgeCalculator bridgeCalculator;
    private final ResultConverter resultConverter;
    private final Processor processor;
    private PlayerBoard playerBoard;

    private int attempts;
    private boolean isComplete;
    private boolean wannaRetry;
    public BridgeGame() {
        this.attempts = 1;
        this.isComplete = true;
        this.wannaRetry = true;
        this.processor = new Processor();
        this.resultConverter = new ResultConverter();
        this.bridge = processor.startGame();
        this.playerBoard = new PlayerBoard(bridge.size());
        this.bridgeCalculator = new BridgeCalculator(bridge);
    }

    public void run() {
        do {
            if (!startRound()) {
                wannaRetry = retry();
            }
            if (!wannaRetry) {
                isComplete = false;
                break;
            }
        } while (!playerBoard.isOver());
        processor.getGameResult(isComplete, attempts, playerBoard);
    }



    private boolean startRound() {
        String inputMoving = processor.askMoving();
        int recentRound = playerBoard.getGameRound();

        boolean isCrossable = bridgeCalculator.isCrossable(recentRound, inputMoving);
        String resultValue = resultConverter.convertToMark(isCrossable);

        move(inputMoving, resultValue);
        String upsideBridge = playerBoard.getBridgeStatus(UP);
        String downsideBridge = playerBoard.getBridgeStatus(DOWN);
        processor.getRoundResult(upsideBridge,downsideBridge);
        return isCrossable;
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void move(String inputMoving, String resultValue) {
        playerBoard.addResultOfBridge(inputMoving, resultValue);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private boolean retry() {
        String choice = processor.askContinue();
        if (choice.equals("R")) {
            initBoard();
            return true;
        }
        return false;
    }

    private void initBoard() {
        attempts++;
        playerBoard = new PlayerBoard(bridge.size());
    }
}
