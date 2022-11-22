package bridge.Domain;

public class TryCount {
    private Integer count;


    private TryCount(int count){
        this.count = count;
    }

    public static TryCount firstTry(){
        return new TryCount(1);
    }

    public void pass(){
        count++;
    }
}
