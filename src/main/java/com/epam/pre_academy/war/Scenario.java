package com.epam.pre_academy.war;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Jakub Hałas
 */

public class Scenario {

    private static final String path = "src" + File.separator + "main" + File.separator + "resources" ;


    public List<Path> allScenarioInResource() {
        try(Stream<Path> files = Files.list(Paths.get(path))) {
            return files
                    .filter(f -> f.toString().startsWith(path + File.separator + "war_"))
                    .filter(f -> f.toString().endsWith(".json"))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
            return null ;
        }
    }

    public static String getScenarioName(Path scernioPathFile) {
        String name = "haha" ;
        switch (scernioPathFile.getFileName().toString()) {
            case "war_deadSimpleGame.json" ->  name = "Dead Simple Game" ;
            case "war_illegalSyntax.json"  ->  name = "Illegal Synatx" ;
            case "war_infiniteGame.json"   ->  name = "Infinite Game" ;
        }
       return  name ;
    }
}
