package bridge;

public class Application {
    static GameService gameService = new GameService();
    static OutputView outputView = new OutputView();
    static InputView inputView = new InputView();
    static ErrorCheck errorCheck = new ErrorCheck();

    public static void main(String[] args) {
        outputView.printStartString();              //시작 멘트 출력
        String sizeString = "";
        boolean gameStartSign = false;
        while (!gameStartSign) {
            sizeString = inputView.readBridgeSize();
            gameStartSign = errorCheck.errorCheckReadBridgeSize(sizeString);
        }
        gameService.playGame(Integer.parseInt(sizeString));
    }


}
