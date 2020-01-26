package de.bohnottensen.websiteparser;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Theme(Lumo.class)
@Route("")
public class InterestRatesView extends Div implements BeforeEnterObserver {

    private ParserService parserService;

    public InterestRatesView(ParserService parserService) {
        this.parserService = parserService;
    }

    @PostConstruct
    public void init() throws IOException {
        List<InterestRatesModel> interestRatesModels = parserService.parseSite();
        Grid<InterestRatesModel> interestRatesModelGrid = new Grid<>(InterestRatesModel.class);
        System.out.println(interestRatesModels.size());
        ListDataProvider dp = DataProvider.ofCollection(interestRatesModels);
        interestRatesModelGrid.setDataProvider(dp);
        interestRatesModelGrid.setColumns("bankName","product","terms","interestPercent","country");
        interestRatesModelGrid.setHeightByRows(true);
        Grid.Column<InterestRatesModel> column = interestRatesModelGrid.getColumnByKey("bankName");
        if(column.getElement().getText().contains("Varengold")){
            column.getElement().setAttribute("color","red");
        }
        add(interestRatesModelGrid);
    }


    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {

    }
}
