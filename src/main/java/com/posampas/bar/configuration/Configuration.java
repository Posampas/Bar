package com.posampas.bar.configuration;

import com.posampas.bar.entities.BeverageEntity;
import com.posampas.bar.entities.BeverageEntityRepository;
import com.posampas.bar.entities.BillEntityRepository;
import com.posampas.bar.facade.*;
import com.posampas.bar.intefaces.IBarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@org.springframework.context.annotation.Configuration
public class Configuration {

    private static final Logger log = LoggerFactory.getLogger(Configuration.class);

    @Bean
    CommandLineRunner initDatabase(BeverageEntityRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new BeverageEntity("Wodka",new BigDecimal(20))));
            log.info("Preloading " + repository.save(new BeverageEntity("Piwo", new BigDecimal(5))));
        };
    }


   @Bean
   BarFacade offerFacade(BeverageEntityRepository repository, BillEntityRepository billRepository){
       IBarService barService = new BarService(
               new BarQuery(repository),
               new BillQuery(billRepository),
               new BillCommand(billRepository)
       );
       return new BarFacade(barService);
   }

}
