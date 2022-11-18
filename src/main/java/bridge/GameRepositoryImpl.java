package bridge;

public class GameRepositoryImpl implements GameRepository{

    private int tryCount;

    public GameRepositoryImpl() {

        this.tryCount = tryCount;
    }


    @Override
    public int manageRetryStatus(String status) {
        tryCount =  new BridgeGame().retry(status);

        return tryCount;
    }
}
