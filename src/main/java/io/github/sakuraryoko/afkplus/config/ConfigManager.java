package io.github.sakuraryoko.afkplus.config;

import static io.github.sakuraryoko.afkplus.data.ModData.*;

import java.io.File;

import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;

import io.github.sakuraryoko.afkplus.data.ConfigData;
import io.github.sakuraryoko.afkplus.util.AfkPlusLogger;
import net.fabricmc.loader.api.FabricLoader;

public class ConfigManager {
    public static ConfigData CONFIG = new ConfigData();

    public static void initConfig() {
        CONFIG.afkPlusOptions.afkPlusCommandPermissions = 3;
        CONFIG.afkPlusOptions.enableAfkCommand = true;
        CONFIG.afkPlusOptions.enableAfkInfoCommand = true;
        CONFIG.afkPlusOptions.afkCommandPermissions = 0;
        CONFIG.afkPlusOptions.afkInfoCommandPermissions = 2;
        CONFIG.afkPlusOptions.afkTimeoutString = "<i><gray>timeout<r>";
        CONFIG.packetOptions.resetOnLook = false;
        CONFIG.packetOptions.resetOnMovement = false;
        CONFIG.packetOptions.timeoutSeconds = 240;
        CONFIG.packetOptions.disableDamage = false;
        CONFIG.packetOptions.disableDamageCooldown = 15;
        CONFIG.PlaceholderOptions.afkPlaceholder = "<i><gray>[AFK%afkplus:invulnerable%]<r>";
        CONFIG.PlaceholderOptions.afkPlusNamePlaceholder = "%player:displayname%";
        CONFIG.PlaceholderOptions.afkPlusNamePlaceholderAfk = "<i><gray>[AFK%afkplus:invulnerable%] %player:displayname_unformatted%<r>";
        CONFIG.PlaceholderOptions.afkDurationPlaceholderFormatting = "<green>";
        CONFIG.PlaceholderOptions.afkTimePlaceholderFormatting = "<green>";
        CONFIG.PlaceholderOptions.afkReasonPlaceholderFormatting = "";
        CONFIG.PlaceholderOptions.afkDurationPretty = false;
        CONFIG.PlaceholderOptions.afkInvulnerablePlaceholder = ":<red>I<r>";
        CONFIG.playerListOptions.afkPlayerName = "<i><gray>[AFK%afkplus:invulnerable%] %player:displayname%<r>";
        CONFIG.playerListOptions.enableListDisplay = true;
        CONFIG.messageOptions.enableMessages = true;
        CONFIG.messageOptions.whenAfk = "%player:displayname% <yellow>is now AFK<r>";
        CONFIG.messageOptions.whenReturn = "%player:displayname% <yellow>is no longer AFK<r>";
        CONFIG.messageOptions.prettyDuration = true;
        CONFIG.messageOptions.defaultReason = "<gray>poof!<r>";
        CONFIG.messageOptions.whenDamageDisabled = "%player:displayname% <yellow>is marked as <red>Invulnerable.<r>";
        CONFIG.messageOptions.whenDamageEnabled = "%player:displayname% <yellow>is no longer <red>Invulnerable.<r>";
        AfkPlusLogger.debug("Default config initialized.");
    }
    public static void testConfig() {
        // Checks for invalid values
        if (CONFIG.afkPlusOptions.afkPlusCommandPermissions < 0 || CONFIG.afkPlusOptions.afkPlusCommandPermissions > 4)
            CONFIG.afkPlusOptions.afkPlusCommandPermissions = 3;
        //CONFIG.afkPlusOptions.enableAfkCommand = true;
        //CONFIG.afkPlusOptions.enableAfkInfoCommand = true;
        if (CONFIG.afkPlusOptions.afkCommandPermissions < 0 || CONFIG.afkPlusOptions.afkCommandPermissions > 4)
            CONFIG.afkPlusOptions.afkCommandPermissions = 0;
        if (CONFIG.afkPlusOptions.afkInfoCommandPermissions < 0 || CONFIG.afkPlusOptions.afkInfoCommandPermissions > 4)
            CONFIG.afkPlusOptions.afkInfoCommandPermissions = 2;
        if (CONFIG.afkPlusOptions.afkTimeoutString == null)
            CONFIG.afkPlusOptions.afkTimeoutString = "<i><gray>timeout<r>";
        //CONFIG.packetOptions.resetOnLook = false;
        //CONFIG.packetOptions.resetOnMovement = true;
        if (CONFIG.packetOptions.timeoutSeconds < -1 || CONFIG.packetOptions.timeoutSeconds > 3600)
            CONFIG.packetOptions.timeoutSeconds = 240;
        //CONFIG.packetOptions.disableDamage = false;
        if (CONFIG.packetOptions.disableDamageCooldown < -1 || CONFIG.packetOptions.disableDamageCooldown > 3600)
            CONFIG.packetOptions.disableDamageCooldown = 15;
        if (CONFIG.PlaceholderOptions.afkPlaceholder == null)
            CONFIG.PlaceholderOptions.afkPlaceholder = "<i><gray>[AFK%afkplus:invulnerable%]<r>";
        if (CONFIG.PlaceholderOptions.afkPlusNamePlaceholder == null)
            CONFIG.PlaceholderOptions.afkPlusNamePlaceholder = "%player:displayname%";
        if (CONFIG.PlaceholderOptions.afkPlusNamePlaceholderAfk == null)
            CONFIG.PlaceholderOptions.afkPlusNamePlaceholderAfk = "<i><gray>[AFK%afkplus:invulnerable%] %player:displayname_unformatted%<r>";
        if (CONFIG.PlaceholderOptions.afkDurationPlaceholderFormatting == null)
            CONFIG.PlaceholderOptions.afkDurationPlaceholderFormatting = "<green>";
        if (CONFIG.PlaceholderOptions.afkTimePlaceholderFormatting == null)
            CONFIG.PlaceholderOptions.afkTimePlaceholderFormatting = "<green>";
        if (CONFIG.PlaceholderOptions.afkReasonPlaceholderFormatting == null)
            CONFIG.PlaceholderOptions.afkReasonPlaceholderFormatting = "";
        //CONFIG.PlaceholderOptions.afkDurationPretty = false;
        if (CONFIG.PlaceholderOptions.afkInvulnerablePlaceholder == null)
            CONFIG.PlaceholderOptions.afkInvulnerablePlaceholder = ":<red>I<r>";
        if (CONFIG.playerListOptions.afkPlayerName == null)
            CONFIG.playerListOptions.afkPlayerName = "<i><gray>[AFK%afkplus:invulnerable%] %player:displayname%<r>";
        //CONFIG.playerListOptions.enableListDisplay = true;
        //CONFIG.messageOptions.enableMessages = true;
        if (CONFIG.messageOptions.whenAfk == null)
            CONFIG.messageOptions.whenAfk = "%player:displayname% <yellow>is now AFK<r>";
        if (CONFIG.messageOptions.whenReturn == null)
            CONFIG.messageOptions.whenReturn = "%player:displayname% <yellow>is no longer AFK<r>";
        //CONFIG.messageOptions.prettyDuration = true;
        if (CONFIG.messageOptions.defaultReason == null)
            CONFIG.messageOptions.defaultReason = "<gray>poof!<r>";
        if (CONFIG.messageOptions.whenDamageDisabled == null)
            CONFIG.messageOptions.whenDamageDisabled = "%player:displayname% <yellow>is marked as <red>Invulnerable.<r>";
        if (CONFIG.messageOptions.whenDamageEnabled == null)
            CONFIG.messageOptions.whenDamageEnabled = "%player:displayname% <yellow>is no longer <red>Invulnerable.<r>";
        AfkPlusLogger.debug("Config checked for null values.");
    }

    public static void loadConfig() {
        File conf = FabricLoader.getInstance().getConfigDir().resolve(AFK_MOD_ID + ".toml").toFile();
        try {
            if (conf.exists()) {
                CONFIG = new Toml().read(conf).to(ConfigData.class);
            } else {
                AfkPlusLogger.info("Config " + AFK_MOD_ID + ".toml not found, creating new file.");
                //initConfig();
                try {
                    if (!conf.createNewFile()) {
                        AfkPlusLogger.error("Error creating config file " + AFK_MOD_ID + ".toml .");
                    }
                } catch (Exception ignored) {
                }
            }
            testConfig();
            new TomlWriter().write(CONFIG, conf);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void reloadConfig() {
        AfkPlusLogger.info("Reloading Config.");
        loadConfig();
    }
}
