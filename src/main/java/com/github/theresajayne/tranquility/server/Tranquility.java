package com.github.theresajayne.tranquility.server;

import com.github.theresajayne.tranquility.formbeans.UniverseFB;
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

    public static void main(final String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        Tranquility tranquility = ctx.getBean(Tranquility.class);
        tranquility.start();
    }

    private void start() {
        System.out.println("Starting Tranquility Server...");
        UniverseFB universeFB = new UniverseFB();
        universeFB.setName("Tranquility");
        universeService.saveUniverse(universeFB);
        List<UniverseFB> universeFBList = universeService.getAllUniverses();
        for(UniverseFB fb: universeFBList){
            System.out.println("Universe #"+fb.getUniverseID()+" Named:"+fb.getName());
        }
    }
}
