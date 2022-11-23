# 4주차 미션 - 다리 건너기

게임을 시작하고 다리를 길이를 입력하면 지나갈 수 있는 정보를 가진 숨겨진 다리 정보가 생성됩니다.

움직임은 U(위)와 D(아래)로 움직일 수 있으며, 생성된 다리 정보와 일치하지 않으면 다리 건너기를 실패합니다.

다리를 지나가는데 실패하면 재동작 여부가 나오고 R(재시작), Q(종료) 키에 따라 재시작 여부를
결정 할 수 있습니다.

성공시에는 시도 횟수를 출력하고 종료합니다.

잘못된 사용자 입력의 경우 그 시점부터 다시 입력을 받습니다.

최종적으로 게임 종료시 게임 결과를 리턴합니다.

## 패키지 구조
```text
├── controller/
│   └── BridgeController.java
│ 
├── domain/
│   ├── BridgeLength.java
│   ├── BridgeStatus.java
│   ├── GameStatus.java
│   ├── MovingCommand.java
│   └── RetryCommand.java
│ 
├── service/
│   └── BridgeGame.java
│
├── cache/
│   └── BridgeStatusSaver.java
│
├── io/
│   └── ConsoleReader.java
│ 
├── view/
│   ├── View.java
│   ├── InputView.java
│   ├── OutputView.java
│   └── draw/
│       ├── BridgeDrawer.java
│       ├── BridgeCommonDrawer.java
│       ├── BridgeFailDrawer.java
│       └── BridgeDrawerFactory.java
│ 
├── Application.java
│ 
├── BridgeMaker.java
├── BridgeNumberGenerator.java
└── BridgeRandomNumberGenerator.java
```
## 기능 목록

### 도메인 객체
- [x] 다리 길이(BridgeLength)
  - [x] 3에서 20사이의 숫자만 입력받아서 데이터 생성

- [x] 다리 게임 정보(BridgeStatus)
  - 브리지 게임의 정보를 담은 객체
  - [x] 정답 bridge, 사용자 입력 bridge, 시도 횟수, 게임 상태 대한 정보를 가짐
  - [x] 사용자 입력 추가 시 정답 bridge와 match 여부에 따라 게임 상태 업데이트
  - [x] 게임 재시작 요청 여부에 대한 boolean 값 제공
    - GameStatus가 SUCCESS, FAIL인 경우 true, IN_PROCESS인 경우 false
  - [x] 시도 횟수 업데이트
  - [x] 시도 횟수 제공
  - [x] userBridge를 빈 값으로 초기화 및 GameStatus을 진행 중 으로 초기화
    - 초기화시 1로 초기화 해야함

- [x] 움직임 명령(MovingCommand)
  - [x] UP("U"), DOWN("D") 목록을 가진다
  - [x] 입력 문자열이 U 또는 D임을 검증하고 변환하는 기능

- [x] 재시작 요청(RetryCommand)
  - [x] Retry("R"), Quit("Q") 목록을 가진다
  - [x] 입력 값이 R 또는 Q임을 검증하고 반환하는 기능

- [x] 게임 상태(GameStatus)
  - [x] SUCCESS, IN_PROGRESS, FAIL 3가지 목록을 가진다
  - [x] 상태에 따른 재실행 여부 기능 추가
  - [x] Details 상태 추가("성공", "진행중", "실패")
  - [x] 실패 여부 확인 기눙

### 입력 / 출력

- [x] 뷰(View)
  - [x] 출력
  - [x] 에러 출력

- [x] 입력뷰(InputView)
  - [x] bridgeSize를 입력 받음
    - [x] 숫자 변환에 대한 예외를 처리함
    - [x] 정수형으로 입력 받음
  - [x] 움직임 명령을 입력 받음
    - [x] 문자열로 입력 받음
  - [x] 재시작 여부에 대해 입력받음
    - [x] 문자열로 입력 받음
  - [x] 예외 발생시 예외 로그를 출력하고 다시 동작을 시도한다.
  - 추가 사항
    - 패키지 변경 가능
    - 기존 메서드 변경 X
    - 인자, 이름, 반환 타입 변경 가능
    - 사용자 입력을 위해 필요한 메서드 추가 가능

- [x] 출력뷰(OutputView)
  - [x] 현재 다리 진행 상태를 보여주는 기능
    - 두 개의 [ ] 사이에 데이터를 표현하도록 함
    - | 로 구분함(양측 사이에 공백)
  - [x] 최종 결과를 출력 기능
  - [x] 빈 칸 추가 기능
  - 추가 사항
    - 패키지 변경 가능
    - 기존 메서드 변경 X
    - 인자, 이름, 반환 타입 변경 가능
    - 사용자 입력을 위해 필요한 메서드 추가 가능

- [x] 콘솔 리더(ConsoleReader)
  - [x] int 입력
    - 콘솔 입력의 원시 객체타입 예외 전환
    - int로 변환 실패의 경우 메시지 처리 및 IllegalArgumentException으로 예외 전환
  - [x] 문자열 입력

- [x] 다리 그리기(BridgeDrawer)
  - [x] 다리 정보 출력을 위해 문자열 가공 기능
  - [x] SUCESS, IN_PROGRESS와 FAIL 이렇게 2가지 경우에 대한 상속 클래스를 가지는 템플릿
  - [x] 성공, 진행 중인 경우는 선택한 다리를 O로 출력함
  - [x] 실패한 경우 선택한 다리를 X로 표시

### layer

- [x] 다리 상태 정보 저장(BridgeStatusSaver)
  - bridgeStatus 상태를 저장하는 클래스
  - [x] bridgeStatus getter, setter 제공
  - [x] bridgeStatus가 비어있는데 요청시 `IllegalStateException` 예외 발생

- [x] 다리 게임 서비스(BridgeGame)
  - 실제 비즈니스 로직을 관리하고 처리함
  - [x] BridgeMaker를 이용해 다리 정보 생성후 상태 저장 기능
  - [x] U, D를 입력 받아 브릿지 상태 업데이트
  - [x] 재시작 여부 요청에 대한 응답
    - [x] 성공적으로 재시작 요청시 재시도 요청 횟수 증가
    - [x] UserBridge clear 수행
  - 추가 사항
    - 인스턴스 변수 추가 가능
    - 패키지 변경 가능
    - 주어진 메서드 이름 변경 X
    - 인자, 반환 타입은 필요에 따라 추가 및 변경 가능
    - 구현에 필요한 메서드 추가 가능

- [x] BridgeController
  - View와 BridgeGame 클래스를 연결하는 역할
  - [x] 다리 생성, 움직이기, 재시작 여부를 요청하고 실제 View로 보여주는 기능

### 다리 생성기
- [x] 랜덤 다리 생성기(BridgeMaker)
  - [x] BridgeRandomNumberGenerator를 활용해서 데이터를 생성
    - 응답은 문자열 형태이며 1 -> "U", 0 -> "D" 형태로 생성함
  - 추가 사항
    - 인스턴스 변경 X
    - 인자, 이름 반환 타입 변경 X

- BridgeRandomNumberGenerator
  - 인터페이스, 구현부 클래스 코드 변경 X

  
## 사용 예시

```text
다리 건너기 게임을 시작합니다.

다리의 길이를 입력해주세요.
3

이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O ]
[   ]

이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O | X ]
[   |   ]

게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)
R
이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O ]
[   ]

이동할 칸을 선택해주세요. (위: U, 아래: D)
D
[ O |   ]
[   | O ]

이동할 칸을 선택해주세요. (위: U, 아래: D)
D
[ O |   |   ]
[   | O | O ]

최종 게임 결과
[ O |   |   ]
[   | O | O ]

게임 성공 여부: 성공
총 시도한 횟수: 2
다리 건너기 게임을 시작합니다.

다리의 길이를 입력해주세요.
3

이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O ]
[   ]

이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O | X ]
[   |   ]

게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)
Q
최종 게임 결과
[ O | X ]
[   |   ]

게임 성공 여부: 실패
총 시도한 횟수: 1

```