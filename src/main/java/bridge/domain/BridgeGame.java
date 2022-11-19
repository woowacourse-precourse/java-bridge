package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.calculator.BridgeCalculator;
import bridge.domain.converter.ResultConverter;
import bridge.ui.InputView;
import bridge.ui.OutputView;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final InputView input;
    private final OutputView output;
    private final ResultConverter resultConverter;
    private PlayerBoard playerBoard;
    private int attempts;
    public BridgeGame(final OutputView output, final InputView input, final List<String> bridge) {
        this.input = input;
        this.output = output;
        this.bridge = bridge;
        this.playerBoard = new PlayerBoard();
        this.resultConverter = new ResultConverter();
        this.attempts = 1;
    }
    public void run() {
    }

    public void initBoard() {
        attempts++;
        playerBoard = new PlayerBoard();
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
