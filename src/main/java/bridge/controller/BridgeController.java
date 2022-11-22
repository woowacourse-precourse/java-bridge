package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.dto.ResultDTO;
import bridge.model.Bridge;
import bridge.model.User;
import bridge.util.Converter;
import bridge.util.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;

import static bridge.model.Case.*;

public class BridgeController {
    private final OutputView outputView;
    private final InputView inputView;
    private final Validator validator;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;
    private final Converter converter;

    public BridgeController() {
        outputView = new OutputView();
        inputView = new InputView();
        validator = new Validator();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame();
        converter = new Converter();
    }

    public void run() {
        outputView.printStartNotice();
        int size = inputBridgeSize();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(size));
        ResultDTO resultDTO = crossBridge(bridge, new User(new ArrayList<>()));
        outputView.printResult(resultDTO);
    }

    private ResultDTO crossBridge(Bridge bridge, User user) {
        int count = 1;
        while (true) {
            boolean end = isCross(bridge, user);
            if (isEnd(end)) {
                return new ResultDTO(converter.convertToMapDTO(user), end, count);
            }
            count = initGame(user, count);
        }
    }

    private int initGame(User user, int count) {
        count++;
        user.clear();
        return count;
    }

    private boolean isEnd(boolean end) {
        return end || !bridgeGame.retry(inputGameCommand());
    }

    private int inputBridgeSize() {
        try {
            String input = inputView.readBridgeSize();
            validator.validateBridgeSize(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputBridgeSize();
        }
    }

    private boolean isCross(Bridge bridge, User user) {
        boolean end = false;
        int size = bridge.getSize();
        for (int round = 0; round < size; round++) {
            if (!isMove(bridge, user, round)) {
                break;
            }
            end = isSuccess(size, round);
        }
        return end;
    }

    private boolean isMove(Bridge bridge, User user, int round) {
        String moving = inputMoving();
        String pass = getPass(bridge, round, moving);
        bridgeGame.move(user, moving, pass);
        outputView.printMap(converter.convertToMapDTO(user));
        return pass.equals(SUCCESS.getPictogram());
    }

    private boolean isSuccess(int size, int round) {
        return round == size - 1;
    }

    private String getPass(Bridge bridge, int round, String moving) {
        if (bridge.isPassable(round, moving)){
            return SUCCESS.getPictogram();
        }
        return FAIL.getPictogram();
    }

    private String inputMoving() {
        try {
            String moving = inputView.readMoving();
            validator.validateMoving(moving);
            return moving;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputMoving();
        }
    }

    private String inputGameCommand() {
        try {
            String input = inputView.readGameCommand();
            validator.validateGameCommand(input);
            return input;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputGameCommand();
        }
    }
}
