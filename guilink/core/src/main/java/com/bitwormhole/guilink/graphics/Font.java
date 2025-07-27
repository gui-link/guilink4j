package com.bitwormhole.guilink.graphics;

public class Font {

    private String name;
    private String family;
    private float size;
    private float weight;
    private boolean italic; // 斜体

    private FontInstance instance;

    public Font() {
        this.useDefault();
    }

    public Font(Font src) {
        if (src == null) {
            this.useDefault();
            return;
        }
        this.name = src.name;
        this.family = src.family;
        this.size = src.size;
        this.weight = src.weight;
        this.italic = src.italic;
    }

    private void useDefault() {
        this.family = "default";
        this.name = "default";
        this.size = 16;
        this.weight = 200;
        this.italic = false;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public float getSize() {
        return size;
    }

    public float getWeight() {
        return weight;
    }

    public boolean isItalic() {
        return italic;
    }

    public FontInstance getInstance() {
        return instance;
    }

}
