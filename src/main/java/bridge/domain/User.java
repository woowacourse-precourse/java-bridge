package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<String> movings = new ArrayList<>();
    private int count;
    private ClearConfirm clearConfirm;

    public User(){
        this.clearConfirm = ClearConfirm.실패;
        this.count = 1;
    }

    public void addMoving(String moving){
        this.movings.add(moving);
    }

    public void clearMovings(){
        this.movings.clear();
        addCount();
    }

    private void addCount(){
        count++;
    }

    public List<String> getMovings() {
        return movings;
    }

    public int getCount() {
        return count;
    }

    public void setClearConfime(ClearConfirm clearConfirm) {
        this.clearConfirm = clearConfirm;
    }

    public ClearConfirm getClearConfirm() {
        return clearConfirm;
    }
}
