package stark.payment_service.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "razorpay")
public class RazorpayConfig {

    private String keyId;
    private String keySecret;
}
