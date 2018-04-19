package at.refugeescode.encoderui.controller;

import at.refugeescode.encoderui.model.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Encoder {

    private RestTemplate restTemplate;

    @Value("${encoder.url}")
    private String encoderUrl;

    private String plainText;

    private String encodedMessage;

    public Encoder(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void encode(Message message) {
        plainText = message.getText();
        encodedMessage = restTemplate.postForObject(encoderUrl, plainText, String.class);
    }

    public String getEncodedMessage() {
        return encodedMessage;
    }

    public String getPlainText() {
        return plainText;
    }


}
