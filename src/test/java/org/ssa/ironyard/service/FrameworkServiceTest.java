package org.ssa.ironyard.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.ssa.ironyard.config.DataSourceConfiguration;
import org.ssa.ironyard.dao.LanguageDAOImpl;
import org.ssa.ironyard.dao.ServerDAOImpl;
import org.ssa.ironyard.model.Language;
import org.ssa.ironyard.model.Server;

public class FrameworkServiceTest
{

    @Test
    public void loadDatabase()
    {
        ServerService serverService = new ServerService(new ServerDAOImpl(new DataSourceConfiguration().datasource()));
        LanguageService languageService = new LanguageService(new LanguageDAOImpl(new DataSourceConfiguration().datasource()));

        String csvFile = "C:/Users/admin/workspace/Benchmarks/resources/static/benchmarks.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        Set<String> setServers = new HashSet<>();
        Set<String> setLanguages = new HashSet<>();
        List<String> listServers = new ArrayList<>();
        List<String> listLanguages = new ArrayList<>();

        try
        {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null)
            {
                String[] benchmark = line.split(cvsSplitBy);
                setLanguages.add(benchmark[1]);
                setServers.add(benchmark[2]);

                // System.out.println("Benchmark [server= " + benchmark[2] + " , language=" + benchmark[1] + "]");
            }

            listServers.addAll(setServers);
            listLanguages.addAll(setLanguages);
            System.out.println(listServers);
            System.out.println(listLanguages);

            for (String serverStr : listServers)
                serverService.insertServer(new Server(serverStr));
            
//            for (String langStr : listLanguages)
//                languageService.insertLanguage(new Language(langStr));

        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
