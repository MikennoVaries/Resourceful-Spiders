package com.mikenyes.resourcefulspiders.init;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mikenyes.resourcefulspiders.api.CustomSpiderData;
import com.mikenyes.resourcefulspiders.registry.SpiderRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.stream.Stream;

public class SpiderSetup {
    public static final Logger LOGGER = LogManager.getLogger();

    private static final String JSON = ".json";
    private static final String ZIP = ".zip";

    private static Path spiderPath;
    private static Path resourcePath;

    public static void setSpiderPath(Path path) {
        spiderPath = path;
    }

    public static void setResourcePath(Path path) {
        resourcePath = path;
    }

    public static Path getResourcePath() {
        return resourcePath;
    }

    private static void parseSpider(Reader reader, String name) {
        name = name.toLowerCase(Locale.ENGLISH).replace(" ", "_");
        Gson gson = new Gson();
        try {
            CustomSpiderData spider = gson.fromJson(reader, CustomSpiderData.class);
            spider.setName(name);
            SpiderRegistry.getRegistry().registerSpider(name, spider);
        } catch (JsonSyntaxException e) {
            String exception = String.format("You fucked up your spider: %s. Json is invalid, validate it here : https://jsonlint.com/", name);
            throw new JsonSyntaxException(exception);
        }
    }

    private static void addSpiders() {
        LOGGER.info("Registering creepy crawlies...");
        try (Stream<Path> zipStream = Files.walk(spiderPath);
             Stream<Path> jsonStream = Files.walk(spiderPath)) {
            zipStream.filter(f -> f.getFileName().toString().endsWith(ZIP)).forEach(SpiderSetup::addZippedSpider);
            jsonStream.filter(f -> f.getFileName().toString().endsWith(JSON)).forEach(SpiderSetup::addSpider);
        } catch (IOException e) {
            LOGGER.error("Dude I dropped my spiders!", e);
        }
    }

    private static void addZippedSpider(Path path) {
    }

    private static void addSpider(Path path) {
    }

    public static void setupSpiders() {
        addSpiders();
    }
}
