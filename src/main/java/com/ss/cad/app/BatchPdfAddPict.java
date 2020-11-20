package com.ss.cad.app;

import com.ss.cad.pdf.util.PdfUtil;
import com.ss.cad.pdf.wm.PDFShortSidePictWaterMark;

import java.io.File;
import java.io.FileFilter;

public class BatchPdfAddPict {
    //private final static String pictPath = "D:\\IDEA\\cad\\202003230930.jpg";
    private final static String pictPath = "D:\\IDEA\\cad\\202003301330.png";
    private final static int pictWidth = 120;
    private final static int pictHeight = 120;
    private final static int margin = 0;
    public static void main(String[] args) throws Exception {
        //String sourcePath = "C:\\Users\\admin\\Desktop\\now\\drawing\\total_donet_convert_pdf";
        String sourcePath = "C:\\Users\\admin\\Desktop\\now\\drawing\\total_dwg_dxf_pdf";
        String targetPath = "C:\\Users\\admin\\Desktop\\now\\drawing\\total_pdf_result";

        File sourceDir = new File(sourcePath);
        File[] files = sourceDir.listFiles(new FileFilter() {
            String fileName;
            String postfix;
            @Override
            public boolean accept(File pathname) {
                fileName = pathname.getName();
                postfix = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
                if(".pdf".equals(postfix)){
                    return true;
                }
                return false;
            }
        });
        String fileName;
        for (File file : files) {
            fileName = file.getName();
            if (fileName.endsWith("pdf") || fileName.endsWith("PDF")) {
                new PdfUtil(sourcePath + "\\" + fileName,targetPath + "\\" +  fileName).waterMark(new PDFShortSidePictWaterMark(pictPath)).action();
                System.out.println(fileName + " -> Done!");
            }
        }
    }

}
