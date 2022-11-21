package bridge;

public class UserConsole {
    /// user console class bridge class  - >  user interaction calss
    private InputView inputView;
    private OutputView outputView;
    private int round ;
    private int totalNumber ;
    private Bridge bridge;
    private BridgeGame bridgeGame ;
    //input view class
    //output view class
    public UserConsole(){
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame(); /// get init userconsole instance
        this.round = 0;
    }

    public void initGame(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        bridgeGame.initGame(inputView.readBridgeSize());
    }
    public void startGame(){
        bridge = bridgeGame.getBridgeInstance();
        while (round < bridgeGame.getBridgeSize()) {
            boolean result =bridge.getComparison(round,inputView.readMoving());
            round++;
            bridgeGame.move(result);
            if(!result) {
                retry(totalNumber,inputView.readGameCommand());
            }
        }
    }
    public void endGame(){
        System.out.println("최종 게임 결과");
        System.out.println();
    }
    public void retry(int totalNumber,String userInput){
        if(bridgeGame.retry(totalNumber,userInput)){
            round = 0 ;
            startGame();
        }
        if(!bridgeGame.retry(totalNumber,userInput)){
            endGame();
        }
    }
}
