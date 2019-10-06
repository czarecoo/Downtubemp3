package downtubemp3;

import java.io.IOException;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;

public class YoutubeVideoIdFetcher {
	private static final String GOOGLE_API_SEARCH_URL = "https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=1&order=rating&q=";
	private static final String KEY = "&key=";
	private static final String GOOGLE_API_KEY = "AIzaSyC3oaWWtycObuHAiPWqQQ8PC013mwS4fv8";
	
	static String findYoutubeVideoId(String keyword) throws IOException {
		keyword = keyword.replace(" ", "+");
		String url = GOOGLE_API_SEARCH_URL + keyword + KEY + GOOGLE_API_KEY;
		String mime = buildMime(url);
		String getJson = getJson(url, mime);
		JSONObject jsonObject = (JSONObject) new JSONTokener(getJson).nextValue();
		return jsonObject.getJSONArray("items").getJSONObject(0).getJSONObject("id").getString("videoId");
	}

	private static String getJson(String url, String mime) throws IOException {
		Document doc = Jsoup.connect(url).header("Content-Type", mime).ignoreContentType(true).get();
		String getJson = doc.text();
		return getJson;
	}

	private static String buildMime(String url) {
		UnsupportedMimeTypeException mimeType = new UnsupportedMimeTypeException("Hey this is Mime", "application/xml",
				url);
		return mimeType.getMimeType();
	}
}
