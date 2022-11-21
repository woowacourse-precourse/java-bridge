package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int bridgeSize, movingIndex = 0, tryNum = 1;
        boolean retry = true, success = false;
        List<String> bridge, upperBridge = new ArrayList<>(), lowerBridge = new ArrayList<>();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeGame bridgeGame = new BridgeGame();

        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");

        bridgeSize = inputView.readBridgeSize();
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);

        do {
            System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");

            String userChoice = inputView.readMoving();
            boolean isCorrectChoice = userChoice.equals(bridge.get(movingIndex));
            boolean isUpper = bridgeGame.upperOrLower(userChoice);
            String input = bridgeGame.canGo(isCorrectChoice);

            if (isCorrectChoice) movingIndex++;

            bridgeGame.move(upperBridge, isUpper, input);
            bridgeGame.move(lowerBridge, !isUpper, input);

            outputView.printMap(upperBridge);
            outputView.printMap(lowerBridge);
            System.out.println();

            if (!isCorrectChoice) {
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                String gameCommand = inputView.readGameCommand();
                retry = bridgeGame.retry(gameCommand);
                movingIndex = 0;
                tryNum = bridgeGame.countGameNum(gameCommand, tryNum);
            }

            if (movingIndex == bridgeSize) {
                success = true;
                retry = false;
            }

            if (!retry) {
                System.out.println("최종 게임 결과");
                outputView.printResult(upperBridge);
                outputView.printResult(lowerBridge);
                System.out.println();
            }

            if (!isCorrectChoice) {
                upperBridge.clear();
                lowerBridge.clear();
            }
        } while (retry);

        System.out.println("게임 성공 여부: " + outputView.isGameSuccess(success));
        System.out.println("총 시도한 횟수: " + tryNum);
    }
}