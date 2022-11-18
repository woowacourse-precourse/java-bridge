package bridge;

import bridge.View.OutputView;

import java.util.*;

import static java.util.stream.Collectors.joining;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> scaffold;
    private final HashMap<String, List<String>> scaffoldMap = new HashMap<>();
    private int gameRound = 0;
    private boolean survive = true;

    public BridgeGame(List<String> bridgeScaffold) {
        this.scaffold = bridgeScaffold;
        initScaffoldMap();
    }

    private void initScaffoldMap() {
        this.scaffoldMap.put("U", new ArrayList<>());
        this.scaffoldMap.put("D", new ArrayList<>());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(String direction) {
        checkRoundResult(direction);

        List<String> movingProgress = getMovingProgress(direction);

        this.gameRound++;

        return movingProgress;
    }

    private void checkRoundResult(String direction) {
        this.survive = direction.equals(this.scaffold.get(gameRound));
    }

    private List<String> getMovingProgress(String direction) {
        updateScaffordMap(direction);

        String upDirectionProgress = getProgressOfDirection("U");
        String downDirectionProgress = getProgressOfDirection("D");

        return new ArrayList<>(List.of(upDirectionProgress, downDirectionProgress));
    }

    private String getOppositeDirection(String direction) {
        if ("U".equals(direction)) {
            return "D";
        }
        return "U";
    }

    private void updateScaffordMap(String direction) {
        String oppositeDirection = getOppositeDirection(direction);
        if (!this.survive) {
            this.scaffoldMap.get(direction).add("X");
            this.scaffoldMap.get(oppositeDirection).add(" ");
        } else {
            this.scaffoldMap.get(direction).add("O");
            this.scaffoldMap.get(oppositeDirection).add(" ");
        }
    }


    private String getProgressOfDirection(String direction) {
        String progress = String.join(" | ", this.scaffoldMap.get(direction));
        return "[ " + progress + " ]";
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        initScaffoldMap();
        gameRound = 0;
    }
}
