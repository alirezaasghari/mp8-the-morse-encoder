package at.refugeescode.morse.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MorseCodes {

    @Value("#{'${morse.codes}'.split(' / ')}")
    private List<String> morseCodes;

    public List<String> getMorseCodes() {
        return new ArrayList<>(morseCodes);
    }
}
