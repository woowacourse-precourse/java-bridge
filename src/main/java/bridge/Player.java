package bridge;

import java.util.List;

public class Player {

    private int coinUsed = 0;
    private PlayerBridge playerBridge;
    private List<String> rightBridge;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void makeNewPlayerBridge(){
        this.playerBridge = new PlayerBridge();
    }

    public void makeRightBridge(int bridgeSize) {
        this.rightBridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
    }

    public void useCoin(){
        coinUsed+=1;
    }

    public void moving() {
        for (String rightRoot : rightBridge) {
            String moving = inputView.readMoving();
            if(compareRightRoot(rightRoot, moving)){
                outputView.printMap(playerBridge);
                continue;}
            if(compareWrongRoot(rightRoot, moving)){
                outputView.printMap(playerBridge);
                break;}}
    }


    private boolean compareRightRoot(String rightRoot, String moving) {
        if(isRightAndUpRoot(rightRoot, moving)) {
            playerBridge.addUpRootRight();
            return true;}
        if (isRightAndDownRoot(rightRoot, moving)){
            playerBridge.addDownRootRight();
            return true;}
        return false;
    }

    private boolean compareWrongRoot(String rightRoot, String moving) {
        if(isWrongAndUpRoot(rightRoot, moving)){
            playerBridge.addUpRootWrong();
            return true;}
        if (isWrongAndDownRoot(rightRoot, moving)){
            playerBridge.addDownRootWrong();
            return true;}
        return false;}

    private boolean isWrongAndDownRoot(String rightRoot, String moving) {
        return !moving.equals(rightRoot) && moving.equals("D");
    }

    private boolean isWrongAndUpRoot(String rightRoot, String moving) {
        return !moving.equals(rightRoot) && moving.equals("U");
    }

    private boolean isRightAndDownRoot(String rightRoot, String moving) {
        return moving.equals(rightRoot) && moving.equals("D");
    }

    private boolean isRightAndUpRoot(String rightRoot, String moving) {
        return moving.equals(rightRoot) && moving.equals("U");
    }


    public boolean fail() {
        return !playerBridge.successRoot();
    }

    public boolean success(){
        return playerBridge.successRoot();
    }

    public PlayerBridge findPlayerBridge(){return playerBridge;}

    public int findCoinUsed(){return coinUsed;}

    public String readGameCommand(){
        return inputView.readGameCommand();
    }

}
