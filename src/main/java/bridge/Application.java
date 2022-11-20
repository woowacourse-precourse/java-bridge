package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        int n, i = 0, cnt = 1;
        boolean retry = true, success = false;
        List<String> bridge, upperBridge, lowerBridge;

        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
        n = InputView.readBridgeSize();
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(n);
        upperBridge = new ArrayList<>();
        lowerBridge = new ArrayList<>();

        do {
            System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String userChoice = InputView.readMoving();
            boolean isCorrectChoice = userChoice.equals(bridge.get(i));
            boolean isUpper = BridgeGame.upperOrLower(userChoice);

            String input = BridgeGame.canGo(isCorrectChoice);

            if (isCorrectChoice) i++;

            upperBridge.add(BridgeGame.isBlank(isUpper, input));
            lowerBridge.add(BridgeGame.isBlank(!isUpper, input));

            OutputView.printMap(upperBridge, n, i - 1);
            OutputView.printMap(lowerBridge, n, i - 1);
            System.out.println();

            if (!isCorrectChoice) {
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                String s = InputView.readGameCommand();
                retry = BridgeGame.retry(s);
                i = 0;
                cnt = BridgeGame.countGameNum(s, cnt);
            }

            if (i == n) {
                success = true;
                retry = false;
            }
            if (retry == false) {
                System.out.println("최종 게임 결과");
                OutputView.printResult(upperBridge, lowerBridge, n, i);
                System.out.println();
            }
            if (!isCorrectChoice) {
                upperBridge.clear();
                lowerBridge.clear();
            }

        } while(retry);


        System.out.println("게임 성공 여부: " + OutputView.isGameSuccess(success));
        System.out.println("총 시도한 횟수: " + cnt);
    }
}
