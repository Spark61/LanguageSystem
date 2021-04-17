package de.spark61.languagesystem;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * @author Spark61
 */
public class LanguageSystem {
    private static final String LANGUAGE_FILE_ENDING = ".json";
    private static final String LANGUAGE_FILE_FOLDER = "/languages/";
    private final EnumMap<Language, LanguageMessages> languageMessages;

    /**
     * LanguageSystem was alle Sprachen aus dem LANGUAGE_FILE_FOLDER lädt
     */
    public LanguageSystem() throws IOException, URISyntaxException {
        this.languageMessages = new EnumMap<>(Language.class);

        this.loadLanguages();
    }

    /**
     * Lädt alle Sprachen aus dem eingestellten Ordner
     */
    private void loadLanguages() throws IOException, URISyntaxException {
        final URL url = LanguageSystem.class.getResource(LanguageSystem.LANGUAGE_FILE_FOLDER);

        assert url != null;
        final URI uri = url.toURI();
        final Path myPath;
        if (uri.getScheme().equals("jar")) {
            final FileSystem fileSystem = FileSystems.newFileSystem(uri, Collections.emptyMap());
            myPath = fileSystem.getPath(LanguageSystem.LANGUAGE_FILE_FOLDER);
        } else {
            myPath = Paths.get(uri);
        }
        final Stream<Path> walk = Files.walk(myPath, 1);
        for (final Iterator<Path> it = walk.iterator(); it.hasNext(); ) {
            final String fileName = it.next().getFileName().toString();

            if (fileName.endsWith(LanguageSystem.LANGUAGE_FILE_ENDING)) {
                final String resourcePath = LanguageSystem.LANGUAGE_FILE_FOLDER + fileName;

                try (final InputStream inputStream = LanguageSystem.class.getResourceAsStream(resourcePath)) {
                    final Language language = Language.getLanguageByString(fileName.substring(0, fileName.length() - LanguageSystem.LANGUAGE_FILE_ENDING.length()));

                    if (language != null && inputStream != null) {
                        this.languageMessages.put(language, new LanguageMessages(inputStream, language));
                    }
                }
            }
        }
    }


    /**
     * @param language Sprache
     * @return alle Nachrichten von dieser Sprache oder null
     */
    public LanguageMessages getLanguageMessage(@NotNull final Language language) {
        return this.languageMessages.get(language);
    }
}
