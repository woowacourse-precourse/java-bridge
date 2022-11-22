package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printResult(String bridgeMessage, GameInfo gameInfo) {
        System.out.println("\n최종 게임 결과");
        printMap(bridgeMessage);
        if (gameInfo.getSuccessOrFail()) {
            System.out.println("게임 성공 여부: 성공");
            System.out.println("총 시도한 횟수: " + gameInfo.getTrialCount());
            return;
        }
        System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + gameInfo.getTrialCount());
    }

    public void printMap(String bridgeMessage) {
        System.out.println(bridgeMessage);
    }
}
