package bridge;

import javax.sound.midi.SysexMessage;
import java.util.List;

import static bridge.ErrorCheck.isUpDown;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printInputMovement();
        String inputMove = inputView.readMoving();
        System.out.println(inputMove);
        isUpDown(inputMove);
        System.out.println("입력완료");
        return inputMove;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int retry() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        outputView.printRetry();
        if (inputView.readGameCommand().equals("R"))
            if(run() == 1)
                return 1;
        return 0;
    }

    public int run() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        outputView.printStart();
        outputView.printInputBridgeLength();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridgeDraw = bridgeMaker.makeBridge(bridgeSize);
        printFinalBridge(bridgeDraw);
        if(bridgeDraw.contains("e")) {
            return ONE;
        }
        return ZERO;
    }
    public void printFinalBridge(List<String> finalBridge) {
        OutputView outputView = new OutputView();
        outputView.printFinalResult();
        outputView.printIconOpen();
        for(int i=0; i<finalBridge.size()/TWO-ONE; i++)
            System.out.print(finalBridge.get(i));
        outputView.printIconClose();
        System.out.println();
        outputView.printIconOpen();
        for(int i=finalBridge.size()/TWO; i<finalBridge.size()-ONE; i++)
            System.out.print(finalBridge.get(i));
        outputView.printIconClose();
        System.out.println();
    }
}
