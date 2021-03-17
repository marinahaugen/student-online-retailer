package no.dnb.studentonlineretailer.bizlayer;

import no.dnb.studentonlineretailer.bizlayer.MyVatBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSimple {

    @Bean
    public MyVatBean my25VatBean() {
        MyVatBean vatBean = new MyVatBean();
        vatBean.setVatPercentage(0.25);
        return vatBean;
    }

    @Bean
    public MyVatBean my27VatBean() {
        MyVatBean vatBean = new MyVatBean();
        vatBean.setVatPercentage(0.27);
        return vatBean;
    }

    @Bean
    public MyVatBean my50VatBean() {
        MyVatBean vatBean = new MyVatBean();
        vatBean.setVatPercentage(0.50);
        return vatBean;
    }

}
