package com.ss.cad.svg.content;

import com.ss.cad.svg.converter.Drawing;
import com.ss.cad.svg.converter.Resolution;
import org.dom4j.Element;

public abstract class AbstractNormalSVGMaker extends AbstractSVGMaker {
    public abstract void add(Element parent, Resolution resolution, Drawing drawing);
}
