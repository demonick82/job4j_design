package ru.job4j.dip;


public class Book {
    private String text;
    private ConsolePrinter printer;

    public void print(String text) {
        printer.print(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ConsolePrinter getPrinter() {
        return printer;
    }

    public void setPrinter(ConsolePrinter printer) {
        this.printer = printer;
    }
}
