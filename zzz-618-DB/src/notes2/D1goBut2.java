package notes2;

import java.awt.Color;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.util.List;

@SuppressWarnings("serial")
public class D1goBut2 extends Dinside {

	public static void goUpdate() throws Exception {
		jText(getList3().get(0));
		if (delete) {
			if (get) {
				if (save) {
					if (execute) {
						if (ok) { // Select table
							if (!getField().getText().trim().isEmpty()) {
								setExecuted("Update");
								setQuery(getField().getText().trim());
								ResultSet results = set("SHOW TABLES;");
								while (results.next()) {
									if (results.getNString(1).equals(getQuery())) {
										getList3().get(0).append("Table " + getQuery() + " In Use"
												+ "\n          *************************************************\n");
										setSettings(getExecuted() + " " + getQuery(), "Execute", Color.CYAN);
										getList().get(1).setText("\nUPDATE " + getQuery()
												+ "\nSET\ncolumnName1 ><= value1\nWHERE\ncolumnName2 ><= value2\n;");
										getList3().get(0).append("Table " + getQuery() + " : Update Edit Ready\n");
										getList3().get(0).append(
												"          *************************************************\n");
										bool();
										unget = true;
										good = false;
										setCountC(colCount(getQuery()));
										getUcols();
										xxx = true;
									}
								}
								if (good) {
									getList3().get(0).append("Bad TABLE Name Entered!\n"
											+ "          *************************************************\n");
								}
							} else {
								getList3().get(0).append("No TABLE Name Entered!\n"
										+ "          *************************************************\n");
							}
						} else if (unget) { // Execute
							sound("bounce.wav");
							String check = "", ss = "TERMINATED BY";

							try {
								if (!getList().get(1).getText().contains(ss)) {
									String[] s = getList().get(1).getText().split("/");
									if (s.length > 1) {
										int count = 0;
										int count1 = 0;
										for (int i = 0; i < s.length; i += 2) {
											count1++;
											if (s[i].trim().equals(""))
												count++;
										}
										if (count == count1)
											check = " But,\nDid  /* and */ get correctly deleted?";
									}
									qInput(getList().get(1).getText(), false);
									getUcols();
								} else {
									set(getList().get(1).getText());
								}
								getList3().get(0).append(getExecuted() + " Execute Done" + check
										+ "\n         *************************************************\n");
							} catch (Exception e1) {
								getList3().get(0).append("Bad MySOL Input!\n" + e1
										+ "\n          *************************************************\n");
							}
						}
					}
				} else {
					save("savedfiles3", 12, "Update");
				}
			} else {
				bool();
				get("savedfiles3");
				unget = true;
			}
		} else {
			delete("savedfiles3", 12, "Update");
		}
	}

	public static void goCreate() throws Exception {
		jText(getList3().get(0));
		if (drop) {
			if (delete) {
				if (get) {
					if (save) {
						if (ok) { // Create database
							if (!getField().getText().trim().isEmpty()) {
								boolean db = true;
								String ss = ("CREATE DATABASE IF NOT EXISTS " + getField().getText().trim() + ";");
								try {
									ResultSet results = set("SHOW DATABASES;");
									while (results.next()) {
										if (results.getNString(1).trim().equals(getField().getText().trim()))
											db = false;
									}
									qInput(ss, false);
								} catch (Exception e1) {
									getList3().get(0).append(getField().getText().trim() + " Database NOT Created!\n"
											+ e1 + "\n          *************************************************\n");
									good = false;
								}
								if (good) {
									if (db) {
										List<String> text = Files.readAllLines(Paths.get("files/set.txt"),
												Charset.forName("UTF-8"));
										String s = index(text.get(1), "=", 1, true);
										String s1 = getField().getText().trim();
										setUrl(s.trim() + s1 + "?allowMultiQueries=true");	
										setMyDb(s1);
										tables("DATABASES");
										getList3().get(0).append(getField().getText().trim() + " : Database Created\n"
												+ "          *************************************************\n");
									} else {
										getList3().get(0).append(getField().getText().trim()
												+ " Database Already Exists\n"
												+ "          *************************************************\n");
									}
								}
							} else {
								getList3().get(0).append("No DATABASE Name Entered!\n"
										+ "          *************************************************\n");
							}
						} else if (unget) { // Start table
							setQuery(getField().getText().trim());
							while (true) {
								String make = "CREATE TABLE\n" + getQuery()
										+ "\n(  \nID INT(5) NOT NULL AUTO_INCREMENT,\n" + "PRIMARY KEY (ID)\n);";
								try {
									ResultSet results = set("SHOW TABLES;");
									while (results.next()) {
										if (results.getNString(1).trim().equals(getQuery()))
											good = false;
									}
									if (!good) {
										getList3().get(0).append(getQuery() + "Table Already Exists!\n"
												+ "          *************************************************\n");
										break;
									}
									qInput(make, false);
									qInput("DROP TABLE " + getQuery() + ";", false);
									getList().get(1).setText(make);
									setSettings("Create " + getQuery(), "Create", Color.lightGray);
									tables("TABLES");
									bool();
									unmove = true;

								} catch (Exception e) {
									if (good) {
										getList3().get(0).append("Bad Table Name!\n"
												+ "          *************************************************\n");
									}
									break;
								}
								break;
							}
						} else if (unmove) { // Create Table / Execute File
							try {
								if (force) { // Execute File
									qInput(getList().get(1).getText(), false);
									getList3().get(0).append(getExecuted() + " File Executed\n"
											+ "          *************************************************\n");
								} else { // Create table
									qInput(getList().get(1).getText(), false);
									getList3().get(0).append(getQuery() + " Table Created\n"
											+ "          *************************************************\n");
									tables("TABLES");
									setCreate("Enter Table Name ", "Start");
									bool();
									unget = true;
								}
							} catch (Exception e) {
								getList3().get(0).append("Bad SQL Input!\n" + e
										+ "\n          *************************************************\n");
							}
						} else { // Create trigger
							try {
								qInput(getList().get(1).getText().trim(), false);
								getList3().get(0).append(getQuery() + " Trigger Created\n"
										+ "          *************************************************\n");
								tables("TRIGGERS");
							} catch (Exception e) {
								getList3().get(0).append("Bad Trigger Input!\n" + e
										+ "\n          *************************************************\n");
							}
						}
					} else {
						save("savedfiles2", 12, "Create");
					}
				} else {
					bool();
					get("savedfiles2");
					unmove = true;
					force = true;
				}
			} else {
				delete("savedfiles2", 12, "Create");
			}
		} else { // Drop
			String name = "";
			if (getDoDrop() == 101) {
				try {
					ResultSet results = set("SHOW " + getQuery() + "S;");
					while (results.next()) {
						if (getList().get(1).getText().toLowerCase().trim().contains(results.getNString(1).trim())) {
							good = false;
							name = results.getNString(1).trim();
						}
					}
				} catch (Exception e1) {
					getList3().get(0).append("Show " + getQuery() + "S Problem!\n"
							+ "          *************************************************\n");
				}
				if (!good) {
					try {
						qInput(getList().get(1).getText().trim(), false);
						good = true;
						setDoDrop(0);
						if(testIt("Databases") == false){
							setUrl(getSss());
							setMyDb("null");
						}
						getList3().get(0).append(name + " " + getQuery() + " Has Been Dropped\n"
								+ "          *************************************************\n");
						drop();
					} catch (Exception e) {
						getList3().get(0).append("Bad MySQL Input!\n" + e
								+ "\n          *************************************************\n");
					}
				} else {
					getList3().get(0).append(getQuery() + " Name Not Available For Drop!\n"
							+ "          *************************************************\n");
				}
			} else {
				setQuery(getField().getText().trim());
				if (getQuery().equals("DATABASE") || getQuery().equals("TABLE") || getQuery().equals("TRIGGER")) {
					setSettings("EXECUTE", "DROP!", Color.red);
					tables(getQuery() + "S");
					getList().get(1).setText("\n\n\nDROP \n     " + getQuery() + " \n           "
							+ getQuery().toLowerCase() + "Name\n;");
					getList3().get(0).append("Replace " + getQuery().toLowerCase() + "Name For PERMANENT DELETION!!!\n"
							+ "          *************************************************\n");
					setDoDrop(101);
				} else {
					getList3().get(0).append("One Of DATABASE / TABLE / TRIGGER Must Be Entered!\n"
							+ "          *************************************************\n");
				}
			}
		}
	}

	public static void goSelect() throws Exception {
		if (ok) {
			if (!getField().getText().trim().isEmpty()) {
				setSss(getField().getText().trim());
				ResultSet results = set("SHOW TABLES;");
				while (results.next()) {
					if (results.getNString(1).equals(getSss())) {
						good = false;
						setSss(getField().getText().trim());
						jText(getList().get(1));
						getList().get(1).setText("");
						System.out.println("SELECT ");
						setCountC(colCount(getSss()));
						int num = getCountC();
						ResultSet ults = set("DESCRIBE " + getSss() + ";");
						while (ults.next()) {
							if (num > 1)
								System.out.println(ults.getNString(1) + ",");
							else
								System.out.print(ults.getNString(1));
							num--;
						}
						ults.beforeFirst();
						System.out.println("\nFROM " + getSss() + "\nLIMIT 999 \n;");
						getList3().get(0).append("Table " + getSss() + " In Use\n"
								+ "          *************************************************\n");
						getList().get(0)
								.setText("            " + getSss() + " Columns\n" + "     *********************\n");
						while (ults.next()) {
							getList().get(0).append(ults.getNString(1) + "  " + ults.getNString(2) + "\n");
						}
						getList().get(0).append("     *********************\n");
					}
				}
				if (good) {
					getList3().get(0).append("Bad TABLE Name Entered!\n"
							+ "          *************************************************\n");
				}
			} else {
				getList3().get(0).append(
						"No TABLE Name Entered!\n" + "          *************************************************\n");
			}
		} else if (unget) {
			save("savedfiles", 11, "Select");
		} else if (unmove) {
			stay = false;
			get("savedfiles");
		} else { // delete
			delete("savedfiles", 11, "Select");
		}
	}
}
