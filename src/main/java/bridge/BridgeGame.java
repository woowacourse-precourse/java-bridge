package bridge;


import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
// * 제공된 BridgeGame 클래스를 활용해 구현해야 한다.
// * BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다.
// * BridgeGame의 패키지는 변경할 수 있다.
// * BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
// * 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.
 */
public class BridgeGame {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    static String failOrTure ="성공";
    static List<String> randomBridge;
    static int count = 1;

    public void move() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        randomBridge = bridgeMaker.makeBridge(inputView.bridgeLength);
        System.out.println(randomBridge);
        for(int i = 0; i < randomBridge.size(); i++){
            String upAndDown = inputView.readMoving();
            if(!randomBridge.get(i).equals(upAndDown)) {
                outputView.wrongPrintMap(randomBridge.get(i));
                failOrTure = "실패";
                break;
            }
            if(randomBridge.get(i).equals(upAndDown)){
                outputView.printMap(randomBridge.get(i));
                failOrTure = "성공";
            }
        }
        if(failOrTure.equals("성공")){
            outputView.printResult(failOrTure, count);
        }
    }


    public String retry() {
        String retry = inputView.readGameCommand();
        if(retry.equals("R")){
            outputView.printMap1.clear();
            outputView.printMap2.clear();
            randomBridge.clear();
            count++;
            move();
        }
        if(retry.equals("Q")){
            outputView.printResult(failOrTure, count);
        }
        return retry;
    }

}
