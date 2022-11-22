package bridge;

public class GameResult {

    public String result;
    public int tryNumber;

    public GameResult(String result, int tryNumber){
        this.result = result;
        this.tryNumber = tryNumber;
    }

    public String getResult(){
        return result;
    }

    public int getTryNumber(){
        return tryNumber;
    }
}
