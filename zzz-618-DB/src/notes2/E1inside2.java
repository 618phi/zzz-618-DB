package notes2;

import java.awt.Color;
import java.io.File;

@SuppressWarnings("serial")
public class E1inside2 extends E2inside3 {

	public static void saveFiles(String sf, int num, String type) {
		jText(getList().get(0));
		File savedFiles = new File(sf.trim() + "/");
		setMyFiles(savedFiles.listFiles());
		getList().get(0).setText("        --------------------------\n         " + type
				+ " Saved Files\n        --------------------------\n");
		for (File f : getMyFiles()) {
			System.out.println(sub(f.toString(), "savedfiles", ".txt", num, 0));
		}
		ok = false;
	}

	public static void drop() {
		getList().get(0)
				.setText("\n\n\n\n\n        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n          THE SELECTED"
						+ "\nDATABASE / TABLE / TRIGGER\n          WILL BE LOST\n          PERMANENLY\n"
						+ "             IF DROP\n                   IS\n             EXECUTED\n"
						+ "        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		getList().get(1).setText("\n\n\n\n\n\n\n\n To Start the Drop Process,\n Type In Uppercase One Of:\n"
				+ "     DATABASE\n     TABLE\n     TRIGGER\n In The Input Selection Field.");
		drop = false;
		setCreate("Input Selection", "Select");
	}

	public static void delete(String sf, int num, String type) {
		if (!getField().getText().trim().isEmpty()) {
			try {
				readFile(sf.trim() + "/" + getField().getText().trim() + ".txt");
			} catch (Exception e1) {
				getList3().get(0).append(getField().getText().trim() + ".txt : BAD FILE INPUT!\n"
						+ "          *************************************************\n");
				good = false;
			}
			if (good) {
				File file = new File(sf.trim() + "/" + getField().getText().trim() + ".txt");
				if (file.exists())
					file.delete();
				getList3().get(0).append(getField().getText().trim() + ".txt : File Delete Completed.\n"
						+ "          *************************************************\n");
				saveFiles(sf.trim(), num, type.trim());
			}
		} else {
			getList3().get(0).append(
					"No Delete File Name Entered!\n" + "          *************************************************\n");
		}
	}

	public static void get(String sf) throws Exception {
		if (!getField().getText().trim().isEmpty()) {
			setExecuted(getField().getText().trim());
			try {
				readFile(sf.trim() + "/" + getExecuted() + ".txt");
			} catch (Exception e1) {
				jText(getList3().get(0));
				System.out.println(getExecuted() + ".txt : BAD FILE INPUT!");
				System.out.println("          *************************************************");
				good = false;
				get = false;
			}
			if (good) {
				if(stay == true)
				setSettings("Execute " + getExecuted(), "Execute", Color.CYAN);
				stay = true;
				String f = readFile(sf.trim() + "/" + getExecuted() + ".txt");
				getList().get(1).setText("");
				jText(getList().get(1));
				System.out.println(f.trim());
				getList3().get(0).append(getExecuted() + ".txt : File In Use\n"
						+ "          *************************************************\n");
			}
		} else {
			get = false;
			getList3().get(0)
					.append("No Get File Name Entered!\n          *************************************************\n");
		}
	}

	public static void save(String sf, int num, String type) {
		if (!getField().getText().trim().isEmpty()) {
			boolean doIt = true;
			String input = sf + "\\" + getField().getText().trim() + ".txt";
			for (File f : getMyFiles()) {
				if (input.equals(f.toString()))
					doIt = false;
			}

			if (doIt) {
				try {
					writeFile(getList().get(1).getText(), input);
				} catch (Exception e1) {
					getList3().get(0).append(getField().getText().trim() + ".txt : BAD FILE INPUT!\n"
							+ "          *************************************************\n");
					good = false;
				}
				if (good) {
					saveFiles(sf, num, type);
					getList3().get(0).append(getField().getText().trim() + ".txt : File Save Completed.\n"
							+ "          *************************************************\n");
				}
			} else {
				getList3().get(0).append(getField().getText().trim() + ".txt : File Already Exists!\n"
						+ "          *************************************************\n");
			}
		} else {
			getList3().get(0).append(
					"No Save File Name Entered!\n" + "          *************************************************\n");
		}
	}
}
