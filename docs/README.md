# 🔍다리 건너기 게임 소개
넷플릭스의 드라마, 오징어게임에서 나온 다리 건너기 게임을 코딩으로 구현한 것이다.<br>
사용자는 다리의 길이를 정해 입력을 한다.<br>
개임이 시작하면 아래와 같은 문구가 출력이 됩니다
```
다리 건너기 게임을 시작합니다.
```
다리의 길이를 묻는 문구가 출력이 됩니다.
```
다리의 길이를 입력해주세요.
```
다리의 길이는 3 이상 20 이하의 길이 만을 입력을 받습니다.<br>
위의 범위를 벗어날 경우, 아래와 같은 문구가 나타난다. <br>
```
[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.
```
다리의 길이를 묻는 문구가 다시 출력이 됩니다.<br>
```
다리의 길이를 입력해주세요.
```

위,아래의 다리 중에 어떤 곳으로 갈지를 묻는 문구가 출력이 됩니다.<br>
```
이동할 칸을 선택해주세요. (위: U, 아래: D)
```
예측한 결과를 U|D 중에 하나를 골라 입력한다. (U: 위, D: 아래)<br>
```
U
```
예측한 결과가 맞을 경우, 아래와 같이 입력이 됩니다.<br>
```
[ O ]
[   ]
```
예측한 결과가 틀릴 경우, 사용자가 위치한 것에 'X'가 입력됩니다.<br>
```
[ X ]
[   ]
```
D를 입력을 하였을 경우는 아래와 같습니다<br>
```
D
[   ]
[ X ]

[   ]
[ O ]
```
위와 같은 방식를 다리의 길이 만큼 반복한다.
```
다리의 길이를 입력해주세요.
3

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
```
게임에 실패하면 게임이 재도전하거나 종료를 할 수 있습니다.<br>
재도전과 종류를 묻는 문구가 출력이 됩니다.<br>
```
게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)
```
게임에 성공하면, 최종 게임 결과와 게임의 성공 여부, 총 시동한 갯수를 출력한 후 프로그램이 종류됩니다.
```
최종 게임 결과
[ O |   |   ]
[   | O | O ]

게임 성공 여부: 성공
총 시도한 횟수: 2
```

# 🚀기능 목록
## 입력
### readBridgeSize
- [x] '다리의 길이를 입력해주세요.'를 출력
- [x] 사용자의 입력을 받는다. 
- [x] 유효한 값인지 검사
- [x] 유효한 값이 아니면, 다시 다리의 길이를 입력
- [x] Integer로 바꾸어서 반환
- [x] [예외처리] 다리의 길이가 3이상 20이하의 수를 입력을 받는다.
- [ ] [예외처리] 숫자 외에 다른 것을 입력 받아서는 안된다.

### readMoving
- [x] '이동할 칸을 선택해주세요. (위: U, 아래: D)'를 출력
- [x] 사용자의 입력을 받는다.
- [x] 입력을 리턴
- [ ] [예외처리] U와 D가 아닌 다른 글자일 경우, 다시 입력을 받는다.

### readGameCommand
- [x] '게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)'를 출력
- [x] 사용자의 입력을 받는다.
- [x] 입력값을 리턴
- [ ] [예외처리] R와 Q가 아닌 다른 글자일 경우, 다시 입력을 받는다.

### readBridgeSizeOfNoNumberException
- [x] brideSizeRegularExpression에 숫자가 한자리에서 두자리까지의 숫자에 대한 정규표현식을 저장
- [x] 매개변수가 brideSizeRegularExpression에 들어맞는지, 확인
- [x] false이면, 예외 던짐

### readScopeOfBridgeSizeOfNumberException
- [x] 매개변수를 Integer타입으로 형변환하여 size에 저장
- [x] size가 3미만이고, 20초과인지, 확인
- [x] false이면, 예외 던짐

### readMovingCommandCheck
- [x] moveCommandRegularExpression에 소대문자 u,d 둘 중에 하나인지를 검사하는 정규표현식을 저장
- [x] 매개변수가 moveCommandRegularExpression에 들어맞는지, 확인
- [x] false이면, 예외 던짐

### readGameCommandCheck
- [x] gameCommandRegularExpression에 소대문자 r,q 둘 중에 하나인지를 검사하는 정교표현식을 저장
- [x] 매개변수가 gameCommandRegularExpression에 들어맞는지, 확인
- [ ] false이면, 예외 던짐

## 출력

### printGameStartMessage
- [x] '다리 건너기 게임을 시작합니다.'를 출력

### printMap
- [x] 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력

### printResult
- [x] '최종 게임 결과'를 출력
- [x] 사용자 이동한 다리의 형태를 출력
- [x] 다리의 성공 여부를 출력
- [x] 게임을 시도한 횟수를 출력

## BridgeMaker
### makeBridge
- [x] List<String> 타입의 변수를 선언
- [x] 매개변수의 크기만큼 변수를 반복문을 작성
- [x] BridgeRandomNumberGenerator.generate 함수를 통해 0또는 1의 랜덤한 값을 받아온다
- [x] 0이면 D, 1이면 U를 리스트에 추가
- [x] 리스트를 리턴

## BridgeGame
- [x] upBridge라는 인스턴스 변수 생성
- [x] downBridge라는 인스턴스 변수 생성
- [x] moveCount라는 인스턴스 변수 생성
- [x] gameCount라는 인스턴스 변수 생성
- [x] gameStatus라는 인스턴스 변수 생성

### BridgeGame
- [x] upBridge를 초기화
- [x] downBridge를 초기화
- [x] moveCount를 0으로 초기화
- [x] gameCount를 1으로 초기화
- [x] gameStatus를 false로 초기화

### move
- [x] 결과 다리와 비교
- [x] moveCount에 1을 더함
- [x] 같으면 true, 틀리면 false를 리턴

### retry
- [x] upBridge변수의 요소 제거
- [x] downBridge변수의 요소 제거
- [x] moveCount변수를 0으로 초기화
- [x] gameCount에 1를 더함

### compareMoveCount
- [x] 매개변수와 moveCount 비교
- [x] true이면 true 반환
  - [x] gameStatus를 true로 저장
- [x] false리면 false 반환

## Application
- [x] inputView 변수 생성
- [x] outputView 변수 생성
- [x] bridgeGame 변수 생성
- [x] bridgeMaker 변수 생성

### main
- [x] printGameStartMessage함수를 실행
- [x] readBridgeSize함수를 실행 후, 반환값을 bridgeSize에 저장
- [x] makeBridge함수에 bridgeSize를 매개변수로 넣고, 반환값을 answerBridge에 저장 
- [x] bridgeSize의 횟수만큼 반복하는 do-while문 생성
  - [x] readMoving함수를 실행 후, 반환값을 userRemoveCommand에 저장
  - [x] move함수에 매개변수로 userRemoveCommand를 넣고, 반환값을 gameChecked에 저장
  - [x] bridgeGame의 upBridge를 printMap함수에 매개변수로 전달하여 출력
  - [x] bridgeGame의 downBridge를 printMap함수에 매개변수로 전달하여 출력
  - [x] gameChecked의 값이 false인지 비교
    - [x] readGameCommand함수를 실행 후, userGameCommand에 저장
    - [x] userGameCommand가 Q인지 비교
      - [x] break문 사용
    - [x] retry함수를 실행
- [x] printResult함수 실행