package completed_01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreBoardF extends JPanel {

	// Connect4GUI connect4gui = new Connect4GUI();


	protected JLabel lblChamp, lblLatestWinner, lblPlayer1Name, lblPlayer2Name, lblPlayer1NumWins, lblPlayer2NumWins,
			lblPlaceHolder, lblPlayerNames, lblPlayerNumWins, lblCurr, lblCurrName, lblPrewChamp, lblPrewWinner, 
			lblPlayerSymbol, lblPlayer1Symbol, lblPlayer2Symbol;

	private JPanel jpGenScoreInfo, jpPlayerScoreInfo, jpCurrentPlayer;
	
	//private Connect4Board cBoard = new Connect4Board();
	
	Playerf player1,player2,currentPlayerf;

	public ScoreBoardF(Playerf p1, Playerf p2, Playerf currPlayer) {

//		System.out.println(currPlayer);
		
		player1 = p1;
		player2 = p2;
		currentPlayerf = currPlayer;
		
		setLayout(new BorderLayout());

		jpGenScoreInfo = new JPanel();
		jpPlayerScoreInfo = new JPanel();

		jpCurrentPlayer = new JPanel();

//		jpanel for the champ info

		jpGenScoreInfo.setLayout(new GridLayout(2, 2));
// 		jpanel for the score info

		jpPlayerScoreInfo.setLayout(new GridLayout(4, 4));

		jpCurrentPlayer.setLayout(new GridLayout(1, 1));

		lblChamp = new JLabel("CHAMP");
		lblLatestWinner = new JLabel("*******");

		jpGenScoreInfo.add(lblChamp);
		jpGenScoreInfo.add(lblLatestWinner);

		lblPrewChamp = new JLabel("LAST CHAMP");
		lblPrewWinner = new JLabel("*******");

		jpGenScoreInfo.add(lblPrewChamp);
		jpGenScoreInfo.add(lblPrewWinner);

		lblPlaceHolder = new JLabel("-----");
		lblPlayerNames = new JLabel("NAMES");
		lblPlayerNumWins = new JLabel("WINS");
		lblPlayerSymbol = new JLabel("SYMBOL");

		jpPlayerScoreInfo.add(lblPlaceHolder);

		jpPlayerScoreInfo.add(new JLabel("Player 1"));
		jpPlayerScoreInfo.add(new JLabel("Player 2"));

		jpPlayerScoreInfo.add(lblPlayerNames);

		lblPlayer1Name = new JLabel(player1.getNameString());
		lblPlayer2Name = new JLabel(player2.getNameString());

		jpPlayerScoreInfo.add(lblPlayer1Name);
		jpPlayerScoreInfo.add(lblPlayer2Name);

		jpPlayerScoreInfo.add(lblPlayerNumWins);

		lblPlayer1NumWins = new JLabel("" + player1.getNumWins());
		lblPlayer2NumWins = new JLabel("" + player2.getNumWins());

		jpPlayerScoreInfo.add(lblPlayer1NumWins);
		jpPlayerScoreInfo.add(lblPlayer2NumWins);
		
		jpPlayerScoreInfo.add(lblPlayerSymbol);
		
		lblPlayer1Symbol = new JLabel(player1.getSymbol());
		lblPlayer2Symbol = new JLabel(player2.getSymbol());
		
		jpPlayerScoreInfo.add(lblPlayer1Symbol);
		jpPlayerScoreInfo.add(lblPlayer2Symbol);

		lblCurr = new JLabel("Current Player");
		lblCurrName = new JLabel(currentPlayerf.getNameString());

		jpCurrentPlayer.add(lblCurr);
		jpCurrentPlayer.add(lblCurrName);

//		----------------------------------------------

		jpGenScoreInfo.setBackground(Color.LIGHT_GRAY);
		jpPlayerScoreInfo.setBackground(Color.YELLOW);

		jpCurrentPlayer.setBackground(Color.LIGHT_GRAY);

//		---------------------------------------------

		
		
		add(jpGenScoreInfo, BorderLayout.NORTH);
		add(jpPlayerScoreInfo, BorderLayout.CENTER);
		add(jpCurrentPlayer, BorderLayout.SOUTH);
	
	}
	
	
	

}
