/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxmijatovic.jp21zavrsni.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import maxmijatovic.jp21zavrsni.controller.ObradaBirdCount;
import maxmijatovic.jp21zavrsni.controller.ObradaParticipant;
import maxmijatovic.jp21zavrsni.controller.ObradaSite;
import maxmijatovic.jp21zavrsni.controller.ObradaSpecies;
import maxmijatovic.jp21zavrsni.model.BirdCount;
import maxmijatovic.jp21zavrsni.model.Counter;
import maxmijatovic.jp21zavrsni.model.Participant;
import maxmijatovic.jp21zavrsni.model.Site;
import maxmijatovic.jp21zavrsni.model.Species;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Alice
 */
public class Pomocno {
    
    public static Participant LOGIRAN;
    
    public static String getNazivAplikacije(){
        return "Bird Counter APP";
    }
    
   public static Date convertToDateViaInstant(LocalDate dateToConvert) {
       return java.util.Date.from(dateToConvert.atStartOfDay()
               .atZone(ZoneId.systemDefault())
               .toInstant());
   }
   
   public static LocalDate convertToLocalDateViaInstant(Date dateToConvert){
       return dateToConvert.toInstant()
               .atZone(ZoneId.systemDefault())
               .toLocalDate();
   }
   
  
    
    public static String getFormatCijelogBroja(long i){
        //https://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html
        DecimalFormat dfCijeliBroj = new DecimalFormat("#");
        return dfCijeliBroj.format(i);
    }
    
     public static int getCijeliBrojIzStringa(String s){
         try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }
    
    public static String getFormatDecimalniBroj(BigDecimal b){
       
        return df().format(b);
    }
    
    public static BigDecimal getDecimalniBrojIzStringa(String s){
        try {
            return new BigDecimal(df().parse(s).doubleValue());
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
           
    }
    
    private static DecimalFormat df(){
        NumberFormat nf = NumberFormat.
                getNumberInstance(new Locale("hr","HR"));
         DecimalFormat dfl = (DecimalFormat) nf;
         dfl.applyPattern("#,###.00");
    return dfl;
    }
    
    
    
    public static void pocetniInsert(){
        
        
        Participant p = new Participant();
        p.setEmail("maxima.mijatovic@gmail.com");
        p.setName("Maksima");
        p.setSurname("Mijatović");
        p.setLozinka(BCrypt.hashpw("123", BCrypt.gensalt()));
        
        
        
        ObradaParticipant obradaParticipant = new ObradaParticipant(p);
        try {
            obradaParticipant.create();
        } catch (BirdCounterException ex) {
            System.out.println(ex.getPoruka());
        }
        
        
        Participant p2 = new Participant();
        p2.setEmail("ivana.grgic@gmail.com");
        p2.setName("Ivana");
        p2.setSurname("Grgić");
        p2.setLozinka(BCrypt.hashpw("456", BCrypt.gensalt()));
        
        
        
        obradaParticipant = new ObradaParticipant(p2);
        try {
            obradaParticipant.create();
        } catch (BirdCounterException ex) {
            System.out.println(ex.getPoruka());
        }
        
        
        
        
        Participant participant = new Participant();
        participant.setName("Maksima");
        participant.setSurname("Mijatović");
        participant.setEmail("maxima.mijatovic@gmail.com");
        
        
        
        
        try{
            obradaParticipant.create();
        }catch(BirdCounterException ex){
            System.out.println(ex.getPoruka());
        }
        
        Participant participant2 = new Participant();
        participant2.setName("Marija");
        participant2.setSurname("Horvat");
        participant2.setEmail("marija.horvat@gmail.com");
        
        obradaParticipant = new ObradaParticipant(participant2);
        
        try{
            obradaParticipant.create();
        }catch(BirdCounterException ex){
            System.out.println(ex.getPoruka());
        }
        
        
        Species species1 = new Species();
        species1.setScientificNameGenus("Anas");
        species1.setScientificNameSpecies("crecca");
        species1.setEnglishName("Green-winged Teal");
        species1.setSpeciesGroup("Ducks");
        species1.setSpeciesCode("ANACR");
        
        ObradaSpecies obradaSpecies = new ObradaSpecies(species1);
        try{
            obradaSpecies.create();
        }catch(BirdCounterException e){
            System.out.println(e.getPoruka());
        }
        
        
        Species species2 = new Species();
        species2.setScientificNameGenus("Anas");
        species2.setScientificNameSpecies("platyrhynchos");
        species2.setEnglishName("Mallard");
        species2.setSpeciesGroup("Ducks");
        species2.setSpeciesCode("ANAPL");
        
        obradaSpecies = new ObradaSpecies(species2);
        try{
            obradaSpecies.create();
        }catch(BirdCounterException e){
            System.out.println(e.getPoruka());
        }
        
        Species species3 = new Species();
        species3.setScientificNameGenus("Cygnus");
        species3.setScientificNameSpecies("olor");
        species3.setEnglishName("Mute Swan");
        species3.setSpeciesGroup("Swans");
        species3.setSpeciesCode("CYGOL");
        
        obradaSpecies = new ObradaSpecies(species3);
        try{
            obradaSpecies.create();
        }catch(BirdCounterException e){
            System.out.println(e.getPoruka());
        }
        
        Species species4 = new Species();
        species4.setScientificNameGenus("Grus");
        species4.setScientificNameSpecies("grus");
        species4.setEnglishName("Common Crane");
        species4.setSpeciesGroup("Crane");
        species4.setSpeciesCode("GRUGR");
        
        obradaSpecies = new ObradaSpecies(species4);
        try{
            obradaSpecies.create();
        }catch(BirdCounterException e){
            System.out.println(e.getPoruka());
        }
        
        Species species5 = new Species();
        species5.setScientificNameGenus("Ardea");
        species5.setScientificNameSpecies("cinerea");
        species5.setEnglishName("Grey Heron");
        species5.setSpeciesGroup("Heron");
        species5.setSpeciesCode("ARDCI");
        
        obradaSpecies = new ObradaSpecies(species5);
        try{
            obradaSpecies.create();
        }catch(BirdCounterException ex){
            System.out.println(ex.getPoruka());
        }
        
        Site site1 = new Site();
        site1.setSiteName("Sava river-2 (211-220 rkm Gunja)");
        site1.setRegion("Sava watershed");
        site1.setSiteCode("HR00270");
        site1.setLatitude(new BigDecimal(44.861797));
        site1.setLongitude(new BigDecimal(18.83769));
        
        ObradaSite obradaSite = new ObradaSite(site1);
        try{
            obradaSite.create();
        }catch(BirdCounterException ex){
            System.out.println(ex.getPoruka());
        }
        
        Site site2 = new Site();
        site2.setSiteName("Kopacki rit Nature Park");
        site2.setRegion("Danube watershed");
        site2.setSiteCode("HR00082");
        site2.setLatitude(new BigDecimal(45.630093));
        site2.setLongitude(new BigDecimal(18.869019));
        
        obradaSite = new ObradaSite(site2);
        try{
            obradaSite.create();
        }catch(BirdCounterException ex){
            System.out.println(ex.getPoruka());
        }
        
         Site site3 = new Site();
        site3.setSiteName("Lonjsko polje Nature Park");
        site3.setRegion("Sava watershed");
        site3.setSiteCode("HR00083");
        site3.setLatitude(new BigDecimal(45.390462));
        site3.setLongitude(new BigDecimal(16.782303));
        
        obradaSite = new ObradaSite(site3);
        try{
            obradaSite.create();
        }catch(BirdCounterException ex){
            System.out.println(ex.getPoruka());
        }
        
        
        BirdCount birdCount = new BirdCount();
        birdCount.setName("2016");
        birdCount.setParticipant(p);
        birdCount.setSite(site3);
        birdCount.setDate(new Date());
        birdCount.setCoverage("Complete");
        birdCount.setWeather("No effect");
        birdCount.setWater("Normal(wet)");
        birdCount.setIce("Completely frozen");
        
        Counter counter = new Counter();
        counter.setBirdCount(birdCount);
        counter.setSpecies(species5);
        counter.setNumberOfBirds(16);
        
        birdCount.getCounters().add(counter);
        
        ObradaBirdCount obradaBirdCount = new ObradaBirdCount(birdCount);
        try {
            obradaBirdCount.create();
        } catch (BirdCounterException ex) {
             System.out.println(ex.getPoruka());
        }
        
        BirdCount birdCount1 = new BirdCount();
        birdCount1.setName("2017");
        birdCount1.setParticipant(p2);
        birdCount1.setSite(site2);
        birdCount1.setDate(new Date());
        birdCount1.setCoverage("Partial");
        birdCount1.setWeather("Little effect");
        birdCount1.setWater("Dry");
        birdCount1.setIce("Partly frozen");
        
        Counter counter1 = new Counter();
        counter1.setBirdCount(birdCount1);
        counter1.setSpecies(species2);
        counter1.setNumberOfBirds(36);
        
        birdCount1.getCounters().add(counter1);
        
        obradaBirdCount = new ObradaBirdCount(birdCount1);
        try {
            obradaBirdCount.create();
        } catch (BirdCounterException ex) {
             System.out.println(ex.getPoruka());
        }
        
        BirdCount birdCount2 = new BirdCount();
        birdCount2.setName("2018");
        birdCount2.setParticipant(p);
        birdCount2.setSite(site1);
        birdCount2.setDate(new Date());
        birdCount2.setCoverage("Unknown");
        birdCount2.setWeather("Moderate effect");
        birdCount2.setWater("Overflooded");
        birdCount2.setIce("Not frozen");
        
        Counter counter2 = new Counter();
        counter2.setBirdCount(birdCount2);
        counter2.setSpecies(species4);
        counter2.setNumberOfBirds(10);
        
        birdCount2.getCounters().add(counter2);
        
        obradaBirdCount = new ObradaBirdCount(birdCount2);
        try {
            obradaBirdCount.create();
        } catch (BirdCounterException ex) {
             System.out.println(ex.getPoruka());
        }
        
        
        
        
        
        
        
        
                                               
        
    }
    
}
