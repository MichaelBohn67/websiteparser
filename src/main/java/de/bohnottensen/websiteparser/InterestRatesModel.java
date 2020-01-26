package de.bohnottensen.websiteparser;

import lombok.Data;

@Data
public class InterestRatesModel {

    private String bankName;
    private String interestPercent;
    private String country;
}
