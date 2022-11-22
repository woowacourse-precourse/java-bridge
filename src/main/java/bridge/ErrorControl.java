package bridge;

public class ErrorControl {
    public ErrorControl(){    }

    public void brdigeSizeStrError(String command){
        if(!command.matches("-?\\d+"))
            throw new IllegalArgumentException(ErrorMessage.strError.getErrorMessage());
    }
    public void bridgeSizeError(int size){
        if(size < 3 && size > 20)
            throw new IllegalArgumentException(ErrorMessage.bridgeSizeError.getErrorMessage());
    }
    public void moveCommandError(String command){
        if(!command.equals("U") && !command.equals("D"))
            throw new IllegalArgumentException(ErrorMessage.strError.getErrorMessage());
    }
}
