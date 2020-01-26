package de.bohnottensen.websiteparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParserService {

    List<String> urlList = new ArrayList<>(3);
    public ParserService() throws IOException {
        urlList.add("https://www.kritische-anleger.de/festgeld-vergleich/1-jahr/");
        //urlList.add("https://www.kritische-anleger.de/festgeld-vergleich/2-jahre/");
        //urlList.add("https://www.kritische-anleger.de/festgeld-vergleich/3-jahre/");
    }

    public List<InterestRatesModel> parseSite () throws IOException {
        List<String> urlList = new ArrayList<>(3);
        urlList.add("https://www.kritische-anleger.de/festgeld-vergleich/1-jahr/");
        urlList.add("https://www.kritische-anleger.de/festgeld-vergleich/2-jahre/");
        urlList.add("https://www.kritische-anleger.de/festgeld-vergleich/3-jahre/");
        Integer years = 1;
        List<InterestRatesModel> interestRatesModelList = new ArrayList<>();
        for (String url : urlList) {

            Document doc = Jsoup.connect(url).userAgent("Mozilla").maxBodySize(0).get();
            int row = 1;
            //System.out.println(doc.getAllElements());

            for (Element element : doc.getElementsByClass("vla_outer_wrapper")) {
                InterestRatesModel interestRatesModel = new InterestRatesModel();
                String bankName = element.getElementsByClass("fgv_angebot_bank_name").text();
                interestRatesModel.setBankName(bankName);
                Elements country = element.getElementsByClass("fgv_angebot_flag");
                String minmax = element.getElementsByClass("vl_term_item_value").text();
                Double intRate = Double.valueOf(element.getElementsByClass("fgv_angebot_zinssatz").text()
                        .replace("%", "")
                        .replace("bis", "")
                        .replace(",", ".").strip());

                BigDecimal interestRate = BigDecimal.valueOf(intRate);
                interestRatesModel.setInterestPercent(interestRate.toPlainString());
                String land = getCountryFromFlag(country);
                interestRatesModel.setCountry(land);
                System.out.println(row + " " + bankName  + " - "+land+ " - " + minmax + " - " + interestRate.doubleValue() + " " + years);
                row++;
                interestRatesModelList.add(interestRatesModel);
            }

            years++;
        }
        return interestRatesModelList;
    }

    private String getCountryFromFlag(Elements bankFlag) {
        String land;
        if (bankFlag.toString().contains("flag-de")) {
            land = "Deutschland";
        } else if (bankFlag.toString().contains("flag-nl")) {
            land = "Niederlande";
        } else if (bankFlag.toString().contains("flag-fr")) {
            land = "Frankreich";
        } else if (bankFlag.toString().contains("flag-at")) {
            land = "Österreich";
        } else if (bankFlag.toString().contains("flag-ro")) {
            land = "Rumänien";
        } else if (bankFlag.toString().contains("flag-hr")) {
            land = "Ungarn";
        } else if (bankFlag.toString().contains("flag-it")) {
            land = "Italien";
        } else if (bankFlag.toString().contains("flag-pt")) {
            land = "Portugal";
        } else if (bankFlag.toString().contains("flag-lv")) {
            land = "Lettland";
        } else if (bankFlag.toString().contains("flag-ee")) {
            land = "Estland";
        } else if (bankFlag.toString().contains("flag-se")) {
            land = "Schweden";
        } else if (bankFlag.toString().contains("flag-ch")) {
            land = "Schweiz";
        } else if (bankFlag.toString().contains("flag-mt")) {
            land = "Malta";
        } else if (bankFlag.toString().contains("flag-gr")) {
            land = "Griechenland";
        } else if (bankFlag.toString().contains("flag-no")) {
            land = "Norwegen";
        } else if (bankFlag.toString().contains("flag-cz")) {
            land = "Tschechische Republik";
        } else if (bankFlag.toString().contains("flag-cy")) {
            land = "Republik Zypern";
        } else if (bankFlag.toString().contains("flag-bg")) {
            land = "Bulgarien";
        } else if (bankFlag.toString().contains("flag-lu")) {
            land = "Luxemburg";
        } else if (bankFlag.toString().contains("flag-gb")) {
            land = "Vereinigtes Königreich von Großbritannien und Nordirland";
        } else if (bankFlag.toString().contains("flag-sk")) {
            land = "Slowakei";
        } else if (bankFlag.toString().contains("flag-lt")) {
            land = "Litauen";
        } else if (bankFlag.toString().contains("flag-pl")) {
            land = "Polen";
        } else if (bankFlag.toString().contains("flag-ie")) {
            land = "Irland Republik";
        } else {
            System.out.println(bankFlag.toString());
            land = "Europa";
        }
        return land;
    }


    private void parseRow(Elements row) {
        System.out.println(row.size());

    }
}
