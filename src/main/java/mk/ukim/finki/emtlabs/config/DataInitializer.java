package mk.ukim.finki.emtlabs.config;

import lombok.Getter;
import mk.ukim.finki.emtlabs.model.Author;
import mk.ukim.finki.emtlabs.model.Country;
import mk.ukim.finki.emtlabs.service.AuthorService;
import mk.ukim.finki.emtlabs.service.CountryService;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//ONLY IF USING H2 DATABASE

@Component
@Getter
public class DataInitializer {

    private final CountryService countryService;
    private final AuthorService authorService;

    public DataInitializer(CountryService countryService, AuthorService authorService) {
        this.countryService = countryService;
        this.authorService = authorService;
    }

    @PostConstruct
    public void init() throws Exception {
        this.countryService.save("Russia", "Europe");
        this.authorService.save("Lev Nikolaevich", "Tolstoy",1L);
    }
}
