package com.laozhang.cad.app;

import com.laozhang.cad.svg.converter.Resolution;
import com.laozhang.cad.svg.converter.impl.DWG2SVGConverter;
import com.laozhang.cad.svg.content.impl.PictFourCornerMidSVGMaker;

public class Dwg2Svg {

    public static void main(String[] args) throws Exception {
        String sourcePath = "E:\\doc\\s21\\二次图\\二次图\\1AA.dwg";
        String targetPath = "F:\\test\\dwg2svg\\1AA.dwg.svg";
//        String pictPath = "D:\\IDEA\\cad\\202003230930.jpg";

        //DWG2SVGConverter converter = new DWG2SVGConverter(sourcePath,targetPath);
        DWG2SVGConverter converter = new DWG2SVGConverter(sourcePath,targetPath, Resolution.RESOLUTION_1920_1080);

//        TextTileSVGMaker maker = new TextTileSVGMaker("10000000 11101100",10,10);
//        maker.horizontalInterval(50);
//        maker.verticalInterval(10);
//        maker.slopeOffset(100);
        //PictTileSVGMaker maker = new PictTileSVGMaker(pictPath, 400, 300);
        //PictAddSVGMaker maker = new PictAddSVGMaker(pictPath, 900, 50, 60, 30);
//        PictFourCornerMidSVGMaker maker = new PictFourCornerMidSVGMaker(pictPath,60, 30);
        converter.buildSvgWithMaker();
    }
}
