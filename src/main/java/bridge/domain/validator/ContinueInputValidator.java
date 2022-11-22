package bridge.domain.validator;

import bridge.ui.InputView;
import bridge.util.Errors;

public class ContinueInputValidator implements Validator {

    private static final String CONTINUE_VALUE = "R";
    private static final String QUIT_VALUE = "Q";

    /**
     * 재시도 여부 입력 값 통합 Validate 메서드
     * <p>
     *     <strong>호출 메서드</strong><br/>
     *     {@link #validateIsBlank(String)} <br/>
     *     {@link #validateIsInvalid(String)} <br/>
     *     {@link #validateIsUpperCase(String)} <br/>
     * </p>
     * @param inputValue
     * @see InputView#readContinue()
     */
    @Override
    public void validate(String inputValue) {
        validateIsBlank(inputValue);
        inputValue = inputValue.trim();
        validateIsInvalid(inputValue);
        validateIsUpperCase(inputValue);
    }

    /**
     * 재시도 여부 입력 값이 공백인지 검사한다.
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
     * 재시도 여부 입력 값이 유효한 값인지 검사한다.
     * <p>
     *     <strong>대소문자 상관없이</strong> {@link #CONTINUE_VALUE} 혹은 {@link #QUIT_VALUE} 값과의 일치 여부
     * </p>
     *
     * @exception IllegalArgumentException (메세지) {@link Errors#INVALID_CONTINUE_VALUE}
     * @param inputValue <strong>(String)</strong>
     * @see #validate(String)
     */
    @Override
    public void validateIsInvalid(String inputValue) {
        if (!inputValue.matches("[rRqQ]")) {
            throw new IllegalArgumentException(Errors.INVALID_CONTINUE_VALUE.message());
        }
    }

    /**
     * 재시도 여부 입력 값이 R 혹은 Q 값이 맞는지 검사한다.
     * <p>
     *     {@link #CONTINUE_VALUE} 혹은 {@link #QUIT_VALUE} 값과의 일치 여부
     * </p>
     *
     * @exception IllegalArgumentException (메세지) {@link Errors#NOT_UPPERCASE}
     * @param inputValue <strong>(String)</strong>
     * @see #validate(String)
     */
    public void validateIsUpperCase(String inputValue) {
        if (inputValue.equals(CONTINUE_VALUE.toLowerCase()) || inputValue.equals(QUIT_VALUE.toLowerCase())) {
            throw new IllegalArgumentException(Errors.NOT_UPPERCASE.message());
        }

    }
}
