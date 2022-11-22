package bridge;

import bridge.enummodel.CommandEnum;
import bridge.enummodel.GameResultEnum;
import bridge.processor.ValidatorProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final ValidatorProcessor validatorProcessor;
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static final int upSide = 0;
    private static final int downSide = 1;
    private static final String BLANK_STRING = " ";

    public BridgeGame(ValidatorProcessor validatorProcessor) {
        this.validatorProcessor = validatorProcessor;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<List<String>> move(List<String> bridge, List<String> command) {
        List<List<String>> result = new ArrayList<>(List.of(new ArrayList<>(), new ArrayList<>()));
        checkMoveMatch(bridge, command, result);
        return result;
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Boolean retry(String command) {
        validatorProcessor.validateRetryInput(command);
        if (command.equals(CommandEnum.RESTART.getValue())) return true;
        if (command.equals(CommandEnum.QUIT.getValue())) return false;
        return false;
    }

    public List<String> addCommandInput(List<String> inputBridge, String input) {
        validatorProcessor.validateCommandInput(input);
        inputBridge.add(input);
        return inputBridge;
    }

    public Integer convertBridgeSize(String sizeInput) {
        return validatorProcessor.validateBridgeSizeInput(sizeInput);
    }

    public List<String> makeBridge(int bridgeSize) {
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private void checkMoveMatch(List<String> bridge, List<String> command, List<List<String>> result) {
        for (int i=0; i<command.size(); i++) {
            if (command.get(i).equals(bridge.get(i))) {
                checkResult(command.get(i), result, GameResultEnum.CHECK.getValue(true));
            }
            if (!command.get(i).equals(bridge.get(i))) {
                checkResult(command.get(i), result, GameResultEnum.CHECK.getValue(false));
            }
        }
    }

    private void checkResult(String command, List<List<String>> result, String check) {
        if (command.equals(CommandEnum.UP.getValue())) {
            result.get(upSide).add(check);
            result.get(downSide).add(BLANK_STRING);
        }
        if (command.equals(CommandEnum.DOWN.getValue())) {
            result.get(upSide).add(BLANK_STRING);
            result.get(downSide).add(check);
        }
    }
}
