import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class Screen extends JFrame {
	private static final long serialVersionUID = -6485631907727411393L;
	private Cube _c;
	private int width = 500, height = 300;
	private KeyL _l;
	
	public Screen(Cube c) {
		_c = c;
		_l = new KeyL(c, this);
		this.setLocationRelativeTo(null);
		this.setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.BLACK);
		this.setVisible(true);
		this.addKeyListener(_l);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.translate(width/2, height/2);
		
		//_c.ortdraw((Graphics2D) g);
		_c.perstdraw((Graphics2D) g);
	}
	
}
