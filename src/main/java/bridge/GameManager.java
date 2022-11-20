package bridge;

import bridge.model.Map;

public class GameManager {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    /*

    // TODO: 프로그램 구현
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    outputView.printGameStart();
    Map map = new Map(bm.makeBridge(inputView.readBridgeSize()));
    while (true){
        outputView.askMove();
        if(!map.insertMove(inputView.readMoving())){
            map = new Map(bm.makeBridge(inputView.readBridgeSize()));
            continue;
        }
        outputView.printMap(map);
    }
 */
    public static void main(String[] args) {
        GameManager gm = new GameManager();
        gm.initGame();
    }

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void initGame(){
        outputView.printGameStart();
        int bridgeSize = inputView.readBridgeSize();
        Map map = new Map(bridgeMaker.makeBridge(bridgeSize));
        while (playGame(map)){

        }
    }

    private boolean playGame(Map map){
        outputView.askMove();
        while (map.insertMove(inputView.readMoving())){
            outputView.printMap(map);
            outputView.askMove();
            //실패해서 끝난건지 끝에 달해서 끝났는지 확인해야함
            //iterator 해서 hasNext false면 true로 끝나고 뭐 닿아서 끝나면 false로?
        }
        outputView.printResult();
        outputView.printMap(map);
        outputView.askRestart();
        if(inputView.readGameCommand().equals("R")){
            map.restartMap();
            return true;
        }
        return false;
    }
}
