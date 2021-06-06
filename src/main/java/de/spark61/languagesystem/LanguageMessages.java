/*
 * Copyright (c) 2021. Spark61
 * This File, its contents and by extension the corresponding project is property of Spark61 and may not be used without explicit permission to do so.
 *
 * spark61@sv-studios.net
 * management@sv-studios.net
 * info@zyonicsoftware.com
 */

package de.spark61.languagesystem;

import de.spark61.config.Document;
import de.spark61.languagesystem.placeholder.PlaceHolder;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author Spark61
 */
public class LanguageMessages extends Document {
    private final Language language;

    /**
     * @param inputStream InputStream von der Sprachfile
     * @param language    Sprache der Nachrichten
     * @throws IOException wenn ein I/O Fehler auftritt
     */
    protected LanguageMessages(@NotNull final InputStream inputStream, @NotNull final Language language) throws IOException {
        super(inputStream);

        this.language = language;
    }

    /**
     * @return Sprache der Nachrichten
     */
    public Language getLanguage() {
        return this.language;
    }

    /**
     * @param key          Key aus der Sprachdatei
     * @param placeHolders PlaceHolder die automatisch ersetzt werden
     * @return String aus der Sprachdatei oder null
     */
    public String getString(@NotNull final String key, final PlaceHolder... placeHolders) {
        String string = super.getString(key);

        for (final PlaceHolder placeHolder : placeHolders) {
            string = string.replace(placeHolder.getSearch(), placeHolder.getReplacement().toString());
        }

        return string;
    }

    /**
     * @param key          Key aus der Sprachdatei
     * @param defaultValue String default Wert, wenn der key nicht in der Sprachdatei existiert
     * @param placeHolders PlaceHolder die automatisch ersetzt werden
     * @return String aus der Sprachdatei
     */
    public String getString(@NotNull final String key, final String defaultValue, final PlaceHolder... placeHolders) {
        String string = super.getString(key, defaultValue);

        for (final PlaceHolder placeHolder : placeHolders) {
            string = string.replace(placeHolder.getSearch(), placeHolder.getReplacement().toString());
        }

        return string;
    }
}
