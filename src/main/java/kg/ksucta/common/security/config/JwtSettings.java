package kg.ksucta.common.security.config;

import kg.ksucta.common.security.model.token.JwtToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "jwtsettings.properties")
@ConfigurationProperties
public class JwtSettings {
    /**
     * {@link JwtToken} will expire after this time.
     */
    @Value("${token.expiration.time}")
    private Integer tokenExpirationTime;

    /**
     * Token issuer.
     */
    @Value("${token.issuer}")
    private String tokenIssuer;
    
    /**
     * Key is used to sign {@link JwtToken}.
     */
    @Value("${token.sign.key}")
    private String tokenSigningKey;
    
    /**
     * {@link JwtToken} can be refreshed during this timeframe.
     */
    @Value("${token.refresh.exp.time}")
    private Integer refreshTokenExpTime;
    
    public Integer getRefreshTokenExpTime() {
        return refreshTokenExpTime;
    }

    public void setRefreshTokenExpTime(Integer refreshTokenExpTime) {
        this.refreshTokenExpTime = refreshTokenExpTime;
    }

    public Integer getTokenExpirationTime() {
        return tokenExpirationTime;
    }
    
    public void setTokenExpirationTime(Integer tokenExpirationTime) {
        this.tokenExpirationTime = tokenExpirationTime;
    }
    
    public String getTokenIssuer() {
        return tokenIssuer;
    }
    public void setTokenIssuer(String tokenIssuer) {
        this.tokenIssuer = tokenIssuer;
    }
    
    public String getTokenSigningKey() {
        return tokenSigningKey;
    }
    
    public void setTokenSigningKey(String tokenSigningKey) {
        this.tokenSigningKey = tokenSigningKey;
    }
}
