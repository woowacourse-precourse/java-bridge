package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.Player;
import bridge.domain.bridgeTool.BridgeMaker;
import bridge.domain.bridgeTool.BridgeNumberGenerator;
import bridge.domain.bridgeTool.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static bridge.message.ValidateMessage.INVALID_INPUT;
import static bridge.message.ValidateMessage.OUT_OF_RANGE;
import static bridge.util.BridgeUtil.*;
import static bridge.util.BridgeUtil.DOWN;
import static bridge.util.GameCommand.QUIT;
import static bridge.util.GameCommand.RESTART;
import static bridge.util.View.SPACE;
import static bridge.util.View.ANSWER_RESULT;
import static bridge.util.View.WRONG_ANSWER_RESULT;

public class BridgeGame {

    private BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker;
    private Bridge bridge;
    private Player player;
    private List<String> upperBridge = new ArrayList<>();
    private List<String> lowerBridge = new ArrayList<>();
    private int tryCount = initTryCount();
    private boolean crossAllBridge;

    public BridgeGame() {
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    private int initTryCount() {
        return BINARY_UP;
    }

    public void initBridge(int bridgeSize) {
        this.bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public void initPlayer() {
        this.player = new Player();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveCommand) {
        initBridgeMap();
        player.addChoice(moveCommand);
        makeBridgeMap();
    }

    private void initBridgeMap() {
        upperBridge = new ArrayList<>();
        lowerBridge = new ArrayList<>();
    }

    private void makeBridgeMap() {
        for (int position = 0; position < player.getNumberOfChoice(); position++) {
            String choice = getChoiceByPosition(position);
            makeUpperBridgeOfPart(position, choice);
            makeLowerBridgeOfPart(position, choice);
        }
    }

    private void makeUpperBridgeOfPart(int position, String choice) {
        if (!choice.equals(UP)) {
            upperBridge.add(SPACE);
            return;
        }

        if (choice.equals(getBridgeByPosition(position))) {
            upperBridge.add(ANSWER_RESULT);
            return;
        }
        upperBridge.add(WRONG_ANSWER_RESULT);
    }

    private void makeLowerBridgeOfPart(int position, String choice) {
        if (!choice.equals(DOWN)) {
            lowerBridge.add(SPACE);
            return;
        }

        if (choice.equals(getBridgeByPosition(position))) {
            lowerBridge.add(ANSWER_RESULT);
            return;
        }
        lowerBridge.add(WRONG_ANSWER_RESULT);
    }

    private String getChoiceByPosition(int position) {
        return player.getChoiceIndex(position);
    }

    private String getBridgeByPosition(int position) {
        return bridge.getBridgeByIndex(position);
    }

    public List<List<String>> getBridgeMap() {
        List<List<String>> bridgeMap = new ArrayList<>();
        bridgeMap.add(upperBridge);
        bridgeMap.add(lowerBridge);
        return bridgeMap;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        addTryCount();
    }

    private int getBridgeLength() {
        return bridge.getBridgeLength();
    }

    private int getNumberOfChoice() {
        return player.getNumberOfChoice();
    }

    public boolean moveAgain() {
        if (isAcrossLast()) {
            return false;
        }
        if (isSameRecentChoiceAndBridge()) {
            return true;
        }

        return false;
    }

    private boolean isSameRecentChoiceAndBridge() {
        return player.getLastChoice().equals(bridge.getBridgeByIndex(getNumberOfChoice() - 1));
    }

    private boolean isAcrossLast() {
        if (getBridgeLength() == getNumberOfChoice()) {
            return true;
        }
        return false;
    }

    public boolean isClearGame() {
        if (isAcrossLast() && isSameRecentChoiceAndBridge()) {
            crossAllBridge();
            return true;
        }
        return false;
    }

    private void crossAllBridge() {
        crossAllBridge = true;
    }

    public boolean validateBridgeSize(String input) {
        try {
            validateConvert(input);
            validateBridgeSizeRange(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INVALID_INPUT);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
        return true;
    }

    private void validateConvert(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    private void validateBridgeSizeRange(int number) {
        if (MIN_BRIDGE_SIZE > number || MAX_BRIDGE_SIZE < number) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }

    public void validateInputMoveCommand(String command) {
        if (!isMoveCommand(command)) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }

    private boolean isMoveCommand(String command) {
        if (UP.equals(command) || DOWN.equals(command)) {
            return true;
        }
        return false;
    }

    public void validateInputGameCommand(String input) {
        if (!isEndCommand(input) && !isRestartCommand(input)) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }

    private boolean isEndCommand(String command) {
        if (QUIT.equals(command)) {
            return true;
        }
        return false;
    }

    private boolean isRestartCommand(String command) {
        if (RESTART.equals(command)) {
            return true;
        }
        return false;
    }

    public boolean isRestartGame(String input) {
        if (RESTART.equals(input)) {
            retry();
            return true;
        }
        return false;
    }

    private void addTryCount() {
        this.tryCount = tryCount + BINARY_UP;
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean isCrossAllBridge() {
        return crossAllBridge;
    }
}
