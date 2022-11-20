### 기능 목록
#### 1. BridgeGame 클래스
- 사용자로부터 U, D을 입력받아 칸 하나를 움직이는 함수
- 사용자로부터 게임을 재시작할지 정보를 입력받아 게임을 재시작할지 말지 결정하는 함수
- 다리에 끝까지 도착했는지 파악하는 함수(-> User 클래스 내에서 판단하는 것이 더 효율적일 수 있기에 보류)

#### 2. BridgeMaker 클래스
##### Bridge를 생성하는 클래스로 BridgeGame 클래스와 OutputView 클래스의 생성자의 인자로 들어간다.
- 입력받은 다리 사이즈에 따라 랜덤하게 Bridge를 생성하는 함수

#### 3. BridgeRandomNumberGenerator 클래스
##### BridgeNumberGenerator 인터페이스의 구현 클래스
- 랜덤하게 0과 1을 생성하는 함수


#### 4. InputView 클래스
##### 사용자로부터 입력을 받는 클래스로 예외에 대해 재귀적으로 함수를 작성
- 사용자로부터 다리의 길이를 입력받는 함수
- 사용자로부터 이동할 칸을 입력받는 함수
- 사용자로부터 게임 재시작 여부를 입력받는 함수
- 사용자로부터 입력받은 값이 올바른지 판단하는 함수(사용자 입력은 모두 String으로 전달)
```java
class InputView {
    private void validate(String input, ValidationType validationRange) {
        // input이 validationRange에 포함되지 않으면 IllegalArgumentException 발생
    }
}
```

#### 4-1 ValidationType enum 클래스
##### 사용자의 입력을 검증하기 위한 enum 클래스로 각 입력 범위를 인스턴스로로 가짐

#### 5. OutputView
- 이동한 칸 수와 이동 성공 여부를 전달받아 다리의 상태를 출력하는 함수
- 게임 성공 여부와 시도 횟수를 전달받아 게임의 최종 결과를 출력하는 함수
- 게임 시작 문구를 출력하는 함수
- 다리 길이 입력 문구를 출력하는 함수
- 칸 이동 시 입력 문구를 출력하는 함수
- 출력 조건에 맞게 한 줄의 다리를 출력하는 함수
- 한 칸의 상태가 O, X, 공백인지 정해서 리턴하는 함수

#### 6. GameStart 클래스
##### InputView, BridgeGame, OutputView를 포함해 게임을 진행하는 클래스
- 게임을 진행하는 run 함수
- 재시작 여부를 체크하는 함수