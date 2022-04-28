public static int capacity[][]; // 간선의 용량을 저장하기 위한 배열
    public static int flow[][]; // 간선의 유량을 저장하기 위한 배열
    public static int path[]; // // 경로를 저장하기 위한 배열
    public static boolean visited[]; 
    public static LinkedList<Integer> graph[];

   public static boolean dfs(int start) {
        if (start == Sink) {
            return true;
        }

        visited[start] = true;
        LinkedList<Integer> nexts = graph[start];
        for (int next: nexts) { // 
            if ( !visited[next] && capacity[start][next] - flow[start][next] > 0) {
                path[next] = start; // 방문하지 않았거나, 해당 경로에 여유 용량이 남아있을때

                if (dfs(next)) { // 경로를 끝까지 찾으면 탈출, 아니면 끝까지 찾기 재시도
                    return true;
                }
            }
        }
        return false;
    }
  
   public static int FordFulkerson() {
        int total = 0;
        while (dfs(Source)) { // dfs로 경로 찾기(증가경로), 경로가 더이상 없으면 종료임.
            int flowNum = Integer.MAX_VALUE;
            for(int i = Sink; i != Source; i = path[i]) {
                int from = path[i];
                int to = i;
                flowNum = Math.min(flowNum, (capacity[from][to]) - flow[from][to]);
		//찾은 경로중에서 capcacity - flow 값이 제일 작은 것을 찾아줌. = 흘릴 수 있는 최대 flow값.
            }

            for(int i = Sink; i != Source; i = path[i]) {
                int from = path[i];
                int to = i;
		// flow 흘리기.
                flow[from][to] += flowNum; // 순방향 간선에는 양수값 넣어주기.
                flow[to][from] -= flowNum; // 유량의 대칭 조건에 따라, 역방향 간선에는 음수값을 넣어줌.
            }                              // 가상의 역방향 간선의 총 유량을 더해주면 capacity = 0, 용량을 넘지 않음.

            total += flowNum; // total값에 유량 더해주기.

            // 찾은 경로를 초기화해서 dfs로 경로 찾기를 Source > Sink 까지 다시 할 수 있게 함.
            Arrays.fill(path, -1);
            Arrays.fill(visited, false);
        }
        return total; //최대 유량의 값 반환.
    }
