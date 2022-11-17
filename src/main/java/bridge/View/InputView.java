package bridge.View;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.Model.BridgeDTO;
import bridge.Model.ErrorUtil;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    ErrorUtil errorUtil = new ErrorUtil();
    BridgeDTO bridgeDTO = new BridgeDTO();

    private String inputSizeData;
    private int transSizeData;

    public BridgeDTO makeBridgeData() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        setBridgeSize();
        transBridgeSize();
        bridgeDTO.setBridge(bridgeMaker.makeBridge(transSizeData));
        return bridgeDTO;
    }

    public void setBridgeSize() {
        this.inputSizeData = readLine();
        errorUtil.errorBridgeSizeNotNumber(inputSizeData);
    }

    public void transBridgeSize() {
        this.transSizeData = Integer.parseInt(inputSizeData);
        errorUtil.errorBridgeSize(transSizeData);
        bridgeDTO.setSize(transSizeData);
    }

    public String readMoving() {
        String inputUpDown = readLine();
        errorUtil.errorInputReadMoving(inputUpDown);
        return inputUpDown;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
