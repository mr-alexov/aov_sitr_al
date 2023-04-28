package config;

import org.aeonbits.owner.ConfigFactory;

public class OwnerWebConfigRunner implements WebConfigRunner {

    static DefaultWebConfig config = ConfigFactory.create(DefaultWebConfig.class, System.getProperties());

    @Override
    public void runWebConfig() {

    }
}
