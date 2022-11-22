package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private String greetingMsg = "다리 건너기 게임을 시작합니다.";
    private String gameResultMsg = "최종 게임 결과";
    private String gameSucceedMsg = "게임 성공 여부: ";
    private String totalTriesMsg = "총 시도한 횟수: ";


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> ups, List<String> downs) {
        printOneMap(ups);
        printOneMap(downs);
    }

    public static void printOneMap(List<String> upDown) {
        System.out.print("[ ");
        for (int i = 0; i < upDown.size() - 1; i++) {
            System.out.print(upDown.get(i) + " | ");
        }
        System.out.println(upDown.get(upDown.size()-1) + " ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> ups, List<String> downs, String success, int tries) {
        System.out.println(gameResultMsg);
        printMap(ups, downs);
        System.out.println();
        System.out.println(gameSucceedMsg + success);
        System.out.println(totalTriesMsg + tries);
    }

    public void printGreeting() {
        System.out.println(greetingMsg);
        System.out.println();
    }

}
