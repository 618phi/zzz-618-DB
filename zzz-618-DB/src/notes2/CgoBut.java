package notes2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class CgoBut extends D1goBut2 {

	public static void goBut() {
		// GO button
		getGo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				good = true;
				try {
					if (table) {
						if (unsave) {
							if (set) {
								if (select) {
									goSelect();
								} else if (create) {
									goCreate();
								} else if (update) {
									goUpdate();
								}
							} else { // change settings
								jText(getList3().get(0));
								ArrayList<String> list = new ArrayList<>();
								ArrayList<String> list2 = new ArrayList<>();
								writeFile(getList().get(1).getText(), "files/temp.txt");
								List<String> text = Files.readAllLines(Paths.get("files/temp.txt"),
										Charset.forName("UTF-8"));
								for (String s : text) {
									if (s.contains("=")) {
										list.add(s);
										list2.add(index(s, "=", 1, true));
									}
								}
								setDriver(list2.get(0).trim());
								setUrl(list2.get(1).trim());
								setUsername(list2.get(2).trim());
								setPassword(list2.get(3).trim());
								try {
									set("SHOW Tables");
									good = false;
									getList3().get(0).append("Set A Database Later!\n"
											+ "          *************************************************\n");
								} catch (Exception e1) {
								}
								if (good) {
									try {
										set("SHOW DATABASES");
									} catch (Exception e1) {
										getList3().get(0).append("BAD SETTINGS INPUT!\n"
												+ "          *************************************************\n");
										good = false;
									}
									if (good) {
										for (String ss : list)
											getList3().get(0).append(ss + "\n");
										getList3().get(0).append("SETTINGS GOOD\n"
												+ "          *************************************************\n");
										setSettings("Save Settings", "Save", Color.green);
										bool();
										unsave = false;
									}
								}
							}
						} else { // Save Settings
							getList().get(1).setText("");
							String sub = sub(getList3().get(0).getText(), "driver", "SETTINGS GOOD", 0, 0);
							writeFile(sub, "files/set.txt");
							setBases();
							tables("DATABASES");
							bool();
							table = false;
							getList().get(1).setText("");
							getList().get(1).setText("");
							getList().get(1).setText(
									"\n\n\n\n\n        *************************\n          Enter Database Name\n          Or Click Create\n"
											+ "          To Create A New Database\n        *************************\n");
						}
					} else { // Database
						jText(getList3().get(0));
						List<String> text = Files.readAllLines(Paths.get("files/set.txt"), Charset.forName("UTF-8"));
						String s = index(text.get(1), "=", 1, true);
						setSss(getUrl());
						String ss = getField().getText().trim();
						setUrl(s.trim() + ss + "?allowMultiQueries=true");
						if (testIt("TABLES")) {
							setMyDb(ss);
							getList3().get(0).append("Database " + ss + " In Use\n"
									+ "          *************************************************\n");
						} else {
							setUrl(getSss().trim());
							getList3().get(0).append(" BAD DATABASE INPUT!\n"
									+ "          *************************************************\n");

						}
					}
				} catch (Exception e1) {
				}
				getField().setText("");
			}
		});
	}
}
