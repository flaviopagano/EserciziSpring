package co.develhope.logging.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BasicService {

    @Value("${customEnvs.n1}")
    private int n1;

    @Value("${customEnvs.n2}")
    private int n2;


    Logger logger = LoggerFactory.getLogger(BasicService.class);


    public Double getExponent() {
        logger.info("Starting power calculation...");
        Double result = Math.pow(n1, n2);
        logger.info("Finished power calculation. Result: {}", result);
        return result;
    }


}