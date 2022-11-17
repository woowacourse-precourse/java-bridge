# 💻 프로그램 동작 방식

---

#### 1. 사용자로부터 `InputView`에서 값을 입력 받고 초기화 후, 게임을 실행한다.
#### 2. `InputView`에서 값을 입력 받고, 해당 값을 `Controller`로 넘겨준다.
#### 3. `Validator`를 통해 입력값을 검증한다.
#### 4. 예외 발생시 재입력받는다.
#### 5. 예외가 발생하지 않을 경우, `Model`을 update한다.
#### 6. update된 정보를 `OutputView`를 활용해 출력한다.
#### 7. 게임이 종료될 때 까지 2~5를 반복한다.


# 🧰 기능 목록

---

### 1. 게임 시작 문구를 출력한다. - `View`/`InputView`

### 2. 다리의 길이를 숫자를 입력받고 생성한다.
   - [ ] 입력받은 숫자(문자열)을 정수로 변환한다. `Controller`/`Converter`
      - [ ] 숫자가 아닌 입력일 경우(문자, 빈 문자열) 예외를 던진다.
      - [ ] 잘못된 입력일 경우, 올바른 입력이 될 때 까지 입력받는다.
   - [ ] 입력받은 숫자가 3 이상 20 이하인지 확인하고 아니면 예외를 던진다. - `Controller`/`BridgeMaker` from `Validator`/`InputValidator`
   - [ ] 위 칸과 아래 칸 중 건널수 있는 칸은 0과 1중 무작위 값을 이용해서 정한다. `Controller`/`BridgeMaker` from `Controller`/`BridgeRandomNumberGenerator`
   - [ ] 0인 경우 위 칸인 `U`, 1인 경우 아래 칸인 `D`인 다리 리스트를 만든다. - `Controller`/`BridgeMaker`
   - [ ]
### 3.`U` 또는 `D`를 입력받아 이동할 칸을 선택한다.
   - [ ] 정해진 문자가 아니거나 입력이 없으면 예외를 던진다. `Validator`/`InputValidator`
   - [ ] 예외가 발생할 경우, 다시 입력받도록 한다. `Controller`/`BridgeGame`
   - [ ] 이동 후 생사여부를 update한다 `Controller`/`BridgeGame` -> `Model`/`UserBridge`

### 4. 입력 결과를 출력한다.
  - [ ] 건너온 칸들은 전부 O로 출력하고 생사여부에 따라 O, X를 출력을 결정한다. `View`/`OutputView`
### 5. 건너다 실패하면 재시작`R`, 종료`Q` 할 수 있다.
   - [ ] 정해진 문자가 아니거나 입력이 없으면 예외를 던진다 `Validator`/`InputValidator`
   - [ ] 잘못된 입력일 경우, 올바른 입력이 될 때 까지 입력받는다.



# 🛠️ 클래스 설계

## BridgeMaker
```
    - Bridge를 랜덤한 길이로 생성
```

## Model

---

- ### Bridge
```
    - 게임에 사용되는 다리 정보
```

- ### Selection
```
    - 선택에 대한 정보를 담은 enum 클래스
```

- ### User
```
    - 현재 위치
    - 생사 여부
```


## View

---

- ### InputView
```
    - 게임 시작 문구 출력
    - 입력 문구 출력
    - 입력받은 값을 Controller에 전달
```
### OutputView
```
    - 결과 문구 출력
    - update된 model의 정보를 출력
```

## Controller

---

- ### BridgeGame
```
    - 게임 실행 및 상태에 관련된 클래스
    - 입력 값에 대한 검증
    - 개수를 입력받고 Bridge 모델 초기화
    - 입력값에 따라 유저의 생사 여부 및 위치 결정
```

- ### Converter
```
  - 사용자가 입력한 값(문자열)을 정수로 변환해 return
```


- ### Validator
```
    - 입력값에 대한 검증
```


# ❗ 주의사항 체크 리스트

---

- [ ] `Exception`이 아닌 `IllegalArgumentException`과 같이 명확하게 유형을 처리하였는가?
- [ ] 입출력 요구 사항을 모두 지켰는가?
  - [ ] 게임 시작 문구
  - [ ] 길이 입력 문구
  - [ ] 칸 입력 문구
  - [ ] 칸 입력 후 다리 상태
  - [ ] 실패했을 시 재시도, 종료 여부
  - [ ] 게임 성공 여부 및 시도 횟수
- [ ] 함수(또는 메소드)의 길이가 10라인 미만인가? (빈줄 포함)
- [ ] 함수(또는 메소드)의 파라미터가 3개 이하인가?
- [ ] 클래스 제약 사항들을 모두 지켰는가?
  - [ ] `OutuptView`의 메소드 이름을 변경하면 안된다.
  - [ ] `BridgeMaker`의 메소드의 시그니처(인자, 이름)와 반환 타입을 변경하면 안된다.
  - [ ] `BridgeGame`의 메소드 이름을 변경하면 안된다.
  - [ ] `Bridge`
  - [ ] `InputView` 클래스에서만 `readLine()`을 사용한다. 
  - [ ] `BridgeRandomNumberGenerator`, `BridgeNumberGenerator`의 코드를 수정하면 안된다.
  - [ ] `BridgeRandomNumberGenerator`, `BridgeNumberGenerator`의 패키지를 수정하면 안된다.
