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

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        BridgeGame bridgeGame = new BridgeGame();
        List<String> bridgeU = new ArrayList<>();
        List<String> bridgeD = new ArrayList<>();
        List<String> joined = new ArrayList<>();
        List<String> randomCollect = makeRandomUpDown(size);
        int countCycle = 1;
        System.out.println("call makeBridge : " + size);
        System.out.println("@@@@");
        for (int i = 0; i < size; i++)
            System.out.println(randomCollect.get(i));
        //
        String moveUpOrDown;
        for (int i = 0; i < size; i++) {
            moveUpOrDown = bridgeGame.move();
            if (moveUpOrDown.equals("U")) {
                if (randomCollect.get(i).equals(moveUpOrDown))
                    bridgeU.add(ICON_COLLECT);
                if (!randomCollect.get(i).equals(moveUpOrDown))
                    bridgeU.add(ICON_FALSE); // 게임 re
                //bridgeD.add("$");
                bridgeD.add(GAME_ICON_SPACE);
                bridgeU.add(GAME_ICON_BAR);
                bridgeD.add(GAME_ICON_BAR);
            }
            if (moveUpOrDown.equals("D")) {
                if (randomCollect.get(i).equals(moveUpOrDown))
                    bridgeD.add(ICON_COLLECT);
                if (!randomCollect.get(i).equals(moveUpOrDown))
                    bridgeD.add(ICON_FALSE); // 게임 re
                //bridgeU.add("$");
                bridgeU.add(GAME_ICON_SPACE);
                bridgeU.add(GAME_ICON_BAR);
                bridgeD.add(GAME_ICON_BAR);
            }
            System.out.print("[ ");
            for(int j=0; j<countCycle; j++)
                System.out.print(bridgeU.get(j));
            System.out.print(" ]");
            System.out.println();
            System.out.print("[ ");
            for(int j=0; j<countCycle; j++)
                System.out.print(bridgeD.get(j));
            System.out.print(" ]");
            countCycle+=2;
            System.out.println();
        }
        joined.addAll(bridgeU);
        joined.addAll(bridgeD);

        return joined;
    }

    public List<String> makeRandomUpDown(int size) {
        List<String> inputUpDown = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int generateRandom = bridgeNumberGenerator.generate();
            System.out.print(generateRandom);
            if (generateRandom == 1)
                inputUpDown.add(ICON_UP);
            if (generateRandom == 0)
                inputUpDown.add(ICON_DOWN);
        }
        return inputUpDown;
    }
}
