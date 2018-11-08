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
            document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, out);
            document.open();
            PDFCreator.addTitlePage(document, TITLE);
            PDFCreator.addContent(document, dataObj);
        } catch (DocumentException e) {
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
