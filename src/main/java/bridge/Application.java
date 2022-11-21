package bridge;

import java.util.List;

public class Application {
    public static boolean retryWhether(InputView input, BridgeGame BG) {
        boolean check = true;
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String bridgegameRecomand = input.readGameCommand();
        if (bridgegameRecomand.equals("R")) {
            BG.retry();
            check = true;
        }
        return check;
    }

    public static void main(String[] args) {
        InputView input = new InputView();
        BridgeRandomNumberGenerator bRNG = new BridgeRandomNumberGenerator();
        BridgeMaker BM = new BridgeMaker(bRNG);
        BridgeGame BG = new BridgeGame();
        OutputView OP = new OutputView();
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리의 길이를 입력해주세요.");
        final int bridgeLength = input.readBridgeSize();
        boolean check = true;
        List<String> bridge_check = BM.makeBridge(bridgeLength);
        do {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String bridgeBlank = input.readMoving();
            check = BG.move(bridgeBlank, bridge_check);
            if (check == false || bridge_check.isEmpty()) {
                check = retryWhether(input, BG);
                continue;
            }
            bridge_check.remove(0);
        } while (check && !bridge_check.isEmpty());
        OP.printResult(BG, bridge_check.size());
    }
}
