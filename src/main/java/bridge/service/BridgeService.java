package bridge.service;

import bridge.domain.*;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeService {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    BridgeGame bridgeGame = new BridgeGame();
    Bridge bridge;
    User user;


    public void startBridgeGame(){
        // 시작 메세지 출력
        int bridgeSize = inputView.readBridgeSize();
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        user = new User();
    }




}
