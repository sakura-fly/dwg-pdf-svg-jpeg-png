package com.ss.cad.pdf.util;

import com.ss.cad.pdf.WaterMark;

public class PdfUtil {
    private String source;
    private String target;
    private WaterMark waterMark;

    /**
     * @param source 源文件绝对路径
     * @param target 保存文件绝对路径
     */
    public PdfUtil(String source,String target){
        this.source = source;
        this.target = target;
    }

    public PdfUtil waterMark(WaterMark waterMark){
        this.waterMark = waterMark;
        return this;
    }

    public void action(){
        this.waterMark.render(this.source,this.target);
    }
}
