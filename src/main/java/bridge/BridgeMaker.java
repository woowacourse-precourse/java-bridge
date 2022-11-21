package bridge;

import view.InputView;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static BridgeNumberGenerator bridgeNumberGenerator;
    private static final int BRIDGE_MAX_LONG = 20;
    private static final int BRIDGE_MIN_LONG = 3;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public static List<String> makeBridge() {
        while (true) {
            try{
                int size = InputView.readBridgeSize();
                return makeBridge(size);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public static List<String> makeBridge(int size) {
        List<String> blocks = getBlocks(size);
        validateBridgeSize(blocks);
        return blocks;
    }

    private static List<String> getBlocks(int size) {
        List<String> blocks = new ArrayList<>();
        String[] upDown = {"D","U"};

        for (int i = 0; i< size; i++) {
            int bridgeBlock = bridgeNumberGenerator.generate();
            blocks.add(upDown[bridgeBlock]);
        }
        return blocks;
    }

    private static void validateBridgeSize(List<String> blocks) {
        if (blocks.size() > BRIDGE_MAX_LONG){
            throw new IllegalArgumentException("[ERROR] 최대 20까지 입력할 수 있습니다.");
        }

        if (blocks.size() < BRIDGE_MIN_LONG){
            throw new IllegalArgumentException("[ERROR] 최소 3이상의 숫자를 적어주세요.");
        }
    }

}
