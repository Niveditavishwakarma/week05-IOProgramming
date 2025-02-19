package com.iplmatch;
import java.util.Map;
import java.util.HashMap;
public class IPLMatch {
    public int match_id;
    public String team1;
    public String team2;
    public Map<String, Integer> score;
    public String winner;
    public String player_of_match;

    public IPLMatch(int match_id, String team1, String team2, int score1, int score2, String winner, String player_of_match) {
        this.match_id = match_id;
        this.team1 = team1;
        this.team2 = team2;
        this.score = new HashMap<>();
        this.score.put(team1, score1);
        this.score.put(team2, score2);
        this.winner = winner;
        this.player_of_match = player_of_match;
    }

    public IPLMatch() {}
    public void applyCensorship() {
        this.team1 = censorTeamName(this.team1);
        this.team2 = censorTeamName(this.team2);
        this.winner = censorTeamName(this.winner);
        this.player_of_match = "REDACTED";

        Map<String, Integer> censoredScore = new HashMap<>();
        for (String team : this.score.keySet()) {
            censoredScore.put(censorTeamName(team), this.score.get(team));
        }
        this.score = censoredScore;
    }

    private String censorTeamName(String team) {
        String[] parts = team.split(" ", 2);
        return parts[0] + " ***";
    }
}

