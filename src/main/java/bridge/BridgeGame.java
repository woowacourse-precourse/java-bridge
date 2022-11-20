package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static final String CMD_UP = "U";
    public static final String CMD_DOWN = "D";
    public static final String CMD_RETRY = "R";
    public static final String CMD_QUIT = "Q";

    private Bridge bridge;
    private int tryCount;
    private Player player;

    /**
     * 생성자
     */
    public BridgeGame() {
        player = new Player();
        bridge = null;
        tryCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String command) {
        player.move(command);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        player = new Player();
        tryCount++;
    }

    /**
     * 플레이어가 생존했는지 죽었는지 확인하는 메서드
     *
     * @return 플레이어가 생존했다면 true 죽었다면 false
     */
    public boolean isPlayerAlive() {
        if (player.getPosition() == 0 || bridge.get(player.getPosition() - 1).equals(player.getCommand())) {
            return true;
        }
        return false;
    }

    /**
     * 플레이어가 해당 게임을 승리했는지 확인하는 메서드
     *
     * @return 플레이어가 승리했다면 true 아니라면 false
     */
    public boolean isSuccess() {
        if (bridge.size() == player.getPosition()) {
            return true;
        }
        return false;
    }

    /**
     * 플레이어의 게임 결과에 맞는 스트링을 반환
     *
     * @return 승리했다면 "성공", 실패했다면 "실패"
     */
    public String getGameResultToString() {
        if (isSuccess()) {
            return "성공";
        }
        return "실패";
    }


    /**
     * 새로운 브릿지 맵을 생성하는 메서드
     *
     * @param size 브릿지 맵 크기
     */
    public void generateBridge(int size) {
        bridge = new Bridge(size, player);
    }

    public int getTryCount() {
        return tryCount;
    }

    public Bridge getBridge() {
        return bridge;
    }
}
