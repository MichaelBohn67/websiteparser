package de.bohnottensen.websiteparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParserService {

    private final List<String> urlList = new ArrayList<>(3);
    private final InterestRatesModelService interestRatesModelService;

    public ParserService(InterestRatesModelService interestRatesModelService) {
        this.interestRatesModelService = interestRatesModelService;
        urlList.add("https://www.kritische-anleger.de/festgeld-vergleich/1-jahr/");
        urlList.add("https://www.kritische-anleger.de/festgeld-vergleich/2-jahre/");
        urlList.add("https://www.kritische-anleger.de/festgeld-vergleich/3-jahre/");
    }

    private static void parseRow(Elements row) {
        System.out.println(row.size());

    }

    List<InterestRatesModel> parseSite() throws IOException {
        int years = 1;
        List<InterestRatesModel> interestRatesModelList = new ArrayList<>();
        for (String url : urlList) {
            String terms = "1";
            if (url.contains("2-jahre")) terms = "2";
            if (url.contains("3-jahre")) terms = "3";
            Document doc = Jsoup.connect(url).userAgent("Mozilla").maxBodySize(0).get();
            int row = 1;
            for (Element element : doc.getElementsByClass("vla_outer_wrapper")) {
                InterestRatesModel interestRatesModel = InterestRatesModelService.createInterestRateModel(element, terms);
                row++;
                interestRatesModelList.add(interestRatesModel);
            }

            years++;
        }
        return interestRatesModelList;
    }


}
