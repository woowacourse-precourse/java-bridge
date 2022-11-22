package bridge.view;

import bridge.data.UserBridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void printWelcome() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printChoice() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> result, String lineBreak) {
        System.out.print("[ ");
        for (int r = 0; r < result.size() - 1; r++) {
            System.out.print(result.get(r) + " | ");
        }
        System.out.println(result.get(result.size() - 1) + " ]" + lineBreak);
    }

    public void printContinue() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String challenge, int attempt, UserBridge userBridge) {
        System.out.println("최종 게임 결과");
        printMap(userBridge.getUpBridge(),"");
        printMap(userBridge.getDownBridge(),"\n");
        System.out.println("게임 성공 여부: " + challenge) ;
        System.out.print("총 시도한 횟수: " + attempt);
    }
}
