package bridge;

public enum UpAndDown {
    UP("U", 1, 0),
    DOWN("D", 0, 1);

    private String direction;
    private int inputDirectionNumber;
    private int index;

    UpAndDown(String direction, int inputDirectionNumber, int index) {
        this.direction = direction;
        this.inputDirectionNumber = inputDirectionNumber;
        this.index = index;
    }

    public String convertNumberToUpAndDown(int number){
        if(number == this.inputDirectionNumber){
            return this.direction;
        }
        return null;
    }

    public boolean isEqualDirection(String block){
        if(block.equals(this.direction)){
            return true;
        }
        return false;
    }

    public int getIndex() {
        return index;
    }
}
