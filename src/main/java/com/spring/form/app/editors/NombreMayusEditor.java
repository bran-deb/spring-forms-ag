package com.spring.form.app.editors;

import java.beans.PropertyEditorSupport;

public class NombreMayusEditor extends PropertyEditorSupport {
    /**
     * The function converts the input text to uppercase and removes any leading or
     * trailing whitespace.
     * 
     * @param text The text parameter is a string that represents the value that
     *             needs to be set.
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        setValue(text.toUpperCase().trim());
    }
}
