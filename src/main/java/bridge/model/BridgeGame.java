package bridge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<Bridge> result = new ArrayList<>();

    public void move(String userInput, String bridge) {
        Bridgelocation bridgelocation = Bridgelocation.valueOf(userInput,userInput.equals(bridge));
        validate(bridgelocation);
        result.add(bridgelocation.getBridge());
    }

    private void validate(Bridgelocation bridgelocation) {
        if (bridgelocation == Bridgelocation.ERROR) {
            throw new IllegalArgumentException("[ERROR] 잘못된 값입니다.");
        }
    }

    public Boolean retry(String userInput) {
        if (userInput.equals("R")) {
            result.clear();
            return true;
        }
        return false;
    }

    public String gameSuccessMessage() {
        if (failCheck()) {
            return "실패";
        }
        return "성공";
    }

    public boolean failCheck(){
        return result.contains(Bridgelocation.UPX.getBridge()) || result.contains(Bridgelocation.DOWNX.getBridge());
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
