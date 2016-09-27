
package org.ssa.ironyard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BenchmarkStarter 
{
    static Logger LOGGER = LogManager.getLogger(BenchmarkStarter.class);

    public static void main(String[] args)
    {
        LOGGER.info("Starting application Benchmark");
        SpringApplication.run(BenchmarkStarter.class, args);
    }
}