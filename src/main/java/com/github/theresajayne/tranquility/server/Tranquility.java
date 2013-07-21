package com.github.theresajayne.tranquility.server;

import com.github.theresajayne.tranquility.formbeans.ConstellationFB;
import com.github.theresajayne.tranquility.formbeans.RegionFB;
import com.github.theresajayne.tranquility.formbeans.UniverseFB;
import com.github.theresajayne.tranquility.model.services.ConstellationService;
import com.github.theresajayne.tranquility.model.services.RegionService;
import com.github.theresajayne.tranquility.model.services.UniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Tranquility {

    @Autowired
    private UniverseService universeService;

    @Autowired
    private RegionService regionService;

    @Autowired
    private ConstellationService constellationService;

    public static void main(final String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        Tranquility tranquility = ctx.getBean(Tranquility.class);
        tranquility.start();
    }

    private void start() {
        System.out.println("Starting Tranquility Server...");
        UniverseFB universeFB = new UniverseFB();
        universeFB.setUniverseName("Tranquility");
        universeService.saveUniverse(universeFB);
        universeFB = universeService.getUniverseByName(universeFB.getUniverseName());
        RegionFB regionFB = new RegionFB();
        regionFB.setRegionName("The Forge");
        regionFB.setUniverseFB(universeFB);
        regionService.saveRegion(regionFB);
        regionFB = regionService.getRegionByName(regionFB.getRegionName());
        ConstellationFB constellationFB = new ConstellationFB();
        constellationFB.setConstellationName("Derelik");
        constellationFB.setRegionFB(regionFB);
        constellationService.saveConstellation(constellationFB);
        displayEntries();
    }

    private void displayEntries() {
        List<UniverseFB> universeFBList = universeService.getAllUniverses();
        for(UniverseFB fb: universeFBList){
            System.out.println("Universe #"+fb.getUniverseID()+" Named:"+fb.getUniverseName());
        }
        List<RegionFB> regionFBList = regionService.getAllRegions();
        for(RegionFB fb:regionFBList){
            System.out.println("Region #"+fb.getRegionID()+" Named:" + fb.getRegionName()+" In Universe:"+fb.getUniverseFB().getUniverseName());
        }
        List<ConstellationFB> constellationFBList = constellationService.getAllConstellations();
        for(ConstellationFB fb: constellationFBList)
        {
            System.out.println("Constellation #"+fb.getConstellationID()+" Named:"+ fb.getConstellationName()+" In Region:"+fb.getRegionFB().getRegionName());
        }
    }
}
