package com.brokerage.util;

import java.util.Date;
import java.util.List;

import com.brokerage.model.Contract;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class PDFCreator {

    private final static String[] HEADER_ARRAY = {"KEY", "VALUE"};
    public final static Font BOLD = new Font(Font.FontFamily.TIMES_ROMAN, 15,
            Font.BOLD);
    public final static Font SMALL_BOLD = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    public final static Font NORMAL_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL);

    public static void addContent(Document document, Contract dataObj) throws DocumentException {
        Paragraph paragraph = new Paragraph();
        paragraph.setFont(NORMAL_FONT);
        createReportTable(paragraph, dataObj);
        document.add(paragraph);
    }
    private static void createReportTable(Paragraph paragraph, Contract dataObj)
            throws BadElementException {
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        paragraph.add(new Chunk("Contract Table - ", SMALL_BOLD));
        if(null == dataObj){
            paragraph.add(new Chunk("No data to display."));
            return;
        }
        addHeaderInTable(HEADER_ARRAY, table);
        addToTable(table, "ID");
        addToTable(table, dataObj.getId().toString());
        addToTable(table, "PurchaseOrderNo");
        addToTable(table, dataObj.getPoNumber());
        addToTable(table, "ContractDate");
        addToTable(table, dataObj.getContractDate().toString());
        addToTable(table, "Buyer");
        addToTable(table, dataObj.getBuyer());
        addToTable(table, "Seller");
        addToTable(table, dataObj.getSeller());
        addToTable(table, "Commodity");
        addToTable(table, dataObj.getCommodity());
        addToTable(table, "Rate");
        addToTable(table, dataObj.getRate().toString());
        addToTable(table, "Specification");
        addToTable(table, dataObj.getSpecification());
        addToTable(table, "DeliveryTime");
        addToTable(table, dataObj.getDeliveryTime().toString());
        addToTable(table, "LoadingPoint");
        addToTable(table, dataObj.getLoadingPoint());
        addToTable(table, "UnloadingPoint");
        addToTable(table, dataObj.getUnloadingPoint());
        addToTable(table, "PaymentTerms");
        addToTable(table, dataObj.getPaymentTerms());
        addToTable(table, "UnloadingAddress");
        addToTable(table, dataObj.getUnloadingAddress());
        addToTable(table, "Commission");
        addToTable(table, dataObj.getCommission().toString());
        paragraph.add(table);
    }
    /** Helper methods start here **/
    public static void addTitlePage(Document document, String title) throws DocumentException {
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        preface.add(new Phrase(new Date().toString(), PDFCreator.NORMAL_FONT));
        addEmptyLine(preface, 1);
        preface.add(new Phrase("Sri Shiveshankar Trading Company ", PDFCreator.BOLD));
        document.addSubject("PDF : " + title);
        preface.setAlignment(Element.ALIGN_CENTER);
        document.add(preface);
        //document.newPage();
    }
    public static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
    public static void addHeaderInTable(String[] headerArray, PdfPTable table){
        PdfPCell c1 = null;
        for(String header : headerArray) {
            c1 = new PdfPCell(new Phrase(header, PDFCreator.SMALL_BOLD));
            c1.setBackgroundColor(BaseColor.GREEN);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
        }
        table.setHeaderRows(1);
    }
    public static void addToTable(PdfPTable table, String data){
        table.addCell(new Phrase(data, PDFCreator.NORMAL_FONT));
    }
    public static Paragraph getParagraph(){
        Paragraph paragraph = new Paragraph();
        paragraph.setFont(PDFCreator.NORMAL_FONT);
        addEmptyLine(paragraph, 1);
        return paragraph;
    }
}
