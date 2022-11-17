package bridge;

public enum UpAndDown {
    UP("U", 1),
    DOWN("D", 0);

    private String direction;
    private int inputDirectionNumber;

    UpAndDown(String direction, int inputDirectionNumber) {
        this.direction = direction;
        this.inputDirectionNumber = inputDirectionNumber;
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

    public String getDirection() {
        return direction;
    }

    public int getInputDirectionNumber() {
        return inputDirectionNumber;
    }
}
