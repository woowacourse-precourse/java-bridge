package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final InputView inputView;
    public BridgeGame(InputView inputView){
        this.inputView = inputView;
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<String> rightBridge, PlayerBridge playerBridge) {
        for (String rightRoot : rightBridge) {
            String moving = inputView.readMoving();
            compareRightRoot(playerBridge, rightRoot, moving);
            compareWrongRoot(playerBridge, rightRoot, moving);
        }
    }

    private static void compareWrongRoot(PlayerBridge playerBridge, String rightRoot, String moving) {
        if(isWrongAndUpRoot(rightRoot, moving)){
            playerBridge.addUpRoot("X");
            playerBridge.addDownRoot(" ");
        }
        if (isWrongAndDownRoot(rightRoot, moving)){
            playerBridge.addDownRoot("X");
            playerBridge.addUpRoot(" ");
        }
    }
    private static void compareRightRoot(PlayerBridge playerBridge, String rightRoot, String moving) {
        if(isRightAndUpRoot(rightRoot, moving)) {
            playerBridge.addUpRoot(moving);
            playerBridge.addDownRoot(" ");
        }
        if (isRightAndDownRoot(rightRoot, moving)){
            playerBridge.addDownRoot("O");
            playerBridge.addUpRoot(" ");
        }
    }
    private static boolean isWrongAndDownRoot(String rightRoot, String moving) {
        return !moving.equals(rightRoot) && moving.equals("D");
    }

    private static boolean isWrongAndUpRoot(String rightRoot, String moving) {
        return !moving.equals(rightRoot) && moving.equals("U");
    }

    private static boolean isRightAndDownRoot(String rightRoot, String moving) {
        return moving.equals(rightRoot) && moving.equals("D");
    }

    private static boolean isRightAndUpRoot(String rightRoot, String moving) {
        return moving.equals(rightRoot) && moving.equals("U");
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals("R")) return true;
        if (gameCommand.equals("Q")) return false;
        return true;
    }

}
