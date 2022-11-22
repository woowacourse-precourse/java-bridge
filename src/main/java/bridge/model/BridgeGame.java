package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final static String STEP_EMPTY = " ";
    private final static String STEP_CORRECT = "O";
    private final static String STEP_WRONG = "X";
    Bridge answerMove;
    List<String> playerMove;
    GameStatus status;

    public BridgeGame(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.answerMove = new Bridge(bridgeMaker.makeBridge(size));
        this.playerMove = new ArrayList<>();
        this.status = GameStatus.SUCCESS;
    }

    public GameStatus getStatus() {
        return this.status;
    }

    public boolean isEnd() {
        return playerMove.equals(answerMove.getBridge());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        InputView inputView = new InputView();
        String step = inputView.readMoving();
        playerMove.add(step);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.playerMove = new ArrayList<>();
        this.status = GameStatus.SUCCESS;
    }

    /**
     * 다리들의 정답 결과를 가져오는 메소드
     * <p>
     * 각 다리의 생성 순서는 Move enum의 상수 순서이다.
     */
    public List<List<String>> getGameMap() {
        return Arrays.stream(Move.values())
                .map(move -> makeEachBridge(move.getCommand()))
                .collect(Collectors.toList());
    }

    private List<String> makeEachBridge(String way) {
        List<String> result = new ArrayList<>();

        for (int index = 0; index < playerMove.size(); index++) {
            String resultStep = checkStep(way, playerMove.get(index), answerMove.getBridge().get(index));
            result.add(resultStep);
        }
        return result;
    }

    private String checkStep(String way, String playerStep, String answerStep) {
        if (!way.equals(playerStep)) {
            return STEP_EMPTY;
        }
        return checkSameStep(playerStep, answerStep);
    }

    private String checkSameStep(String playerStep, String answerStep) {
        if (!answerStep.equals(playerStep)) {
            this.status = GameStatus.FAIL;
            return STEP_WRONG;
        }
        return STEP_CORRECT;
    }
}
