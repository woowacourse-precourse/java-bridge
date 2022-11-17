package bridge;

import java.util.List;

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

    static boolean gameProgress(InputView input, BridgeGame bridgeGame, int bridgeSize) {
        for (int step = 0; step < bridgeSize; step++) {
            String nextStep = readMoving(input);
            boolean rightStep = bridgeGame.move(nextStep, step);
            // 스텝 후 현재 상황 출력
            if (rightStep && step == bridgeSize - 1) return true;    // 게임 종료로 분기
            if (!rightStep) return false;   // 게임 재시도 여부로 분기
            bridgeGame.nextStepRecord();
        }
        throw new IllegalArgumentException();
    }

    static String readMoving(InputView input) {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return input.readMoving();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            startMessage();
            InputView input = new InputView();
            int bridgeSize = readBridgeSize(input);
            List<String> bridge = makeBridge(bridgeSize);
            BridgeGame bridgeGame = new BridgeGame(bridge);
            boolean gameResult = gameProgress(input, bridgeGame, bridgeSize);
        } catch (IllegalArgumentException exception) {
            System.out.print("[ERROR] ");
            System.out.println(exception.getMessage());
        }
    }
}
