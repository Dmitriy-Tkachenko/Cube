
public class Main {

	public static void main(String[] args) {
		Cube c = new Cube();
		c.translate(-0.5, -0.5, -0.5);
		c.scale(100);
		//c.rotate(15, 45, 0);
		Screen s = new Screen(c);

	}

}
