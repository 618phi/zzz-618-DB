package notes2;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@SuppressWarnings("serial")
public class Dinside extends E1inside2 {

	public static void getUcols() {
		jText(getList().get(0));
		getList().get(0).setText("");
		System.out.println("           " + getQuery() + " Columns");
		System.out.println("     *********************");
		try {
			printCols(getQuery(), 3);
		} catch (Exception e) {
			System.out.println("Problem Printing " + getQuery() + " Columns\n" + e + "\n");
		}
		System.out.println("     *********************");
	}

	public static void add(String s1, String s2, String s3) {
		boolean go = true;
		int count = 0;
		int count1 = 0;
		jText(getList().get(1));
		try {
			List<String> lines = lines(true, 1);
			getList().get(1).setText("");
			for (String s : lines) {
				if (s.contains(s1)) {
					go = false;
					count++;
				}
			}
			if (go) {
				for (String s : lines) {
					System.out.println(s);
					if (s.contains(s2)) {
						sound("bounce.wav");
						System.out.println(s3);
					}
				}
			} else {
				for (String s : lines) {
					System.out.println(s);
					if (s.contains(s1) && go == false) {
						count1++;
						if (count == count1) {
							sound("bounce.wav");
							System.out.println(s3);
							go = true;
						}
					}
				}
			}
		} catch (Exception e1) {
			System.out.println("cColumn Problem!!!!!!\n" + e1);
		}
	}

	public static void settings() throws Exception {
		String set = readFile("files/set.txt");
		getList().get(0)
				.setText("        ---------------------\n             Settings\n        ---------------------\n" + set);
		getList().get(1).setText(
				"        ---------------------\n        Change Settings\n        ---------------------\n" + set);
	}

	public static List<String> lines(boolean all, int num) throws Exception {
		boolean go = true;
		writeFile(getList().get(num).getText(), "files/temp.txt");
		List<String> lines = Files.readAllLines(Paths.get("files/temp.txt"), Charset.forName("UTF-8"));
		if (all == false) {
			lines.remove(0);
			for (int i = 0; i < lines.size(); i++) {
				if (!lines.get(i).contains(",")) {
					if (go) {
						i++;
						go = false;
					}
					lines.remove(i);
					i--;
				}
			}
		}
		return lines;
	}
}
