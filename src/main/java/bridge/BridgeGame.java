package bridge;

import domain.Bridge;
import domain.Result;
import enums.InputEnum;
import enums.ResultMessage;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    final InputView inputView = new InputView();
    final OutputView outputView = new OutputView();
    static final Result result = new Result();
    final Bridge bridge = new Bridge();
    static int trial = 1;
    int position = 0;
    static boolean flag = true;
    static List<String> bridgeAnswer;
    public BridgeGame(){
        System.out.println(InputEnum.START_BRIDGE_GAME.getValue() );
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(final List<String> bridgeAnswer) { //이동
            if(position == bridgeAnswer.size()) {
                result.setResult(true, trial);
                return false; //성공
            }
            if( bridgeAnswer.get(position).equals( inputView.readMoving() ) ){ // 맞는 경우
                outputView.printMap();
                position++;
                return true;
            }
            retry(); // 틀리면 -> 틀린 다리 상태 출력 & RETRY() 호
            return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        trial++;
        outputView.printMapWhenFail();
        String retrial = inputView.readGameCommand();
        if(retrial.equals("Q")) {
            System.out.println(ResultMessage.RESULT_INTRO_TEXT.getText());
            outputView.printResult(result);
            return;
        }
        start();
    }

    public void start() {
        while(flag){
            flag = move(bridgeAnswer);
        }
        outputView.printResult(result);

    }

    public void setUp(){
        final int size = inputView.readBridgeSize();
        bridgeAnswer = bridgeMaker.makeBridge(size);
        System.out.println(bridgeAnswer);
    }
}
