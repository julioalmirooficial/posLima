package controllerpublic;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class HeaderFooterReport extends PdfPageEventHelper {

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        Rectangle rect = writer.getBoxSize("art");

        switch (writer.getPageNumber() % 2) {
            case 0:
//                ColumnText.showTextAligned(writer.getDirectContent(),
//                        Element.ALIGN_RIGHT, new Phrase("even header"),
//                        rect.getRight(), rect.getTop(), 0);

                break;

            case 1:
//                ColumnText.showTextAligned(writer.getDirectContent(),
//                        Element.ALIGN_LEFT, new Phrase("odd header"),
//                        rect.getLeft(), rect.getTop(), 0);
                
            break;

        }

        Font tituloTablaWHITE = FontFactory.getFont(
                FontFactory.HELVETICA, 8, Font.NORMAL,
                BaseColor.BLACK);
        ColumnText.showTextAligned(writer.getDirectContent(),
                Element.ALIGN_CENTER, new Phrase(String.format("Página %d", writer.getPageNumber()), tituloTablaWHITE),
                (rect.getLeft() + rect.getRight()) / 2, rect.getBottom() - 30, 0);
    }

}
