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

    private void initBridgeMap() {
        upperBridge = new ArrayList<>();
        lowerBridge = new ArrayList<>();
    }

    private String getChoiceByPosition(int position) {
        return player.getChoiceIndex(position);
    }

    private String getBridgeByPosition(int position) {
        return bridge.getBridgeByIndex(position);
    }

    private int getBridgeLength() {
        return bridge.getBridgeLength();
    }

    private int getNumberOfChoice() {
        return player.getNumberOfChoice();
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

}
