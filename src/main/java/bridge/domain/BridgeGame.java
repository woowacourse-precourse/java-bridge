package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.enums.MoveResult;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * 제공된 BridgeGame 클래스를 활용해 구현해야 한다.
 * BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다.
 * BridgeGame의 패키지는 변경할 수 있다.
 * BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.
 */
public class BridgeGame {

    private List<String> answerBridge;
    private List<String> guessBridge;
    private Integer tryCount;

    private BridgeGame(int size) {
        this.answerBridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
        this.guessBridge = new ArrayList<>();
        this.tryCount = 1;
    }

    public static BridgeGame initNewGame(int size) {
        return new BridgeGame(size);
    }

    public Integer getTryCount() {
        return tryCount;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveResult move(String userDirection) {
        guessBridge.add(userDirection);

        if (isValidDirection()) {
            return MoveResult.ANSWER;
        }

        return MoveResult.NOT_ANSWER;
    }

    private boolean isValidDirection() {
        Integer lastGuessIndex = guessBridge.size() - 1;
        String answer = answerBridge.get(lastGuessIndex);
        String guess = guessBridge.get(lastGuessIndex);

        return answer.equals(guess);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        guessBridge.clear();
        tryCount += 1;
    }

    public boolean reachOppositeSide() {
        return answerBridge.size() == guessBridge.size();
    }

    public List<Check> getChecks() {
        List<Check> roundResult = new ArrayList<>();

        for (int index = 0; index < guessBridge.size(); index++) {
            Check checkResult = Check.getGuessResult(answerBridge.get(index), guessBridge.get(index));
            roundResult.add(checkResult);
        }

        return roundResult;
    }
}
