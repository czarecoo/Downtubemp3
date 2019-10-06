package downtubemp3;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
		String keyword = "Mr. President - Coco Jamboo";
		String result = YoutubeVideoIdFetcher.findYoutubeVideoId(keyword);
		YoutubeDownloader ytdownloader = new YoutubeDownloader();
		ytdownloader.downloadVideo(result, "C:\\Users\\Ewa\\Desktop\\java");
	}
}