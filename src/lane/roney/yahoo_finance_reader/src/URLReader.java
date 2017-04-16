/*
 * URLReader.java 1.0 Jan 16, 2016
 *
 * Copyright (c) 2016 David J. Powell
 * Campus Box 2320, Elon University, Elon, NC 27244
 */
package lane.roney.yahoo_finance_reader.src;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class URLReader {

  private Document document;
  private Response csvLink;
  private final String OUTPUT_FOLDER = "/Users/rbmenke/Desktop/storeYahooData/";
  private File analysisFile;
  private String ticker;
  private String pageUrl;

  public URLReader(String tickerSymbol) {

    this.ticker = tickerSymbol;
    this.pageUrl = buildUrl();
  }

  /**
   * 
   * Connect to yahoo's server, find the link with the historical prices
   * download file, and then stream/write it to a file and return that file
   *
   * @return
   */
  public File grabData() {

    try {
      System.out.println("url: " + this.pageUrl);
      document = Jsoup.connect(this.pageUrl).get();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    Elements elements = document.select("a[download]");

    try {
      System.out.println("num els: " + elements.size() + " attr: " + elements.attr("href"));
      csvLink = Jsoup.connect(elements.attr("href")).timeout(60000).execute();
      analysisFile = writeFile(csvLink);

    } catch (IOException e) {

      e.printStackTrace();

    }

    // System.out.println(elements.attr("href"));
    return analysisFile;

  }

  private String buildUrl() {

    return "http://finance.yahoo.com/q/hp?s=" + this.ticker + "+Historical+Prices";
  }

  /**
   * 
   * Take the server's response as an argument and writes the byte data to a
   * file specified by the programmer in private final String OUTPUT_FILE
   *
   * @param res
   * @return
   * @throws IOException
   * @throws FileNotFoundException
   */
  private File writeFile(Response res) throws IOException, FileNotFoundException {

    File outfile = new File(OUTPUT_FOLDER + this.ticker + ".csv");
    FileOutputStream out = new FileOutputStream(outfile);
    try {
      out.write(res.bodyAsBytes());
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    out.close();
    return outfile;
  }
}
