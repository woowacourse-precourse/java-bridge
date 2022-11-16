# 미션: 다리건너기

-------------------
## 기능 목록 및 제공 클래스 정리
![다리건너기](https://user-images.githubusercontent.com/54941130/202209453-f3d26487-10c2-4298-a7c9-629e03267ea9.png)

-------------------
## 사용할 메소드

<br/>

#### 다리 생성시, `bridge.BridgeRandomNumberGenerator` 의 `generate()` 메소드 이용

예) 
``` java
int number = bridgeNumberGenerator.generate();
```

#### 입력 받을 시, `camp.nextstep.edu.missionutils.Console` 의 `readLine()` 메소드 이용

예)
``` java
String answer = readLine();
```

-------------------
## 필요한 기능 목록

-------------------
### 1. 다리 생성하기
### 2. 이동할 위치 입력받기
### 3. 이동시, 가능 유무와 함께 다리 출력하기
### 4. 다리 건너기 실패 &rarr; 게임 재시작 or 종료 입력 받기
### 5. 재시작시, 기존 다리 재사용하기
### 6. 다리 건너기 성공 &rarr; 게임 종료
### 7. 게임 종료시, 성공 여부와 시도 횟수 출력하기
### 8. 예외처리 &rarr; `[ERROR]`와 같이 오류 메세지 출력 후, 그 부분부터 다시 입력받기

-------------------