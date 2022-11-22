package bridge;

public class GameRunner {
    InputView inputView;
    OutputView outputView;
    BridgeGame game;
    GameRunner(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public Player play()throws IllegalArgumentException{
        String input = inputView.readMoving();
        game.move(input);
        outputView.printMap(game);
        return game.status();
    }


    public void start()throws IllegalArgumentException{
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        game = new BridgeGame(new BridgeGameInfo(inputView.readBridgeSize()));
        while(true) {
            Player status = play();
            if(status==Player.WIN)break;
            if(status==Player.SURVIVE)continue;
            if(inputView.readGameCommand().equals("Q"))break;
            game.retry();
        }
        outputView.printResult(game);
    }

    public void run(){
        try{
            start();;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
