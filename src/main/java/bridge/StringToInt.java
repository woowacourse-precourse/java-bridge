package bridge;

public class StringToInt implements InputStringShape{
    @Override
    public int toInt(String inputsize){
        int bridgesize = Integer.parseInt(inputsize);
        return bridgesize;
    }
}
