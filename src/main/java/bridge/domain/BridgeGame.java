package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * TODO 필드(인스턴스 변수) 추가 가능
 * TODO 메서드 이름 변경 불가!!!!!!!
 * TODO 인자와 반환 타입은 필요에 따라 추가하거나 변경 가능
 * TODO 게임 진행을 위해 필요한 메서드를 추가하거나 변경 가능
 */
public class BridgeGame {

    public static final String OK_SIGN = "O";
    public static final String NO_SIGN = "X";

    private final Bridge bridge;
    private final Player player;
    private final GameResults gameResults;

    public BridgeGame(Bridge bridge, Player player, GameResults gameResults) {
        this.bridge = bridge;
        this.player = player;
        this.gameResults = gameResults;
    }

    public String matchResult(String movement) {
        if (bridge.isMatched(player, movement)) {
            return OK_SIGN;
        }

        // 틀리면 다시 시도 메세지!
        return NO_SIGN;
    }

    public GameResults gameResults(String movement) {
        String matchResult = matchResult(movement);
        gameResults.addResults(movement, matchResult);
        return gameResults;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * TODO 한칸씩 해당 메서드가 수행되고 결과를 반환해야 한다.
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {  // TODO 값 반환 고민..
        // movement + Player position과 Bridge 비교
        player.move();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * TODO "사용자가 재시작을 입력했을 때"라고 가정하자.
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        // 게임을 재시도 할 때는 Bridge 상태가 그대로여야 한다.
        // 하지만 플레이어의 위치는 초기화 해야 한다.
        gameResults.reset();
        player.initPosition();
        player.increaseNumberOfChallenges();  // 시도 회수 증가.
    }

    public GameResults gameResults() {
        return gameResults;
    }
}
