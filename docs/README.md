```
다시 건너기 게임을 시작합니다.

다리의 길이를 입력해주세요.
삼
[ERROR] 3 ~ 20 범위의 정수를 입력해야 합니다.
3
```

## 디렉토리, 클래스 목록

- controller
    - BridgeController
- view
    - InputView
    - OutputView
    - OutputMessage(Enum)
    - BridgeDesign(Enum)
- utils
    - EmptyChecker
    - InputParser
- domain
    - exception
        - SizeIllegalArgumentException
        - UDIllegalArgumentException
        - RQIllegalArgumentException
    - resources
        - UpOrDown
        - ReOrQuit
        - Bridge
        - UserBridge
          BridgeGame
          Application
          BridgeMaker
          BridgeNumberGenerator
          BridgeRandomNumberGenerator

## 기능 목록

[InputView.java](../src/main/java/bridge/view/InputView.java)

- 다리 길이 입력 기능

```
- 공백 제거
- null 체크
- 3 ~ 20 범위의 정수가 아닌 경우 예외 처리
- 예외 발생 시에 다시 입력
```

- 움직일 칸 입력 기능

```
- 공백 제거
- null 체크
- 대문자 U나 D가 아닐 경우 예외 처리
- 예외 발생 시에 다시 입력
```

- 게임 재시작 입력 기능

```
- 공백 제거
- null 체크
- 대문자 R이나 Q가 아닐 경우 예외 처리
- 예외 발생 시에 다시 입력
```

- 다리 생성 기능

```
- 난수를 받아서 List<Integer>에 담는다.
- List<Integer>를 List<String>으로 변환
```

- 비교 기능

```
- 사용자 입력과 다리 내용물이 같다면 O나 X를 OXBridge에 추가하는 기능
- 사용자 입력이 R이면 true, Q면 false를 반환하는 기능
```

- 출력 기능

```
- OXBridge에 축적된 내용물들을 출력하는 기능
- 안내 메시지 출력 기능
- 에러 메시지 출력 기능
```

## 예외 목록

- 이동 칸 입력이 U나 D가 아닐 경우
- 다리 길이가 3 ~ 20 범위의 정수가 아닐 경우
- 재시작 입력이 R이나 Q가 아닐 경우