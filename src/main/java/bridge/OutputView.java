package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String STARTGAME = "다리 건너기 게임을 시작합니다.";
    private static final String READ_BRIDGESIZE = "다리의 길이를 입력해주세요.";
    private static final String READ_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String READ_GAMECOMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String GAME_OVER = "최종 게임 결과";
    private static final String GAME_SUCCESSORFAIURE = "게임 성공 여부: %s\n";
    private static final String TOTAL_NUMBEROFATTEMPT = "총 시도한 횟수: %d\n";
    private static final int ABOVEOFBRIDGE = BridgeDirection.UP.getBridgeRandomNumber();
    private static final int BELOWOFBRIDGE = BridgeDirection.DOWN.getBridgeRandomNumber();

    public void printStartGame() {
        System.out.println(STARTGAME);
    }

    public void printReadBridgeSize() {
        System.out.println(READ_BRIDGESIZE);
    }

    public void pringReadMoving() {
        System.out.println(READ_MOVING);
    }

    public void printReadGameCommand() {
        System.out.println(READ_GAMECOMMAND);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> aboveOfBridgeResult, List<String> belowOfBridgeResult) {

        for (int bridgeIndex = 0; bridgeIndex < aboveOfBridgeResult.size(); bridgeIndex++) {
            System.out.print(aboveOfBridgeResult.get(bridgeIndex));
        }
        System.out.println();
        for (int bridgeIndex = 0; bridgeIndex < belowOfBridgeResult.size(); bridgeIndex++) {
            System.out.print(belowOfBridgeResult.get(bridgeIndex));
        }
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> totalBridgeResult, int numberOfAttempt, String successOrFailure) {
        System.out.println(GAME_OVER);
        printMap(totalBridgeResult.get(ABOVEOFBRIDGE), totalBridgeResult.get(BELOWOFBRIDGE));
        System.out.printf(GAME_SUCCESSORFAIURE, successOrFailure);
        System.out.printf(TOTAL_NUMBEROFATTEMPT, numberOfAttempt);
    }
}
