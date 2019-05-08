package completed_01;

public class ShowGUI 
{
	
	// run the connect 4 game
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				MainMenu gui = new MainMenu();
				
			}
		});
	}

}
