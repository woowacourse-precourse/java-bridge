package bridge;

//TODO 주의! 메서드의 이름은 변경할 수 없습니다
// 인자와 반환 타입은 추가, 변경 가능합니다
// 메서드 추가 가능합니다

import bridge.domain.FootPrint;
import bridge.domain.Result;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param footPrint
     */
    public static void printMap(FootPrint footPrint) {
        System.out.println(footPrint);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param result
     */
    public static void printResult(Result result) {
        System.out.println("\n최종 게임 결과");
        printMap(result.getFootPrint());
        System.out.println();
        if (result.getSuccess()) {
            System.out.println("게임 성공 여부: 성공");
        } else {
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.println("총 시도한 횟수: " + result.getTryCnt());
    }

    public static void showErrorMessage(IllegalArgumentException e) {
        System.out.println("[ERROR]" + e.getMessage());
    }
}
