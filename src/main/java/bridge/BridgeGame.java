package bridge;

/**
 * 필드 변수 추가 가능
 * 패키지 변경 가능
 * 메서드 이름 변경 불가
 * 인자 변경 가능
 * 타입 변경 가능
 * 추가 메서드 구현 가능
 */

import bridge.Constants.BridgeShape;
import bridge.Constants.Command;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> upLine;
    private List<String> downLine;
    private int bridgeIndex;

    private static List<String> bridge;
    private static int countAttempt = 0;
    public static String RESULT = "실패";

    BridgeGame() {
        this.upLine = new ArrayList<String>();
        this.downLine = new ArrayList<String>();
        this.bridgeIndex = 0;
    }

    public boolean isFinish() {
        if(BridgeGame.bridge.size() == this.bridgeIndex) {
            return true;
        }
        return false;
    }

    public List<String> getUpLine() {
        return this.upLine;
    }
    public List<String> getDownLine() {
        return this.downLine;
    }

    public static int getCountAttempt() {
        return BridgeGame.countAttempt;
    }

    public static void setCountAttempt() {
        BridgeGame.countAttempt += 1;
    }


    public static void setBridge(List<String> bridge) {
        BridgeGame.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direction) {
        if(direction.equals(Command.UP)) {
            if(bridge.get(bridgeIndex).equals(Command.UP)) {
                this.upLine.add(BridgeShape.MOVABLE);
                this.downLine.add(BridgeShape.BLANK);
                bridgeIndex += 1;
                return true;
            }
            this.upLine.add(BridgeShape.UNMOVABLE);
            this.downLine.add(BridgeShape.BLANK);
            bridgeIndex += 1;
            return false;
        }
        if(bridge.get(bridgeIndex).equals(Command.UP)) {
            this.downLine.add(BridgeShape.UNMOVABLE);
            this.upLine.add(BridgeShape.BLANK);
            bridgeIndex += 1;
            return false;
        }
        this.downLine.add(BridgeShape.MOVABLE);
        this.upLine.add(BridgeShape.BLANK);
        bridgeIndex += 1;
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
