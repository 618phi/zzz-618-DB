package notes2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.List;

@SuppressWarnings("serial")
public class Bbutts extends C1butts2 {

	public static void buttons() {
		moreButts();
		moreButts2();
		goBut();
		evenMoreButts();

		// DBs button
		getBut1().get(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				setBases();
				try {
					tables("DATABASES");
					getList().get(1).setText("");
					getList().get(1).setText(
							"\n\n\n\n\n        *************************\n          Enter Database Name\n          Or Click Create\n"
									+ "          To Create A New Database\n        *************************\n");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				bool();
				table = false;
			}
		});

		// Tables button
		getBut1().get(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (testIt("TABLES")) {
					try {
						tables("TABLES");
						sound("bounce.wav");
						setGo(Color.blue);
						bool();
						ok = true;
						getList3().get(0).append("Select A Table From Database " + getMyDb() + "\n");
						getList3().get(0).append("          *************************************************\n");
					} catch (Exception e1) {
						getList3().get(0).append("Get Tables Problem!\n" + e1);
					}

				}
			}
		});

		// Where button
		getBut1().get(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getList().get(1).getText().contains("SELECT")) {
					boolean go = true;
					jText(getList().get(1));
					try {
						List<String> lines = lines(true, 1);
						for (String s : lines) {
							if (s.contains("WHERE")) {
								go = false;
							}
						}
						if (go) {
							sound("bounce.wav");
							getList().get(1).setText("");
							for (String s : lines) {
								System.out.println(s);
								if (s.contains("FROM")) {
									System.out.println("WHERE column ><= value");
								}
							}
						}
					} catch (Exception e1) {
						System.out.println("Where Problem!!!!!!\n" + e1);
					}
				}
			}
		});

		// And button
		getBut1().get(3).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = "AND column ><= value";
				add("AND", "WHERE", s);
			}
		});

		// Or button
		getBut1().get(4).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = "OR column ><= value";
				add("OR", "WHERE", s);
			}
		});

		// Order button
		getBut1().get(5).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getList().get(1).getText().contains("SELECT")) {
					boolean go = true;
					boolean go1 = true;
					jText(getList().get(1));
					int count = 0;
					int count1 = 0;
					try {
						List<String> lines = lines(true, 1);
						for (String s : lines) {
							if (s.contains("ORDER")) {
								go = false;
							}
							if (s.contains("LIMIT")) {
								count1 = count;
								go1 = false;

							}
							count++;
						}
						if (go && !go1) {
							sound("bounce.wav");
							getList().get(1).setText("");
							for (String s : lines) {
								System.out.println(s);
								if (s == lines.get(count1 - 1)) {
									System.out.println("ORDER BY column DESC / ASC");
								}
							}
						}
						if (go && go1) {
							sound("bounce.wav");
							getList().get(1).setText("");
							for (String s : lines) {
								System.out.println(s);
								if (s == lines.get(count - 2)) {
									System.out.println("ORDER BY column DESC / ASC");
								}
							}
						}
					} catch (Exception e1) {
						System.out.println("Order Problem!!!!!!\n" + e1);
					}
				}
			}
		});

		// ENTER button
		getBut1().get(6).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getList().get(1).getText().contains("SELECT")) {
					sound("bounce.wav");
					jText(getList3().get(0));
					try {
						qInput("CREATE TABLE " + getMyDb() + ".xtempz LIKE " + getMyDb() + "." + getSss() + ";", false);
						qInput("INSERT INTO " + getMyDb() + ".xtempz " + "SELECT * FROM " + getMyDb() + "." + getSss()
								+ ";", false);
						ResultSet ults = set("DESCRIBE " + getSss() + ";");
						while (ults.next()) {
							if (!getList().get(1).getText().contains(ults.getString(1))) {
								qInput("ALTER TABLE xtempz DROP COLUMN " + ults.getString(1) + ";", false);
							}
						}
						showTab("xtempz", getList().get(1).getText());
						qInput("DROP TABLE xtempz;", false);
						System.out.println("          *************************************************");
					} catch (Exception e1) {
						System.out.println("Enter Problem!!!!!!\n" + e1);
						System.out.println("          *************************************************");
						try {
							qInput("DROP TABLE xtempz;", false);
						} catch (Exception e2) {
						}
					}
				}
			}
		});

		// Save
		getBut2().get(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				setIt("Save", Color.cyan);
				saveFiles("savedfiles", 11, "Select");
				bool();
				unget = true;

			}
		});

		// Get
		getBut2().get(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				getList3().get(0).append(
						"To compare current work : Use RtoL before hitting Get\n          *************************************************\n");
				setIt("Get", Color.orange);
				saveFiles("savedfiles", 11, "Select");
				bool();
				unmove = true;
			}
		});

		// Delete
		getBut2().get(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				setIt("Delete", Color.red);
				saveFiles("savedfiles", 11, "Select");
				bool();
			}
		});

		// RtoL
		getBut2().get(3).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jText(getList3().get(0));
				sound("bounce.wav");
				getList().get(0).setText(getList().get(1).getText());
				System.out.println("Right Textfeild Copied to Left Textfeild");
				System.out.println("          *************************************************");
			}
		});

		// Clear button
		getBut2().get(4).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				getList3().get(0).setText("");
			}
		});

		// Create button
		getBut2().get(5).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createMode();
			}
		});

		// Update button
		getBut2().get(6).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMode();
			}
		});

		// SET button
		getBut2().get(7).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				bool();
				set = false;
				try {
					settings();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				setSettings("Enter Settings", "Enter", Color.green);
			}
		});
	}
}
