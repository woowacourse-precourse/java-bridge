package bridge;

import java.util.List;

import static bridge.ErrorCheck.isUpDown;
import static bridge.ErrorCheck.stringToInt;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

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
    public void retry() {
        run();
    }

    public void run(){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        outputView.printStart();
        outputView.printInputBridgeLength();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridgeDraw = bridgeMaker.makeBridge(bridgeSize);
        //outputView.printInputMovement();
/*        System.out.println();
        for(int i=0; i<bridgeDraw.size(); i++) {
            System.out.println(i + " " + bridgeDraw.get(i));
        }*/
        System.out.println();
        System.out.print("[ ");
        for(int i=0; i<bridgeSize*2-1; i++){
            System.out.print(bridgeDraw.get(i));
            //System.out.print("ㄴㅇㄴㅇㄹ");
        }
        System.out.print(" ]");
        System.out.println();
        System.out.print("[ ");
        for(int i=bridgeSize*2; i<bridgeSize*4-1; i++){
            System.out.print(bridgeDraw.get(i));
            //System.out.print("ㄴㅇㄴㅇㄹ");
        }
        System.out.print(" ]");

    }
}
