package bridge.service;

import bridge.domain.BridgeGameService;
import bridge.domain.CommandConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame implements BridgeGameService {

    public static final String SYMBOL_OF_SUCCESS = "O";
    public static final String SYMBOL_OF_FAILURE = "X";
    private final List<String> bridge;
    private List<String> upStep;
    private List<String> downStep;
    private int attemptCount = 0;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    @Override
    public void move(String step) {
        this.attemptCount = getAttemptCount() + 1;
        updateMaps(step);
    }


    @Override
    public void retry(String command) {
        this.upStep.clear();
        this.downStep.clear();
    }

    @Override
    public List<List<String>> getMaps() {
        List<List<String>> map = new ArrayList<>();
        map.add(getUpStep());
        map.add(getDownStep());
        return map;
    }

    // break 조건 1
    @Override
    public Boolean isGameSuccess(String step) {
        boolean checkSize = getUpStep().size() == bridge.size();
        boolean checkLastStep = isValidLastStep(step);
        return checkSize && checkLastStep;
    }

    // break 조건 2
    @Override
    public Boolean isValidLastStep(String step) {
        return Objects.equals(step, bridge.get(bridge.size() - 1));
    }


    public int getAttemptCount() {
        return attemptCount;
    }

    private void updateMaps(String step) {
        String symbol = getSymbolOfTrack(step);
        if (Objects.equals(step, CommandConstant.UP)) {
            goToUpStep(symbol);
        }
        if (Objects.equals(step, CommandConstant.DOWN)) {
            goToDownStep(symbol);
        }
    }


    private boolean isMovable(String step) {
        int index = getUpStep().size();
        return Objects.equals(step, bridge.get(index));
    }


    private String getSymbolOfTrack(String currentStep) {
        if (isMovable(currentStep)) {
            return SYMBOL_OF_SUCCESS;
        }
        return SYMBOL_OF_FAILURE;
    }


    private void goToUpStep(String symbol) {
        upStep.add(symbol);
        downStep.add(" ");
    }

    private void goToDownStep(String symbol) {
        downStep.add(symbol);
        upStep.add(" ");
    }

    private List<String> getUpStep() {
        return upStep;
    }

    private List<String> getDownStep() {
        return downStep;
    }
}
