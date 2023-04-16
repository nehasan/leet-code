import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScoreBoard {
    public void updateTeam(Map<String, Integer> teams, String team, int score1, int score2, int[] teamLen) {
        if (teams.containsKey(team)) {
            if (score1 > score2) {
                teams.put(team, teams.get(team) + 3);
            } else if (score1 == score2) {
                teams.put(team, teams.get(team) + 1);
            }
        } else {
            if (score1 > score2) {
                teams.put(team, 3);
            } else if (score1 < score2) {
                teams.put(team, 0);
            } else {
                teams.put(team, 1);
            }
            teamLen[0]++;
        }
    }
    public String[] scoreBoard(String[] scores) {
        Map<String, Integer> teams = new HashMap<>();

        int[] teamLen = new int[]{0};
        for (int i = 0; i < scores.length; i++) {
            String[] tokens = scores[i].split(" ");
            String team1 = tokens[0];
            String team2 = tokens[2];
            int score1 = Integer.parseInt(tokens[1].split(":")[0]);
            int score2 = Integer.parseInt(tokens[1].split(":")[1]);

            updateTeam(teams, team1, score1, score2, teamLen);
            updateTeam(teams, team2, score2, score1, teamLen);
        }

        List<String> fScoreBoard = new ArrayList<>();
        teams.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x -> fScoreBoard.add(x.getKey() +" : "+x.getValue()));
        return fScoreBoard.toArray(String[]::new);
    }

    public void func() {
        String[] scores = new String[]{
                "Liverpool 3:2 PSG",
                "RealMadrid 1:2 PSG",
                "ManUnited 4:1 AtlMadrid",
        };
        System.out.println(Arrays.toString(Arrays.stream(scoreBoard(scores)).toArray()));
    }

    public static void main (String[] args) {
        ScoreBoard sb = new ScoreBoard();
        sb.func();
    }
}
