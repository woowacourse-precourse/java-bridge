package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final int START_PLAYER_LOCATION = 0;
    private final int START_PLAYER_TRY = 1;
    private final boolean START_PLAYER_WINNING = false;

    private Bridge bridge;
    private int playerLocation;
    private int playerTry;
    private boolean winning;

    public BridgeGame(List<String> movableSpace) {
        this.bridge = new Bridge(movableSpace);
        playerLocation = START_PLAYER_LOCATION;
        playerTry = START_PLAYER_TRY;
        winning = START_PLAYER_WINNING;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        playerLocation += 1;
    }

    public boolean checkMovable(String selectedSpace){
        return bridge.checkMovable(playerLocation, selectedSpace);
    }

    public boolean checkEnd(){
        return playerLocation == bridge.getSize();
    }
    //
    public MapDTO transferProgressMap(boolean flag, String selectedSpace) {
        // playerLocation는 현재입력 전단계까지 나오고 현재입력을 넣어 Map에 넣는다.
        List<String> currentBridge = bridge.getCurrentBridge(playerLocation);
        currentBridge.add(selectedSpace);
        return new MapDTO(currentBridge, flag);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        playerLocation = START_PLAYER_LOCATION;
        playerTry++;
    }

    public int getPlayerTry() {
        return playerTry;
    }
    public boolean getWinning() {
        return winning;
    }
    public void winning(){
        winning = true;
    }
}
