package bridge.study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class EnumTest {

    @AfterEach
    void resetEnumToOriginValue() {
        testEnum test = testEnum.Test;
        test.setTestValue("hello");
    }

    @Test
    @DisplayName("Enum의 값이 setter에 의해서 바뀌는지 확인")
    void Enum_값_변경_테스트() {
        testEnum testEnum = EnumTest.testEnum.Test;

        assertAll(() -> {
            assertThat(testEnum.getEnumValue()).isEqualTo("hello");
            testEnum.setTestValue("changed");
            assertThat(testEnum.getEnumValue()).isEqualTo("changed");

            testEnum secondTestEnum = EnumTest.testEnum.Test;
            assertThat(secondTestEnum.getEnumValue()).isEqualTo("changed");
        });

    }

    @Test
    @DisplayName("하나의 Enum값만 바꾸어도 해당 값들을 사용하는 모든 Enum의 값들이 바뀐다")
    void Enum_값_변경시_다른_enum에_영향을_주는지_검사() {
        testEnum testEnum = EnumTest.testEnum.Test;
        testEnum secondTestEnum = EnumTest.testEnum.Test;
        testEnum thirdTestEnum3 = EnumTest.testEnum.Test;
        testEnum fourthTestEnum4 = EnumTest.testEnum.Test;


        assertAll(() -> {
            assertThat(testEnum.getEnumValue()).isEqualTo("hello");
            testEnum.setTestValue("changed");
            assertThat(testEnum.getEnumValue()).isEqualTo("changed");
            assertThat(secondTestEnum.getEnumValue()).isEqualTo("changed");
            assertThat(thirdTestEnum3.getEnumValue()).isEqualTo("changed");
            assertThat(fourthTestEnum4.getEnumValue()).isEqualTo("changed");
        });

    }


    public enum testEnum {
        Test("hello");

        private String testValue;

        testEnum(String value) {
            this.testValue = value;
        }

        public void setTestValue(String testInput) {
            this.testValue = testInput;
        }

        public String getEnumValue() {
            return testValue;
        }
    }
}
