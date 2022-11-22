package bridge;

import java.util.List;
import java.util.Objects;

public class Application {
    static void startMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    static int readBridgeSize(InputView input) {
        System.out.println("다리의 길이를 입력해주세요.");
        int readInput = input.readBridgeSize();
        System.out.println();
        return readInput;
    }

    static List<String> makeBridge(int bridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    static boolean gameProgress(InputView input, BridgeGame bridgeGame, OutputView output) {
        for (int step = 0; step < bridgeGame.getBridgeSize(); step++) {
            boolean rightStep = moveStep(input, bridgeGame, step);
            output.printMap(bridgeGame);    // 시스템 현재 상황 출력
            if (rightStep && step == bridgeGame.getBridgeSize() - 1) return true;    // 게임 종료로 분기
            if (!rightStep) return false;   // 게임 재시도 여부로 분기
            bridgeGame.nextStepRecord();
        }
        throw new IllegalArgumentException();
    }

    static boolean moveStep(InputView input, BridgeGame bridgeGame, int step) {
        String nextStep = readMoving(input);
        return bridgeGame.move(nextStep, step);
    }

    static String readMoving(InputView input) {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return input.readMoving();
    }

    static String readCommand(InputView input) {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return input.readGameCommand();
    }

    static String playGame(InputView input, BridgeGame bridgeGame, OutputView output) {
        while (true) {
            bridgeGame.plusGameCount();
            boolean gameResult = gameProgress(input, bridgeGame, output);
            if (gameResult) return "성공";
            if (Objects.equals(readCommand(input), "Q")) return "실패";
            bridgeGame.retry();
        }
    }

    static void startGame() {
        startMessage();
        InputView input = new InputView();
        int bridgeSize = readBridgeSize(input);
        List<String> bridge = makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        printOutput(bridgeGame, input);
    }

    static void printOutput(BridgeGame bridgeGame, InputView input) {
        OutputView output = new OutputView();
        String isSuccess = playGame(input, bridgeGame, output);
        output.printResult(bridgeGame);
        output.printIsSuccess(bridgeGame, isSuccess);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            startGame();
        } catch (IllegalArgumentException exception) {
            System.out.print("[ERROR] " + exception.getMessage());
        }
    }
}
