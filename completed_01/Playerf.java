package completed_01;

import java.awt.Color;

import javax.swing.ImageIcon;

public class Playerf 
{
	
	private String name;
	private String symbol;
	private int wins;
	private int losses;
	private int draws;
	private int numGamePlayed;
	private Color color;
	private ImageIcon icon;
	
	public Playerf() {
	
		name = "John Doe";
		symbol = "?";
		wins = 0;
		losses =0;
		draws = 0;
		numGamePlayed = 0;
		color = Color.BLUE;
		icon = null;
		
	}
	
	public Playerf(String symb)
	{
		this();
		symbol = symb;
	}
	
	public Playerf(String symb, String nam)
	{
		this();
		symbol = symb;
		name = nam;
	}
	public Playerf(String symb, String nam, Color col)
	{
		this();
		symbol = symb;
		name = nam;
		color = col;
	}
	public Playerf(String symb, String nam, ImageIcon icol)
	{
		this();
		symbol = symb;
		name = nam;
		icon = icol;
	}
	
	protected void addWin() {
		numGamePlayed++;
		wins++;
	}

	protected void addLoss() {
		losses++;
		numGamePlayed++;
	}

	protected void addDraws() {
		draws++;
		numGamePlayed++;
	}
	public void setColor(Color col)
	{
		color = col;
	}
	
	public Color getColor() {
		return color;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon symbol) {
		icon = symbol;
	}

	public String getNameString() {
		return name;
	}

	public void setNameString(String nameString) {
		this.name = nameString;
	}

	public int getNumGames() {
		return numGamePlayed;
	}


	public int getNumWins() {
		return wins;
	}


	public int getNumLosses() {
		return losses;
	}


	public int getNumDraws() {
		return draws;
	}
	
	
	public boolean equalTo(Object o)
	{
		if(o instanceof Playerf)
		{
			Playerf otherPlayer = (Playerf) o;
			if(this.name.equals(otherPlayer.name))
			{
				if(this.symbol.equals(otherPlayer.symbol))
				{
					if(this.icon == otherPlayer.icon)
					{
					return true;
					}
				}
			}
		}
		return false;
	}
	
	public String toString()
	{
		String str = String.format("Name = %20s | Symbol %5s", getNameString(), getSymbol());
		return str;
	}
	
}
