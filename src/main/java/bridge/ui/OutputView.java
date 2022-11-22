package bridge.ui;

import bridge.domain.BridgeGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public void printMap(BridgeGame bridgeGame, String token) {
        createPrintBridge(bridgeGame, "U", token);
        createPrintBridge(bridgeGame, "D", token);
        printNewLine();
    }

    public void printResultBridge(BridgeGame bridgeGame, int flag) {
        System.out.println("최종 게임 결과");
        if (flag == Constant.GAME_CLEAR) {
            printMap(bridgeGame, Constant.TOKEN_CLEAR);
            return;
        }
        printMap(bridgeGame, Constant.TOKEN_FAIL);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int gameResult, BridgeGame bridgeGame) {
        printResultBridge(bridgeGame, gameResult);
        if (gameResult == Constant.GAME_CLEAR) {
            System.out.println("게임 성공 여부: 성공");
        } else if (gameResult == Constant.GAME_FAIL) {
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.println("총 시도한 횟수: " + bridgeGame.getCountGameTry());
    }

    public void printNewLine() {
        System.out.println();
    }

    private String createToken(BridgeGame bridgeGame, String floor, int index) {
        if (Objects.equals(bridgeGame.getBridge().get(index), floor)) {
            return Constant.TOKEN_CLEAR;
        }
        return Constant.TOKEN_NULL;
    }

    private String createToken(BridgeGame bridgeGame, String floor, String token) {
        if (Objects.equals(token, Constant.TOKEN_FAIL) &&
                !Objects.equals(bridgeGame.getBridge().get(bridgeGame.getCurrentPosition() - 1), floor)) {
            return token;
        }
        if (Objects.equals(token, Constant.TOKEN_CLEAR) &&
                Objects.equals(bridgeGame.getBridge().get(bridgeGame.getCurrentPosition() - 1), floor)) {
            return token;
        }
        return Constant.TOKEN_NULL;
    }

    private void createPrintBridge(BridgeGame bridgeGame, String floor, String token) {
        List<String> temp = new ArrayList<>();
        temp.add("[");
        for (int i = 0; i < bridgeGame.getCurrentPosition() - 1; i++) {
            temp.add(" " + createToken(bridgeGame, floor, i) + " |");
        }
        temp.add(" " + createToken(bridgeGame, floor, token) + " ]");
        printBridge(temp);
    }

    private void printBridge(List<String> printBridge) {
        for (String s : printBridge) {
            System.out.print(s);
        }
        printNewLine();
    }

    // 여기부터 에러 메시지들
    public void printErrorBridgeSize() {
        System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    public void printErrorMoving() {
        System.out.println("[ERROR] 이동 할 위치는 U 또는 D 값이여야 합니다.");
    }

    public void printErrorGameCommand() {
        System.out.println("[ERROR] 재시도: R 또는 종료: Q 를 입력해주세요.");
    }

}
