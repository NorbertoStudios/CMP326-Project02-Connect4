package completed_01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Array2dJpanelBtn extends JPanel implements ActionListener {

	protected Playerf player1;
	protected Playerf player2;
	protected Playerf currentPlayer;


	// impement the scaner for scales
	public final static int NUM_ROWS = 6;
	public final static int NUM_COLUMNS = 7;

	int indexH = -1;
	int indexV = -1;

	int test1 = 0;
	int x1 = 0;
	int y1 = 0;
	

	boolean isWinnerInRow = false;

	JButton[][] boardBtn;

	ImageIcon base;
	
	ScoreBoardF scoreBoardF;
	

	public Array2dJpanelBtn(Playerf p1, Playerf p2, Playerf currPlayer) {

		player1 = p1;
		player2 = p2;
		currentPlayer = currPlayer;
		
		scoreBoardF = new ScoreBoardF(player1, player2, currentPlayer);
		
	
		setLayout(new GridLayout(NUM_ROWS, NUM_COLUMNS));

		// 242,216,26
		setBackground(new Color(12, 85, 204));

		base = new ImageIcon("images/base8.png");

		
		appendStrToFile("Player 1 "+player1.toString()+"\n");
		appendStrToFile("Player 2 "+player2.toString()+"\n");
		appendStrToFile("Player turn "+currentPlayer.getNameString()+"\n");
		
		displayBtn();

	}

	public void displayWinner() {
		

		//scoreBoardF = new ScoreBoardF(player1, player2, currentPlayer);
		
		currentPlayer.addWin();
		
		
		scoreBoardF.lblLatestWinner.setText(currentPlayer.getNameString());
		// update Jlabel
		if (currentPlayer.equals(player1)) {
			scoreBoardF.lblPlayer1NumWins.setText("" + currentPlayer.getNumWins());
		} else {
			scoreBoardF.lblPlayer2NumWins.setText("" + currentPlayer.getNumWins());
		}
		
		appendStrToFile(currentPlayer.getNameString()+" Wins \nTotal wins = "
		+currentPlayer.getNumWins()+"Total losses = "+currentPlayer.getNumLosses()+"\n");

	}
	public void currentPlayerDisplay() {
		
		
		scoreBoardF.lblCurrName.setText(currentPlayer.getNameString());
		System.out.println(scoreBoardF.lblCurrName.getText());
	}

	public void displayBtn() {
		boardBtn = new JButton[NUM_ROWS][NUM_COLUMNS];

		for (int row = 0; row < NUM_ROWS; row++) {
			for (int col = 0; col < NUM_COLUMNS; col++) {
				boardBtn[row][col] = new JButton(base);

				// btnA[row][col].setPreferredSize(new Dimension(50, 50));
//					btnA[row][col].setOpaque(true);
//					btnA[row][col].setBorderPainted(false);

				boardBtn[row][col].addActionListener(this);

				add(boardBtn[row][col]);

			}
		}
		
		
	}

	public boolean isWinner(String currentPlayer) {
//			if (isWinnerInRow()) {
//				return true;
//			}
//
//			if (isWinnerInCol()) {
//				return true;
//			}
//		
		return isWinnerInMainDiag() || isWinnerInSecondDiag() || isWinnerInCol() || isWinnerInRow();
	}

	public boolean isWinnerInRow() {
		for (int row = 0; row < NUM_ROWS; row++) {
			int numMatchInRow = 0;
			for (int col = 0; col < NUM_COLUMNS; col++) {
				if (boardBtn[row][col].getIcon() == currentPlayer.getIcon()) {
					numMatchInRow++;
					if (numMatchInRow == 4) {
						return true; // current player won the game
					}
				} else {
					numMatchInRow = 0;
				}

			}
		}
		return false;
	}

	public boolean isWinnerInCol() {

		for (int col = 0; col < NUM_COLUMNS; col++) {
			int numMatchInCol = 0;
			for (int row = 0; row < NUM_ROWS; row++) {
				if (boardBtn[row][col].getIcon() == currentPlayer.getIcon()) {
					numMatchInCol++;
					if (numMatchInCol == 4) {
						return true; // current player won the game
					}
				} else {
					numMatchInCol = 0;
				}
			}
		}
		return false;
	}

	public boolean isWinnerInMainDiag() {

		int row;
		int col;

		for (row = 0; row < NUM_ROWS - 3; row++) {

			for (col = 0; col < NUM_COLUMNS - 3; col++) {

				if (boardBtn[row][col].getIcon() == currentPlayer.getIcon()
						&& boardBtn[row + 1][col + 1].getIcon() == currentPlayer.getIcon()
						&& boardBtn[row + 2][col + 2].getIcon() == currentPlayer.getIcon()
						&& boardBtn[row + 3][col + 3].getIcon() == currentPlayer.getIcon()) {

					return true;

				}

			}

		}

		return false;
	}

	public boolean isWinnerInSecondDiag() {

		for (int row = 0; row < NUM_ROWS - 3; row++) {
			for (int col = 3; col < NUM_COLUMNS; col++) {
				if (boardBtn[row][col].getIcon() == currentPlayer.getIcon()
						&& boardBtn[row + 1][col - 1].getIcon() == currentPlayer.getIcon()
						&& boardBtn[row + 2][col - 2].getIcon() == currentPlayer.getIcon()
						&& boardBtn[row + 3][col - 3].getIcon() == currentPlayer.getIcon()) {

					return true;

				}
			}
		}
		return false;
	}

	public void takeTurn() {

		if (currentPlayer.equals(player1)) {
			currentPlayer = player2;
		} else {

			currentPlayer = player1;

		}
		appendStrToFile("Player turn: "+currentPlayer.getNameString()+"\n");
		currentPlayerDisplay();
	}

	public void boardFull() {
		// if board is full
		if (test1 == NUM_ROWS * NUM_COLUMNS) {

			JOptionPane.showMessageDialog(null, "Board is full\nIs A draw");

			// is a draw
			// Ask if want to continue playing new game
			clearBoard();
			// if not go to main menu
			player1.addDraws();
			player2.addDraws();

		}
	}

	public void clearBoard() {
		
		for (int row = 0; row < NUM_ROWS; row++) {
			for (int col = 0; col < NUM_COLUMNS; col++) {
//					btnA[row][col].setIcon(base); // icon
				boardBtn[row][col].setText("");
				boardBtn[row][col].setIcon(base); // when the icons are set
			}
		}

		test1 = 0;
		x1 = 0;
		y1 = 0;
		isWinnerInRow = false;
	}
	
	public void appendStrToFile(String str) 
	{ 
        String gameLog =  "Connect4_Results.txt";
		
		try { 

			// Open given file in append mode. 
			BufferedWriter out = new BufferedWriter( 
					new FileWriter(gameLog, true)); 
			out.write(str); 
			out.close(); 
		} 
		catch (IOException e) { 
			System.out.println("exception occoured" + e); 
			this.appendStrToFile("exception occoured" + e+"\n");
		} 
	} 

	public void actionBtn(JButton btn) {

		btn.getLocation();

		// row
		int x = btn.getX();
		// col
		int y = btn.getY();

		int count = 0;

		// Get the index numbers
		for (int row = 0; row < NUM_ROWS; row++) {

			for (int col = 0; col < NUM_COLUMNS; col++) {

				if (x == boardBtn[row][col].getLocation().x) {
					if (y == boardBtn[row][col].getLocation().y) {
						indexH = row;
						indexV = col;
					} // end of if

				} // end of if
			} // end of for loop
		} // end of for loop

		// ----------------------------//
		System.out.println("Button clicked at Row Index = " + indexH);
		System.out.println("Button clicked at Col Index = " + indexV);
		// ----------------------------//

		for (int i = NUM_ROWS - 1; i >= 0; i--) {

//				if (btnA[i][indexV].getIcon() == base) {
			if (boardBtn[i][indexV].getIcon() == base) {
				btn = (JButton) boardBtn[i][indexV];
				// btn.setIcon((currentPlayer.getSymbol());//////// change it for icon
//					btn.setText(currentPlayer.getSymbol());
				btn.setIcon(currentPlayer.getIcon());
//					btn.setForeground(currentPlayer.getColor());

				// -----------------------------//
				System.out.println(" chip set at point = " + i + ", " + indexV);
				appendStrToFile("Chip set at point = " + i + ", " + indexV+"\n");
//------------------------------------------------------------------------------------------
				String symbol = boardBtn[i][indexV].getText();

				ImageIcon symbolIcon = (ImageIcon) boardBtn[i][indexV].getIcon();

				if (symbolIcon == currentPlayer.getIcon()) {

					System.out.println("Im a icon of " + currentPlayer.getNameString());
					test1++;
				}

				if (symbol.equalsIgnoreCase(currentPlayer.getSymbol())) {
//						
					// total of moves
					test1++;

					if (symbol.equals(player1.getSymbol())) {
						x1++;
//							
					} else if (symbol.equals(player2.getSymbol())) {
						y1++;

					}

					System.out.println(symbol + " total moves = " + test1);

				}
//------------------------------------------------------------------------------------------

//					checkHorizontal(i, indexV);
//					checkVertical(i, indexV);
//					checkMainDiagonal(i, indexV);
				System.out.println(isWinner(currentPlayer.getNameString()));

				// maybe check here for winner
				if (isWinner(currentPlayer.getSymbol())) {
					JOptionPane.showMessageDialog(null,
							"WINNER! \n" + currentPlayer.getNameString() + "\n" + currentPlayer.getSymbol());

					displayWinner();
					currentPlayerDisplay();
					
					int yesNo = JOptionPane.showConfirmDialog(null, "Do you want to play another game");
					if(yesNo == 0)
					{
						clearBoard();

						takeTurn();
						appendStrToFile("New Game \n");
					}else {
						appendStrToFile("Game terminated \n");
						JOptionPane.showMessageDialog(null, "Thanks for playing");
						
						System.exit(0);
					}
					
				}

				break;
			}
			count++;

		}

		// System.out.println(count);

		if (count == NUM_ROWS) {
			JOptionPane.showMessageDialog(null, "Column is full");

			// JOptionPane.showMessageDialog(null, "Board is full");

		}

		boardFull();

		// System.out.println(test1);

	}// end of function

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btnButton = (JButton) e.getSource();

		actionBtn(btnButton);

		takeTurn();

	}

}
