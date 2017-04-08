package notes;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Label;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import bigGirl.Aconstruct;

@SuppressWarnings("serial")
public class More extends Aconstruct {
	private static File[] myFiles;
	private static String query, sss, myDb, executed;
	private static int gogo = 0, doDrop = 0, countC = 0;
	public static boolean xxx, good, select, create, update, ok, set, unget, unmove, unsave, table, drop, save, get,
			delete, execute, force, stay;
	private static JButton go = new JButton();
	private static JTextField field = new JTextField();
	private static Label label = new Label();
	private static Font font = new Font("Serif", Font.BOLD, 18);
	private static String s = "DBs,Tables,Where,And,Or,Order,Enter",
			s1 = "|  Save  |,|   Get   |,| Delete|,|  RtoL  |,| Clear |,|Create|,|Update|,| setUp |",
			s3 = "createDB,ceateTable,addColumn,createTrigger",
			s4 = "|  Save  |,|   Get   |,|Delete |,|  RtoL  |,| Clear |,| Select |,|Update|,|DROP |",
			s5 = "Tables,Update,Insert,Delete,Alter,CSV",
			s6 = "| Save  |,|  Get   |,|Delete|,| RtoL  |,|Clear |,|Select |,|Create|,| Show |";
	private static List<JButton> but1 = butts(s, Color.lightGray), but2 = butts(s1, Color.lightGray),
			but3 = butts(s3, Color.yellow), but4 = butts(s4, Color.yellow), but5 = butts(s5, Color.lightGray),
			but6 = butts(s6, Color.yellow);
	private static List<JTextArea> list = area(2, 20, 20, false, Color.orange, Color.BLACK),
			list2 = area(1, 3, 10, false, Color.white, Color.BLUE),
			list3 = area(1, 30, 50, false, Color.black, Color.orange);
	private static JFrame frame1 = new JFrame("Select Mode" + "          " + "Website : tinyurl.com/618-projects"
			+ "          " + "Free Application : Donations are greatly needed and appreciated"),
			frame2 = new JFrame("Create Mode" + "          " + "Website : tinyurl.com/618-projects" + "          "
					+ "Free Application : Donations are greatly needed and appreciated"),
			frame3 = new JFrame("Update Mode" + "          " + "Website : tinyurl.com/618-projects" + "          "
					+ "Free Application : Donations are greatly needed and appreciated");

	public static JFrame getFrame1() {
		return frame1;
	}

	public static JFrame getFrame2() {
		return frame2;
	}

	public static JFrame getFrame3() {
		return frame3;
	}

	public static int getGogo() {
		return gogo;
	}

	public static void setGogo(int gogo) {
		More.gogo = gogo;
	}

	public static List<JButton> getBut1() {
		return but1;
	}

	public static List<JButton> getBut2() {
		return but2;
	}

	public static List<JButton> getBut3() {
		return but3;
	}

	public static List<JButton> getBut4() {
		return but4;
	}

	public static List<JButton> getBut5() {
		return but5;
	}

	public static List<JButton> getBut6() {
		return but6;
	}

	public static List<JTextArea> getList() {
		list.get(1).setEditable(true);
		list.get(1).setForeground(Color.gray);
		list.get(1).setBackground(Color.white);
		return list;
	}

	public static List<JTextArea> getList2() {
		list2.get(0).add(label);
		list2.get(0).add(go);
		list2.get(0).add(field);
		return list2;
	}

	public static List<JTextArea> getList3() {
		return list3;
	}

	public static Label getLabel() {
		label.setFont(font);
		label.setBounds(20, 20, 185, 35);
		return label;
	}

	public static JButton getGo() {
		go.setFont(font);
		go.setText("GO");
		go.setBackground(Color.green);
		go.setBounds(415, 20, 100, 35);
		return go;
	}

	public static JTextField getField() {
		field.setBounds(210, 20, 200, 35);
		field.setFont(font);
		return field;
	}

	public static void setIt(String text, Color col) {
		getList2().get(0).add(getField());
		getLabel();
		getGo();
		go.setText(text);
		list2.get(0).setBackground(col);
		label.setBackground(col);
		label.setForeground(Color.black);
		label.setText("Enter File Name :");
	}

	public static void setSettings(String textL, String textB, Color color) {
		getList2().get(0).remove(getField());
		Font f = new Font("Serif", Font.BOLD, 40);
		label.setFont(f);
		label.setBounds(20, 20, 300, 50);
		list2.get(0).setBackground(Color.BLACK);
		label.setBackground(Color.BLACK);
		label.setText(textL);
		go.setBounds(350, 20, 150, 50);
		go.setText(textB);
		go.setBackground(color);
		label.setForeground(Color.white);
	}

	public static void setBases() {
		getList2().get(0).add(getField());
		getLabel();
		getGo();
		list2.get(0).setBackground(Color.magenta);
		label.setBackground(Color.magenta);
		label.setForeground(Color.white);
		label.setText("Enter Database Name :");
	}

	public static void setGo(Color col) {
		getList2().get(0).add(getField());
		getLabel();
		getGo();
		field.setText("");
		go.setText("GO");
		list2.get(0).setBackground(col);
		label.setBackground(col);
		label.setForeground(Color.white);
		label.setText("Enter Table Name :");
	}

	public static void setCreate(String enter, String create) {
		list2.get(0).add(getField());
		getLabel();
		getGo();
		field.setText("");
		go.setText(create);
		list2.get(0).setBackground(Color.black);
		label.setBackground(Color.black);
		label.setForeground(Color.white);
		label.setText(enter + " :");
		go.setBackground(Color.green);
	}

	public static String getQuery() {
		return query;
	}

	public static void setQuery(String query) {
		More.query = query;
	}

	public static String getSss() {
		return sss;
	}

	public static void setSss(String sss) {
		More.sss = sss;
	}

	public static File[] getMyFiles() {
		return myFiles;
	}

	public static void setMyFiles(File[] myFiles) {
		More.myFiles = myFiles;
	}

	public static int getDoDrop() {
		return doDrop;
	}

	public static void setDoDrop(int doDrop) {
		More.doDrop = doDrop;
	}

	public static String getMyDb() {
		return myDb;
	}

	public static void setMyDb(String myDb) {
		More.myDb = myDb;
	}

	public static int getCountC() {
		return countC;
	}

	public static void setCountC(int count) {
		More.countC = count;
	}

	public static String getExecuted() {
		return executed;
	}

	public static void setExecuted(String executed) {
		More.executed = executed;
	}

	public static void openWebpage(URI uri) {
		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
		if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			try {
				desktop.browse(uri);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void openWebpage(URL url) {
		try {
			openWebpage(url.toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

}
