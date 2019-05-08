package com.photoshare.paypal.config;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Young
 * @Description
 * @Date: 2019/5/8 0008 10:55
 */
@Configuration
public class PaypalConfig {

    private String clientId = "AZdn64lnLxsvQ-pjHcz6lZEMoBLV5YBTRQS51gAieitJd9Vi9RqUO_esNONZ55schDuvUHg3dFFRaCdx";
    private String clientSecret = "EKxfhu9OOQNng1_lQmR_OEr5c_VJnTFbeWh1cNBy7FJE8bAJRIk-A5gTf3DjQMChyqxLxS_BBRDUcU_7";
    private String mode="sandbox";

    @Bean
    public Map<String, String> paypalSdkConfig(){
        Map<String, String> sdkConfig = new HashMap<>();
        sdkConfig.put("mode", mode);
        return sdkConfig;
    }

    @Bean
    public OAuthTokenCredential authTokenCredential(){
        return new OAuthTokenCredential(clientId, clientSecret, paypalSdkConfig());
    }

    @Bean
    public APIContext apiContext() throws PayPalRESTException {
        APIContext apiContext = new APIContext(authTokenCredential().getAccessToken());
        apiContext.setConfigurationMap(paypalSdkConfig());
        return apiContext;
    }
}
