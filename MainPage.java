import java.awt.*;
import javax.swing.*;

public class MainPage {

	private static final int w = 1689;
	private static final int h = 744;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Transformation");
		frame.setPreferredSize(new Dimension(w,h));
		frame.setMinimumSize(new Dimension(w,h));
		frame.setMaximumSize(new Dimension(w,h));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(new Display());
		frame.setVisible(true);
	}
}

