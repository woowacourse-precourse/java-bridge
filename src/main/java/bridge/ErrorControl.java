package bridge;

public class ErrorControl {
    public ErrorControl(){    }

    public void bridgeSizeStrError(String command){
        try {
            int tmp = Integer.parseInt(command);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException(ErrorMessage.strError.getErrorMessage());
        }
    }
    public void bridgeSizeError(int size){
        if(size < 3 && size > 20)
            throw new IllegalArgumentException(ErrorMessage.bridgeSizeError.getErrorMessage());
    }
    public void moveCommandError(String command){
        if(!command.equals("U") && !command.equals("D"))
            throw new IllegalArgumentException(ErrorMessage.strError.getErrorMessage());
    }
    public void retryCommandError(String command){
        if(!command.equals("R") && !command.equals("Q"))
            throw new IllegalArgumentException(ErrorMessage.strError.getErrorMessage());
    }
}
