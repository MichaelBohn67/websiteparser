package de.bohnottensen.websiteparser;

import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
class CountryFlagService {
    CountryFlagService() {
    }

    static String getCountryFromFlag(Elements bankFlag) {
        String land;
        if (bankFlag.toString().contains("flag-de")) land = "Deutschland";
        else if (bankFlag.toString().contains("flag-nl")) land = "Niederlande";
        else if (bankFlag.toString().contains("flag-fr")) land = "Frankreich";
        else if (bankFlag.toString().contains("flag-at")) land = "Österreich";
        else if (bankFlag.toString().contains("flag-ro")) land = "Rumänien";
        else if (bankFlag.toString().contains("flag-hr")) land = "Ungarn";
        else if (bankFlag.toString().contains("flag-it")) land = "Italien";
        else if (bankFlag.toString().contains("flag-pt")) land = "Portugal";
        else if (bankFlag.toString().contains("flag-lv")) land = "Lettland";
        else if (bankFlag.toString().contains("flag-ee")) land = "Estland";
        else if (bankFlag.toString().contains("flag-se")) land = "Schweden";
        else if (bankFlag.toString().contains("flag-ch")) land = "Schweiz";
        else if (bankFlag.toString().contains("flag-mt")) land = "Malta";
        else if (bankFlag.toString().contains("flag-gr")) land = "Griechenland";
        else if (bankFlag.toString().contains("flag-no")) land = "Norwegen";
        else if (bankFlag.toString().contains("flag-cz")) land = "Tschechische Republik";
        else if (bankFlag.toString().contains("flag-cy")) land = "Republik Zypern";
        else if (bankFlag.toString().contains("flag-bg")) land = "Bulgarien";
        else if (bankFlag.toString().contains("flag-lu")) land = "Luxemburg";
        else if (bankFlag.toString().contains("flag-gb"))
            land = "Vereinigtes Königreich von Großbritannien und Nordirland";
        else if (bankFlag.toString().contains("flag-sk")) land = "Slowakei";
        else if (bankFlag.toString().contains("flag-lt")) land = "Litauen";
        else if (bankFlag.toString().contains("flag-pl")) land = "Polen";
        else if (bankFlag.toString().contains("flag-ie")) land = "Irland Republik";
        else {
            System.out.println(bankFlag);
            land = "Europa";
        }
        return land;
    }
}