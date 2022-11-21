package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String up, String down) {
        System.out.println(up + "]");
        System.out.println(down + "]");

    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame BG, int size) {
        System.out.println("최종 게임 결과");
        System.out.println(String.join("|", BG.getUp()) + "]");
        System.out.println(String.join("|", BG.getDown()) + "]");
        if (size == 0) System.out.println("게임 성공 여부: 성공");
        if (size != 0) System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + (BG.getCount() + 1));

    }
}
