package bridge.model;

import bridge.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<Bridge> result = new ArrayList<>();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String userInput, String bridge) {
        Bridgelocation bridgelocation = Bridgelocation.valueOf(userInput,
                Utility.StringEquals(userInput, bridge));
        validate(bridgelocation);
        result.add(bridgelocation.getBridge());
    }

    private void validate(Bridgelocation bridgelocation) {
        if (bridgelocation == Bridgelocation.ERROR) {
            throw new IllegalArgumentException("[ERROR] 잘못된 값입니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Boolean retry(String userInput) {
        if (userInput.equals("R")) {
            result.clear();
            return true;
        }
        return false;
    }

    public StringBuilder upline() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        result.forEach(bridge -> sb.append(" ").append(bridge.getUp()).append(" |"));
        sb.deleteCharAt(sb.length() - 1).append("]");
        return sb;
    }

    public StringBuilder downline() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        result.forEach(bridge -> sb.append(" ").append(bridge.getDown()).append(" |"));
        sb.deleteCharAt(sb.length() - 1).append("]");
        return sb;
    }

    public List<Bridge> getResult() {
        return result;
    }

}
