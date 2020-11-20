package com.ss.cad.svg.converter;

import com.ss.cad.svg.content.AbstractNormalSVGMaker;
import com.ss.cad.svg.content.AbstractTileSVGMaker;

public interface IConverter {
    void buildSvgWithMaker(AbstractTileSVGMaker maker);

    void buildSvgWithMaker(AbstractNormalSVGMaker maker);
}
