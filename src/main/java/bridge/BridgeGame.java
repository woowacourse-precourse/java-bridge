package bridge;

/**
 * 필드 변수 추가 가능
 * 패키지 변경 가능
 * 메서드 이름 변경 불가
 * 인자 변경 가능
 * 타입 변경 가능
 * 추가 메서드 구현 가능
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> upLine;
    private List<String> downLine;
    private List<String> bridge;

    private int bridgeIndex = 0;
    private static int countAttempt = 0;

    BridgeGame() {
        this.upLine = new ArrayList<String>();
        this.downLine = new ArrayList<String>();
    }

    public List<String> getUpLine() {
        return this.upLine;
    }
    public List<String> getDownLine() {
        return this.downLine;
    }

    public static int getCountAttempt() {
        return countAttempt;
    }

    public static void setCountAttempt() {
        countAttempt += 1;
    }


    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direction) {
        if(direction.equals("U")) {
            if(bridge.get(bridgeIndex).equals("U")) {
                this.upLine.add(" O ");
                this.downLine.add("   ");
                bridgeIndex += 1;
                return true;
            }
            this.upLine.add(" X ");
            this.downLine.add("   ");
            bridgeIndex += 1;
            return false;
        }
        if(bridge.get(bridgeIndex).equals("U")) {
            this.downLine.add(" X ");
            this.upLine.add("   ");
            bridgeIndex += 1;
            return false;
        }
        this.downLine.add(" O ");
        this.upLine.add("   ");
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
