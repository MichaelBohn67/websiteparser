package de.bohnottensen.websiteparser;

import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
class InterestRatesModelService {

    static InterestRatesModel createInterestRateModel(Element element, String terms) {
        InterestRatesModel interestRatesModel = new InterestRatesModel();
        String bankName = element.getElementsByClass("fgv_angebot_bank_name").text();
        interestRatesModel.setBankName(bankName);
        Elements country = element.getElementsByClass("fgv_angebot_flag");
        String minmax = element.getElementsByClass("vl_term_item_value").text();
        String product = element.getElementsByClass("fgv_angebot_product_name").text();
        double intRate = Double.parseDouble(element.getElementsByClass("fgv_angebot_zinssatz").text()
                .replace("%", "")
                .replace("bis", "")
                .replace(",", ".").strip());

        BigDecimal interestRate = BigDecimal.valueOf(intRate);
        interestRatesModel.setInterestPercent(interestRate.toPlainString());
        String land = CountryFlagService.getCountryFromFlag(country);
        interestRatesModel.setCountry(land);
        interestRatesModel.setTerms(terms);
        interestRatesModel.setProduct(product);
        return interestRatesModel;
    }
}
