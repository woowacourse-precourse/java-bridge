package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        int n, i = 0, cnt = 1;
        boolean gameOver = false, retry = true, success = false;
        List<String> bridge;

        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
        n = InputView.readBridgeSize();
        System.out.println();
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(n);

        do {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");

            if (InputView.readMoving().equals(bridge.get(i))) {
                i++;
            }

            gameOver = OutputView.printMap(bridge, i - 1);

            if (gameOver) {
                System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                String s = InputView.readGameCommand();
                retry = BridgeGame.retry(s);
                i = 0;
                cnt = BridgeGame.countGameNum(s, cnt);
                gameOver = false;
            }

            if (i == n) {
                success = true;
                retry = false;
            }

        } while(retry);

        System.out.println("게임 성공 여부: " + OutputView.isGameSuccess(success));
        System.out.println("총 시도한 횟수: " + cnt);
    }
}
