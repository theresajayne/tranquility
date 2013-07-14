package com.github.theresajayne.tranquility.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Tranquility {

    public static void main(final String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        Tranquility tranquility = ctx.getBean(Tranquility.class);
        tranquility.start();
    }

    private void start() {
        System.out.println("Starting Tranquility Server...");
    }
}
