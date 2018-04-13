package at.refugeescode.encoder.endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping
public class EncoderEndpoint {

    @Value("${morse.url}")
    private String morseUrl;

    private RestTemplate restTemplate;

    public EncoderEndpoint(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/encode")
    String encode(@RequestBody String morseMessage) {
        String[] letters = morseMessage.split("");
        return Stream.of(letters)
                .map(letter -> restTemplate.postForObject(morseUrl, letter, String.class))
                .collect(Collectors.joining(" "));
    }


}
