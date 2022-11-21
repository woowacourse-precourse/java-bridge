package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.OutputView.GAME_ICON_BAR;
import static bridge.OutputView.GAME_ICON_SPACE;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;
    private static final String ICON_COLLECT = "o";
    private static final String ICON_FALSE = "x";
    private static final String ICON_UP = "U";
    private static final String ICON_DOWN = "D";
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        BridgeGame bridgeGame = new BridgeGame();
        List<String> errorBridge = new ArrayList<>();
        List<String> bridgeU = new ArrayList<>();
        List<String> bridgeD = new ArrayList<>();
        List<String> joined = new ArrayList<>();
        List<String> randomCollect = makeRandomUpDown(size);
        errorBridge.add("e");
        int countCycle = ONE;
        for (int i = ZERO; i < size; i++)
            System.out.println(randomCollect.get(i));

        String moveUpOrDown;
        for (int i = ZERO; i < size; i++) {
            moveUpOrDown = bridgeGame.move();
            if (moveUpOrDown.equals(ICON_UP)) {
                bridgeU = isEqual(randomCollect.get(i), bridgeU, moveUpOrDown);
                /*if (randomCollect.get(i).equals(moveUpOrDown))
                    bridgeU.add(ICON_COLLECT);
                if (!randomCollect.get(i).equals(moveUpOrDown))
                    bridgeU.add(ICON_FALSE);*/
                bridgeD.add(GAME_ICON_SPACE);
                bridgeU.add(GAME_ICON_BAR);
                bridgeD.add(GAME_ICON_BAR);
            }
            if (moveUpOrDown.equals(ICON_DOWN)) {
                bridgeD = isEqual(randomCollect.get(i), bridgeD, moveUpOrDown);
                bridgeU.add(GAME_ICON_SPACE);
                bridgeU.add(GAME_ICON_BAR);
                bridgeD.add(GAME_ICON_BAR);
            }
            printBridge(bridgeU, bridgeD, countCycle);

            if (bridgeU.contains(ICON_FALSE)) {
                System.out.println();
                return errorBridge;
            }
            if (bridgeD.contains(ICON_FALSE)) {
                System.out.println();
                return errorBridge;
            }
            countCycle += TWO;
            System.out.println();
        }
        joined.addAll(bridgeU);
        joined.addAll(bridgeD);
        return joined;
    }

    public List<String> makeRandomUpDown(int size) {
        List<String> inputUpDown = new ArrayList<>();
        for (int i = ZERO; i < size; i++) {
            int generateRandom = bridgeNumberGenerator.generate();
            System.out.print(generateRandom);
            if (generateRandom == 1)
                inputUpDown.add(ICON_UP);
            if (generateRandom == 0)
                inputUpDown.add(ICON_DOWN);
        }
        return inputUpDown;
    }

    public static void printBridge(List<String> bridgeUp, List<String> bridgeDown, int countCycle) {
        System.out.print("[ ");
        for (int j = ZERO; j < countCycle; j++)
            System.out.print(bridgeUp.get(j));
        System.out.print(" ]");
        System.out.println();
        System.out.print("[ ");
        for (int j = ZERO; j < countCycle; j++)
            System.out.print(bridgeDown.get(j));
        System.out.println(" ]");
    }

    private static List<String> isEqual(String randomCollect, List<String> bridge, String moveUpOrDown) {
        if (randomCollect.equals(moveUpOrDown))
            bridge.add(ICON_COLLECT);
        if (!randomCollect.equals(moveUpOrDown))
            bridge.add(ICON_FALSE);
        return bridge;
    }
}
