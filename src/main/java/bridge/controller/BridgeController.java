package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.dto.MapDTO;
import bridge.dto.PathDTO;
import bridge.dto.ResultDTO;
import bridge.model.Bridge;
import bridge.util.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

import static bridge.model.Case.*;

public class BridgeController {
    private final OutputView outputView;
    private final InputView inputView;
    private final Validator validator;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;

    public BridgeController() {
        outputView = new OutputView();
        inputView = new InputView();
        validator = new Validator();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame();
    }

    public void run() {
        outputView.printStartNotice();
        int size = inputBridgeSize();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(size));
        ResultDTO resultDTO = crossBridge(size, bridge);
        outputView.printResult(resultDTO);
    }

    public ResultDTO crossBridge(int size, Bridge bridge) {
        int count = 1;
        while (true) {
            List<PathDTO> pathDTO = new ArrayList<>();
            boolean end = isCross(size, bridge, pathDTO);
            if (isEnd(end)) {
                return new ResultDTO(new MapDTO(pathDTO), end, count);
            }
            count++;
        }
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

    public boolean isCross(int size, Bridge bridge, List<PathDTO> pathDTO) {
        boolean end = false;
        for (int round = 0; round < size; round++) {
            if (!isMove(bridge, pathDTO, round)) {
                break;
            }
            end = isSuccess(size, round);
        }
        return end;
    }

    private boolean isMove(Bridge bridge, List<PathDTO> pathDTO, int round) {
        String moving = inputMoving();
        String pass = getPass(bridge, round, moving);
        bridgeGame.move(pathDTO, moving, pass);
        outputView.printMap(new MapDTO(pathDTO));
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

    public String inputGameCommand() {
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
