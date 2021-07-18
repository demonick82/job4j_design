package ru.job4j.ood.lsp;

public class Square extends Rectangle {
    @Override
    public void setWidth(double width) {
        setWidth(getHeight());
    }
}
