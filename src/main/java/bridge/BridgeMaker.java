package bridge;

import java.util.List;


/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;


    InputView inputView = new InputView();

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;

    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {

        List<Integer> bridgeSize = inputView.readBridgeSize();

        String[] Column = new String[size];
        for (int i = 0; i < Column.length; i++) {
            if (bridgeSize.get(i) == 1) {
                Column[i] = " O";
            } else if (bridgeSize.get(i) != 1) {
                Column[i] = " X";
            }
        }
        String ColumnString = String.join(" | ", Column);


        return List.of(ColumnString);
    }

    public List<String> downMakeBridge(int size) {

        List<Integer> downbridgeSize = inputView.readBridgeSize();
        String[] downColumn = new String[size];
        for (int i = 0; i < downColumn.length; i++) {
            if (downbridgeSize.get(i) == 0) {
                downColumn[i] = " O";
            } else if (downbridgeSize.get(i) != 0) {
                downColumn[i] = " X";
            }
        }
        String downColumnString = String.join(" | ", downColumn);

        return List.of(downColumnString);
    }




}
