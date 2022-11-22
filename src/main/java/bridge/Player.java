package bridge;

import java.util.List;
import java.util.Map;

public class Player {
    private static final String BRIDGE_LENGTH_ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String DIRECTION_ERROR_MESSAGE = "[ERROR] 이동할 칸은 U 또는 D여야 합니다.";
    private static final String COMMAND_ERROR_MESSAGE = "[ERROR] 재시도를 위해서는 R 그리고 종료를 위해서는 Q를 입력하여야 합니다.";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private static final int MIN_BRIDGE_LENGTH = 3;
    private static final int MAX_BRIDGE_LENGTH = 20;


    private int currentPosition = -1;
    public boolean success = false;
    private int gameCount = 0;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public List<String> makeBridge(){
        int bridgeSize = getSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return bridge;
    }

    private int getSize(){
        String size = inputView.readBridgeSize();
        if(!isValidateSize(size)){
            throw new IllegalArgumentException(BRIDGE_LENGTH_ERROR_MESSAGE);
        }

        return Integer.parseInt(size);
    }

    private boolean isValidateSize(String size) {
        try{
            Integer.parseInt(size);
        }catch (IllegalArgumentException illegalArgumentException){
            return false;
        }
        if(Integer.parseInt(size) < MIN_BRIDGE_LENGTH || Integer.parseInt(size) > MAX_BRIDGE_LENGTH)
            return false;
        return true;
    }

    public int getNextIdx() {
        currentPosition++;
        return currentPosition;
    }

    public String getNextSpot(){
        String nextSpot = inputView.readMoving();
        if(!isValidSpot(nextSpot)){
            throw new IllegalArgumentException(DIRECTION_ERROR_MESSAGE);
        }

        return nextSpot;
    }

    private boolean isValidSpot(String nextSpot) {
        if(nextSpot.equals(UP) || nextSpot.equals(DOWN))
            return true;

        return false;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public boolean retry() {
        String command = inputView.readGameCommand();
        if(!isValidCommand(command)){
            throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE);
        }
        return command.equals(RETRY);
    }

    private boolean isValidCommand(String command) {
        if(command.equals(RETRY) || command.equals(QUIT))
            return true;
        return false;
    }

    public void currentPositionReset(){
        currentPosition = -1;
    }

    public boolean isSuccess() {
        return success;
    }

    public void increaseGameCount(){
        gameCount++;
    }

    public void printTotalScore(Map<String, String> lastMap) {
        outputView.printResult(lastMap, success, gameCount);
    }
}
