package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.enums.Message;
import bridge.enums.UpDown;
import bridge.model.Player;
import bridge.view.InputNumValidator;
import bridge.view.InputStringValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private List<String> bridge;

    public void start() {
        outputView.printMessage(Message.GAME_START_MSG);
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        InputNumValidator bridgeSizeInputValidator = new InputNumValidator(inputView.readBridgeSize());
        bridge = bridgeMaker.makeBridge(bridgeSizeInputValidator.getInputValue());
//        List<String> myBridge = new ArrayList<>();
        Player gamePlayer = new Player();
        do {
            move(gamePlayer);
            outputView.printMap(bridge, gamePlayer);
        } while ()
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Player player) {
        InputStringValidator moveCommandValidator = new InputStringValidator(inputView.readGameCommand());
        moveCommandValidator.isValidateAlphabet(UpDown.getStrValues());
        String direction = moveCommandValidator.getInputValue();
        player.forward(direction);
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
