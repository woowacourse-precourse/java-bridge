package bridge;

import domain.Bridge;
import domain.Result;
import enums.BridgeEnum;
import enums.PrintEnum;
import enums.ResultMessage;
import view.InputView;
import view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    final InputView inputView = new InputView();
    final OutputView outputView = new OutputView();
    static final Result result = new Result();
    static final Bridge bridge = new Bridge();
    static int trial = 1;
    static int position = 0;
    static List<String> bridgeAnswer;
    public BridgeGame(){
        System.out.println(PrintEnum.START_BRIDGE_GAME.getValue() );
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        while(true) {
            if( setResultWhenSuccess() ) break;
            final String moving = inputView.readMoving();
            if ( showWhenCorrect(moving) ) continue;
            insertMovingWhenFail(moving, position);
            outputView.printMapWhenFail(bridge, position);
            retry(moving);
        }
    }

    private boolean setResultWhenSuccess(){
        if (position == bridgeAnswer.size()) {
            result.setResult(ResultMessage.SUCCESS.getText(), trial);
            return true;
        } return false;
    }

    private boolean showWhenCorrect(String moving){
        insertMovingWhenSuccess(moving, position);
        if ( bridgeAnswer.get(position).equals(moving) ) {
            position++;
            outputView.printMap(bridge, position);
            return true;
        } return false;
    }

    private void insertMovingWhenSuccess(String moving, int position){
        if(moving.equals(BridgeEnum.U.name())) {
            bridge.getUp().add(position,PrintEnum.O.getValue());
        }
        if(moving.equals(BridgeEnum.D.name())) {
            bridge.getDown().add(position,PrintEnum.O.getValue());
        }
    }

    private void insertMovingWhenFail(String moving, int position){
        if(moving.equals(BridgeEnum.U.name())){
            bridge.getUp().add(position,PrintEnum.X.getValue());
        }
        if(moving.equals(BridgeEnum.D.name())) {
            bridge.getDown().add(position,PrintEnum.X.getValue());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void retry(String moving) {
        trial++;
        String retrial = inputView.readGameCommand();
        if(retrial.equals("Q")) {
            System.out.println(ResultMessage.RESULT_INTRO_TEXT.getText());
            outputView.printResult(result ,bridge, position);
            return;
        }
    }

    public void start() {
        move();
        outputView.printResult(result, bridge, position);
    }

    public void setUp(){
        final int size = inputView.readBridgeSize();
        bridgeAnswer = bridgeMaker.makeBridge(size);
        System.out.println(bridgeAnswer);
    }
}
