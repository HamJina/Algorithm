import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> result = new ArrayList<>();

        HashMap<String, Integer> geneMap = new HashMap<>();
        HashMap<String, List<Node>> playMap = new HashMap<>();

        // O(N)
        for(int i = 0; i < genres.length; i++) {
            if(geneMap.containsKey(genres[i])) {
                geneMap.put(genres[i], geneMap.get(genres[i]) + plays[i]);
            } else {
                geneMap.put(genres[i], plays[i]);
            }
            List<Node> list = playMap.getOrDefault(genres[i], new ArrayList<>());
            list.add(new Node(plays[i], i));
            playMap.put(genres[i], list);
        }

        // geneMap을 값 기준으로 내림차순 정렬 O(logN)
        List<Map.Entry<String, Integer>> entryList =
                geneMap.entrySet()
                        .stream()
                        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) // 내림차순
                        .toList(); // 장르별 내림차순

        // playMap의 각 리스트를 정렬 (map을 통째로 정렬하는 게 아니라 value인 List를 정렬)
        for (List<Node> list : playMap.values()) {
            Collections.sort(list);
        }
        
        // 각 장르내 top2 노래 고르기
        for (int i = 0; i < entryList.size(); i++) {
            String gene = entryList.get(i).getKey();

            // playMap에서 value인 list 가져오기 (top2만)
            List<Node> nodes = playMap.get(gene);

            for (int j = 0; j < nodes.size(); j++) {
                if(j >= 2) break;
                result.add(nodes.get(j).index);
            }


        }


        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    static class Node implements Comparable<Node>{
        int play;
        int index;

        Node(int play, int index) {
            this.play = play;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            if (this.play != o.play) {
                return o.play - this.play; // play 내림차순
            }
            return this.index - o.index; // play가 같으면 index 오름차순
        }
    }
}