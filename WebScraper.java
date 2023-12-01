/*
 * Copyright(C) 2023 DeviceBlack
 *
 * Licensed under the Apache License, Version 2.0(the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	 http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dwrb.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.os.StrictMode;

/**
 * WebScraper class for scraping content from a web page.
 */
public class WebScraper {
	private String content;

	/**
	 * Constructor to initialize WebScraper with a specified URL.
	 *
	 * @param url The URL of the web page to be scraped.
	 */
	public WebScraper(String url) {
		try {
			// Permit all operations on the main thread (for educational purposes only, avoid in production)
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);

			URL urlObject = new URL(url);
			HttpURLConnection urlConnection = (HttpURLConnection) urlObject.openConnection();

			int responseCode = urlConnection.getResponseCode();

			if (responseCode == HttpURLConnection.HTTP_OK) {
				InputStream inputStream = urlConnection.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
				StringBuilder stringBuilder = new StringBuilder();

				String line;
				while ((line = reader.readLine()) != null) {
					stringBuilder.append(line);
				}

				content = stringBuilder.toString();
			} else {
				content = "(void)";
			}

			urlConnection.disconnect();
		} catch (IOException e) {
			// Handle exceptions appropriately (here we just print the stack trace)
			e.printStackTrace();
			content = "(void)";
		}
	}

	/**
	 * Get the content of the web page.
	 *
	 * @return The content of the web page.
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Find patterns in the content of the web page and return them as an array of Strings.
	 *
	 * @param patternStr The regular expression pattern to search for.
	 * @return An array of Strings containing the matched patterns.
	 */
	public String[] findWithPattern(String patternStr) {
		List<String> results = new ArrayList<>();
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(content);

		while (matcher.find()) {
			results.add(matcher.group());
		}

		return results.toArray(new String[0]);
	}
}

