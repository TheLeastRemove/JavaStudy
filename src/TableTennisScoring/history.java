package TableTennisScoring;

public class history{
    Pair<Integer, Integer> numberOfSets;
    Pair<String,Integer> player_1;
    Integer score_1;
    Pair<String,Integer> player_2;
    Integer score_2;

    public history(Pair<Integer, Integer> numberOfSets, Pair<String, Integer> player_1, Integer score_1, Pair<String, Integer> player_2, Integer score_2) {
        this.numberOfSets = numberOfSets;
        this.player_1 = player_1;
        this.score_1 = score_1;
        this.player_2 = player_2;
        this.score_2 = score_2;
    }

    public void setScore (boolean player) {
        if (player) {
            score_1++;
        } else {
            score_2++;
        }
    }
    }
