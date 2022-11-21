package bridge;

import java.util.List;

/**
 * 게임의 진행을 관리하는 역할을 한다.
 */
public class GameController {
    private OutputView outputView =new OutputView();
    private InputView inputView = new InputView();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static int trials=1;
    public void begin(){
//        int trials = 1;
        outputView.gameStartMessage();

        outputView.bridgeSizeMessage();
        int size = readBridgeSizeStep();//inputView.readBridgeSize();

        List<String> answer_bridge = bridgeMaker.makeBridge(size);
        System.out.println(answer_bridge);

        BridgeGame bridgeGame = new BridgeGame(answer_bridge);
        boolean keepgo = true;
        while(keepgo) {
            move( bridgeGame);//끝까지 성공하거나 중간에 실패하기전까지 이동

            //성공하거나 Q를 입력받으면 false return
            keepgo = successOrRetry( bridgeGame);
            trials++;
        }
    }
    private boolean successOrRetry(BridgeGame bridgeGame){
        if (bridgeGame.isSuccess()) {
            outputView.printResult("성공", bridgeGame, trials);
            return false;
        }

        outputView.restartMessage();
        String command = readRestartStep();
        if (command.equals("R")) {
            bridgeGame.retry();
        }

        if (command.equals("Q")) {
            outputView.printResult("실패", bridgeGame, trials);
            return false;
        }
        return true;
    }
    private void move(BridgeGame bridgeGame) {
        boolean isEnd = false;
        while (!isEnd) {
            move1Step(bridgeGame);
            isEnd = bridgeGame.isEnd();
        }
    }
    private void move1Step(BridgeGame bridgeGame){
        //move message 출력
        outputView.moveMessage();
        //input move
        String way = readMovingStep();
        //move
        bridgeGame.move(way);
        //printMap
        outputView.printMap(bridgeGame);

    }
    private int readBridgeSizeStep(){
        try{
            return inputView.readBridgeSize();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readBridgeSizeStep();
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
            return readBridgeSizeStep();
        }
    }
    private String readMovingStep(){
        try{
            return inputView.readMoving();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readMovingStep();
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
            return readMovingStep();
        }
    }
    private String readRestartStep(){
        try{
            return inputView.readGameCommand();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readRestartStep();
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
            return readRestartStep();
        }
    }
}
