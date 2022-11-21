package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private BridgeMaker bridgeMaker;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public BridgeGame() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    }
    public int move(String command) {
        if(!command.equals("U") && !command.equals("D")) {
            throw new IllegalArgumentException("[Error] u 또는 D를 입력해주세요");
        }

        return upOrDown(command);
    }

    public int upOrDown(String commnad) {
        if(commnad.equals("D")) {//down
            return 0;
        }
        return 1;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        if(!command.equals("Q") && !command.equals("R")) {
            throw new IllegalArgumentException("[Error] R 또는 Q를 입력해주세요");
        }

        return isRetry(command);
    }

    public boolean isRetry(String command) {
        if(command.equals("R")) {
            return true;
        }
        return false;
    }
}
