package bridge;

public class Application {
    static final int ERROR=-1;
    public static void main(String[] args) {
        ReadSize readSize = new ReadSize();
        while (readSize.bridgeSize()==-1){
            readSize = new ReadSize();
        }
    }
}
class ReadSize{
    static final int ERROR=-1;
    public int bridgeSize(){
        InputView inputview = new InputView();  int size=0;
        try { size=inputview.readBridgeSize(); }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return ERROR;
        }
        return size;
    }
}