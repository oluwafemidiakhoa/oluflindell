package lottery.backend.server;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

import org.springframework.stereotype.Component;

@Component
public class ServletContainerCustomizer implements EmbeddedServletContainerCustomizer {

    @Override
    public void customize(final ConfigurableEmbeddedServletContainer container) {
    	//Backend will run in port 8090
        container.setPort(8090);
    }
}
