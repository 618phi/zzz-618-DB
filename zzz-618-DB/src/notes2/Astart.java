package notes2;

import java.awt.Color;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Astart extends Bbutts{
	public static void start() throws Exception {
		setSss(getUrl());
		bool();
		select = true;
		frame(getFrame1(), Color.PINK, 10, box());
		if (!testIt("DATABASES")) {
			set = false;
			settings();
			setSettings("Enter Settings", "Enter", Color.green);
		} else {
			setBases();
			tables("DATABASES");
			table = false;
			getList().get(1).setText("");
			getList().get(1).setText(
					"\n\n\n\n\n        *************************\n          Enter Database Name\n          Or Click Create\n"
							+ "          To Create A New Database\n        *************************\n");
			ArrayList<String> list2 = new ArrayList<>();
			java.util.List<String> text = Files.readAllLines(Paths.get("files/set.txt"));
			for (String s : text) {
				if (s.contains("=")) {
					list2.add(index(s, "=", 1, true));
				}
			}
			setDriver(list2.get(0).trim());
			setUrl(list2.get(1).trim());
			setUsername(list2.get(2).trim());
			setPassword(list2.get(3).trim());
		}  
	}  
}

