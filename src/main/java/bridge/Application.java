package bridge;

public class Application {

    public static void main(String[] args) {
        GameService gameService = new GameService();
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        ErrorCheck errorCheck=new ErrorCheck();
        outputView.printStartString();              //시작 멘트 출력
        String sizeString=inputView.readBridgeSize();
        if(errorCheck.errorCheckReadBridgeSize(sizeString)){
            gameService.playGame(Integer.parseInt(sizeString));
        }

    }


}
