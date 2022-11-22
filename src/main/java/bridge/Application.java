package bridge;


import static bridge.BridgeGame.Bridge;
import static bridge.InputView.Ending_Enter;
import static bridge.InputView.Retry_Enter;

public class Application {
    public static final String FailPrint = "실패";
    public static final String SuccessPrint = "성공";

    static InputView input = new InputView();
    static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    static BridgeMaker maker = new BridgeMaker(bridgeRandomNumberGenerator);
    static BridgeGame bridgeGame = new BridgeGame();
    static OutputView outputView = new OutputView();
    static int Location = 0;
    static int TryNumber = 1;
    static String Command;


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        init();
        System.out.println(Bridge);
        while (Location < Bridge.size() && bridgeGame.Ending()) {
            Bridge_Move();
            Bridge_Check();
            EndingCheck();
            Location++;
        }
    }

    public static void init() {
        int size = input.readBridgeSize();
        Bridge = maker.makeBridge(size);
    }

    public static void Bridge_Move() {
        Command = input.readMoving();
        outputView.Area_Division(Bridge, Command, Location);
        outputView.printMap();
    }

    private static void Bridge_Check() {
        String Retry_Command = null;
        if (bridgeGame.move(Command, Location)) {
            Retry_Command = input.readGameCommand();
            RetryPrint(Retry_Command);
            Location = bridgeGame.retry(Retry_Command, Location);
        }
    }

    private static void RetryPrint(String Retry_Command) {
        if (Retry_Command.equals(Retry_Enter)) {
            outputView.Delete_Bridge();
            TryNumber++;
            return;
        }
        if (Retry_Command.equals(Ending_Enter)) {
            String Fail = FailPrint;
            outputView.printResult(TryNumber, Fail);
        }
    }
    private static void EndingCheck(){
        if(Location==(Bridge.size()-1)){
            String Success = SuccessPrint;
            outputView.printResult(TryNumber, Success);
        }
    }
}
