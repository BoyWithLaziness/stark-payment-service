package stark.payment_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import stark.payment_service.dto.RazorpayCreatePaymentRequest;
import stark.payment_service.dto.RazorpayCreatePaymentResponse;

@Service
public class RazorpayClient {

    private RestClient restClient = RestClient.create();
    

    public RazorpayCreatePaymentResponse createRazorpayPayment(RazorpayCreatePaymentRequest payload, String authKey) {
        System.out.println("======>>>>>>Entered createRazorpayPayment ");
            String url = "https://api.razorpay.com/v1/orders";

            RazorpayCreatePaymentResponse response = (RazorpayCreatePaymentResponse) restClient.post()
                                                    .uri(url)
                                                    .body(payload)
                                                    .header("Authorization", "Basic"+" "+ authKey)
                                                    .retrieve()
                                                    .body(RazorpayCreatePaymentResponse.class);
                                                    
            System.out.println("======>>>>>>Razorpay response ");
            System.out.println(response);
            return response;
    }
}
