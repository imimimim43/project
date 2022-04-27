## 포드-풀커슨 알고리즘(Ford-Fulkerson algorithm)

<br>


■ 포드-풀커슨(Ford-Fulkerson)

- 유량 네트워크에서 소스와 싱크 사이에 흐를 수 있는 최대 유량(Maximum Flow)을 구하는 알고리즘이다.

<br>

■ 유량 네트워크(flow network)

- 각 간선에 용량이라는 추가 속성이 존재하는 방향 그래프이다.
  ![image](https://user-images.githubusercontent.com/102197100/165531238-c59d5ab5-c3c3-4601-811e-7aabf90a95c5.png)
  
-  (a,c)간선을 예로 들면, 초당 최대 20만큼의 자료를 전송할 수 있으며 이때의 20은 간선의 용량(capacity)라고 한다. <br>
   또한, 초당 13만큼의 자료가 전송되고 있는데 이때의 13은 간선의 유량(flow)라고 한다.<br>
 - 경로 s-b-d-t를 살펴보면, 거치는 간선의 용량의 최솟값은 3이므로 이 값이 해당 경로를 통해 보낼 수 있는 유량의 최댓값이다.<br>
