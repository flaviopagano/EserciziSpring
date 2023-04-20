package co.develhope.redisCache.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfiguration {
    /**
     * prendere i valori dal file YAML usando @Value
     */
    @Value("${redis.host}")
    private String redisHost;

    @Value("${redis.port}")
    private int redisPort;

    @Value("${redis.password}")
    private String redisPassword;

    @Value("${redis.database}")
    private String redisDatabase;

    /**
     *  Tutti i dati di connessione al DATABASE redis
     *  setta l'host, port, password, e database
     *  JedisConnectionFactory, una classe di Spring Data Redis
     *  che  permette la connessione al server Redis
     *  */
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisHost, redisPort);
        redisStandaloneConfiguration.setPassword(RedisPassword.of(redisPassword));
        redisStandaloneConfiguration.setDatabase(0); // i database partono dal numero 0
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    /**
     *  redisTemplate è un metodo per effettuare le operazioni
     *  CRUD sul database Redis, e si assicura che la giusta
     *  connessione venga utilizzata per accedere al database
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }


}
