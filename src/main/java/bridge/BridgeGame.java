package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    static List<String> result = new ArrayList<>();
    static List<String> bridge;
    static StringBuilder upResult;
    static StringBuilder downResult;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * @param direction 사용자의 입력방향
     * @param index 현재 건너는 칸 수
     */
    public static void move(String direction, int index) {
        String answer = bridge.get(index);
        result.add(direction);
        if (direction.equals(answer)) {
            printMove(result, true);
        }
        if (!direction.equals(answer)) {
            printMove(result,false);
            // 재시작
        }
    }
    private static void printMove(List<String> result, boolean thisturn) {
        upResult = new StringBuilder("[");
        downResult = new StringBuilder("[");
        prePrint();
        nowPrint(thisturn);
        upResult.append("]");
        downResult.append("]");
        System.out.println(upResult);
        System.out.println(downResult);
    }
    private static void prePrint() {
        for (int index=0; index<result.size()-1; index++) {
            if (result.get(index).equals("U")) {
                upTrue();
            }
            if (result.get(index).equals("D")) {
                downTrue();
            }
            upResult.append("|");
            downResult.append("|");
        }
    }
    private static void nowPrint(boolean thisturn) {
        if (thisturn) {
            nowTrue();
        }
        if (!thisturn) {
            nowFalse();
        }
    }
    private static void upTrue() {
        upResult.append(" O ");
        downResult.append("   ");

    }
    private static void upFalse() {
        upResult.append(" X ");
        downResult.append("   ");
    }
    private static void downTrue() {
        upResult.append("   ");
        downResult.append(" O ");
    }
    private static void downFalse() {
        upResult.append("   ");
        downResult.append(" X ");
    }
    private static void nowTrue() {
        if (result.get(result.size()-1).equals("U")) {
            upTrue();
        }
        if (result.get(result.size()-1).equals("D")) {
            downTrue();
        }
    }
    private static void nowFalse() {
        if (result.get(result.size()-1).equals("U")) {
            upFalse();
        }
        if (result.get(result.size()-1).equals("D")) {
            downFalse();
        }
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
