package bridge;

import bridge.controller.BridgeGame;

public class Application {

    public static void main(String[] args) {
        int gameCount = 0;
        int epoch = 1;
        BridgeGame bridgeGame = new BridgeGame();

        //1. 게임 시작 문구 출력
        bridgeGame.printStartMessage();

        try {
            //2. 다리 개수 입력
            gameCount = bridgeGame.enterNumberOfBridge();

            for(int tempCount = gameCount; tempCount > 0 ; tempCount--) {
                //3. 사용자가 다음에 이동할 칸을 입력
                bridgeGame.enterNextStep();

                //4. 사용자가 입력한 칸과 컴퓨터가 생성한 칸이 겹치는지 확인
                if (!bridgeGame.move()) {

                    //5. 재시작 여부를 입력받음
                    if(bridgeGame.enterRetry()) {
                        bridgeGame.retry();

                        tempCount = gameCount + 1;
                        epoch += 1;
                        continue;
                    }

                    //6-1. 실패 후 결과 출력
                    bridgeGame.printResult(true, epoch);
                    return;
                }
            }

            //6-2. 성공 후 결과 출력
            bridgeGame.printResult(false, epoch);
            return;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            //bridgeGame.printResult(false, epoch);
        }
    }
}
