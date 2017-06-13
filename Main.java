package com.company;

import com.company.entities.Student;
import org.pushingpixels.substance.api.skin.SubstanceBusinessLookAndFeel;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);

                try {
                    UIManager.setLookAndFeel(new SubstanceBusinessLookAndFeel());
                    UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceBusinessLookAndFeel");
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                JFrame w = new JFrame("Skolas datu bāze");
                JPanel pane = new JPanel(null);
                JPanel pane2 = new JPanel(null);
                JPanel pane3 = new JPanel(null);
                JPanel pane4 = new JPanel(null);
                pane.setLayout(null);
                pane2.setLayout(null);
                pane3.setLayout(null);
                pane4.setLayout(null);


                JMenuBar menuBar = new JMenuBar();
                JMenu fileMenu = new JMenu("Fails");
                JMenu settingMenu = new JMenu("DB Rīķi");
                final JMenu helpMenu = new JMenu("Palidzība");

                URL fileIconUrl = Main.class.getResource("/resources/file.png");
                ImageIcon fileIcon = new ImageIcon(fileIconUrl);
                fileMenu.setIcon(fileIcon);
                URL settingsIconURL = Main.class.getResource("/resources/settings.png");
                ImageIcon settingsIcon = new ImageIcon(settingsIconURL);
                settingMenu.setIcon(settingsIcon);
                URL infoIconURL = Main.class.getResource("/resources/info.png");
                ImageIcon infoIcon = new ImageIcon(infoIconURL);
                helpMenu.setIcon(infoIcon);

                JMenuItem saveMenuItem = new JMenuItem("Saglabāt kā fails");
                fileMenu.add(saveMenuItem);
                fileMenu.add(settingMenu);

                fileMenu.addSeparator();

                JMenuItem exit = new JMenuItem("Iziet");
                fileMenu.add(exit);

                JMenuItem aboutProgram = new JMenuItem("Par programmu");
                helpMenu.add(aboutProgram);
                JMenuItem programContactAuthor = new JMenuItem("Iegūst palidzību");
                helpMenu.add(programContactAuthor);

                JMenuItem newUserMenuItem = new JMenuItem("Pievienot studentu");
                settingMenu.add(newUserMenuItem);
                final JMenuItem editUserMenuItem = new JMenuItem("Rediģēt studentu");
                settingMenu.add(editUserMenuItem);
                settingMenu.addSeparator();
                JMenuItem newTeacherMenuItem = new JMenuItem("Pievienot skolotāju");
                settingMenu.add(newTeacherMenuItem);
                final JMenuItem editTeacherMenuItem = new JMenuItem("Rediģēt skolotāju");
                settingMenu.add(editTeacherMenuItem);
                settingMenu.addSeparator();
                JMenuItem newUserLessonMenuItem = new JMenuItem("Pievienot priekšmetu");
                settingMenu.add(newUserLessonMenuItem);
                settingMenu.addSeparator();
                JMenuItem newUserScoreMenuItem = new JMenuItem("Pievienot atzīmi");
                settingMenu.add(newUserScoreMenuItem);

                exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });

                menuBar.add(fileMenu);
                menuBar.add(settingMenu);
                menuBar.add(helpMenu);


                aboutProgram.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String msg = "Lorem Ipsum\n" +
                                "\"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...\"\n" +
                                "\"There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain...\"\n" +
                                "\n" +
                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce hendrerit lacinia metus, id maximus magna euismod ac. Quisque non nisi dictum, consequat nibh sit amet, sollicitudin tortor. Suspendisse mollis, enim eget mollis facilisis, sem nulla tempus lacus, in pretium orci nunc condimentum sapien. Sed vel est neque. Donec enim dolor, dictum non malesuada ut, viverra non eros. Praesent tincidunt ultrices sem, sed tincidunt nisi viverra malesuada. Sed eget lacus in sem dictum sagittis vulputate eget purus. Phasellus lectus augue, tincidunt vel dictum ac, maximus sit amet lacus. Fusce eget erat et sem dictum sagittis et ut quam. Donec sollicitudin, dolor nec porta tempor, velit ligula scelerisque elit, non sodales augue enim nec ante. Maecenas maximus tincidunt leo, quis aliquet purus accumsan laoreet. Nam ullamcorper ultrices leo, vitae placerat nibh faucibus eget. Donec malesuada commodo purus sed accumsan. Donec dignissim elit at fermentum suscipit. Morbi porttitor accumsan lacus vel condimentum.";
                        JOptionPane optionPane = new NarrowOptionPane();
                        optionPane.setMessage(msg);
                        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                        JDialog dialog = optionPane.createDialog(null, "Par programmu");
                        dialog.setVisible(true);
                    }
                });
                programContactAuthor.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String msg = "Lorem Ipsum\n" +
                                "\"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...\"\n" +
                                "\"There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain...\"\n";
                        JOptionPane optionPane = new NarrowOptionPane();
                        optionPane.setMessage(msg);
                        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                        JDialog dialog = optionPane.createDialog(null, "Par programmu");
                        dialog.setVisible(true);
                    }
                });
                w.addWindowFocusListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {

                    }
                });

                String col[] = {"Vārds","Uzvārds","Dzimums", "Dzimšanas gads", "Kurss"};


                DefaultTableModel tableModel = new DefaultTableModel(col, 0);
                JTable studentTable = new JTable(tableModel);
                JScrollPane studentTableJSPane = new JScrollPane(studentTable);
                w.add(studentTableJSPane);
                studentTableJSPane.setBounds(10, 20, 800, 400);


                ArrayList<Student> students = new ArrayList<Student>();

                for (int i = 0; i < students.size(); i++) {
                    String name = students.get(i).getNameStudent();
                    String surname = students.get(i).getSurnameStudent();
                    String sex = students.get(i).getSexStudent();
                    String birthday = students.get(i).getBirthDayStudent();
                    String course = students.get(i).getCourse();

                    Object[] data = {name, surname, sex, birthday, course};

                    tableModel.addRow(data);
                }

                JTableHeader tableHeader = studentTable.getTableHeader();
                TableColumnModel tableColumnModel = tableHeader.getColumnModel();
                TableColumn nameColumn = tableColumnModel.getColumn(0);
                TableColumn surnameColumn = tableColumnModel.getColumn(1);
                TableColumn sexColumn = tableColumnModel.getColumn(2);
                TableColumn birthdayColumn = tableColumnModel.getColumn(3);
                TableColumn courseColumn = tableColumnModel.getColumn(4);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                nameColumn.setCellRenderer(centerRenderer);
                surnameColumn.setCellRenderer(centerRenderer);
                sexColumn.setCellRenderer(centerRenderer);
                birthdayColumn.setCellRenderer(centerRenderer);
                courseColumn.setCellRenderer(centerRenderer);

                Font font = tableHeader.getFont();
                studentTable.setRowHeight(30);
                tableHeader.setFont(new Font(String.valueOf(font), Font.BOLD, 12));

                w.setJMenuBar(menuBar);
                w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                w.setPreferredSize(new Dimension(950, 700));
                w.pack();
                w.setLocationRelativeTo(null);
                w.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}
