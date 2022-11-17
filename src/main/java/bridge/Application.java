package bridge;


public class Application {

    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView output = new OutputView();
        BridgeGame bridgeGame = new BridgeGame();

        //게임클리어여부
        while(bridgeGame.clear())
        {
            //이동
            String move = input.readMoving();
            bridgeGame.move(move);

            //맵출력
            output.printMap(bridgeGame.board, bridgeGame.step, bridgeGame.result);

            //이동실패시 재시작여부
            if(!bridgeGame.result){
                String command = input.readGameCommand();
                if(!bridgeGame.retry(command))
                    break;
            }
        }
        //게임 결과 출력
        output.printResult(bridgeGame.board, bridgeGame.step, bridgeGame.result, bridgeGame.retryNum);
    }
}
