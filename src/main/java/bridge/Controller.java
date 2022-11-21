package bridge;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;
    private final Bridge bridge;

    public Controller() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = new Bridge();
    }

    public void runGame(){
        beforeStartGame();
        int count = 1;
        String result = "";
        while(true){
            startGame();
            if(bridgeGame.isFail()){
                outputView.printLine("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                String s = inputView.readGameCommand();
                if(bridgeGame.retry(s)){
                    count++;
                    continue;
                }
                result = "실패";
                outputView.printResult(bridgeGame.getLines(), result, count);
                break;
            }
            if (bridgeGame.isSuccess(bridge.getElementsOfBridge().size())) {
                result = "성공";
                outputView.printResult(bridgeGame.getLines(), result, count);
                break;
            }
        }

    }

    public void beforeStartGame(){
        outputView.printLine("다리 건너기 게임을 시작합니다.\n");
        outputView.printLine("다리의 길이를 입력해주세요");
        int size = inputView.readBridgeSize();
        bridge.setElementsOfBridge(bridgeMaker.makeBridge(size));
        System.out.println();
    }

    public void startGame(){
        for(String element : bridge.getElementsOfBridge()){
            outputView.printLine("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String s = inputView.readMoving();
            bridgeGame.move(element, s);
            outputView.printMap(bridgeGame.getLines());
            System.out.println();
        }
    }

    public void afterGame(){

    }

}
