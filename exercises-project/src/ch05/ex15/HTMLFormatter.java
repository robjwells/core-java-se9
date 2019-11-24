package ch05.ex15;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class HTMLFormatter extends XMLFormatter {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger("ch05.ex15");
        FileHandler handler = new FileHandler("%h/Desktop/JavaLog%g.html");
        handler.setFormatter(new HTMLFormatter());
        logger.addHandler(handler);
        logger.info("Here’s a log message!");
    }

    @Override
    public String getHead(Handler h) {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("    <meta charset=\"UTF-8\">\n")
                .append("    <title>This is a Java log!</title>\n")
                .append("</head>\n")
                .append("<body>\n");
        return sb.toString();
    }

    @Override
    public String getTail(Handler h) {
        return "</body>\n</html>\n";
    }
}
