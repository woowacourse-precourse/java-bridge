package bridge.Controller;

import bridge.Domain.BridgeMaker;
import bridge.Domain.BridgeNumberGenerator;
import bridge.Domain.BridgeRandomNumberGenerator;
import bridge.View.InputView;

public class Controller {
    public InputView inputView;
    public BridgeNumberGenerator bridgeNumberGenerator;
    public BridgeMaker bridgeMaker;
    public void run(){
        inputView = new InputView();
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();

        //다리 길이 입력 받기
        int bridgeLen = inputView.readBridgeSize();

        //다리 생성하기

        //게임 시작
        String moving = inputView.readMoving();

        ////성공

        ////실패
        String gameCommand = inputView.readGameCommand();

        //결과 출력
    }

}
