package at.refugeescode.morse.endpoint;

import at.refugeescode.morse.logic.AlphabetLetters;
import at.refugeescode.morse.logic.MorseCodes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class MorseEndpoint {

    private AlphabetLetters alphabetLetters;

    private MorseCodes morseCodes;

    public MorseEndpoint(AlphabetLetters alphabetLetters, MorseCodes morseCodes) {
        this.alphabetLetters = alphabetLetters;
        this.morseCodes = morseCodes;
    }

    @PostMapping("/morse")
    String encode(@RequestBody String letter) {
        if (!Character.isAlphabetic(letter.charAt(0))
                && !Character.isDigit(letter.charAt(0))) {
            return " ";
        }
        return convertToMorseCode(letter);
    }

    private String convertToMorseCode(@RequestBody String letter) {
        List<String> letters = alphabetLetters.getLetters();
        List<String> morseCode = morseCodes.getMorseCodes();
        return morseCode.get(letters.indexOf(letter.toLowerCase()));
    }
}
