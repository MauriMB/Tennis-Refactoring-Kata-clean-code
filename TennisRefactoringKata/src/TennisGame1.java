public class TennisGame1 implements TennisGame {
    
    private int mainScore1 = 0;
    private int mainScore2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            mainScore1 += 1;
        else
            mainScore2 += 1;
    }

    public String getScore() {
        String score = "";
        int temporalScore=0;
        boolean itsATie = false;
        if (mainScore1==mainScore2)
        {
        	itsATie = true;
        	score = getStringScores(mainScore1, itsATie);
        }
        else if (mainScore1>=4 || mainScore2>=4)
        {
            int minusResult = mainScore1-mainScore2;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) temporalScore = mainScore1;
                else { score+="-"; temporalScore = mainScore2;}
                score += getStringScores(temporalScore, itsATie);
            }
        }
        return score;
    }
    
    public String getStringScores(int result, boolean itsATie){
    	String score = "Deuce";
    	if (result == 0)
    		score = "Love";
    	else if (result == 1)
        	score = "Fifteen";
    	else if (result == 2)
        	score = "Thirty";
    	else if (result == 3)
        	score = "Forty";
        if (score != "Deuce" && itsATie)
        	score += "-All";
        return score;
    }
}