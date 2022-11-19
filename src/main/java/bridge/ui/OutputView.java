package bridge.ui;

import bridge.domain.BridgeGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다. \n");
    }

    public void printGetBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printGetNextBlock() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRetry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        System.out.println(bridgeGame.getBridge() + " : " + bridgeGame.getCurrentPosition());
        printNewLine();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int flag, BridgeGame bridgeGame) {
        if (flag == Constant.GAME_CLEAR) {
            System.out.println("게임 성공 여부: 성공");
        }
        else if (flag == Constant.GAME_FAIL) {
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.println("총 시도한 횟수: " + bridgeGame.getCountGameTry());
    }

    public void printNewLine() { System.out.println(); }

    private String createToken() {
        String token = "O";
        // 위, 아래, 참, 거짓을 판단해서 토큰을 반환해줌
        return token;
    }

    private String createPrintBridge(String upOrDown, String currentUpOrDown, String token) {
        // 위, 아래를 입력받고,
        String printBridge = "[";
        printBridge = printBridge.concat(" " + token + " ");

        return printBridge;
    }

    // 여기부터 에러 메시지들
    public void printErrorBridgeSize() {
        System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    public void printErrorMoving() {
        System.out.println("[ERROR] 이동 할 위치는 U 또는 D 값이여야 합니다.");
    }
}
