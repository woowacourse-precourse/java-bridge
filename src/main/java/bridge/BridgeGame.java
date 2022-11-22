package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> upBridge = new ArrayList<>();
    private List<String> downBridge = new ArrayList<>();
    public int needRestart = 0;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String correctBridge, String playerMove) {
        if(playerMove.equals("U") == true) {
            upMove(correctBridge, playerMove);
        } if (playerMove.equals("D") == true) {
            downMove(correctBridge, playerMove);
        }
    }

    public static List<String> makeCorrectBridge(int bridgeSize) {
        BridgeRandomNumberGenerator random = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(random);
        List<String> correctBridge = bridgeMaker.makeBridge(bridgeSize);
        return correctBridge;
    }

    private String compareCanMoveSquare(String correctBridgeSquare, String playerMove) {
        String result = "O";
        if(correctBridgeSquare.equals(playerMove) == false ) {
            result = "X";
        }
        return result;
    }

    private void upMove(String correctBridge, String playerMove) {
        if (compareCanMoveSquare(correctBridge, playerMove).equals("O") == true) {
            this.upBridge.add(" O ");
            this.downBridge.add("   ");
        }
        if (compareCanMoveSquare(correctBridge, playerMove).equals("O") == false) {
            this.upBridge.add(" X ");
            this.downBridge.add("   ");
            this.needRestart += 1;
        }
    }

    private void downMove(String correctBridge, String playerMove){
        if (compareCanMoveSquare(correctBridge, playerMove).equals("O") == true) {
            this.upBridge.add("   ");
            this.downBridge.add(" O ");
        } if (compareCanMoveSquare(correctBridge, playerMove).equals("O") == false) {
            this.upBridge.add("   ");
            this.downBridge.add(" X ");
            this.needRestart += 1;
        }
    }

    public List<String> getUpBridge() {
        return this.upBridge;
    }

    public List<String> getDownBridge() {
        return this.downBridge;
    }

    public int getNeedRestart() {
        return this.needRestart;
    }

    public void clearBridge() { //재시도시 리스트 초기화
        this.upBridge.clear();
        this.downBridge.clear();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static int retry(String playerCommand) {
        int quitCommand = 0;
        if (playerCommand.equals("Q")) {
            quitCommand = 1;
        }
        return quitCommand;
    }
}
