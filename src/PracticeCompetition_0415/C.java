/*


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Track track = new Track();
        int n, returnAns = 0,MAX=0;
        for (int k = 0; k < 6; k++) {
            n = scanner.nextInt();
            track.tracks[k]= new OptimizePairing(n);
            for (int i = 0; i < n; i++) {
                track.tracks[k].pairs[i].first = scanner.nextInt();
                track.tracks[k].pairs[i].second = scanner.nextInt();
                returnAns += track.tracks[k].pairs[i].second - track.tracks[k].pairs[i].first + 1;
                MAX=Math.max(MAX,track.tracks[k].pairs[i].second);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(MAX+1);
        for (int i = 0; i < MAX+1; i++) {
            list.add(0);
        }
        for (int k = 0; k < 6; k++) {
            for (int i = 0; i < track.tracks[k].n; i++) {
                for (int j = track.tracks[k].pairs[i].first; j <= track.tracks[k].pairs[i].second; j++) {
                    list.set(j, list.get(j) + 1);
                    if(list.get(j)==6){
                        returnAns--;
                    }
                }
            }
        }
        System.out.println(returnAns);

    }
}

class Pair {
    public int first;
    public int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class OptimizePairing {
    Pair[] pairs;
    int n;
    public OptimizePairing(int n) {
        this.n=n;
        pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(0, 0);
        }
    }
}

class Track{
    int n=6;
    public OptimizePairing[] tracks = new OptimizePairing[n];
}


 */