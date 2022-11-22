package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    static final int UP = 0;
    static final int DOWN = 1;
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    static public void printMap(List<String> trace, boolean result) {
        printLine(trace, result, checkUpDown(UP));
        printLine(trace, result, checkUpDown(DOWN));
    }

    static public void printLine(List<String> trace, boolean result, String ud){
        System.out.print("[");
        int size = trace.size();
        for (int i = 0; i < size - 1; i++) {
            if (trace.get(i).equals(ud)) {
                System.out.print(" O |");
                continue;
            }
            System.out.print("   |");
        }
        printLastStep(trace, result, ud);
    }

    static public void printLastStep(List<String> trace, boolean result, String ud){
        String lastStep = " O ]";
        if (!result)
            lastStep = " X ]";
        if (trace.get(trace.size() - 1).equals(ud)){
            System.out.println(lastStep);
            return;
        }
        System.out.println("   ]");
    }

    static public String checkUpDown(int updown){
        if (updown == UP)
            return "U";
        return "D";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    static public void printResult(List<String> trace, boolean result, int rerun) {
        System.out.println("\n최종 게임 결과");
        printMap(trace, result);
        System.out.print("\n게임 성공 여부: ");
        if (result)
            System.out.println("성공");
        if (!result)
            System.out.println("실패");
        System.out.println("총 시도한 횟수: " + rerun);
    }

    static public void printLengthGuide(){
        System.out.println("다리의 길이를 입력해주세요.");
    }
    static public void printMoveGuide(){
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }
    static public void printGameCommandGuide(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
