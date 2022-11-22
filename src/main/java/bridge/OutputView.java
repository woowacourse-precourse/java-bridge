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
    public void printMap(List<String> Prog1, List<String> Prog2) {
        System.out.print("["+Prog1.get(0));
        for (int i = 1; i < Prog1.size(); i++) {
            System.out.print("|"+Prog1.get(i));
        }
        System.out.println("]");
        System.out.print("["+Prog2.get(0));
        for (int i = 1; i < Prog2.size(); i++) {
            System.out.print("|"+Prog2.get(i));
        }
        System.out.println("]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int tryNum,String output) {
        System.out.println("게임 성공 여부: " + output);
        System.out.println("총 시도한 횟수: " + tryNum);
    }

    public void printResultMap(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        List<String>P1 = bridgeGame.getProgress1();
        List<String>P2 = bridgeGame.getProgress2();
        printMap(P1, P2);
    }
}
