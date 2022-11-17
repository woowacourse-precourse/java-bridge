package bridge;

import java.util.regex.Pattern;

public class BridgeSizeValidator {

    String size;

    public BridgeSizeValidator(String size) {
        this.size = size;
        validate();
    }

    public void validate(){
        validateInputNonBlank(); //공백인지를 먼저 파악한다.
        validateInputType(); //그 다음으로 숫자만으로 구성되었는지를 파악해야 한다. 그래야 정수 형태로 변환이 가능
        validateInputSize();
    }

    private void validateInputNonBlank(){
        if(size.equals("")){
            throw new IllegalArgumentException("[ERROR] 값을 넣어야합니다.");
        }
    }

    private void validateInputType(){
        if(!Pattern.matches(Constants.PATTERN, size)){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }

    private void validateInputSize() {
        if(Integer.parseInt(size)<Constants.MIN_LENGTH||Integer.parseInt(size)>Constants.MAX_LENGTH){
            throw new IllegalArgumentException("[ERROR] 3이상 20이하의 길이를 입력해야 합니다.");
        }
    }

}
