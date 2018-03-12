package java实例与思考;

import javax.swing.JFrame;

import org.junit.Test;

public class 图形界面 {
	@Test
	public static void test窗口() {
		JFrame frame = new JFrame("第一个窗口");
		JFrame frame2 = new JFrame("第二个窗口");
		frame.setSize(1360, 760);
		frame.setBounds(60, 100, 1360, 760);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		test窗口();
	}
}
