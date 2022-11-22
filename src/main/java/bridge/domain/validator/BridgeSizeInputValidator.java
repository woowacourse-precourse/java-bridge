package bridge.domain.validator;

import bridge.ui.InputView;
import bridge.util.Errors;

public class BridgeSizeInputValidator implements Validator {
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    /**
     * 다리 길이 입력 값 통합 Validate 메서드
     * <p>
     *     <strong>호출 메서드</strong><br/>
     *     {@link #validateIsBlank(String)} <br/>
     *     {@link #validateIsInvalid(String)} <br/>
     *     {@link #validateRange(String)} <br/>
     * </p>
     * @param inputValue
     * @see InputView#readBridgeSize()
     */
    @Override
    public void validate(String inputValue) {
        validateIsBlank(inputValue);
        inputValue = inputValue.trim();
        validateIsInvalid(inputValue);
        validateRange(inputValue);
    }

    /**
     * 다리 길이 입력 값이 공백인지 검사한다.
     *
     * @exception IllegalArgumentException (메세지) {@link Errors#IS_EMPTY}
     * @param inputValue <strong>(String)</strong>
     * @see #validate(String)
     */
    @Override
    public void validateIsBlank(String inputValue) {
        if (inputValue.isBlank()) {
            throw new IllegalArgumentException(Errors.IS_EMPTY.message());
        }
    }

    /**
     * 다리 길이 입력값이 유효한 값인지 검사한다.
     * <p>
     *     - 3자리 수 이상의 정수 값<br/>
     *     - 1자리 ~ 2자리 수가 아닌 값 (문자, 기호 등)
     * </p>
     *
     * @exception IllegalArgumentException (메세지) {@link Errors#OUT_OF_BOUND} / {@link Errors#NOT_NUMBER}
     * @param inputValue <strong>(String)</strong>
     * @see #validate(String)
     */
    @Override
    public void validateIsInvalid(String inputValue) {
        if(inputValue.matches("\\d{3,}")){
            throw new IllegalArgumentException(Errors.OUT_OF_BOUND.message());
        }
        if (!inputValue.matches("\\d{1,2}")) {
            throw new IllegalArgumentException(Errors.NOT_NUMBER.message());
        }

    }

    /**
     * 다리 길이 입력값이 3 이상 20 이하의 값인지 검사한다.
     * <p>
     *     {@link #MIN_SIZE} 와 {@link #MAX_SIZE} 에서 벗어날 경우
     * </p>
     *
     * @exception IllegalArgumentException (메세지) {@link Errors#OUT_OF_BOUND}
     * @param inputValue <strong>(String)</strong>
     * @see #validate(String)
     */
    public void validateRange(String inputValue) {
        int inputValueToInt = Integer.parseInt(inputValue.trim());
        if (inputValueToInt < MIN_SIZE || inputValueToInt > MAX_SIZE){
            throw new IllegalArgumentException(Errors.OUT_OF_BOUND.message());
        }
    }
}
