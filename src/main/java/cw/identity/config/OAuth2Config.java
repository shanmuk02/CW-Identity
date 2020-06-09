package cw.identity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import cw.identity.mongo.config.MongoTokenStore;
import cw.identity.redis.config.CustomRedisTokenStore;

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
	
	@Value("#{new Integer('${token.timeout}')}") private int tokenTimeout;
	@Value("#{('${tokenstore.type}')}") private String tokenStoreType;
	private String clientId = "talk2amareswaran";
	private String clientSecret = "my-secret";
	private String privateKey = "123";

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MD5PasswordEncoder passwordEncoder;
	
	@Bean
	public JwtAccessTokenConverter tokenEnhancer() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(privateKey);
		return converter;
	}
	
	public TokenStore tokenStore() {
		if(tokenStoreType.equalsIgnoreCase("MONGO"))
			return new MongoTokenStore();
		else if(tokenStoreType.equalsIgnoreCase("REDIS"))
			return new CustomRedisTokenStore(new JedisConnectionFactory());
		else
			return new JwtTokenStore(tokenEnhancer());
    }
	
//	public JwtTokenStore tokenStore() {
//		return new JwtTokenStore(tokenEnhancer());
//	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
				.accessTokenConverter(tokenEnhancer());
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient(clientId).secret(passwordEncoder.encode(clientSecret))
			.scopes("read", "write").authorizedGrantTypes("password", "refresh_token")
			.accessTokenValiditySeconds(tokenTimeout*60).refreshTokenValiditySeconds(tokenTimeout*60);
	}
}
