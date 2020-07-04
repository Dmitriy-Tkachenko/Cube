import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyL implements KeyListener{
	private enum rotate {Left, Right, Up, Down, None};
	private rotate rt = rotate.None;
	private Cube _c;
	private Screen _scr;

	public KeyL(Cube c, Screen s) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				CheckKeys();
			}

		}).start();
		_c = c;
		_scr = s;
	}
	
	protected void CheckKeys() {
		while (true) {
			switch(rt) {
				case Left: {
					_c.rotate(0, -1, 0);
					_scr.repaint();
					break;
				}
				case Right: {
					_c.rotate(0, 1, 0);
					_scr.repaint();
					break;
				}
				case Up: {
					_c.rotate(1, 0, 0);
					_scr.repaint();
					break;
				}
				case Down: {
					_c.rotate(-1, 0, 0);
					_scr.repaint();
					break;
				}
			default:
				break;				
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rt = rotate.Left;
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rt = rotate.Right;
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			rt = rotate.Up;
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rt = rotate.Down;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		rt = rotate.None;
	}

}
