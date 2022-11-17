package bridge;


public class Application {
    static InputView input = new InputView();
    static OutputView output = new OutputView();

    public static void main(String[] args) {
        int boardSize = new InputView().readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(boardSize);

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
