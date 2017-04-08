package notes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.swing.Box;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Ok1 extends More {
	private static String s11 = "618-Projects,618-Tube,618-Donate";
	private static List<JButton> but7 = butts(s11, Color.pink);

	public static List<JButton> getBut7() {
		return but7;
	}

	public static Box box() {
		List<JButton> butGo = getBut1();
		List<JButton> butSet = getBut1();

		switch (getGogo()) {
		case 0:
			butGo = getBut1();
			butSet = getBut2();
			break;
		case 1:
			butGo = getBut3();
			butSet = getBut4();
			break;
		case 2:
			butGo = getBut5();
			butSet = getBut6();
			break;
		}

		Box box = Box.createHorizontalBox();
		Box box1 = Box.createVerticalBox();
		box1.add(butBox(but7, true));
		box1.add(textBox(getList(), true));
		box1.add(Box.createVerticalStrut(10));
		box1.add(butBox(butGo, true));
		box1.add(Box.createVerticalStrut(10));
		box1.add(textBox(getList2(), true));
		box.add(box1);
		box.add(butBox(butSet, false));
		box.add(Box.createHorizontalStrut(10));
		box.add(textBox(getList3(), true));

		return box;
	}

	public static void evenMoreButts() {

		getBut7().get(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				try {
					URL domain = new URL("http://tinyurl.com/618-projects");
					openWebpage(domain);
				} catch (MalformedURLException e1) {
					System.out.println("URL PROBLEM!!!\n" + e1);

				}
			}
		});

		getBut7().get(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				try {
					URL domain = new URL("https://www.youtube.com/channel/UCz-ViYfEMUhFREpuUhqEImQ");
					openWebpage(domain);
				} catch (MalformedURLException e1) {
					System.out.println("URL PROBLEM!!!\n" + e1);

				}
			}
		});

		getBut7().get(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				try {
					URL domain = new URL("https://www.paypal.me/618phi");
					openWebpage(domain);
				} catch (MalformedURLException e1) {
					System.out.println("URL PROBLEM!!!\n" + e1);

				}
			}
		});

	}
}

