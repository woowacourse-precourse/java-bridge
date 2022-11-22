package bridge.view;

import java.util.List;
import java.util.Stack;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<Stack> stairs) {
        for (Stack stair : stairs) {
            for (Object o : stair) {
                System.out.print(o + "");
            }
            System.out.println();
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<Stack> stairs, int runCnt, boolean isSuccess) {
        System.out.println("\n최종 게임 결과");
        printMap(stairs);
        String success = convertBooleanToStr(isSuccess);
        System.out.println("\n게임 성공 여부: " + success);
        System.out.println("총 시도한 횟수: " + runCnt);
    }

    private String convertBooleanToStr(boolean isSuccess) {
        if (isSuccess) {
            return "성공";
        }
        if (!isSuccess) {
            return "실패";
        }
        throw new IllegalArgumentException("잘못된 입력 값입니다.");
    }

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printPlay() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRetry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
