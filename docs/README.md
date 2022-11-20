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

- [x] 다리 길이 입력 기능
- [x] 움직일 칸 입력 기능
- [x] 게임 재시작 입력 기능

[BridgeConverter.java](../src/main/java/bridge/domain/bridgebuilder/BridgeConverter.java)

- [x] 난수로 생성된 숫자를 담은 List<Integer>를 List<String>으로 바꾸는 기능

[BridgeMaker.java](../src/main/java/bridge/domain/bridgebuilder/BridgeMaker.java)

- [x] 다리 생성 기능
- [ ] 사용자 입력과 다리 내용물 비교 기능
- [ ] 출력 기능

## 예외 목록

[UpOrDown.java](../src/main/java/bridge/domain/resources/UpOrDown.java)

- [x] 이동 칸 입력이 U나 D가 아닐 경우
- [ ] 다리 길이가 3 ~ 20 범위의 정수가 아닐 경우
- [ ] 재시작 입력이 R이나 Q가 아닐 경우