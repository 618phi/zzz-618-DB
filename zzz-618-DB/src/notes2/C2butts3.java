package notes2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class C2butts3 extends CgoBut {
	private static ArrayList<String> list = new ArrayList<String>();
	private static int count = 0, count2 = 0;

	public static void writeF(String fileName, int count) throws Exception {
		File file = new File(fileName);
		if (!file.exists()) {
			file.createNewFile();
		}
		file.mkdirs();
		FileWriter fw = new FileWriter(file.getAbsolutePath());

		ResultSet set = set("SELECT * FROM trig");
		while (set.next()) {
			for (int i = 1; i <= count; count++) {
				fw.append(set.getString(i));
				fw.append(',');
			}
			fw.append('\n');
			fw.flush();
			fw.close();
		}
	}

	public static void moreButts2() {
		// uTable
		getBut5().get(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				try {
					tables("Tables");
					bool();
					ok = true;
					setGo(Color.DARK_GRAY);
					getList3().get(0).append("Select A Table From Database " + getMyDb() + "\n");
					getList3().get(0).append("          *************************************************\n");
				} catch (Exception e1) {
					getList3().get(0).append("Get Tables Problem!\n" + e1);
				}
			}
		});
		// uUpdate button
		getBut5().get(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (xxx == true) {
					sound("bounce.wav");
					getUcols();
					setExecuted("Update");
					setSettings(getExecuted() + " " + getQuery(), "Execute", Color.CYAN);
					getList().get(1).setText("\nUPDATE " + getQuery()
							+ "\nSET\ncolumnName1 ><= value1\nWHERE\ncolumnName2 ><= value2\n;");
					getList3().get(0).append("Table " + getQuery() + " : Update Edit Ready\n");
					getList3().get(0).append("          *************************************************\n");
					bool();
					unget = true;
				}
			}
		});

		// uInsert button
		getBut5().get(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (xxx == true) {
					sound("bounce.wav");
					getUcols();
					setExecuted("Insert");
					setSettings(getExecuted() + " " + getQuery(), "Execute", Color.CYAN);
					try {
						ResultSet set = set("DESCRIBE " + getQuery() + ";");
						while (set.next()) {
							list.add(set.getString(1));
							count2++;
						}
					} catch (Exception e1) {
					}
					getList().get(1).setText("\nINSERT INTO\n" + getQuery() + "\n(\n");
					count = 0;
					for (String s : list) {
						getList().get(1).append(s);
						count++;
						if (count < count2)
							getList().get(1).append("  ,  \n");
					}
					count = 0;
					getList().get(1).append("\n)\nVALUES\n(\n");
					for (String s : list) {
						getList().get(1).append("\"" + s + "Value\"");
						count++;
						if (count < count2)
							getList().get(1).append("  ,  \n");
					}
					getList().get(1).append("\n)\n;");
					getList3().get(0).append("Table " + getQuery() + " : Insert Edit Ready\n");
					getList3().get(0).append("          *************************************************\n");
					count = 0;
					count2 = 0;
					list.clear();
					bool();
					unget = true;
				}
			}
		});

		// uDelete
		getBut5().get(3).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (xxx == true) {
					sound("bounce.wav");
					getUcols();
					setExecuted("Delete");
					setSettings(getExecuted() + " " + getQuery(), "Execute", Color.CYAN);
					getList().get(1)
							.setText("\nDELETE FROM\n" + getQuery() + "\nWHERE\n" + "columnName ><= value\n;\n");
					getList3().get(0).append("Table " + getQuery() + " : Delete Edit Ready\n");
					getList3().get(0).append("          *************************************************\n");
					getList().get(1)
							.append("\n/*\n#Fix AUTO_INCREMENT\nSET  @N = 0;\nUPDATE\n" + getQuery() + "\nSET\n"
									+ "columnName\n= @N := (@N + 1);\nALTER TABLE\n" + getQuery()
									+ "\nAUTO_INCREMENT = 1;\n*/");
					bool();
					unget = true;
				}
			}
		});

		// uAlter
		getBut5().get(4).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (xxx == true) {
					sound("bounce.wav");
					getUcols();
					setExecuted("Alter");
					setSettings(getExecuted() + " " + getQuery(), "Execute", Color.CYAN);
					getList().get(1).setText("\nALTER TABLE\n" + getQuery() + "\nADD\n# MODIFY COLUMN\ncolumnName\n"
							+ "INT(5)\nNOT NULL\n# PRIMARY KEY\n# AUTO_INCREMENT\n# AFTER columnName\n;\n");
					getList().get(1).append("\n/*\nALTER TABLE\n" + getQuery() + "\nDROP\ncolumnName\n;\n*/");
					getList3().get(0).append("Table " + getQuery() + " : Alter Edit Ready\n");
					getList3().get(0).append("          *************************************************\n");
					bool();
					unget = true;
				}
			}
		});

		// CSV button
		getBut5().get(5).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				try {
					sound("bounce.wav");
					setExecuted("CSV");
					setSettings(getExecuted(), "Execute", Color.CYAN);
					getList().get(1).setText(readFile("files/tocsv.txt"));
					getList3().get(0).append("CSV Import/Export Edit Ready\n");
					getList3().get(0).append("          *************************************************\n");
					bool();
					unget = true;
				} catch (Exception e1) {
					getList3().get(0).append(e1 + "\n          *************************************************\n");
				}
			}
		});

		// uSave
		getBut6().get(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				setIt("Save", Color.cyan);
				saveFiles("savedfiles3", 12, "Update");
				bool();
				save = false;
			}
		});

		// uGet
		getBut6().get(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				getList3().get(0).append(
						"To compare current work : Use RtoL before hitting Get\n          *************************************************\n");

				setIt("Get", Color.orange);
				saveFiles("savedfiles3", 12, "Update");
				bool();
				get = false;
			}
		});

		// uDelete button
		getBut6().get(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				setIt("Delete", Color.red);
				saveFiles("savedfiles3", 12, "Update");
				bool();
				delete = false;
			}
		});

		// uRtoL
		getBut6().get(3).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jText(getList3().get(0));
				sound("bounce.wav");
				getList().get(0).setText(getList().get(1).getText());
				System.out.println("Right Textfeild Copied to Left Textfeild");
				System.out.println("          *************************************************");
			}
		});

		// uClear button
		getBut6().get(4).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				getList3().get(0).setText("");
			}
		});

		// uSelect button
		getBut6().get(5).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectMode();
			}
		});

		// uCreate button
		getBut6().get(6).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createMode();
			}
		});

		// uShow button
		getBut6().get(7).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (xxx == true) {
					sound("bounce.wav");
					jText(getList3().get(0));
					if (xxx == true) {
						try {
							showTab(getQuery().trim(), "*");
							System.out.println("\n          *************************************************");
						} catch (Exception e1) {
							System.out.println("Problem Showing Table " + getQuery() + "\n" + e1);
							System.out.println("\n          *************************************************");
						}
					}
				}
			}
		});
	}
}
