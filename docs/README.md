# 게임 : 다리 건너기 

---

## 구현할 기능 목록
- [x] 게임 시작 문구 출력
- [x] 다리 길이 입력 요청 문구 출력
- [x] 다리 길이 입력 받기
  - [x] 다리 길이 유효성 검사
    - [x] 숫자인가
    - [x] 3 이상 20 이하인가
    - [x] 유효성 검사 실패 시 재질문
- [x] 다리 생성
  - [x] 입력받은 다리 길이를 갖도록 생성
  - [x] 위와 아래 중 하나만 건널 수 있도록 생성
- [x] 게임 시도
  - [x] 시도 횟수 + 1
  - [x] 이동할 칸 선택 요청 문구 출력
  - [x] 이동할 칸 입력 받기
  - [x] 이동 입력 유효성 검사
    - [x] 'U' 혹은 'D' 인가
    - [x] 유효성 검사 실패 시 재질문
  - [x] 이동하기
  - [x] 이동 결과 확인
    - [x] 이동 상태를 표시하는 맵 업데이트
      - [x] 이동 위치가 유효한지 검사(실패했는가)
      - [x] 이동할 칸이 남았는지 확인(성공했는가)
    - [x] 이동에 대한 결과 출력
  - [x] 결과 출력 후 이동 성공 시 이동할 칸이 남았으면 이동 반복
  - [x] 결과 출력 후 이동 실패 시
    - [x] 게임 재시작 여부 입력 요청 문구 출력
    - [x] 게임 재시작 여부 입력 받기
    - [x] 재시작 입력 유효성 확인
      - [x] 'R' 혹은 'Q' 인가
      - [x] 유효성 검사 실패 시 재질문
  - [x] 게임 성공 시 최종 게임 결과 출력
    - [x] 최종 다리 상태 출력
    - [x] 게임 성공 여부 문구 출력
    - [x] 총 시도 횟수 출력
  
---

## 테스트 구현 기능 목록

### Class BridgeChecker

- [x] 다리 길이 입력 유효성 확인 기능
- [x] 이동 방향 입력 유효성 확인 기능
- [x] 재시도 여부 입력 유효성 확인 기능

### Class BridgeGame

- [x] 게임 시도 횟수 세는 기능
- [x] 게임 상태 확인하는 기능
  - [x] 성공했는지 확인하는 기능
  - [x] 실패했는지 확인하는 기능
  - [x] 진행 중인지 확인하는 기능
- [x] 게임 종료 시 게임 성공여부를 반환하는 기능 (진행 중이면 예외 발생)

### Class BridgeMaker

- [x] 랜덤으로 다리를 생성하는 기능 
> ApplicationTest에서 BridgeNumberGenerator 인터페이스을 상속 구현하여 이미 테스트함

### Class BridgeMap

- [x]  이동 상태를 저장하고 최신화하는 기능

### Class BridgeService

- [x] 세 가지 입력 예외가 발생하면 예외문구를 출력하고 다시 입력을 받는 기능 
> 입력값을 받는 로직이 포함되어 있으므로 'ApplicationTest.기능_테스트()'를 응용해서 테스트코드 작성

---

## 발생할 수 있는 예외

> IllegalStateException.class
- Class BridgeController.findOutSuccessOrNot()

해당 함수는 게임이 <b>종료됐을 때</b> 게임 성공 여부에 따른 문자열을 반환. 
게임이 종료되지 않았다면 잘못된 사용으로 예외 발생
> IllegalArgumentException.class
- Class BridgeChecker.validateBridgeSize(String bridgeSize)

다리 길이에 대한 유효성 검사 함수. 검사 실패 시 예외 발생


- Class BridgeChecker.validateMoving(final String moving)

이동 방향에 대한 유효성 검사 함수. 검사 실패 시 예외 발생


- Class BridgeChecker.validateGameCommand(final String gameCommand)

재시도 여부에 대한 유효성 검사 함수. 검사 실패 시 예외 발생

---

## TODO

- 예외 처리 후 다시 시작하는 방법이 재귀호출밖에 없는지 확인 -> throw 지점에서 처리할 수도 있는데 user에 대한 controller를 분리해서 그렇게 안하는 것이 좋을 듯
- 예외 처리할 필요없은 예외는 처리하지 않는다.
- 테스트코드 리팩토링
- 예외 문서화
- 예외가 발생하지 않는지 예외처리 단위를 테스트하는 방법은?