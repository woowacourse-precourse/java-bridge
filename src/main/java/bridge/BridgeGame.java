package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */

public class BridgeGame {
    public final List<String> board;
    public int step;
    public int retryNum;
    public boolean result;

    public BridgeGame(int boardSize){
        BridgeRandomNumberGenerator randomGenerator = new BridgeRandomNumberGenerator();
        board = new BridgeMaker(randomGenerator).makeBridge(boardSize);
        step = 0;
        retryNum = 0;
        result = true;
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String move) {
        validateMove(move);
        result = board.get(step).equals(move);
        step += 1;
    }

    private void validateMove(String move){
        if(!(move.equals("U") || move.equals("D")))
            throw new IllegalArgumentException();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        validateRetry(command);
        if(command.equals("R")){
            step = 0;
            retryNum += 1;
            result = true;
            return true;
        }
        return false;
    }

    private void validateRetry(String command){
        if(!(command.equals("R") || command.equals("Q")))
            throw new IllegalArgumentException();
    }

    public boolean clear(){
        return step <= board.size()-1;
    }
}
