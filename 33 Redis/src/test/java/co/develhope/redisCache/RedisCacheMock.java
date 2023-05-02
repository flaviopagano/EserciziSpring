package co.develhope.redisCache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@TestConfiguration
public class RedisCacheMock {

    private RedisServer redisServer;

    @Value("${redis.port}") int redisPort;

    /**
     * Dopo la costruzione creiamo un redis server
     * su redis port
     */
    @PostConstruct
    public void postConstruct() {
        try {
            redisServer = new RedisServer(redisPort);
            redisServer.start();
        }catch(Exception e){
            System.out.println(e);
            throw e;
        }
    }

    /**
     *  Prima di distruggerlo si deve fermarlo ( .stop() )
     */
    @PreDestroy
    public void preDestroy() {
        redisServer.stop();
    }
}
