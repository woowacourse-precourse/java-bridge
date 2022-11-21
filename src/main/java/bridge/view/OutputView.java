package bridge.view;

import bridge.service.BridgeGame;

import java.util.List;
import java.util.Map;

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
        Map<String, List<String>> crossedRecord = bridgeGame.getCrossedRecord();
        printUpperPart(crossedRecord.get("upperCrossedRecord"));
        printLowerPart(crossedRecord.get("lowerCrossedRecord"));
    }

    private void printUpperPart(List<String> upperCrossedRecord) {
        String upperPart = String.join("|", upperCrossedRecord);
        System.out.println("[" + upperPart + "]");
    }

    private void printLowerPart(List<String> lowerCrossedRecord) {
        String lowerPart = String.join("|", lowerCrossedRecord);
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
