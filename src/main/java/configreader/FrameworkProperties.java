package configreader;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:framework.properties")
public interface FrameworkProperties extends Config {

    @Key("driver.baseurl")
    String baseURL();

    @Key("driver.remote")
    boolean isRemote();

}
