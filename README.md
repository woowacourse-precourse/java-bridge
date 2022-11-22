# 미션 - 다리 건너기

## 🔍 진행 방식

- 미션은 **기능 요구 사항, 프로그래밍 요구 사항, 과제 진행 요구 사항** 세 가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고,<br>기능 단위로 커밋 하는 방식으로 진행한다.
- 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

* * *

## ✨ 체크 포인트
### 메소드 분리/분화/객체화/결합도 약화/테스트
- AssertionFailedError
  - 발생해야 하는 에러가 발생하지 않았을 경우에도 발생!

* * *

## 🤔 의문점
```
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by camp.nextstep.edu.missionutils.Console (file:/C:/Users/nn/.gradle/caches/modules-2/files-2.1/com.github.woowacourse-projects/mission-utils/1.0.0/dad5230ec970560465a42a1cade24166e6a424f4/mission-utils-1.0.0.jar) to field java.util.Scanner.sourceClosed
WARNING: Please consider reporting this to the maintainers of camp.nextstep.edu.missionutils.Console
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
```
### VS
`unable to determine if the scanner is closed.`
- Console 의 close 여부를 확인할 수 없다  

겨우 WARNING 안뜨게했더니 다른 출력이..  
[이전 기수 참가자의 글](https://yeonyeon.tistory.com/165) 을 보면 콘솔의 isClosed에서  
출력되는 에러인데.. Exception마다 콘솔을 열고닫아야하나  

일단 출력이 깔끔해야 할 것 같아서 전자로 복귀