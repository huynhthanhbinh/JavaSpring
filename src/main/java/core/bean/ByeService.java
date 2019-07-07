package core.bean;

import core.lang.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ByeService {

    @Autowired
    private Language language;


    public ByeService(Language language) {
        this.language = language;
    }

    public void sayBye() {
        language.log("Bye           : " + language.getBye());
    }
}
