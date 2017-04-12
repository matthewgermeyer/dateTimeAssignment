package com.example;
/*

Write clock
 in infinite loop while (0 == 0){  e.g.
 sout ( LocalTime.now());

Thread.sleep to sleep for (900L)

 use StringUtils.leftPad to pad make sure the minutes and seconds are always two digits
  (left pad with 0 if one digit). e.g. Left pad with 0 (to 2 values) to ensure that 12:05:04 (h:m:s)  does not print as 12:5:4

Write the output of the following html file. The meta refresh will refresh the page.
Replace the hh, mm and ss with hour, minutes and seconds respectively.

Open clock.html in a browser
 */

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalTime;

public class Main {
    private static final String CLOCK_HTML = "<html>\n" +
            "<head>\n" +
            "    <title>Clock</title>\n" +
            "    <meta http-equiv=\"refresh\" content=\"0.9\">\n" +
            "</head>\n" +
            "<body>\n" +
            "    <br><br><br>\n" +
            "    <div align=\"center\"><span style=\"font-size:48\">hh:mm:ss</span></div>\n" +
            "</body>\n" +
            "</html>\n" +
            "</html>\n";

    private static final Path CLOCK_PATH = Paths.get("./clock.html");
    private static final Charset US_ASCII = Charset.forName("US-ASCII");

    public static void main(String[] args) throws InterruptedException {

        while (true) {
            String timeNow = LocalTime.now().toString();
            int dotSpot = timeNow.indexOf('.');
            String everythingBut = timeNow.substring(0, dotSpot);

            System.out.println("Time is --->   " + everythingBut);
            //sleep for 500 ms after each time print statement.
            Thread.sleep(500L);

            System.out.println("sleeping zzz   (0.5s)\n");
            String newClockHtml = CLOCK_HTML.replace("hh:mm:ss", everythingBut);

            System.out.println(newClockHtml);

            try (BufferedWriter writer = Files.newBufferedWriter(CLOCK_PATH, US_ASCII, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
                writer.write("" + newClockHtml);
                writer.flush();
            } catch (IOException e) {
                System.out.printf("ERROR: %s%n", e);
            }
        }
    }
}





