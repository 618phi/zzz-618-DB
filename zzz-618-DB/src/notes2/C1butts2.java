package notes2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class C1butts2 extends C2butts3 {

	public static void moreButts() {

		// cDatabase button
		getBut3().get(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				setCreate("Enter Database Name", "Create");
				getList().get(1).setText("");
				try {
					tables("DATABASES");
				} catch (Exception e1) {
					System.out.println("Get Tables Problem!\nAre Databases Set!\n" + e1);
				}
				setDoDrop(0);
				bool();
				ok = true;
				getList().get(1)
						.setText("\n\n\n\n\n      ***********************\n"
								+ "          To Create Database\n          Enter Database Name\n"
								+ "           In The TextField\n      ***********************\n");
				getList3().get(0).append("Enter databaseName In The TextField\n");
				getList3().get(0).append("          *************************************************\n");
			}
		});

		// cTable button
		getBut3().get(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				setCreate("Enter Table Name ", "Start");
				setDoDrop(0);
				bool();
				unget = true;
				
				getList().get(1)
						.setText("\n\n\n\n\n        ***********************\n" + "          Table Will Be Created\n"
								+ "          In Database " + getMyDb() + "\n          To Change Database\n"
								+ "          Use Select Mode\n        ***********************\n");
				getList3().get(0).append("Create A Table For Database " + getMyDb() + "\n");
				getList3().get(0).append("          *************************************************\n");
				try {
					tables("TABLES");
				} catch (Exception e1) {
					getList().get(1).setText("Problem Getting Tables!\n" + e1);
				}
			}
		});

		// cColumn button
		getBut3().get(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getList().get(1).getText().contains("CREATE TABLE")) {
					String ss = "columnName INT(5) NOT NULL ,";
					add(",", "(  ", ss);
					getList().get(0).setText(
							"            ---------------------\n               Main Types\n            ---------------------\n"
									+ "INT(size)\nTINYINT(size)\nBIGINT(size)\nDECIMAL(size,d)\nDOUBLE(size,d)\nFLOAT(size,d)"
									+ "\nVARCHAR(size)\nCHAR(size)\nBLOB\nLONGBLOB\nENUM(x,y,z,etc.)\nBOOLEAN\nDATE\nDATETIME\n"
									+ "TIMESTAMP\nTIME\nYEAR\n ");

					getList3().get(0).append("A New Column Is Edit Ready\n");
					getList3().get(0).append("          *************************************************\n");
				}
			}
		});

		// cTrigger button
		getBut3().get(3).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				setSettings("Create Trigger", "Create", Color.lightGray);
				setDoDrop(0);
				bool();
				getList().get(1).setText("CREATE TRIGGER\ntriggerName\nBEFORE INSERT ON \ndatabaseName.tableName\n"
						+ "FOR EACH ROW BEGIN\n" + "IF\nNEW.columnName1 =\n someValue1 \nTHEN\n"
						+ "SET NEW.columnName2 =\n someValue2 ;\n" + "ELSEIF\nNEW.columnName1 =\n anotherValue\nTHEN\n"
						+ "SET NEW.columnName2 =\n someValue3 ;\nEND IF ;\nEND ;\n");
				try {
					tables("TRIGGERS");
				} catch (Exception e1) {
					System.out.println("Problem Showing Triggers\n" + e1);
				}
				getList3().get(0).append("createTrigger Is Edit Ready\n");
				getList3().get(0).append("          *************************************************\n");
			}
		});

		// cSave
		getBut4().get(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				setIt("Save", Color.cyan);
				saveFiles("savedfiles2", 12, "Create");
				setDoDrop(0);
				bool();
				save = false;
			}
		});

		// cGet
		getBut4().get(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				getList3().get(0).append(
						"To compare current work : Use RtoL before hitting Get\n          *************************************************\n");
				setIt("Get", Color.orange);
				saveFiles("savedfiles2", 12, "Create");
				setDoDrop(0);
				bool();
				get = false;
			}
		});

		// cDelete button
		getBut4().get(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				setIt("Delete", Color.red);
				saveFiles("savedfiles2", 12, "Create");
				setDoDrop(0);
				bool();
				delete = false;
			}
		});

		// cRtoL
		getBut4().get(3).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jText(getList3().get(0));
				sound("bounce.wav");
				getList().get(0).setText(getList().get(1).getText());
				System.out.println("Right Textfeild Copied to Left Textfeild");
				System.out.println("          *************************************************");
			}
		});

		// cClear button
		getBut4().get(4).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				getList3().get(0).setText("");
			}
		});

		// cSelect button
		getBut4().get(5).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectMode();
			}
		});

		// cUpdate button
		getBut4().get(6).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMode();
			}
		});

		// cDrop button
		getBut4().get(7).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound("bounce.wav");
				drop();
				setDoDrop(0);
				getList3().get(0).append(
						"IF DROP EXECUTED DATABASE / TABLE / TRIGGER\n          " + "WILL BE PERMANENTLY LOST!!!\n");
				getList3().get(0).append("          *************************************************\n");
			}
		});
	}
}
