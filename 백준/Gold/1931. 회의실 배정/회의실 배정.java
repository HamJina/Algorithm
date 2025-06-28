import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class MeetingTime implements Comparable<MeetingTime> {
        int start;
        int end;

        MeetingTime(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(MeetingTime o) {
            if (this.end == o.end) {
                return Integer.compare(this.start, o.start); // 시작 시간 오름차순, 끝나는 시간이 같으면 시작시간이 빠른 순으로
            }
            return Integer.compare(this.end, o.end); // 종료 시간 오름차순, 끝나는 시간이 빠른 순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<MeetingTime> meetings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new MeetingTime(start, end));
        }

        // 정렬
        Collections.sort(meetings);

        // 회의 선택
        int count = 0;
        int lastEndTime = 0;
        for (MeetingTime mt : meetings) {
            if (mt.start >= lastEndTime) {
                lastEndTime = mt.end;
                count++;
            }
        }

        System.out.println(count);
    }
}
