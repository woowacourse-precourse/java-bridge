package bridge;

import java.util.ArrayList;
import java.util.List;

public class UserMove {
    private int tryCount=0;
    private List<String> userLocation=new ArrayList<>();

    public void increaseTryCount(){
        tryCount++;
    }
}
