package downtubemp3;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
		if (args.length != 2) {
			throw new RuntimeException("You need to provide 2 parameters: title and path where to save mp3 file");
		}
		String keyword = args[0];
		String whereToSavePath = args[1];
		String result = YoutubeVideoIdFetcher.findYoutubeVideoId(keyword);
		YoutubeDownloader ytdownloader = new YoutubeDownloader();
		ytdownloader.downloadVideo(result, whereToSavePath);
	}
}