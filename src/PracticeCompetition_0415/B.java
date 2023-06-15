package PracticeCompetition_0415;

import java.util.*;

public class B {
    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String s = scanner.next();
                String t = scanner.next();
                map.put(s, t);
            }
            List<String> queries = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                queries.add(scanner.next());
            }
            List<String> results = new ArrayList<>();
            for (String query : queries) {
                results.add(map.get(query));
            }
            System.out.println(String.join(" ", results));
        }
    }

}
