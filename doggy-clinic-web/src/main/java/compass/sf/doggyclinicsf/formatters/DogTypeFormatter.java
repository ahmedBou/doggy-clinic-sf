package compass.sf.doggyclinicsf.formatters;

import compass.sf.doggyclinicsf.model.DoggyType;
import compass.sf.doggyclinicsf.service.DoggyTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
public class DogTypeFormatter implements Formatter<DoggyType> {

    private final DoggyTypeService doggyTypeService;

    public DogTypeFormatter(DoggyTypeService doggyTypeService) {
        this.doggyTypeService = doggyTypeService;
    }

    @Override
    public DoggyType parse(String s, Locale locale) throws ParseException {
        Collection<DoggyType> findDogTypes = doggyTypeService.findAll();

        for(DoggyType type : findDogTypes){

                return type;

        }
        throw new ParseException("type not found: ", 0);
    }

    @Override
    public String print(DoggyType doggyType, Locale locale) {
        return doggyType.getNames();
    }
}
