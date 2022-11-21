package bridge;

import bridge.controller.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();

        //1. 게임 시작 문구 출력
        bridgeGame.printStartMessage();

        try {
            //2. 다리 개수 입력
            bridgeGame.enterNumberOfBridge();

            //3. 컴퓨터 랜덤 수 생성
            bridgeGame.createRandomNumber();

            //4. 사용자가 다음에 이동할 칸을 입력
            bridgeGame.enterNextStep();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
