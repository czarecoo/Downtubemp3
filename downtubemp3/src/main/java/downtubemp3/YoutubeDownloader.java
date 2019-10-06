package downtubemp3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class YoutubeDownloader {
	void downloadVideo(String videoUrl, String whereToSavePath) throws InterruptedException {
		Runtime runtime = Runtime.getRuntime();
		try {
			String cmd = "cmd /c start " + getFileFromResources("start.bat") +" " + videoUrl;
			Process p1 = runtime.exec(cmd);
			p1.waitFor();
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p1.getInputStream()));

			BufferedReader stdError = new BufferedReader(new InputStreamReader(p1.getErrorStream()));

			// Read the output from the command
			System.out.println("Here is the standard output of the command:\n");
			String s = null;
			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
			}

			// Read any errors from the attempted command
			System.out.println("Here is the standard error of the command (if any):\n");
			while ((s = stdError.readLine()) != null) {
				System.out.println(s);
			}
		} catch (IOException ioException) {
			System.out.println(ioException.getMessage());
		}
	}

	private File getFileFromResources(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		URL resource = classLoader.getResource(fileName);
		if (resource == null) {
			throw new IllegalArgumentException("file is not found!");
		} else {
			return new File(resource.getFile());
		}
	}
}
