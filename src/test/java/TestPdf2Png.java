import com.aspose.pdf.Document;
import com.aspose.pdf.devices.JpegDevice;
import com.aspose.pdf.devices.PngDevice;
import com.aspose.pdf.devices.Resolution;

public class TestPdf2Png {
    public static void main(String[] args) throws Exception {

        Document pdfDocument = new Document("C:\\Users\\admin\\Desktop\\now\\drawing\\total_java\\4A18025A001A0.pdf");
        java.io.OutputStream imageStream = new java.io.FileOutputStream("C:\\Users\\admin\\Desktop\\now\\drawing\\total_java_convert\\Output.png");
        // Create JPEG device with specified attributes
        // Quality [0-100], 100 is Maximum
        // Create Resolution object
        Resolution resolution = new Resolution(300);
        // Create JpegDevice object where second argument indicates the quality of resultant image
        PngDevice pngDevice = new PngDevice(resolution);
        // Convert a particular page and save the image to stream
        pngDevice.process(pdfDocument.getPages().get_Item(1), imageStream);
        // Close the stream
        imageStream.close();
    }
}
