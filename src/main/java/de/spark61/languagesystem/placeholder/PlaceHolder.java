/*
 * Copyright (c) 2021. Spark61
 * This File, its contents and by extension the corresponding project is property of Spark61 and may not be used without explicit permission to do so.
 *
 * spark61@sv-studios.net
 * management@sv-studios.net
 * info@zyonicsoftware.com
 */

package de.spark61.languagesystem.placeholder;

/**
 * @author Spark61
 */
public class PlaceHolder {
    private final String search;
    private final Object replacement;

    /**
     * @param search      String nachdem in der Nachricht gesucht wird
     * @param replacement Object durch das der search Wert ersetzt wird
     */
    public PlaceHolder(final String search, final Object replacement) {
        this.search = search;
        this.replacement = replacement;
    }

    /**
     * @return Object durch das der search Wert ersetzt wird
     */
    public Object getReplacement() {
        return this.replacement;
    }

    /**
     * @return String nachdem in der Nachricht gesucht wird
     */
    public String getSearch() {
        return this.search;
    }
}
