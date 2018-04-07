package util;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;

public class PropriedadesTela {
	Insets in;
	Dimension d;
	
	public PropriedadesTela(Insets in){
		setIn(in);
	}
	
	public void setIn(Insets in)
	{
		this.in = in;
	}
	
	public Insets getIn()
	{
		return in;
	}
	
	public int width()
	{
		d = Toolkit.getDefaultToolkit().getScreenSize();

		int width = d.width-(getIn().left + getIn().top);
		return width;
	}
	
	public int height()
	{
		d = Toolkit.getDefaultToolkit().getScreenSize();

		int height = d.height-(getIn().top + getIn().bottom);
		
		return height;
	}
}
