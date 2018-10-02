package utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Utils {

    public Utils(){
        Logger log = initLogger();
    }

    public Logger initLogger(){
        DOMConfigurator.configure("./log4j.xml");
        return Logger.getLogger("fileLogger");
    }
}
