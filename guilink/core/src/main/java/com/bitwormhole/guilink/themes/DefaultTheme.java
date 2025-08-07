package com.bitwormhole.guilink.themes;

import com.bitwormhole.guilink.boxes.Box;
import com.bitwormhole.guilink.boxes.BoxSizingEnum;
import com.bitwormhole.guilink.boxes.BoxStateEnum;
import com.bitwormhole.guilink.boxes.Container;
import com.bitwormhole.guilink.boxes.LineStyleEnum;
import com.bitwormhole.guilink.boxes.StylePipelineRegistration;
import com.bitwormhole.guilink.boxes.ThemeBuilder;
import com.bitwormhole.guilink.graphics.Color;
import com.bitwormhole.guilink.graphics.Font;
import com.bitwormhole.guilink.widgets.Button;
import com.bitwormhole.guilink.widgets.Label;

public class DefaultTheme extends BaseTheme {

    public DefaultTheme() {
        super();
    }

    @Override
    protected void onInit(ThemeBuilder tb) {
        super.onInit(tb);

        this.regForBox(tb, Box.class);
        this.regForButton(tb, Button.class);
        this.regForContainer(tb, Container.class);
        this.regForLabel(tb, Label.class);

    }

    private void regForBox(ThemeBuilder builder, Class<Box> tt) {

        final Font font = new Font();
        font.setSize(15);
        font.setWeight(0.5f);
        font.setFamily("default");
        font.setItalic(false);

        final StylePipelineRegistration normal = new StylePipelineRegistration();
        final StylePipelineRegistration disabled = new StylePipelineRegistration();

        normal.setTargetType(tt);
        normal.setState(BoxStateEnum.NORMAL);
        normal.setPipeline((style) -> {
            style.setBorderColor(Color.BLACK);
            style.setBorderStyle(LineStyleEnum.SOLID);
            style.setBorderWidth(1f);
            style.setBackgroundColor(Color.WHITE);
            style.setForegroundColor(Color.BLACK);
            style.setFont(font);
            return style;
        });

        disabled.setTargetType(tt);
        disabled.setState(BoxStateEnum.DISABLED);
        disabled.setPipeline((style) -> {
            Color gray1 = new Color(200, 200, 200, 255);
            Color gray2 = new Color(220, 220, 220, 255);
            style.setBorderColor(gray2);
            style.setBackgroundColor(gray1);
            style.setForegroundColor(gray2);
            return style;
        });

        builder.add(normal);
        builder.add(disabled);
    }

    private void regForLabel(ThemeBuilder builder, Class<Label> tt) {

        final StylePipelineRegistration normal = new StylePipelineRegistration();
        normal.setTargetType(tt);
        normal.setState(BoxStateEnum.NORMAL);
        normal.setPipeline((style) -> {

            return style;
        });

        builder.add(normal);
    }

    private void regForContainer(ThemeBuilder builder, Class<Container> tt) {

        final StylePipelineRegistration normal = new StylePipelineRegistration();
        normal.setTargetType(tt);
        normal.setState(BoxStateEnum.NORMAL);
        normal.setPipeline((style) -> {

            return style;
        });

        builder.add(normal);
    }

    private void regForButton(ThemeBuilder builder, Class<Button> tt) {

        final StylePipelineRegistration normal = new StylePipelineRegistration();
        final StylePipelineRegistration hover = new StylePipelineRegistration();
        final StylePipelineRegistration pressed = new StylePipelineRegistration();

        final Font font = new Font();
        font.setSize(13);
        font.setWeight(0.5f);
        font.setFamily("default");
        font.setItalic(false);

        normal.setTargetType(tt);
        normal.setState(BoxStateEnum.NORMAL);
        normal.setPipeline((style) -> {
            style.setBoxSizing(BoxSizingEnum.BORDER_BOX);
            style.setMargin(2.0f);
            style.setBorderWidth(1.0f);
            style.setBorderColor(Color.GRAY);
            style.setBorderStyle(LineStyleEnum.SOLID);
            style.setPadding(3f);
            style.setForegroundColor(Color.GRAY);
            return style;
        });

        hover.setTargetType(tt);
        hover.setState(BoxStateEnum.HOVERED);
        hover.setPipeline((style) -> {
            style.setMargin(1.0f);
            style.setBorderWidth(2.0f);
            style.setBorderColor(Color.BLACK);
            // style.setFont(font);
            style.setForegroundColor(Color.BLACK);
            style.setBackgroundColor(Color.GRAY9);
            return style;
        });

        pressed.setTargetType(tt);
        pressed.setState(BoxStateEnum.PRESSED);
        pressed.setPipeline((style) -> {
            // style.setMargin(2.0f);
            // style.setBorderWidth(1.0f);
            style.setFont(font);
            style.setBorderColor(Color.BLUE);
            style.setForegroundColor(Color.BLUE);
            style.setBackgroundColor(Color.GRAY9);
            return style;
        });

        builder.add(pressed);
        builder.add(normal);
        builder.add(hover);
    }

}
