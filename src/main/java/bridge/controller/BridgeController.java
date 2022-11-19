package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.ErrorMessage;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeController {
    private List<String> bridge = new ArrayList<>();
    private InputView input = new InputView();
    private OutputView output = new OutputView();
    private BridgeGame bridgeGame = new BridgeGame();
    private BridgeRandomNumberGenerator random = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(random);

    public void bridgeCross(){
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        String count;
        count = bridgeLengthError();
        System.out.println();
        bridgeResult(bridgePlay(Integer.parseInt(count),bridge),output,count);
    }

    private void bridgeResult(List<String> bridge, OutputView output, String count){
        if(bridge.size() != Integer.parseInt(count)*2){
            output.printResult(bridge,"실패",BridgeGame.playcount);
            return;
        }
        output.printResult(bridge,"성공",BridgeGame.playcount);
    }
    private List<String> bridgePlay(int count, List<String> bridge){
        List<String> makeBridgeSafe = bridgeMaker.makeBridge(count);
        return bridgeGame.crossSelect(count,bridge,makeBridgeSafe);
    }

    private String bridgeLengthError(){
        String input;
        try{
            input = new InputView().readBridgeSize();
        }catch (IllegalArgumentException e){
            System.out.println(ErrorMessage.BRIDGE_LENGTH_RANGE.getMessage());
            return bridgeLengthError();
        }
        return input;
    }
}
