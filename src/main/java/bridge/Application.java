package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        int n;
        boolean gameOver = false;
        List<String> bridge;

        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
        n = InputView.readBridgeSize();
        System.out.println();
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(n);

        do {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            InputView.readMoving();

            if (gameOver) {
                System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                InputView.readGameCommand();
            }

        } while(BridgeGame.retry());

        System.out.println("게임 성공 여부: ");
        System.out.println("총 시도한 횟수: ");
    }
}
