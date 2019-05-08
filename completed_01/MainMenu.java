package completed_01;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainMenu extends JFrame implements ActionListener {
	private JPanel jMain, jTitle, jContent, jCredit;
	private JLabel titleLabel, creditJLabel;

	private JButton mainButton, highScoreButton;

	private JMenuBar mainMenuBar;
	private JMenu file, help;
	private JMenuItem mainMenu, exit01;

	private ImageIcon xIcon1, oIcon1, yIcon1, zIcon1;

	private Font titleFont;

	ImageIcon xIcon, oIcon, yIcon, zIcon;

	protected Playerf player1;
	protected Playerf player2;
	protected Playerf currentPlayer;

	String symbol1txt, name1txt, symbol2txt, name2txt;
	ImageIcon p1Symbol, p2Symbol;

	ScoreBoardF scoreBoard;
	Array2dJpanelBtn gamebtn;


	public MainMenu() {

		oIcon = new ImageIcon("images/oIcon.png");
		xIcon = new ImageIcon("images/xIcon.png");
		yIcon = new ImageIcon("images/yIcon.png");
		zIcon = new ImageIcon("images/zIcon.png");

//		player1 = new Playerf("X", "Sandy", xIcon);
//		player2 = new Playerf("O", "Norberto", oIcon);
//		currentPlayer = player1;

		// -------------------------------------------------------------------//
		/// Setting Up the Menu Bar

		mainMenuBar = new JMenuBar();
		setJMenuBar(mainMenuBar);

		file = new JMenu("File");
		help = new JMenu("Help");

		mainMenu = new JMenuItem("Main Menu");
		exit01 = new JMenuItem("Exit");

		file.add(mainMenu);
		file.add(exit01);

		mainMenuBar.add(file);
		mainMenuBar.add(help);

		/// End of menu-bar
		// -------------------------------------------------------------------//

		// the base of all j panels
		jMain = new JPanel();

		mainMenu();

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// set the window to the center
		setLocationRelativeTo(null);
		// fixed dimensions
		setResizable(false);
		setVisible(true);

		mainMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				jMain.removeAll();

				mainMenu();

			}
		});

		exit01.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				System.exit(0);
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		p1Setup();
	}

	public void mainMenu() {

		jTitle = new JPanel();
		jContent = new JPanel();
		jCredit = new JPanel();

		// Set the layout for the panel
		jMain.setLayout(new FlowLayout(2, 30, 30));

		titleLabel = new JLabel("MAIN MENU", SwingConstants.CENTER);

		mainButton = new JButton("New Game");
		highScoreButton = new JButton("High Score");
		creditJLabel = new JLabel("Created by: Norberto Studios", SwingConstants.CENTER);

		titleFont = new Font("", Font.BOLD, 64);
		titleLabel.setFont(titleFont);

		jTitle.add(titleLabel);

		jContent.setLayout(new FlowLayout(0, 5, 5));

		mainButton.setPreferredSize(new Dimension(200, 100));
		highScoreButton.setPreferredSize(new Dimension(200, 100));

		mainButton.addActionListener(this);

		jContent.add(mainButton);
		jContent.add(highScoreButton);

		jCredit.add(creditJLabel);

		jMain.add(jTitle);
		jMain.add(jContent);
		jMain.add(jCredit);

		add(jMain);

		setTitle("Main Menu - Connect 4");
		setSize(500, 450);

	}

	public void p1Setup() {
		jMain.removeAll();

		setSize(new Dimension(400, 500));

		setTitle("Player Setup");

		jMain.setLayout(new GridLayout(4, 1));

		JPanel jPtitle1 = new JPanel();
		JPanel jPanel1 = new JPanel();
		JPanel jPradiobtn = new JPanel();
		JPanel jPbotton1 = new JPanel();

		oIcon1 = new ImageIcon("images/oIcon1.png");
		xIcon1 = new ImageIcon("images/xIcon1.png");
		yIcon1 = new ImageIcon("images/yIcon1.png");
		zIcon1 = new ImageIcon("images/zIcon1.png");

		JTextField inputName = new JTextField("Enter Name");
		JLabel name1 = new JLabel("Name: ", SwingConstants.CENTER);
		JLabel symbol1 = new JLabel("Choose Your Symbol", SwingConstants.CENTER);
		JLabel title1 = new JLabel("Player 1", SwingConstants.CENTER);

		JLabel oJLabel = new JLabel(oIcon1);
		JLabel xJLabel = new JLabel(xIcon1);
		JLabel yJLabel = new JLabel(yIcon1);
		JLabel zJLabel = new JLabel(zIcon1);

		inputName.setHorizontalAlignment(SwingConstants.CENTER);
		name1.setFont(new Font("Tahoma", Font.BOLD, 20));
		symbol1.setFont(new Font("Tahoma", Font.BOLD, 20));

		JRadioButton c1 = new JRadioButton("O", true);
		JRadioButton c2 = new JRadioButton("X");
		JRadioButton c3 = new JRadioButton("Y");
		JRadioButton c4 = new JRadioButton("Z");
		JButton confirm1 = new JButton("Next");

		jPtitle1.setLayout(new GridLayout(1, 1));
		jPanel1.setLayout(new GridLayout(3, 1));

		jPbotton1.setLayout(new FlowLayout());
		jPradiobtn.setLayout(new GridLayout(2, 4));

		title1.setFont(title1.getFont().deriveFont(34.0f));
		title1.setFont(title1.getFont().deriveFont(Font.BOLD));

		confirm1.setPreferredSize(new Dimension(200, 100));

		ButtonGroup symbolGroup = new ButtonGroup();

		symbolGroup.add(c1);
		symbolGroup.add(c2);
		symbolGroup.add(c3);
		symbolGroup.add(c4);

		jPtitle1.add(title1);
//    	
		jPanel1.add(name1);
		jPanel1.add(inputName);
		jPanel1.add(symbol1);

		jPradiobtn.add(c1);
		jPradiobtn.add(oJLabel);
		jPradiobtn.add(c2);
		jPradiobtn.add(xJLabel);
		jPradiobtn.add(c3);
		jPradiobtn.add(yJLabel);
		jPradiobtn.add(c4);
		jPradiobtn.add(zJLabel);

		jPbotton1.add(confirm1);

		jMain.add(jPtitle1);
		jMain.add(jPanel1);
		jMain.add(jPradiobtn);
		jMain.add(jPbotton1);

		confirm1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("hello");

				name1txt = inputName.getText();

				if (c1.isSelected()) {
					p1Symbol = oIcon;
					symbol1txt = c1.getText();
					System.out.println("c1 is selected");

				} else if (c2.isSelected()) {
					p1Symbol = xIcon;
					symbol1txt = c2.getText();
					System.out.println("c2 is selected");
				} else if (c3.isSelected()) {
					p1Symbol = yIcon;
					symbol1txt = c3.getText();
					System.out.println("c3 is selected");
				} else if (c4.isSelected()) {
					p1Symbol = zIcon;
					symbol1txt = c4.getText();
					System.out.println("c4 is selected");
				}

				System.out.println("Name " + name1txt);

				
				jMain.setVisible(false);
				p2Setup();

			}
		});

	}

	public void p2Setup() {

		jMain.removeAll();
		jMain.setVisible(true);

		setTitle("Player 2 Setup");

		JPanel jPtitle2 = new JPanel();
		JPanel jPanel2 = new JPanel();
		JPanel jPradiobtn2 = new JPanel();
		JPanel jPbotton2 = new JPanel();

		oIcon1 = new ImageIcon("images/oIcon1.png");
		xIcon1 = new ImageIcon("images/xIcon1.png");
		yIcon1 = new ImageIcon("images/yIcon1.png");
		zIcon1 = new ImageIcon("images/zIcon1.png");

		JTextField inputName = new JTextField("Enter Name");
		JLabel name1 = new JLabel("Name: ", SwingConstants.CENTER);
		JLabel symbol1 = new JLabel("Choose Your Symbol", SwingConstants.CENTER);
		JLabel title2 = new JLabel("Player 2", SwingConstants.CENTER);

		JLabel oJLabel = new JLabel(oIcon1);
		JLabel xJLabel = new JLabel(xIcon1);
		JLabel yJLabel = new JLabel(yIcon1);
		JLabel zJLabel = new JLabel(zIcon1);

		inputName.setHorizontalAlignment(SwingConstants.CENTER);
		name1.setFont(new Font("Tahoma", Font.BOLD, 20));
		symbol1.setFont(new Font("Tahoma", Font.BOLD, 20));

		JRadioButton c1 = new JRadioButton("O");
		JRadioButton c2 = new JRadioButton("X", true);
		JRadioButton c3 = new JRadioButton("Y");
		JRadioButton c4 = new JRadioButton("Z");
		JButton confirm2 = new JButton("Done");

		jPtitle2.setLayout(new GridLayout(1, 1));
		jPanel2.setLayout(new GridLayout(3, 1));

		jPbotton2.setLayout(new FlowLayout());
		jPradiobtn2.setLayout(new GridLayout(2, 4));

		title2.setFont(title2.getFont().deriveFont(34.0f));
		title2.setFont(title2.getFont().deriveFont(Font.BOLD));

		confirm2.setPreferredSize(new Dimension(200, 100));
		ButtonGroup symbolGroup = new ButtonGroup();

		symbolGroup.add(c1);
		symbolGroup.add(c2);
		symbolGroup.add(c3);
		symbolGroup.add(c4);

		jPtitle2.add(title2);
//    	
		jPanel2.add(name1);
		jPanel2.add(inputName);
		jPanel2.add(symbol1);

		jPradiobtn2.add(c1);
		jPradiobtn2.add(oJLabel);
		jPradiobtn2.add(c2);
		jPradiobtn2.add(xJLabel);
		jPradiobtn2.add(c3);
		jPradiobtn2.add(yJLabel);
		jPradiobtn2.add(c4);
		jPradiobtn2.add(zJLabel);

		jPbotton2.add(confirm2);

		jMain.add(jPtitle2);
		jMain.add(jPanel2);
		jMain.add(jPradiobtn2);
		jMain.add(jPbotton2);

		confirm2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				name2txt = inputName.getText();

				if (c1.isSelected()) {
					

						p2Symbol = oIcon;
						symbol2txt = c1.getText();
						System.out.println("c1 is selected");
					
				} else if (c2.isSelected()) {
				

						p2Symbol = xIcon;
						symbol2txt = c2.getText();
						System.out.println("c2 is selected");
					
				} else if (c3.isSelected()) {
					
						p2Symbol = yIcon;
						symbol2txt = c3.getText();
						System.out.println("c3 is selected");
					
				} else if (c4.isSelected()) {
					

						p2Symbol = zIcon;
						symbol2txt = c4.getText();
						System.out.println("c4 is selected");
					
				}

				
				String[] randomNames = {"Batman", "Superman", "Spiderman", 
						"WonderWoman", "Hulk", "CaptainAmerica", "CaptainMalvel","Lucky",
						"Rocket Racoon"};

				
				
				if(name1txt.equalsIgnoreCase("Enter Name") || name1txt.equalsIgnoreCase(""))
				{
					
					name1txt = randomNames[0 +(int)(Math.random()*((randomNames.length-0)+1))];
				}
				
				if(name2txt.equalsIgnoreCase("Enter Name") || name2txt.equalsIgnoreCase(""))
				{
					
					name2txt = randomNames[0 +(int)(Math.random()*((randomNames.length-0)+1))];
				}
				
				player1 = new Playerf(symbol1txt, name1txt, p1Symbol);
				player2 = new Playerf(symbol2txt, name2txt, p2Symbol);
				currentPlayer = player1;


				setSize(700, 650);
				setLocationRelativeTo(null);
				jMain.removeAll();
				jMain.setLayout(new BorderLayout());
				setTitle("Connect 4 ");

				gamebtn = new Array2dJpanelBtn(player1, player2, currentPlayer);
				scoreBoard = gamebtn.scoreBoardF;

				
				jMain.add(scoreBoard, BorderLayout.NORTH);
				jMain.add(gamebtn, BorderLayout.CENTER);
				
				// will display the first player turn
				JOptionPane.showMessageDialog(null,currentPlayer.getNameString()+ " Will go first!");
			}
		});
		
		
	}
	
	


}
