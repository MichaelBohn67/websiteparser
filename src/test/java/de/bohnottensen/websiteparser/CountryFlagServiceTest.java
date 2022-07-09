package de.bohnottensen.websiteparser;

import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CountryFlagServiceTest {

    private final CountryFlagService service = new CountryFlagService();
    private final Elements elementsMock = mock(Elements.class);

    @Test
    void givenFlagEngThenReturnStringEN() {
        when(elementsMock.toString()).thenReturn("flag-gb");
        String result = service.getCountryFromFlag(elementsMock);
        assertThat(result, is("Vereinigtes Königreich von Großbritannien und Nordirland"));

    }

    @Test
    void givenFlagDeuThenReturnStringDE() {
        when(elementsMock.toString()).thenReturn("flag-de");
        String result = service.getCountryFromFlag(elementsMock);
        assertThat(result, is("Deutschland"));

    }
}