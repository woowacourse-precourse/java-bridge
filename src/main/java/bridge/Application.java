package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int bridgeSize, movingIndex = 0, tryNum = 1;
        boolean retry = true, success = false;
        List<String> bridge, upperBridge, lowerBridge;

        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");

        bridgeSize = InputView.readBridgeSize();
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
        upperBridge = new ArrayList<>();
        lowerBridge = new ArrayList<>();

        do {
            System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");

            String userChoice = InputView.readMoving();
            boolean isCorrectChoice = userChoice.equals(bridge.get(movingIndex));
            boolean isUpper = BridgeGame.upperOrLower(userChoice);
            String input = BridgeGame.canGo(isCorrectChoice);

            if (isCorrectChoice) movingIndex++;

            upperBridge.add(BridgeGame.isBlank(isUpper, input));
            lowerBridge.add(BridgeGame.isBlank(!isUpper, input));

            OutputView.printMap(upperBridge, bridgeSize, movingIndex - 1);
            OutputView.printMap(lowerBridge, bridgeSize, movingIndex - 1);
            System.out.println();

            if (!isCorrectChoice) {
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                String gameCommand = InputView.readGameCommand();
                retry = BridgeGame.retry(gameCommand);
                movingIndex = 0;
                tryNum = BridgeGame.countGameNum(gameCommand, tryNum);
            }

            if (movingIndex == bridgeSize) {
                success = true;
                retry = false;
            }

            if (retry == false) {
                System.out.println("최종 게임 결과");
                OutputView.printResult(upperBridge, lowerBridge, bridgeSize, movingIndex);
                System.out.println();
            }

            if (!isCorrectChoice) {
                upperBridge.clear();
                lowerBridge.clear();
            }
        } while (retry);

        System.out.println("게임 성공 여부: " + OutputView.isGameSuccess(success));
        System.out.println("총 시도한 횟수: " + tryNum);
    }
}