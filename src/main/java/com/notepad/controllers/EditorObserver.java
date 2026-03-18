package com.notepad.controllers;

public final class EditorObserver {
    private static Editor editor;

    private EditorObserver() {
    }

    public static void initObserver(Editor editor) {
        EditorObserver.editor = editor;
    }

    public static void setText(String text) {
        editor.setText(text);
    }

    public static String getText() {
        return editor.getText();
    }
}
