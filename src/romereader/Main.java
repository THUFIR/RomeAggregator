package romereader;

import com.rometools.rome.io.FeedException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private final static Logger log = Logger.getLogger(Main.class.getName());
    private final ProcessFeeds feeds = new ProcessFeeds();
    private final ProcessLinks links = new ProcessLinks();

    public static void main(String... args) {
        new Main().getLinks();
    }

    private void getLinks() {
        try {
            feeds.getFeeds();
        } catch (IOException | IllegalArgumentException | FeedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        log.info("completed:  all feeds processed");
    }
}
