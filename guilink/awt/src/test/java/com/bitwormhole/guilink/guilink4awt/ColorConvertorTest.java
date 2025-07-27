package com.bitwormhole.guilink.guilink4awt;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bitwormhole.guilink.graphics.Color;

public class ColorConvertorTest {

    static final Logger logger = LoggerFactory.getLogger(ColorConvertorTest.class);

    @Test
    public void testConvert() {

        Map<String, com.bitwormhole.guilink.graphics.Color> all = this.getColors();
        com.bitwormhole.guilink.graphics.Color c1 = null;
        java.awt.Color c2 = null;
        StringBuilder sb = null;

        for (String name : all.keySet()) {

            sb = new StringBuilder();
            c1 = all.get(name);
            c2 = ColorConvertors.convert(c1);

            sb.append("[color");
            sb.append(" name:").append(name);
            sb.append(" r:").append(c2.getRed());
            sb.append(" g:").append(c2.getGreen());
            sb.append(" b:").append(c2.getBlue());
            sb.append(" a:").append(c2.getAlpha());
            sb.append(']');

            System.out.println(sb);
            logger.info("c1 = " + c1);
            logger.info("c2 = " + c2);
        }

    }

    private Map<String, com.bitwormhole.guilink.graphics.Color> getColors() {
        Map<String, com.bitwormhole.guilink.graphics.Color> m = new HashMap<>();

        m.put("red", Color.RED);
        m.put("green", Color.GREEN);
        m.put("blue", Color.BLUE);

        m.put("black", Color.BLACK);
        m.put("white", Color.WHITE);
        m.put("gray", Color.GRAY);

        /// (b)(g)(r)(a)
        m.put("RGBA", new Color(1, 2, 3, 4));

        return m;
    }

}
