
package com.example;

import com.example.service.DataInitService;
import com.example.service.PerformanceTestService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("hibernate-cache-pu");

        EntityManager em = emf.createEntityManager();

        try {
            DataInitService dataInitService = new DataInitService(em);
            PerformanceTestService performanceTestService =
                    new PerformanceTestService(em);

            // Initialisation des données
            System.out.println("--- Initialisation des données ---");
            dataInitService.initData();

            // Test sans cache
            System.out.println("--- Test sans cache ---");
            performanceTestService.testPerformanceSansCache();

            // Test avec JOIN FETCH
            System.out.println("--- Test avec JOIN FETCH ---");
            performanceTestService.testPerformanceAvecJoinFetch();

            // Test avec Entity Graph
            System.out.println("--- Test avec Entity Graph ---");
            performanceTestService.testPerformanceAvecEntityGraph();

            // Test avec cache de second niveau
            System.out.println("--- Test avec cache de second niveau ---");
            performanceTestService.testPerformanceAvecCache();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
