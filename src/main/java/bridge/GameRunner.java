package bridge;

public class GameRunner {
    InputView inputView;
    OutputView outputView;
    BridgeGame game;
    GameRunner(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void play(){
        String input = inputView.readMoving();
        game.move(input);
        outputView.printMap(game);
    }
    public void run(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        int size = inputView.readBridgeSize();
        game = new BridgeGame(new BridgeGameInfo(size));
        String gameCommand="R";
        while(gameCommand.equals("R")) {
            play();
        }
    }

}
