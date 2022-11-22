package bridge.domain;

import bridge.domain.calculator.BridgeCalculator;
import bridge.domain.converter.ResultConverter;
import bridge.util.Directions;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeCalculator bridgeCalculator;
    private final ResultConverter resultConverter;
    private final Processor processor;
    private final List<String> bridge;

    private PlayerBoard playerBoard;
    private boolean isComplete;
    private boolean wannaRetry;
    private int attempts;

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

    /**
     * Bridge 게임을 실행하는 메서드이다.
     * <p>
     *     * 해당 게임의 정답 Bridge에 대해 플레이어가 모두 건널 때까지 반복한다.<br/>
     *     1. 한 라운드가 끝나고 {@link #startRound()}의 결과 (<strong>조건문 1</strong>)<br/>
     *     &nbsp&nbsp - {@code false}일 때, 재시도 여부를 묻게끔 한다.<br/>
     *     2. 재시도 여부({@link #wannaRetry}) 값을 확인한다.(<strong>조건문 2</strong>)<br/>
     *     &nbsp&nbsp - {@code false}일 때, {@link #isComplete}를 .{@code false}로 초기화하고 반복문을 {@code break}한다<br/>
     *     <br/>
     *     * 반복문이 종료되면 {@link #isComplete}, {@link #attempts}, {@link #playerBoard} 를 기반으로<br/>
     *     최종 결과를 출력한다.
     * </p>
     * @see #startRound()
     * @see #retry()
     * @see PlayerBoard#isOver()
     * @see Processor#getGameResult(boolean, int, PlayerBoard)
     */
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

    /**
     * 한 라운드를 처리한다.
     * <p>
     *     1. 플레이어의 이동 방향을 입력받는다.{@link Processor#askMoving()} <br/>
     *     2. 현재 진행 라운드를 알아낸다.{@link PlayerBoard#getGameRound()} <br/>
     *     3. 플레이어의 이동 방향이 건널 수 있는지 여부를 확인한다.{@link Processor#askMoving()} <br/>
     *     4. 플레이어의 이동 성공 여부를 기호로 변환한다.{@link ResultConverter#convertToMark(boolean)} <br/>
     *     5. 이동 결과를 PlayerBoard에 반영한다.{@link #move(String, String)} <br/>
     *     6. 반영된 해당 라운드에 대한 PlayerBoard 결과를 출력한다.{@link #showRoundResult(PlayerBoard)} <br/>
     *     7. 게임 진행 여부를 위한 3번 과정의 결과를 반환한다.
     * </p>
     * @return {@link #isComplete} : 해당 라운드에서 다리를 건너는 것에 대한 성공/실패 여부
     * @see Processor
     * @see ResultConverter#convertToMark(boolean)
     * @see BridgeCalculator#isCrossable(int, String)
     * @see PlayerBoard#getBridgeStatus(String)
     */
    private boolean startRound() {
        String inputMoving = processor.askMoving();
        int recentRound = playerBoard.getGameRound();
        boolean isCrossable = bridgeCalculator.isCrossable(recentRound, inputMoving);
        String roundResult = resultConverter.convertToMark(isCrossable) ;
        
        move(inputMoving, roundResult);
        showRoundResult(playerBoard);
        return isCrossable;
    }
    
    private void showRoundResult(PlayerBoard playerBoard){
        String upsideBridge = playerBoard.getBridgeStatus(Directions.UP.getValue());
        String downsideBridge = playerBoard.getBridgeStatus(Directions.DOWN.getValue());
        processor.getRoundResult(upsideBridge, downsideBridge);
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
     * @return {@link #wannaRetry} : 재시도 여부
     */
    private boolean retry() {
        String choice = processor.askContinue();
        if (choice.equals("R")) {
            initBoard();
            return true;
        }
        return false;
    }

    /**
     * 시도횟수({@link #attempts})를 1 증가시키고<br/>
     * 사용하던 PlayerBoard({@link #playerBoard})도 초기화한다.
     */
    private void initBoard() {
        attempts++;
        playerBoard = new PlayerBoard(bridge.size());
    }
}
