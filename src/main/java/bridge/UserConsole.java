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
        round = 0 ;
        boolean check = true;
        bridge = bridgeGame.getBridgeInstance();
        System.out.println(bridgeGame.getBridgeSize());
        while (round < bridgeGame.getBridgeSize()) {
            System.out.println("input U or D");
            boolean result =bridge.getComparison(round,inputView.readUserInput());
            round++;
            bridgeGame.move(result);
            if(!result) {
                System.out.println("틀렸습니다 R or Q");
                String userInput = inputView.readUserInput();
                retry(totalNumber,userInput);
            }
        }

    }
    public void endGame(){
        System.out.println("EndGame");
        System.out.println();
    }
    public void retry(int totalNumber,String userInput){
        if(bridgeGame.retry(totalNumber,userInput)){
            startGame();
        }
        if(!bridgeGame.retry(totalNumber,userInput)){
            endGame();
        }
    }
}
