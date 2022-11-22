package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public void readBridgeSize(BridgeGame bridgeGame) {
        try {
            System.out.println("다리의 길이를 입력해주세요");
            int size = Integer.parseInt(Console.readLine());
            bridgeGame.start(size);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.readBridgeSize(bridgeGame);
        }
    }

    public void readMoving(BridgeGame bridgeGame) {
        try {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String input = Console.readLine();
            bridgeGame.move(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.readMoving(bridgeGame);
        }
    }

    public void readGameCommand(BridgeGame bridgeGame) {
        try {
            if (!bridgeGame.isInProgress) {
                bridgeGame.result();
                return;
            }
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String input = Console.readLine();
            bridgeGame.retry(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.readGameCommand(bridgeGame);
        }
    }
}
