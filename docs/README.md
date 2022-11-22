# 기능 요구 사항
- [x] 입력 받기
  - [x] 다리 사이즈 입력받기
  - [x] 방향 입력 받기
    - [x] 옳지 않은 값이면 에러메시지 출력 후 다시 입력받기
  - [x] 재시작 혹은 종료 입력받기
    - [x] 옳지 않은 값이면 에러메시지 출력 후 다시 입력받기
- [x] 입력 검증
  - [x] null
  - [x] 숫자인지
  - [x] 범위가 옳은지 (3~20)
  - [x] R 혹은 Q인지
  - [x] U 혹은 D인지
- [x] 다리를 무작위 값(0 혹은 1)을 이용하여 생성
  - [x] 무작위 값이 0인 경우 아래칸, 1인 경우 위칸이 건널 수 있는 칸
- [x] 입력 받은 칸이 건널 수 있다면 O, 없다면 X로 표시
- [x] 다리를 끝까지 건너면 게임 종료
- [x] 다리 건너기를 실패하면 게임 재시작 or 종료
  - [x] 재시작 해도 처음에 만든 다리로 재사용
- [x] 총 시도한 횟수를 표시 (게임 성공한 경우)
- [x] enum 상수화
  - [x] 컨트롤 키
  - [x] 예외 메시지
  - [x] 게임 내의 가이드 메시지
  - [x] 다리의 범위


# 패키지 구조

```
bridge
  │
  ├─📁 controller
  │       └─ BridgeController
  │
  ├─📁 enums
  │       └─ ControlKey
  │       └─ ExceptionMessage
  │       └─ InGameMessage
  │       └─ MapOutputFormat
  │       └─ Range
  │
  ├─📁 io
  │    ├─ 📁 validation
  │               └─ InputValidation
  │               └─ NullValidation
  │               └─ NumberValidation
  │               └─ RangeValidation
  │               └─ ROrQValidation
  │               └─ UOrDValidation
  │               └─ Validation
  │               └─ ValidationDecorator
  │    ├─ InputView
  │    └─ OutputView
  ├─📁 model
  │       └─ Bridge
  ├─📁 service
  │       └─ BridgeGame
  │       └─ MapMaker
  ├─ Application
  ├─ BridgeMaker
  ├─ BridgeNumberGenerator
  └─ BridgeRandomNumberGenerator
```