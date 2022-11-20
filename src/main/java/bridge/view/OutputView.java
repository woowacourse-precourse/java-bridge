package bridge.view;

import bridge.service.BridgeGame;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * 패키지 변경가능, 메서드 이름 변경 불가. 인자와 반환타입은 추가 및 변경 가능
 * 메서드 추가 가능
 */
public class OutputView {
    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printBridgeSizeInputRequest() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printError(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printMovingInputRequest() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        printUpperPart(bridgeGame);
        printLowerPart(bridgeGame);
    }

    private void printUpperPart(BridgeGame bridgeGame) {
        int playerLocation = bridgeGame.getPlayerLocation();
        List<String> crossedSpaces = bridgeGame.getMovableSpaces().subList(0, playerLocation);

        String upperPart = String.join("|", crossedSpaces);

        // 만약 실패했고 실패한 지점의 정답이 D였다면 사망표시
        if (bridgeGame.isFailed() && upperPart.charAt(upperPart.length() - 1) == 'D') {
            upperPart = upperPart.substring(0, upperPart.length() - 1) + " X ";
        } else if (bridgeGame.isFailed() && upperPart.charAt(upperPart.length() - 1) == 'U') {
            upperPart = upperPart.substring(0, upperPart.length() - 1) + "   ";
        }

        upperPart = upperPart.replace("U", " O ");
        upperPart = upperPart.replace("D", "   ");
        System.out.println("[" + upperPart + "]");
    }

    private void printLowerPart(BridgeGame bridgeGame) {
        int playerLocation = bridgeGame.getPlayerLocation();
        List<String> crossedSpaces = bridgeGame.getMovableSpaces().subList(0, playerLocation);

        String lowerPart = String.join("|", crossedSpaces);
        // 만약 실패했고 실패한 지점의 정답이 U였다면 사망표시
        if (bridgeGame.isFailed() && lowerPart.charAt(lowerPart.length() - 1) == 'U') {
            lowerPart = lowerPart.substring(0, lowerPart.length() - 1) + " X ";
        } else if (bridgeGame.isFailed() && lowerPart.charAt(lowerPart.length() - 1) == 'D') {
            lowerPart = lowerPart.substring(0, lowerPart.length() - 1) + "   ";
        }

        lowerPart = lowerPart.replace("U", "   ");
        lowerPart = lowerPart.replace("D", " O ");
        System.out.println("[" + lowerPart + "]");
    }

    public void printGameCommandInputRequest() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame);
        printSuccessOrFail(bridgeGame.isFailed());
        printTryCount(bridgeGame);
    }

    private void printSuccessOrFail(boolean fail) {
        String result;
        if (fail) {
            result = "실패";
        } else {
            result = "성공";
        }
        System.out.println("게임 성공 여부: " + result);
    }

    private void printTryCount(BridgeGame bridgeGame) {
        int tryCount = bridgeGame.getTryCount();
        System.out.println("총 시도한 횟수: " + tryCount);
    }
}
