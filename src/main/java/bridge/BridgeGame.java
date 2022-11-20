package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static List<String> bridgeIntegerMapper = Arrays.asList("D", "U"); //1일 때 위, 0일 때 밑

    private BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
    private List<String> realBridge;
    private HashMap<String, List<String>> moveStatus;
    private int currentLocation;
    private int restartNumber;

    public HashMap<String, List<String>> getMoveStatus() {
        return moveStatus;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public int getRestartNumber() {
        return restartNumber;
    }

    public BridgeGame(int bridgeLength) {
        realBridge = generateBridge(bridgeLength);
        moveStatus.put("U", new ArrayList<String>());
        moveStatus.put("D", new ArrayList<String>());
        currentLocation = 0;
        restartNumber = 1;
    }

    private List<String> generateBridge(int bridgeLength) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < bridgeLength; i++) {
            realBridge.add(bridgeIntegerMapper.get(numberGenerator.generate()));
        }

        return bridge;
    }
    public boolean move(String direction) {
        currentLocation++;
        if (realBridge.get(currentLocation) == direction) {
            return reflectMovement(true, direction);
        }
        return reflectMovement(false, direction);
    }

    public void retry() {
        moveStatus.put("U", new ArrayList<>());
        moveStatus.put("D", new ArrayList<>());
        currentLocation = 0;
        restartNumber++;
    }

    private boolean reflectMovement(boolean isCorrectLocation, String direction) {
        String correctCharacter = "O";
        if (!isCorrectLocation) {
            correctCharacter = "X";
        }
        moveStatus.get(direction).add(correctCharacter);
        moveStatus.get(bridgeIntegerMapper.get(1 - bridgeIntegerMapper.indexOf(direction))).add(" ");

        return isCorrectLocation;
    }
}
