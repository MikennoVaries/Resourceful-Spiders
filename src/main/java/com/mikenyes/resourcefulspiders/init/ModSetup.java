package com.mikenyes.resourcefulspiders.init;

import com.mikenyes.resourcefulspiders.ResourcefulSpiders;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.FolderPack;
import net.minecraft.resources.IPackNameDecorator;
import net.minecraft.resources.ResourcePackInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ModSetup {
    public static final Logger LOGGER = LogManager.getLogger();

    public static void initialize() {
        setupPaths();
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ModSetup::loadResources);
    }

    private static void setupPaths() {
        LOGGER.info("Setting up config paths...");
        Path configPath = FMLPaths.CONFIGDIR.get();
        Path rbSpidersPath = Paths.get(configPath.toAbsolutePath().toString(), ResourcefulSpiders.MOD_ID, "spiders");
        Path rbAssetsPath = Paths.get(configPath.toAbsolutePath().toString(),ResourcefulSpiders.MOD_ID, "resources");
        SpiderSetup.setSpiderPath(rbSpidersPath);
        SpiderSetup.setResourcePath(rbAssetsPath);

        try { Files.createDirectories(rbSpidersPath);
        } catch (FileAlreadyExistsException ignored) { //ignored
        } catch (IOException e) { LOGGER.error("failed to create \"bees\" directory");}

        try { Files.createDirectory(rbAssetsPath);
        } catch (FileAlreadyExistsException ignored) { //ignored
        } catch (IOException e) { LOGGER.error("Failed to create \"assets\" directory");}

        try (FileWriter file = new FileWriter(Paths.get(rbAssetsPath.toAbsolutePath().toString(), "pack.mcmeta").toFile())) {
            String mcMetaContent = "{\"pack\":{\"pack_format\":6,\"description\":\"Resourceful Spiders resource pack used for lang purposes for the user to add lang for spider/items.\"}}";
            file.write(mcMetaContent);
        } catch (FileAlreadyExistsException ignored) { //ignored
        } catch (IOException e) { LOGGER.error("Failed to create pack.mcmeta file for resource loading");}
    }

    public static void loadResources() {
        Minecraft.getInstance().getResourcePackRepository().addPackFinder((consumer, factory) -> {
            final ResourcePackInfo packInfo = ResourcePackInfo.create(
                    ResourcefulSpiders.MOD_ID,
                    true,
                    () -> new FolderPack(SpiderSetup.getResourcePath().toFile()) {
                        @Override
                        public boolean isHidden() {
                            return true;
                        }
                    },
                    factory,
                    ResourcePackInfo.Priority.TOP,
                    IPackNameDecorator.BUILT_IN
            );
            if (packInfo == null) {
                LOGGER.error("Failed to load resource pack, some things may not work.");
                return;
            }
            consumer.accept(packInfo);
        });
    }
}
