package com.notepad;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

import com.notepad.controllers.Editor;
import com.notepad.controllers.EditorObserver;
import com.notepad.controllers.Frame;
import com.notepad.controllers.FrameObserver;
import com.notepad.controllers.actions.AlwaysOnTopAction;
import com.notepad.controllers.actions.CloseFrameAction;
import com.notepad.controllers.actions.OpenFileAction;
import com.notepad.controllers.actions.SaveFileAction;

public class Bootstrap implements Runnable {

    private void boot() {
        Frame frame = new Frame();
        Editor editor = new Editor();
        JScrollPane pane = new JScrollPane(editor);

        FrameObserver.initObserver(frame);
        EditorObserver.initObserver(editor);

        frame.setJMenuBar(menuBar());
        frame.add(pane);
        frame.setVisible(true);
    }

    private JMenuBar menuBar() {
        var menuBar = new JMenuBar();
        menuBar.add(menuFile());
        return menuBar;
    }

    private JMenu menuFile() {
        JMenu menu = new JMenu(Language.getText("file"));
        JMenuItem open = new JMenuItem(Language.getText("open..."));
        JMenuItem save = new JMenuItem(Language.getText("save"));
        JMenuItem close = new JMenuItem(Language.getText("close"));
        JCheckBoxMenuItem alwaysOnTop = new JCheckBoxMenuItem(Language.getText("always_on_top"));
        open.addActionListener(i -> new OpenFileAction().onAction());
        save.addActionListener(i -> new SaveFileAction().onAction());
        close.addActionListener(i -> new CloseFrameAction().onAction());
        alwaysOnTop.addActionListener(i -> new AlwaysOnTopAction().onAction());
        menu.add(open);
        menu.add(save);
        menu.add(alwaysOnTop);
        menu.addSeparator();
        menu.add(close);
        return menu;
    }

    @Override
    public void run() {
        try {
            String themeClass = Application
                    .getProperty("app.theme", "com.formdev.flatlaf.FlatLightLaf")
                    .toString();
            javax.swing.UIManager.setLookAndFeel(themeClass);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
        boot();
    }
}
