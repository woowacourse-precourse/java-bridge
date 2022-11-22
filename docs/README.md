# 🍀 다리건너기

## Model

---

## BridgeGame (게임 관리)

- 인스턴스 변수
    - 다리
    - 사용자
    - 총 시도 횟수
    - 성공 여부

- [x] 사용자가 칸을 이동할 수 있는지
- [x] 사용자 칸 이동 및 다리 끝까지 완주했는지
- [x] 위의 결과를 "O", "X"로 변환
- [x] 사용자의 게임 시도 횟수를 증가
- [x] 게임 다시 시도
- [x] 사용자 반환
- [x] 시도 횟수 반환

## BridgeMaker (다리 생성)

- [x] 다리 길이를 입력 받아 다리를 생성

## User (다리 건너는 사람)

- 인스턴스 변수
    - 윗다리
    - 아랫다리
    - 라운드 (사용자가 "U", "D"를 입력한 횟수)
- [x] 윗다리 경로 반환
- [x] 아랫다리 경로 반환
- [x] 이동한 칸 추가
- [x] 라운드 수 올리기
- [x] 라운드 수 반환

## UpDownTable enum

- 열거형 상수
    - UP
    - DOWN
- 인스턴스 변수
    - 움직임 (String)
    - 움직임 (int)
- 움직임 (int)를 넣으면 움직임(String)으로 반환

<br>

## Validator

---

## InputValidator

- [ ] 숫자인지 확인
- [ ] 숫자 아닐 시, 에러 발생
- [ ] 다리길이 범위 (3 ~ 20)가 아닐 시, 에러 발생
- [ ] U, D가 아닐 시, 에러 발생
- [ ] R, Q가 아닐 시, 에러 발생

## Constants

---

### ErrorConstants

- [x] 에러 발생 시, 출력되는 String

<br>

## UI

---

## InputView

- [x] 다리 길이를 입력
- [x] 이동할 칸 입력 (U, D)
- [x] 게임 재시작 / 종료 여부를 입력

## OutputView

- [x] "다리 건너기 게임을 시작합니다." 출력
- [x] "다리의 길이를 입력해주세요." 출력
- [x] "이동할 칸을 선택해주세요. (위: U, 아래: D)" 출력
- [x] 다리 건너기 결과 출력
- [x] "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)" 출력
- [x] 게임 결과 출력
- [x] 에러 발생 시 에러메세지 출력

## Constants

---

### InputConstants

- [x] 입력 제한 상수

### OutputConstants

- [x] System.out 시, 출력되는 String 상수

<br>

## Validator

---

## InputValidator

- [x] 숫자가 아닌 경우 예외처리
- [x] 값이 3부터 20사이의 값이 아닌 경우 예외처리
- [x] U, D가 아닌 값인 경우 예외처리
- [x] R, Q가 아닌 값인 경우 예외처리

<br>

## Test

---

## ApplicationTest

- [ ] 다리 생성 테스트
- [ ] 기능 테스트
- [ ] 재시도 후 성공 테스트
- [ ] 실패 테스트
- [ ] 예외 테스트

## BridgeGameTest

- [ ] 정답인 경우 move 테스트
- [ ] 오답인 경우 move 테스트
- [ ] true -> O로 변경하는 경우 테스트
- [ ] false -> X로 변경하는 경우 테스트
- [ ] retry 시, BridgeGame 내 User 변수 객체 재할당 되는지 테스트

```
(OutputView, InputView -> BridgeMaker)
다리 건너기 게임을 시작합니다.

다리의 길이를 입력해주세요.
3 

(OutputView -> InputView -> BridgeGame -> User -> OutView)
이동할 칸을 선택해주세요. (위: U, 아래: D) 
U  
[ O ]
[   ]

(OutputView -> InputView -> BridgeGame -> User -> OutView, BridgeGame)
이동할 칸을 선택해주세요. (위: U, 아래: D) (OutputView)
U
[ O | X ]
[   |   ]

게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)
R

(OutputView -> InputView -> BridgeGame -> User -> OutView)
이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O ]
[   ]

(OutputView -> InputView -> BridgeGame -> User -> OutView)
이동할 칸을 선택해주세요. (위: U, 아래: D)
D
[ O |   ]
[   | O ]

(OutputView -> InputView -> BridgeGame -> User -> OutView)
이동할 칸을 선택해주세요. (위: U, 아래: D)
D
[ O |   |   ]
[   | O | O ]

(OutputView -> InputView -> BridgeGame -> User -> OutView)
최종 게임 결과
[ O |   |   ]
[   | O | O ]

게임 성공 여부: 성공
총 시도한 횟수: 2
```

```
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