package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> answer, List<String> user) {
        printBridgeState(answer,user,"U");
        printBridgeState(answer,user,"D");
        System.out.println();
    }

    public void printBridgeState(List<String> answer, List<String> user, String direction) {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < user.size(); i++,result.append("|"))
            result.append(getOorX(user.get(i).equals(direction),user.get(i).equals(answer.get(i))));
        result.deleteCharAt(result.length()-1);
        result.append("]");
        System.out.println(result.toString());
    }

    public String getOorX(boolean ans, boolean equal) {
        if (!ans)
            return "   ";
        if (ans & equal)
            return " O ";
        return " X ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> answer, List<String> user, int reTryCount) {
        System.out.println("최종 게임 결과");
        printMap(answer,user);
        System.out.println("게임 성공 여부: 성공");
        System.out.println("총 시도한 횟수: " + reTryCount);
    }

    public void printStartGame() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printGetBridgeLength() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printMoveDirection() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
