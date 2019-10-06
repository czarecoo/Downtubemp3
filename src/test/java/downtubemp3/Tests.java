package downtubemp3;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class Tests {
	@Test
	public void fetchedResultVideIdShouldBeTheSameAsFirstForManyRetries() throws IOException {
		String keyword = "pewdiepie";

		String result = YoutubeVideoIdFetcher.findYoutubeVideoId(keyword);

		for (int i = 0; i < 50; i++) {
			Assert.assertEquals("Result should be the same after many retries", result,
					YoutubeVideoIdFetcher.findYoutubeVideoId(keyword));
		}
	}
}
