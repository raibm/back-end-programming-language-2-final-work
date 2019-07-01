package com.airfare.airfareapp.service;

import com.airfare.airfareapp.domain.Airfare;
import com.airfare.airfareapp.repository.AirfareRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceImpl {

    private final AirfareRepository airfareRepository;

    public ServiceImpl(AirfareRepository airfareRepository){
        this.airfareRepository = airfareRepository;
    }


    public List<Airfare> getAirfareInternational(){
        String url = "https://www.viajanet.com.br/passagens-internacionais";
        Document doc;
        List<Airfare> list = new ArrayList<>();

        try {
            doc = Jsoup.connect(url).get();
            Elements els = doc.select("a[href]");
            for (Element e : els) {
                Airfare newAirfare = new Airfare();
                String origin = e.getElementsByClass("origin").text();
                String destination = e.getElementsByClass("destination").text();
                String price = e.getElementsByClass("price").text();
                if(!e.getElementsByClass("origin").text().isEmpty()){
                    newAirfare.setOriginCity(origin);
                    newAirfare.setDestinyCity(destination);
                    newAirfare.setPrice(price);
                    list.add(newAirfare);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed load.");
            e.printStackTrace();
        }

        return list;
    }


    public List<Airfare> getAirfareNational(){
        String url = "https://www.viajanet.com.br/passagens-nacionais";
        Document doc;
        List<Airfare> list = new ArrayList<>();

        try {
            doc = Jsoup.connect(url).get();
            Elements els = doc.select("a[href]");
            for (Element e : els) {
                Airfare newAirfare = new Airfare();
                String origin = e.getElementsByClass("origin").text();
                String destination = e.getElementsByClass("destination").text();
                String price = e.getElementsByClass("price").text();
                if(!e.getElementsByClass("origin").text().isEmpty()){
                    newAirfare.setOriginCity(origin);
                    newAirfare.setDestinyCity(destination);
                    newAirfare.setPrice(price);
                    list.add(newAirfare);
                }
            }
        } catch (IOException e) {
            System.out.println("Houve algum erro !");
            e.printStackTrace();
        }

        return list;
    };

    public void deleteAirfareById(Integer id){
          airfareRepository.deleteById(id);
    }

    public Airfare addAirfare(Airfare airfare){
      return  airfareRepository.save(airfare);
    }

    public Airfare editAirfare(Airfare airfare){
        return airfareRepository.save(airfare);
    }

    public List<Airfare> myAirfares(){
        return airfareRepository.findAll();
    }
}
