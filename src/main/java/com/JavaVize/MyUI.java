package com.JavaVize;

import javax.servlet.annotation.WebServlet;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        final TextField name = new TextField();
        name.setCaption("Şehir giriniz:");

        java.lang.String veri = "";
        java.lang.String lon = "";
        java.lang.String lat = "";
        java.lang.String main = "";
        java.lang.String description = "";
        java.lang.String temp = "";
        java.lang.String minTemp = "";
        java.lang.String maxTemp = "";
        java.lang.String wind = "";
        java.lang.String pressure = "";
        java.lang.String humidity = "";
        java.lang.String city = "";
        java.lang.String country = "";
        WeatherService service = WeatherService.getInstance();
        try{

            veri = service.GetData(name.getValue());
            lon = service.GetLongitude(name.getValue());
            lat = service.GetLatitude(name.getValue());
            main = service.GetMain(name.getValue());
            description=service.GetDescription(name.getValue());
            temp=service.GetTemp(name.getValue());
            minTemp=service.GetTempMin(name.getValue());
            maxTemp=service.GetTempMax(name.getValue());
            wind=service.GetWind(name.getValue());
            pressure=service.GetPressure(name.getValue());
            humidity=service.GetHumidity(name.getValue());
            city=service.GetCity(name.getValue());
            country=service.GetCountry(name.getValue());
        }catch(Exception ex){

        }
        Button button = new Button("Göster");
        final String[] finalVeri = {veri};
        final String[] finalLon = {lon};
        final String[] finalLat = {lat};
        final String[] finalMain = {main};
        final String[] finalDescription = {description};
        final String[] finalTemp = {temp};
        final String[] finalMinTemp = {minTemp};
        final String[] finalMaxTemp = {maxTemp};
        final String[] finalWind = {wind};
        final String[] finalPressure = {pressure};
        final String[] finalHumidity = {humidity};
        final String[] finalCity = {city};
        final String[] finalCountry = {country};
        button.addClickListener((Button.ClickEvent e) -> {
            try {
                finalVeri[0] =service.GetData(name.getValue());
                finalLat[0] =service.GetLatitude(name.getValue());
                finalLon[0] =service.GetLongitude(name.getValue());
                finalMain[0] =service.GetMain(name.getValue());
                finalDescription[0] =service.GetDescription(name.getValue());
                finalTemp[0] =service.GetTemp(name.getValue());
                finalMinTemp[0] =service.GetTempMin(name.getValue());
                finalMaxTemp[0] =service.GetTempMax(name.getValue());
                finalWind[0] =service.GetLatitude(name.getValue());
                finalPressure[0] =service.GetWind(name.getValue());
                finalHumidity[0] =service.GetHumidity(name.getValue());
                finalCity[0] =service.GetCity(name.getValue());
                finalCountry[0] =service.GetCountry(name.getValue());
            } catch (UnirestException e1) {
                e1.printStackTrace();
            }
            /*layout.addComponent(new Label("Name:"+name.getValue()+"---Data: " + finalVeri[0]));*/
            layout.addComponent(new Label("Enlem: "+ finalLat[0]));
            layout.addComponent(new Label("Boylam: "+ finalLon[0]));
            layout.addComponent(new Label("Hava: "+ finalMain[0]));
            layout.addComponent(new Label("Açıklama: "+ finalDescription[0]));
            layout.addComponent(new Label("Sıcaklık: "+ finalTemp[0]));
            layout.addComponent(new Label("Min Sıcaklık: "+ finalMinTemp[0]));
            layout.addComponent(new Label("Max Sıcaklık: "+ finalMaxTemp[0]));
            layout.addComponent(new Label("Rüzgar: "+ finalWind[0]));
            layout.addComponent(new Label("Basınç: "+ finalPressure[0]));
            layout.addComponent(new Label("Nem: %"+ finalHumidity[0]));
            layout.addComponent(new Label("Şehir: "+ finalCity[0]));
            layout.addComponent(new Label("Ülke: "+ finalCountry[0]));
        });
        layout.addComponents(name, button);
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
