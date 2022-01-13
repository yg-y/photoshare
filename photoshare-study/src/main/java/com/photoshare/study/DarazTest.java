package com.photoshare.study;

import com.lazada.lazop.api.LazopClient;
import com.lazada.lazop.api.LazopRequest;
import com.lazada.lazop.api.LazopResponse;
import com.lazada.lazop.util.ApiException;

/**
 * @author young
 * @version 1.0
 * @date 2021/12/6 11:15 上午
 * @description
 */
public class DarazTest {
    public static void main(String[] args) throws ApiException {
        LazopClient client = new LazopClient("https://api.daraz.com/rest", "500310", "YLgNUKEFvJQ6yarkwqft8i0uDhMnIAhY");
        LazopRequest request = new LazopRequest("/auth/token/create");
        request.addApiParameter("code", "4_500310_DOY65UsN8zJuECbl9w5MbrEY18");
        LazopResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
}
