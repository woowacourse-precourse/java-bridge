package bridge;

import static bridge.util.message.GameMessage.*;

import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;


import javax.naming.ldap.StartTlsRequest;
import java.util.ArrayList;
import java.util.List;

public class BridgeGamePlayer {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public boolean startGame(){

        List<String> bridge = new ArrayList<>();
        outputView.showMessage(START_MESSAGE.getMessage());
        bridge = getBridge();

        return true;
    }

    private static List<String> getBridge(){

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(getBridgeSize());
    }

    private static int getBridgeSize(){
        return inputView.readBridgeSize();
    }


}
