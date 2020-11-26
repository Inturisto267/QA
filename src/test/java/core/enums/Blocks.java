package core.enums;

import org.openqa.selenium.By;

public enum Blocks {

    MANUFACTURER("Производитель"),
    DOCUMENTATION_STANDARD("Нормативно-техническая документация"),
    STEEL_MAKE("Марка стали"),
    BORE("Условный проход"),
    WALL_THICKNESS("Толщина стенки"),
    AMOUNT("Количество"),
    CODE("div");

    private String block;


    Blocks(String block) {
        this.block = block;
    }

    public String getBlockName() {
        return block;
    }
}
