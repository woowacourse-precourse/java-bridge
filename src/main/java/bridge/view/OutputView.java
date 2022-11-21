package bridge.view;

import bridge.model.constant.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private List<String> upside = new ArrayList<>();
    private List<String> downside = new ArrayList<>();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String move, boolean result) {
        upside.add(addUpside(move, result));
        downside.add(addDownside(move, result));
        System.out.println("[ " + String.join(" | ", upside) + " ]");
        System.out.println("[ " + String.join(" | ", downside) + " ]\n");
    }

    public String addUpside(String move, boolean result) {
        if (move.equals(Message.UP.getMessage()) && result) {
            return Message.SUCCESS.getMessage();
        }
        if (move.equals(Message.UP.getMessage())) {
            return Message.FAIL.getMessage();
        }
        return Message.EMPTY.getMessage();
    }

    public String addDownside(String move, boolean result) {
        if (move.equals(Message.DOWN.getMessage()) && result) {
            return Message.SUCCESS.getMessage();
        }
        if (move.equals(Message.DOWN.getMessage())) {
            return Message.FAIL.getMessage();
        }
        return Message.EMPTY.getMessage();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printStartGame() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printInputBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printInputMove() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }
}
