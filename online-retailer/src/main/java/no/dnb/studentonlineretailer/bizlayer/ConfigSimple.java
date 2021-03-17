package no.dnb.studentonlineretailer.bizlayer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSimple {

    @Bean
    public VatSetup vatSetup() {
        VatSetup vatSetup = new VatSetup();
        vatSetup.addVatPolicy(new VatPolicy(0, 100, 25));
        vatSetup.addVatPolicy(new VatPolicy(101, 10000,27));
        vatSetup.addVatPolicy(new VatPolicy(10001, VatPolicy.NO_UPPER_LIMIT, 50));
        return vatSetup;
    }

}
