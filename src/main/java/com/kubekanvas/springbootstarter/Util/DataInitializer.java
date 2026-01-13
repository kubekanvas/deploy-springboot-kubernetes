package com.kubekanvas.springbootstarter.Util;

import com.kubekanvas.springbootstarter.Model.KanvasLink;
import com.kubekanvas.springbootstarter.Repository.LinkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    private final LinkRepository linkRepository;

    public DataInitializer(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Check if data already exists to avoid duplicates on restart
        if (linkRepository.count() == 0) {

            KanvasLink link1 = new KanvasLink("https://www.kubekanvas.io/", "Home");
            KanvasLink link2 = new KanvasLink("https://www.kubekanvas.io/tutorials", "Tutorials");
            KanvasLink link3 = new KanvasLink("https://www.kubekanvas.io/features", "Features");
            KanvasLink link4 = new KanvasLink("https://www.kubekanvas.io/contact", "Contact");

            linkRepository.saveAll(Arrays.asList(link1, link2, link3, link4));

            System.out.println(">> KubeKanvas Database Initialized with 4 Links");
        }
    }
}