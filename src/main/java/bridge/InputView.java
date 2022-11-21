package bridge;

import bridge.Setting.BridgeLengthSetting;
import bridge.Setting.BridgeRetryIndex;
import bridge.Setting.BridgeSideIndex;
import bridge.Setting.OutputViewPrintEnum;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    static final String ERROR_MESSAGE = "[ERROR]";
    public int readBridgeSize(){
        while (true){
            try{
                System.out.println(OutputViewPrintEnum.INPUT_BRIDGE_LENGTH.getMessage());
                return getBridgeSize(Console.readLine());
            } catch (IllegalArgumentException e){
                System.out.println(ERROR_MESSAGE + e.getMessage());
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException {
        while (true){
            try{
                System.out.println(OutputViewPrintEnum.INPUT_BRIDGE_MOVE.getMessage());
                return getMoving(Console.readLine());
            } catch (IllegalArgumentException e){
                System.out.println(ERROR_MESSAGE + e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true){
            try{
                System.out.println(OutputViewPrintEnum.INPUT_BRIDGE_RETRY.getMessage());
                return getGameCommand(Console.readLine());
            } catch (IllegalArgumentException e){
                System.out.println(ERROR_MESSAGE + e.getMessage());
            }
        }
    }

    public int getBridgeSize(String line){
        try {
            int bridgeSize = Integer.parseInt(line);
            validBridgeSize(bridgeSize);
            return bridgeSize;
        } catch (IllegalArgumentException | NoSuchElementException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public String getMoving(String line) {
        try {
            validReadMoving(line);
            return line;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String getGameCommand(String line) {
        try{
            validReadGameCommand(line);
            return line;
        } catch (IllegalArgumentException | NoSuchElementException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void validReadGameCommand(String line) {
        List<BridgeRetryIndex> bridgeRetryIndices = List.of(BridgeRetryIndex.values());
        for (BridgeRetryIndex bridgeRetryIndex : bridgeRetryIndices){
            if (bridgeRetryIndex.getLabel().equals(line)){
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    private void validBridgeSize(int bridgeSize) {
        if (bridgeSize < BridgeLengthSetting.MIN_LENGTH.getLength()
                || bridgeSize > BridgeLengthSetting.MAX_LENGTH.getLength()) {
            throw new NoSuchElementException();
        }
    }

    private void validReadMoving(String line) {
        List<BridgeSideIndex> bridgeSideIndex = List.of(BridgeSideIndex.values());
        for (BridgeSideIndex bridgeSideEach : bridgeSideIndex) {
            if (bridgeSideEach.getLabel().equals(line)) {
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
