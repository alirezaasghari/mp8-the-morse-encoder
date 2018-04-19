package at.refugeescode.encoderui.view;

import at.refugeescode.encoderui.controller.Encoder;
import at.refugeescode.encoderui.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    private Encoder encoder;

    public IndexController(Encoder encoder) {
        this.encoder = encoder;
    }

    @ModelAttribute("message")
    Message message() {
        return new Message();
    }

    @ModelAttribute("plain")
    String plain() {
        return encoder.getPlainText();
    }

    @ModelAttribute("encoded")
    String encoded() {
        return encoder.getEncodedMessage();
    }

    @GetMapping
    String page() {
        return "index";
    }

    @PostMapping
    String post(Message message) {
        encoder.encode(message);
        return "redirect:/";
    }
}
