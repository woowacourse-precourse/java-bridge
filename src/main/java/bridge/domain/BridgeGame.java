package bridge.domain;

import bridge.domain.calculator.BridgeCalculator;
import bridge.domain.converter.ResultConverter;
import bridge.ui.InputView;
import bridge.ui.OutputView;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String UP = "U" ;
    private static final String DOWN = "D" ;
    private final List<String> bridge;
    private final InputView input;
    private final OutputView output;
    private final BridgeCalculator bridgeCalculator;
    private final ResultConverter resultConverter;
    private PlayerBoard playerBoard;

    private int attempts;
    private boolean isComplete;
    private boolean wannaRetry;
    public BridgeGame(final OutputView output, final InputView input, final List<String> bridge) {
        this.input = input;
        this.output = output;
        this.bridge = bridge;
        this.attempts = 1;
        this.isComplete = true;
        this.wannaRetry = true;
        this.playerBoard = new PlayerBoard(bridge.size());
        this.bridgeCalculator = new BridgeCalculator(bridge);
        this.resultConverter = new ResultConverter();
    }

    public void quitGame(boolean isComplete) {
        output.printResult(isComplete, attempts, playerBoard);
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
        quitGame(isComplete);
    }

    public void initBoard() {
        attempts++;
        playerBoard = new PlayerBoard(bridge.size());
    }

    public boolean startRound() {
        String inputMoving = getMoving();
        int recentRound = playerBoard.getGameRound();

        boolean isCrossable = bridgeCalculator.isCrossable(recentRound, inputMoving);
        String resultValue = resultConverter.convertToMark(isCrossable);

        move(inputMoving, resultValue);
        String upsideBridge = playerBoard.getBridgeStatus(UP);
        String downsideBridge = playerBoard.getBridgeStatus(DOWN);
        output.printMap(upsideBridge, downsideBridge);
        return isCrossable;
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String inputMoving, String resultValue) {
        playerBoard.addResultOfBridge(inputMoving, resultValue);
    }

    public String getMoving(){
        String moving;
        do{
            moving = input.readMoving();
        }while (moving.equals("error"));
        return moving ;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String choice = getContinue();
        if (choice.equals("R")) {
            initBoard();
            return true;
        }
        return false;
    }
    public String getContinue(){
        String choice;
        do{
            choice = input.readContinue();
        }while (choice.equals("error"));
        return choice ;
    }
}
