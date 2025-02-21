package com.msutherland128.dogboarding.routes;

import com.msutherland128.dogboarding.userinput.MainMenu;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import static com.msutherland128.dogboarding.constant.DogBoardingConstants.MAIN_MENU_ROUTE;

@Component
public class MainMenuRoute extends RouteBuilder {

    private MainMenu mainMenu;

    public MainMenuRoute(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    @Override
    public void configure() throws Exception {


        from("direct:MAIN_MENU_ROUTE")
                .id(MAIN_MENU_ROUTE)
                .log(LoggingLevel.INFO, "Logging message from Main Menu Route")
                //todo - add choice for if csv or excel
                .process(mainMenu)
                .end();
    }

}
