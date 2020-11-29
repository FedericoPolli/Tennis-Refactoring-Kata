
public class TennisGame1 implements TennisGame {
    
    private int score_player1 = 0;
    private String player1Name;

    private int score_player2 = 0;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName))
            score_player1 += 1;
        else
            score_player2 += 1;
    }

    public String getScore(){
        if (players_tied()) {
            return equal_score();
        } else if (advantage()) {
            return "Advantage "+player_with_higher_score();
        } else if (game_won()) {
            return "Win for " + player_with_higher_score();
        } else {
            return other_scores();
        }
    }

    private boolean advantage() {
        return both_players_have_3_or_more_points() && player_has_1_more_point();
    }

    private boolean player_has_1_more_point() {
        return Math.abs(score_player1 - score_player2) == 1;
    }

    private boolean both_players_have_3_or_more_points() {
        return score_player1 >= 3 && score_player2 >= 3;
    }

    private String other_scores() {
        return correct_term(score_player1)+"-"+correct_term(score_player2);
    }

    private boolean game_won() {
        return player_scored_more_than_4_points() && player_has_two_points_more();
    }

    private boolean player_has_two_points_more() {
        return Math.abs(score_player1 - score_player2) >= 2;
    }

    private boolean player_scored_more_than_4_points() {
        return score_player2 >= 4 || score_player1 >= 4;
    }

    private String player_with_higher_score() {
        if (score_player1 >= score_player2)
            return player1Name;
        else
            return player2Name;
    }

    private String equal_score() {
        if (score_player1 < 3) {
            return correct_term(score_player1)+"-All";
        } else  {
            return "Deuce";
        }
            
    }

    private String correct_term(int score) {
        String term="";
        switch (score) {
            case 0:
                term+="Love";
                break;
            case 1:
                term+="Fifteen";
                break;
            case 2:
                term+="Thirty";
                break;
            case 3:
                term+="Forty";
                break;
        }
        return term;
    }

    private boolean players_tied() {
        return score_player1 == score_player2;
    }

}
