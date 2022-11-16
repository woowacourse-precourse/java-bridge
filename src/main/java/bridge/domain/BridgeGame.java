package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * TODO 필드(인스턴스 변수) 추가 가능
 * TODO 메서드 이름 변경 불가!!!!!!!
 * TODO 인자와 반환 타입은 필요에 따라 추가하거나 변경 가능
 * TODO 게임 진행을 위해 필요한 메서드를 추가하거나 변경 가능
 */
public class BridgeGame {

    public static final String PASS_SIGN = "O";
    public static final String FAIL_SIGN = "X";

    private final Bridge bridge;
    private final Player player;
    private final GameResults gameResults;

    public BridgeGame(Bridge bridge, Player player, GameResults gameResults) {
        this.bridge = bridge;
        this.player = player;
        this.gameResults = gameResults;
    }

    public String matchResult(String moveSign) {
        if (bridge.isMatched(player, moveSign)) {
            return PASS_SIGN;
        }

        return FAIL_SIGN;
    }

    public GameResults gameResults(String moveSign, String resultSign) {
        gameResults.addResults(moveSign, resultSign);
        return gameResults;
    }

    public boolean ongoing(int bridgeSize) {
        return player.inTheGame(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        player.move();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        gameResults.reset();
        player.initPosition();
        player.increaseNumberOfChallenges();
    }

    public GameResults gameResults() {
        return gameResults;
    }

    public Player player() {
        return player;
    }
}
