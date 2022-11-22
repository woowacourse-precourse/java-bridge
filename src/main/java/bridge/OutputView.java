package bridge;

import java.util.Collections;
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

    /**
     * listU,listD의 최종 값
     * 
     * @param listU
     * @param listD
     */
    public void printMap(List<String> listU, List<String> listD) {
        printMapDetail(listU);
        printMapDetail(listD);
    }

    /**
     * 출력 Print 모양 잡기
     * 
     * @param list
     */
    public void printMapDetail(List<String> list) {
        System.out.print("[ " + list.get(0));
        for (int i = 1; i < list.size(); i++) {
            System.out.print(" | " + list.get(i));
        }
        System.out.println(" ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    /**
     * 결과 내역 Print 출력
     * 
     * @param moveReady
     * @param listU
     * @param listD
     */
    public void printResult(List<String> moveReady, List<String> listU, List<String> listD) {
        System.out.println("\n" + "최종 게임 결과");
        printMap(listU, listD);

        System.out.println("\n" + "게임 성공 여부: " + successGame(moveReady, listU, listD));
    }

    /**
     * Game 시도 횟수 Print 출력
     * 
     * @param gameCount
     */
    public void printResult2(int gameCount) {
        System.out.println("총 시도한 횟수: " + gameCount);
    }

    /**
     * listU 와 listD에 담겨진 게임 결과 "O"의 갯수 확인<br/>
     * 갯수 확인 결과 "성공"/"실패" 여부 return
     * 
     * @param moveReady
     * @param listU
     * @param listD
     * @return
     */
    public String successGame(List<String> moveReady, List<String> listU, List<String> listD) {
        int UCount = Collections.frequency(listU, "O");
        int DCount = Collections.frequency(listD, "O");

        if (moveReady.size() == (UCount + DCount))
            return "성공";

        return "실패";
    }
}
