package com.brokerage.util;

import com.brokerage.model.Contract;

import java.io.*;
import java.util.List;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public class Client {

    private static final String TITLE = "ContractReport";
    public static final String PDF_EXTENSION = ".pdf";

    public static ByteArrayInputStream generatePdf(Contract contract) {
        Contract dataObj = contract;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = null;
        try {
            //Document is not auto-closable hence need to close it separately
            document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(
                    new File(TITLE + PDF_EXTENSION)));
            HeaderFooter event = new HeaderFooter();
            event.setHeader("Test Report");
            writer.setPageEvent(event);
            PdfWriter.getInstance(document, out);
            document.open();
            //PDFCreator.addMetaData(document, TITLE);
            PDFCreator.addTitlePage(document, TITLE);
            PDFCreator.addContent(document, dataObj);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("FileNotFoundException occurs.." + e.getMessage());
        } finally {
            if (null != document) {
                document.close();
            }
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
}
