package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalozationServiceTest {
    @Test
    public void ruLocaleTest(){
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        Country country = Country.RUSSIA;
        String expected = "Добро пожаловать";


        String preferences = localizationService.locale(country);

        Assertions.assertEquals(expected,preferences);
    }

    @Test
    public void enLocaleTest(){
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        Country country = Country.GERMANY;
        String expected = "Welcome";


        String preferences = localizationService.locale(country);

        Assertions.assertEquals(expected,preferences);
    }
}
