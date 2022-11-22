package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Moving {

    private List<String> up;
    private List<String> down;
    private int count;
    private boolean right;

    public Moving(){
        this.up = new ArrayList<>();
        this.down = new ArrayList<>();
        this.count = 0;
        this.right = true;
    }

    public List<String> getUp(){
        return up;
    }
    public List<String> getDown(){
        return down;
    }

    public int getCount() {
        return count;
    }
    public void plusCount(){
        this.count = getCount()+1;
    }
    public void resetCount(){
        this.count = 0;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right){
        this.right = right;
    }
    public void resetUpDown(){
        up.clear();
        down.clear();
    }

    public void checkRight(String moving, String bridgeComponent){
        if(bridgeComponent.equals(moving))
            right = true;
        if(!bridgeComponent.equals(moving))
            right = false;
    }
    public void checkUp(String inputMoving){
        if(right && inputMoving.equals("U")) {
            up.add("O");
            down.add(" ");
        }
        if(!right && inputMoving.equals("U")) {
            up.add("X");
            down.add(" ");
        }
    }
    public void checkDown(String inputMoving){
        if(right && inputMoving.equals("D")) {
            down.add("O");
            up.add(" ");
        }
        if(!right && inputMoving.equals("D")) {
            down.add("X");
            up.add(" ");
        }
    }

}
