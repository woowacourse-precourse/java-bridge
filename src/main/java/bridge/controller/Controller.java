package bridge.controller;

import bridge.dto.BridgeMapDto;
import bridge.dto.RetryCountDto;
import bridge.model.value.OutMessage;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.model.value.OutMessage.*;
public class Controller {
    private final BridgeGame game;
    private final OutputView out;
    private final InputView input;
    public Controller(BridgeGame game, OutputView out, InputView input){
        this.game = game;
        this.out = out;
        this.input = input;
    }
    /*
1. startGame()
    2. 다리 생성 - 입력 필요
3. moveBridge()
    4. 결과 출력
5. retry()
6.success()
7. printResult()
     */
    public void createBridge() {
        out.printMessage(START_MESSAGE);
        out.printMessage(INPUT_BRIDGE_MESSAGE);
        game.createBridge(input.readBridgeSize());
        game.createBridgeMap();
        game.createPlayer();
        game.createCount();
    }

    public void moveBridge() {
        out.printMessage(INPUT_MOVE_MESSAGE);
        game.move(input.readMoving());
    }

    public void printState() { // TODO: Refactoring Service 계층에서 변환하여 전달해주자
        out.printMap(game.getBridgeMap());
    }

}
