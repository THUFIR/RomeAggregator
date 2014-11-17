package romereader;

import com.rometools.rome.io.FeedException;
import dur.bounceme.net.rome.jpa.LinkJpaController;
import dur.bounceme.net.rome.jpa.PageJpaController;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProcessLinks {

    private final static Logger log = Logger.getLogger(ProcessLinks.class.getName());
    private LinkJpaController linksController = null;
    private PageJpaController pagesController = null;

    public void getPages() throws IOException, MalformedURLException, IllegalArgumentException, FeedException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("RomeReaderPU");
        linksController = new LinkJpaController(emf);
        linksController.findLinkEntities();
    }
}
