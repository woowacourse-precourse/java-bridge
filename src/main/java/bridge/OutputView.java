package bridge;

import java.util.List;


public class OutputView {
    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("\n다리의 길이를 입력해주세요.");
    }

    public void printRequestToInputMoveCommand() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRequestToInputRetryCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void printMap(BridgeGame bridgeGame) {
        System.out.println(makeFirstLine(bridgeGame));
        System.out.println(makeSecondLine(bridgeGame));
    }

    public String makeFirstLine(BridgeGame bridgeGame) {
        if (bridgeGame.getCurrentPosition() == 0) {
            return makeFirstLinePositionIsZero(bridgeGame);
        }
        return "[" + makeFirstLineMiddle(bridgeGame) + makeFirstLineEnd(bridgeGame);
    }

    public String makeFirstLinePositionIsZero(BridgeGame bridgeGame) {
        List<String> bridge = bridgeGame.getBridge();
        if (bridge.get(0).equals("U") && bridgeGame.isSuccess()) {
            return "[ O ]";
        }
        if (bridge.get(0).equals("D") && !bridgeGame.isSuccess()) {
            return "[ X ]";
        }
        return "[   ]";
    }

    public String makeFirstLineMiddle(BridgeGame bridgeGame) {
        StringBuilder line = new StringBuilder();
        List<String> bridge = bridgeGame.getBridge();
        for (int i = 0; i < bridgeGame.getCurrentPosition(); i++) {
            line.append(convertToResultForFirstLine(bridge.get(i)));
        }
        return line.toString();
    }

    public String convertToResultForFirstLine(String move) {
        if (move.equals("U")) {
            return " O |";
        }
        return "   |";
    }

    public String makeFirstLineEnd(BridgeGame bridgeGame) {
        List<String> bridge = bridgeGame.getBridge();
        if (bridge.get(bridgeGame.getCurrentPosition()).equals("U") && bridgeGame.isSuccess()) {
            return " O ]";
        }
        if (bridge.get(bridgeGame.getCurrentPosition()).equals("D") && !bridgeGame.isSuccess()) {
            return " X ]";
        }
        return "   ]";
    }

    public String makeSecondLine(BridgeGame bridgeGame) {
        if (bridgeGame.getCurrentPosition() == 0) {
            return makeSecondLinePositionIsZero(bridgeGame);
        }
        return "[" + makeSecondLineMiddle(bridgeGame) + makeSecondLineEnd(bridgeGame);
    }

    public String makeSecondLinePositionIsZero(BridgeGame bridgeGame) {
        List<String> bridge = bridgeGame.getBridge();
        if (bridge.get(0).equals("D") && bridgeGame.isSuccess()) {
            return "[ O ]";
        }
        if (bridge.get(0).equals("U") && !bridgeGame.isSuccess()) {
            return "[ X ]";
        }
        return "[   ]";
    }

    public String makeSecondLineMiddle(BridgeGame bridgeGame) {
        StringBuilder line = new StringBuilder();
        List<String> bridge = bridgeGame.getBridge();
        for (int i = 0; i < bridgeGame.getCurrentPosition(); i++) {
            line.append(convertToResultForSecondLine(bridge.get(i)));
        }
        return line.toString();
    }

    public String convertToResultForSecondLine(String move) {
        if (move.equals("D")) {
            return " O |";
        }
        return "   |";
    }

    public String makeSecondLineEnd(BridgeGame bridgeGame) {
        List<String> bridge = bridgeGame.getBridge();
        if (bridge.get(bridgeGame.getCurrentPosition()).equals("D") && bridgeGame.isSuccess()) {
            return " O ]";
        }
        if (bridge.get(bridgeGame.getCurrentPosition()).equals("U") && !bridgeGame.isSuccess()) {
            return " X ]";
        }
        return "   ]";
    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println("\n최종 게임 결과");
        printMap(bridgeGame);
        System.out.print("\n게임 성공 여부: ");
        if (bridgeGame.isSuccess()) {
            System.out.println("성공");
        }
        if (!bridgeGame.isSuccess()) {
            System.out.println("실패");
        }
        System.out.println("총 시도한 횟수: " + bridgeGame.getTotalTryCount());
    }
}