/*
 * Copyright (c) 2021. Spark61
 * This File, its contents and by extension the corresponding project is property of Spark61 and may not be used without explicit permission to do so.
 *
 * spark61@sv-studios.net
 * management@sv-studios.net
 * info@zyonicsoftware.com
 */

package de.spark61.languagesystem;

import org.jetbrains.annotations.NotNull;

/**
 * @author Spark61
 */
public enum Language {
    German("de"),
    English("en");

    private final String isoCode;

    /**
     * @param isoCode ISO 639-1 Code der Sprache
     */
    Language(@NotNull final String isoCode) {
        this.isoCode = isoCode;
    }

    /**
     * @param language Name der Sprache
     * @return Language Enum oder null
     */
    public static Language getLanguageByString(@NotNull final String language) {
        try {
            return Language.valueOf(language);
        } catch (final IllegalArgumentException ignored) {
            return null;
        }
    }

    /**
     * @return ISO 639-1 Code der Sprache
     */
    public String getIsoCode() {
        return this.isoCode;
    }
}
