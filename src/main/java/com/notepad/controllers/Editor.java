package com.notepad.controllers;

import java.awt.Font;

import javax.swing.JTextArea;

import com.notepad.Application;

public class Editor extends JTextArea {
    public Editor() {
        setLineWrap(
                Boolean.parseBoolean(Application.getProperty("editor.wrap", "true").toString()));
        setFont(
                new Font(
                        Application.getProperty("editor.font.family", "Monospaced").toString(),
                        java.awt.Font.PLAIN,
                        Integer.parseInt(Application.getProperty("editor.font.size", "12").toString())));
        setWrapStyleWord(true);
    }
}
