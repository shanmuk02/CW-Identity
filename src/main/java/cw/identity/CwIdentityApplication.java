package cw.identity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import cw.identity.config.CWIdentity;

@SpringBootApplication
@EnableAuthorizationServer
public class CwIdentityApplication {
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<String, String> redisTemplate() {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		CWIdentity.setRedisTemplate(redisTemplate);
		return redisTemplate;
 	}

	public static void main(String[] args) {
		SpringApplication.run(CwIdentityApplication.class, args);
	}

}
