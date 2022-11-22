package bridge;
import java.util.List;
public class BridgeGame {
    private final List<String> bridge;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    MoveCheck moveCheck;
    MoveStatus moveStatus = new MoveStatus();
    private boolean availableToMove;
    public List<List<String>> statusMap = null;
    public BridgeGame (List<String> bridge){
        this.bridge = bridge;
    }
    public List<List<String>> move(int moveValue, String moves){
        moveCheck = new MoveCheck(bridge);
        availableToMove = moveCheck.checkIfAvailableToMove(moveValue,moves);
        statusMap = moveStatus.printMoves(moves,availableToMove);
        return statusMap;
    }
    public boolean getAvailableToMove(){
        return availableToMove;
    }
    public boolean retry(String readCommand){
        if (readCommand.equals("R")) {
            return true;
        }
        return false;
    }
}
