package at.refugeescode.morse.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlphabetLetters {

    @Value("#{'${alphabet.letters}'.split(' ')}")
    private List<String> alphabetletters;

    public List<String> getLetters() {
        return new ArrayList<>(alphabetletters);
    }
}
