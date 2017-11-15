package com.JavaVize;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sun.org.apache.xpath.internal.operations.String;
import com.vaadin.ui.TextField;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * An in memory dummy "database" for the example purposes. In a typical Java app
 * this class would be replaced by e.g. EJB or a Spring based service class.
 * <p>
 * In demos/tutorials/examples, get a reference to this service class with
 * {@link /*CustomerService#getInstance()}.
 */
public class WeatherService {

    public synchronized java.lang.String GetLatitude(java.lang.String city) throws UnirestException {
        HttpResponse<java.lang.String> response = Unirest.get("http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=c93f19c6e0cd420387bbdc5fdc7e3b2d")
                .header("cache-control", "no-cache")
                .header("postman-token", "c93ff175-27d8-2b7e-2761-3cc2a4405718")
                .asString();
        int startIndex = response.getBody().indexOf("lat\":") + 5;
        int endIndex = response.getBody().indexOf("},\"weather\":");
        return response.getBody().substring(startIndex,endIndex);
    }
    public synchronized java.lang.String GetLongitude(java.lang.String city) throws UnirestException {
        HttpResponse<java.lang.String> response = Unirest.get("http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=c93f19c6e0cd420387bbdc5fdc7e3b2d")
                .header("cache-control", "no-cache")
                .header("postman-token", "c93ff175-27d8-2b7e-2761-3cc2a4405718")
                .asString();
        int startIndex = response.getBody().indexOf("lon\":") + 5;
        int endIndex = response.getBody().indexOf(",\"lat\":");
        return response.getBody().substring(startIndex,endIndex);
    }


    public synchronized java.lang.String GetMain(java.lang.String city) throws UnirestException {
        HttpResponse<java.lang.String> response = Unirest.get("http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=c93f19c6e0cd420387bbdc5fdc7e3b2d")
                .header("cache-control", "no-cache")
                .header("postman-token", "c93ff175-27d8-2b7e-2761-3cc2a4405718")
                .asString();
        int startIndex = response.getBody().indexOf("main\":") + 7;
        int endIndex = response.getBody().indexOf(",\"description\":");
        return response.getBody().substring(startIndex,endIndex-1);
    }
    public synchronized java.lang.String GetDescription(java.lang.String city) throws UnirestException {
        HttpResponse<java.lang.String> response = Unirest.get("http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=c93f19c6e0cd420387bbdc5fdc7e3b2d")
                .header("cache-control", "no-cache")
                .header("postman-token", "c93ff175-27d8-2b7e-2761-3cc2a4405718")
                .asString();
        int startIndex = response.getBody().indexOf("description\":") + 14;
        int endIndex = response.getBody().indexOf(",\"icon\":");
        return response.getBody().substring(startIndex,endIndex-1);
    }
    public synchronized java.lang.String GetTemp(java.lang.String city) throws UnirestException {
        HttpResponse<java.lang.String> response = Unirest.get("http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=c93f19c6e0cd420387bbdc5fdc7e3b2d")
                .header("cache-control", "no-cache")
                .header("postman-token", "c93ff175-27d8-2b7e-2761-3cc2a4405718")
                .asString();
        int startIndex = response.getBody().indexOf("temp\":") + 6;
        int endIndex = response.getBody().indexOf(",\"pressure\":");
        double temp=Double.parseDouble(response.getBody().substring(startIndex,endIndex));
        temp-=273;
        return (Double.toString(temp).substring(0,4)+" Derece");
    }
    public synchronized java.lang.String GetTempMin(java.lang.String city) throws UnirestException {
        HttpResponse<java.lang.String> response = Unirest.get("http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=c93f19c6e0cd420387bbdc5fdc7e3b2d")
                .header("cache-control", "no-cache")
                .header("postman-token", "c93ff175-27d8-2b7e-2761-3cc2a4405718")
                .asString();
        int startIndex = response.getBody().indexOf("temp_min\":") + 10;
        int endIndex = response.getBody().indexOf(",\"temp_max\":");
        double temp=Double.parseDouble(response.getBody().substring(startIndex,endIndex));
        temp-=273;
        return (Double.toString(temp).substring(0,4)+" Derece");
    }
    public synchronized java.lang.String GetTempMax(java.lang.String city) throws UnirestException {
        HttpResponse<java.lang.String> response = Unirest.get("http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=c93f19c6e0cd420387bbdc5fdc7e3b2d")
                .header("cache-control", "no-cache")
                .header("postman-token", "c93ff175-27d8-2b7e-2761-3cc2a4405718")
                .asString();
        int startIndex = response.getBody().indexOf("temp_max\":") + 10;
        int endIndex = response.getBody().indexOf("},\"visibility\":");
        double temp=Double.parseDouble(response.getBody().substring(startIndex,endIndex));
        temp-=273;
        return (Double.toString(temp).substring(0,4)+" Derece");
    }
    public synchronized java.lang.String GetWind(java.lang.String city) throws UnirestException {
        HttpResponse<java.lang.String> response = Unirest.get("http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=c93f19c6e0cd420387bbdc5fdc7e3b2d")
                .header("cache-control", "no-cache")
                .header("postman-token", "c93ff175-27d8-2b7e-2761-3cc2a4405718")
                .asString();
        int startIndex = response.getBody().indexOf("speed\":") + 7;
        int endIndex = response.getBody().indexOf(",\"deg\":");
        return response.getBody().substring(startIndex,endIndex);
    }
    public synchronized java.lang.String GetPressure(java.lang.String city) throws UnirestException {
        HttpResponse<java.lang.String> response = Unirest.get("http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=c93f19c6e0cd420387bbdc5fdc7e3b2d")
                .header("cache-control", "no-cache")
                .header("postman-token", "c93ff175-27d8-2b7e-2761-3cc2a4405718")
                .asString();
        int startIndex = response.getBody().indexOf("pressure\":") + 10;
        int endIndex = response.getBody().indexOf(",\"humidity\":");
        return response.getBody().substring(startIndex,endIndex);
    }
    public synchronized java.lang.String GetHumidity(java.lang.String city) throws UnirestException {
        HttpResponse<java.lang.String> response = Unirest.get("http://api.openweathermap.org/data/2.5/weather?q=Istanbul&APPID=c93f19c6e0cd420387bbdc5fdc7e3b2d")
                .header("cache-control", "no-cache")
                .header("postman-token", "c93ff175-27d8-2b7e-2761-3cc2a4405718")
                .asString();
        int startIndex = response.getBody().indexOf("humidity\":") + 10;
        int endIndex = response.getBody().indexOf(",\"temp_min\":");
        return response.getBody().substring(startIndex,endIndex);
    }
    public synchronized java.lang.String GetCity(java.lang.String city) throws UnirestException {
        HttpResponse<java.lang.String> response = Unirest.get("http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=c93f19c6e0cd420387bbdc5fdc7e3b2d")
                .header("cache-control", "no-cache")
                .header("postman-token", "c93ff175-27d8-2b7e-2761-3cc2a4405718")
                .asString();
        int startIndex = response.getBody().indexOf("name\":") + 7;
        int endIndex = response.getBody().indexOf(",\"cod\":")-1;
        return response.getBody().substring(startIndex,endIndex);
    }
    public synchronized java.lang.String GetCountry(java.lang.String city) throws UnirestException {
        HttpResponse<java.lang.String> response = Unirest.get("http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=c93f19c6e0cd420387bbdc5fdc7e3b2d")
                .header("cache-control", "no-cache")
                .header("postman-token", "c93ff175-27d8-2b7e-2761-3cc2a4405718")
                .asString();
        int startIndex = response.getBody().indexOf("country\":") + 10;
        int endIndex = response.getBody().indexOf(",\"sunrise\":")-1;
        return response.getBody().substring(startIndex,endIndex);
    }
    public synchronized java.lang.String SetData(java.lang.String city) throws UnirestException {
        HttpResponse<java.lang.String> response = Unirest.get("http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=c93f19c6e0cd420387bbdc5fdc7e3b2d")
                .header("cache-control", "no-cache")
                .header("postman-token", "c93ff175-27d8-2b7e-2761-3cc2a4405718")
                .asString();
        return response.getBody();
    }



    public synchronized java.lang.String GetData(java.lang.String city) throws UnirestException {
        HttpResponse<java.lang.String> response = Unirest.get("http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=c93f19c6e0cd420387bbdc5fdc7e3b2d")
                .header("cache-control", "no-cache")
                .header("postman-token", "c93ff175-27d8-2b7e-2761-3cc2a4405718")
                .asString();
        return response.getBody();
    }
    public static WeatherService getInstance(){
        WeatherService service=new WeatherService();
        return service;
    }

}