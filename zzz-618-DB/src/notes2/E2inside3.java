package notes2;

import java.awt.Color;
import java.sql.ResultSet;
import notes.Ok;

@SuppressWarnings("serial")
public class E2inside3 extends Ok {

	public static void bool() {
		table = true;
		unsave = true;
		set = true;
		ok = false;
		unget = false;
		unmove = false;
		drop = true;
		delete = true;
		get = true;
		save = true;
		execute = true;
		force = false;
	}

	public static void updateMode() {
		if (testIt("TABLES")) {
			sound("bounce.wav");
			xxx = false;
			getFrame1().getContentPane().removeAll();
			getFrame1().dispose();
			getFrame2().getContentPane().removeAll();
			getFrame2().dispose();
			setGogo(2);
			frame(getFrame3(), Color.PINK, 10, box());
			getList().get(1).setText(
					"\n\n\n\n\n        *************************\n          Enter Table Name\n          Or Click Get\n"
							+ "          To Open A Saved File\n        *************************\n");
			bool();
			ok = true;
			select = false;
			create = false;
			update = true;
			setGo(Color.DARK_GRAY);
			getList3().get(0).append("Update Mode In Use\n");
			getList3().get(0).append("          *************************************************\n");
			try {
				tables("Tables");
			} catch (Exception e1) {
				System.out.println("Get Tables Problem!\n" + e1);
			}
		}
	}

	public static void selectMode() {
		sound("bounce.wav");
		getList().get(1).setText("");
		getList().get(1).setText(
				"\n\n\n\n\n        *************************\n          Enter Database Name\n          Or Click Create\n"
						+ "          To Create A New Database\n        *************************\n");
		getField().setText("");
		getFrame2().dispose();
		getFrame2().getContentPane().removeAll();
		getFrame3().dispose();
		getFrame3().getContentPane().removeAll();
		setGogo(0);
		frame(getFrame1(), Color.PINK, 10, box());
		setBases();
		try {
			tables("DATABASES");
		} catch (Exception e) {
		}
		bool();
		table = false;
		select = true;
		create = false;
		update = false;
		getList3().get(0).append("Select Mode In Use\n");
		getList3().get(0).append("          *************************************************\n");
	}

	public static void createMode() {
			sound("bounce.wav");
			getFrame1().getContentPane().removeAll();
			getFrame1().dispose();
			getFrame3().getContentPane().removeAll();
			getFrame3().dispose();
			setGogo(1);
			frame(getFrame2(), Color.PINK, 10, box());
			getList().get(1).setText("");
			bool();
			ok = true;
			select = false;
			create = true;
			update = false;
			setCreate("Enter Database Name", "Create");
			try {
				tables("DATABASES");
			} catch (Exception e1) {
				System.out.println("Get Database Problem!\n" + e1);
				;
			}
			setDoDrop(0);
			getList3().get(0).append("Create Mode In Use\n");
			getList3().get(0).append("          *************************************************\n");
			getList().get(1).setText("\n\n\n\n\n      ***********************\n"
					+ "          To Create Database\n          Enter Database Name\n"
					+ "          In The TextField\n      ***********************\n");
	}

	public static boolean testIt(String type) {
		boolean b = true;
		try {
			set("SHOW " + type.trim());
		} catch (Exception e1) {
			b = false;
		}
		return b;
	}

	public static void tables(String show) throws Exception {
		jText(getList().get(0));
		try {
			if (!(getMyDb() == null) && !show.contains("DATABASES")) {
				getList().get(0).setText("        --------------------------\n          " + getMyDb() + " " + show
						+ "\n        --------------------------\n");
			} else {
				getList().get(0).setText(
						"        ---------------------\n          " + show + "\n        ---------------------\n");
			}
			ResultSet results = set("SHOW " + show + ";");
			while (results.next()) {
				System.out.print(results.getNString(1) + " ");
				System.out.println();
			}
		} catch (Exception e1) {
			getList3().get(0).append(
					"Problem Showing " + show + "\n          *************************************************\n");
		}
	}
}
