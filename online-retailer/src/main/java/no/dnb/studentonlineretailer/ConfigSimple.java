package no.dnb.studentonlineretailer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSimple {

    @Bean
    public MyVatBean my25VatBean() {
        MyVatBean vatBean = new MyVatBean();
        vatBean.setVatPercentage(25);
        return vatBean;
    }

    @Bean
    public MyVatBean my27VatBean() {
        MyVatBean vatBean = new MyVatBean();
        vatBean.setVatPercentage(27);
        return vatBean;
    }

    @Bean
    public MyVatBean my50VatBean() {
        MyVatBean vatBean = new MyVatBean();
        vatBean.setVatPercentage(50);
        return vatBean;
    }

}
