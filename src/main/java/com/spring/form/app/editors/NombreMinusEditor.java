package com.spring.form.app.editors;

import java.beans.PropertyEditorSupport;

public class NombreMinusEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(text.toLowerCase().trim());
    }
}
