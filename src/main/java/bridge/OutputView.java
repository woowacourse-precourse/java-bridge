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
    public void printMap(String gameState) {
        System.out.println(gameState);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(CurrentLocationInformation currentLocationInformation, int resultCount, boolean state) {
        String gameResult = "실패";
        String resultLocation = currentLocationInformation.getResultLocation();
        System.out.println("최종 게임 결과");
        if (state) {
            gameResult = "성공";
        }
        System.out.println(resultLocation);
        System.out.println();
        System.out.println("게임 성공 여부: " + gameResult);
        System.out.println("총 시도한 횟수: " + resultCount);
    }

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }
}
