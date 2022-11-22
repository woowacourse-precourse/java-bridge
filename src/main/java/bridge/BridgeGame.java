package bridge;

import java.util.List;

public class BridgeGame {
    private List<String> bridge;
    private User player;

    public void start(List<String> bridge){
        this.bridge = bridge;
        this.player = new User();
    }

    public int move(String direction) {
        return player.move(bridge, direction);
    }

    public boolean retry(String text) {
        if (text.equals("R")){
            player.upRetry();
            return true;
        }
        return false;
    }

    public List<Result> getGameResult(){
        return player.makeGameResult();
    }

    public int getRetryCount(){
        return player.getRetry();
    }

    public boolean isSuccess(){
        return player.lastResultIsSuccess();
    }
}
