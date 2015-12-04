/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_2.elements;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.stream.Stream;
import org.foi.uzdiz.mkovacek.zadaca_2.shapes.ShapeHelper;
import org.foi.uzdiz.mkovacek.zadaca_2.iterator.Iterator;
import org.foi.uzdiz.mkovacek.zadaca_2.savedStates.ElementCareTaker;
import org.foi.uzdiz.mkovacek.zadaca_2.savedStates.ElementOriginator;

import org.foi.uzdiz.mkovacek.zadaca_2.validator.FileValidator;

/**
 *
 * @author Matija
 */
public class ElementHandler {

    private Element element;
    private final FileValidator fv;
    private final ElementCareTaker careTaker;
    private final ElementOriginator originator;


    public ElementHandler() {
        fv = new FileValidator();
        careTaker = new ElementCareTaker();
        originator = new ElementOriginator();
    }

    public void readFile(Path path) {
        fillStructure(path);
    }

    public void fillStructure(Path path) {
        try (Stream<String> lines = Files.lines(path, Charset.defaultCharset())) {
            System.out.println("Validacija datoteke...");
            lines.forEach((String line) -> {
                System.out.print(line);
                Matcher m = fv.checkSyntax(line);

                if (m != null) {
                    if (m.group(1).equals("0") && m.group(2).equals(m.group(3))) {
                        element = new Parent(Integer.valueOf(m.group(1)), m.group(2), m.group(3), m.group(6), true);
                        String[] cords = m.group(4).split(",");
                        List<Integer> cordinates = new ArrayList<>();
                        for (String cord : cords) {
                            cordinates.add(Integer.valueOf(cord));
                        }
                        element.setCoordinates(cordinates);
                        element.setRelativeCoordinates(cordinates);
                    } else if (m.group(1).equals("0")) {
                        Iterator it = element.createIterator();
                        Element parent = new Parent(Integer.valueOf(m.group(1)), m.group(2), m.group(3), m.group(6), true);
                        String[] cords = m.group(4).split(",");
                        List<Integer> cordinates = new ArrayList<>();
                        for (String cord : cords) {
                            cordinates.add(Integer.valueOf(cord));
                        }
                        parent.setCoordinates(cordinates);

                        if (element.getCode().equals(parent.getParentCode())) {
                            if (element.isVisible()) {
                                int xParent = element.getRelativeCoordinates().get(0);
                                int yParent = element.getRelativeCoordinates().get(1);
                                element.setRelCords(xParent, yParent);
                                element.add(parent);
                            }
                        } else {
                            if (!it.hasNext()) {
                                if (element.isVisible()) {
                                    int xParent = element.getRelativeCoordinates().get(0);
                                    int yParent = element.getRelativeCoordinates().get(1);
                                    element.setRelCords(xParent, yParent);
                                    element.add(parent);
                                }
                            } else {
                                while (it.hasNext()) {
                                    Element elem = it.next();
                                    if (elem.isVisible()) {
                                        elem.add(parent);
                                    }
                                }
                            }
                        }
                    } else {
                        Iterator it = element.createIterator();
                        Element child = new Child(Integer.valueOf(m.group(1)), m.group(2), m.group(3), m.group(6), true);
                        String[] cords = m.group(4).split(",");
                        List<Integer> cordinates = new ArrayList<>();
                        for (String cord : cords) {
                            cordinates.add(Integer.valueOf(cord));
                        }
                        child.setCoordinates(cordinates);
                        if (element.getCode().equals(child.getParentCode())) {
                            if (element.isVisible()) {
                                int xParent = element.getRelativeCoordinates().get(0);
                                int yParent = element.getRelativeCoordinates().get(1);
                                element.setRelCords(xParent, yParent);
                                element.add(child);
                            }
                        } else {
                            if (!it.hasNext()) {
                                if (element.isVisible()) {
                                    int xParent = element.getRelativeCoordinates().get(0);
                                    int yParent = element.getRelativeCoordinates().get(1);
                                    element.setRelCords(xParent, yParent);
                                    element.add(child);
                                }
                            } else {
                                while (it.hasNext()) {
                                    Element elem = it.next();
                                    if (elem.isVisible()) {
                                        elem.add(child);
                                    }
                                }
                            }
                        }

                    }
                }
            });
            originator.set(element.printStates(""));
            careTaker.addMemento(originator.storeInMemento());
        } catch (IOException ex) {
            Logger.getLogger(ElementHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Kraj validacije\n");
        element.print();
    }

    public void checkState() {
        System.out.println(element.getType() + "\t" + element.getCode() + "\t" + element.getParentCode() + "\t" + element.getRelativeCoordinates().toString() + "\t" + element.getColor() + "\t Status " + element.getStatus() + "\t Vidljiv " + element.isVisible() + "\t Prijestup " + element.getOverlapCords());
        element.checkOverlaping(element.getShape());
    }

    public void checkOverlaping() {
        Iterator it = element.createIterator();
        List<Element> childs = new ArrayList<>();
        if (element.isVisible()) {
            if (element.getCode().equals(element.getParentCode())) {
                while (it.hasNext()) {
                    Element el = it.next();
                    if (el.isVisible()) {
                        childs.add(el);
                        el.checkIntersection();
                    }
                }
                ShapeHelper id = new ShapeHelper();
                System.out.print("Roditelj: " + element.getCode() + " => ");
                id.checkIntersection(element.getShape(), childs);
            }
        }
    }

    public void changeStatus(String[] input) {
        element.changeStatus(input[0], input[1]);
        element.print();
        originator.set(element.printStates(""));
        careTaker.addMemento(originator.storeInMemento());
    }

    public void getArea() {
        element.getColorAreaInfo(element.getShape());
        System.out.println("\n");

        HashMap<String, Double> areaByColor = new HashMap<>();
        Iterator it = element.createIterator();
        if (element.isVisible()) {
            element.setArea(element.iShape.calculateArea(element.getCoordinates()));
            String color = element.getColor();
            Double area = element.getArea();
            if (!areaByColor.isEmpty()) {
                if (areaByColor.containsKey(color)) {
                    areaByColor.put(color, (areaByColor.get(color) + area));
                } else {
                    areaByColor.put(color, area);
                }
            } else {
                areaByColor.put(color, area);
            }

            while (it.hasNext()) {
                Element elem = it.next();
                List<Element> el = elem.getColorArea(element.getShape());
                if (!el.isEmpty()) {
                    el.forEach(e -> {
                        String eColor = e.getColor();
                        Double eArea = e.getArea();
                        if (areaByColor.containsKey(eColor)) {
                            areaByColor.put(eColor, (areaByColor.get(eColor) + eArea));
                        } else {
                            areaByColor.put(eColor, eArea);
                        }
                    });
                }
            }
        }
        areaByColor.entrySet().stream().forEach((entry) -> {
            System.out.println("Boja: " + entry.getKey() + "\t Površina: " + entry.getValue());
        });
    }

    public void getStates() {
        System.out.println("Sva stanja:");
        for (int j = 0; j < careTaker.getAllMementos().size(); j++) {
            System.out.println("stanje: " + j);
            originator.restoreFromMemento(careTaker.getMemento(j));
            System.out.println(originator.restoreFromMemento(careTaker.getMemento(j)));
        }
    }

}
