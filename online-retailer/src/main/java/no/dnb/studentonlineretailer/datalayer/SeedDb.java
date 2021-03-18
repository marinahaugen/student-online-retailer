package no.dnb.studentonlineretailer.datalayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SeedDb {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate.update("insert into PRODUCTS (name, price, instock) values (?, ?, ?)", new Object[]{"Book", 299, 20});
        jdbcTemplate.update("insert into PRODUCTS (name, price, instock) values (?, ?, ?)", new Object[]{"Game", 599, 30});
        jdbcTemplate.update("insert into PRODUCTS (name, price, instock) values (?, ?, ?)", new Object[]{"Butter", 39, 50});
        jdbcTemplate.update("insert into PRODUCTS (name, price, instock) values (?, ?, ?)", new Object[]{"Bread", 35, 60});
        jdbcTemplate.update("insert into PRODUCTS (name, price, instock) values (?, ?, ?)", new Object[]{"Yoghurt", 25, 40});
    }
}
