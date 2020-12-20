package com.reports;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.restaurant.model.dto.CheuqeDTO;
import com.restaurant.model.dto.FoodItemDataDTO;

public class PDFExporter {

	private static void createNewCell(PdfPTable table, Color bkClr, Color brdClr, int padding, String data, Font font,
			int alignment) {
		PdfPCell cel = new PdfPCell();

		cel.setBorderColor(brdClr);
		cel.setBackgroundColor(bkClr);
		cel.setPadding(padding);
		cel.setPhrase(new Phrase(data, font));
		cel.setHorizontalAlignment(alignment);
		table.addCell(cel);

	}

	private static void preparTitle(Document document, CheuqeDTO dto, BaseFont bf) {

		PdfPTable table = new PdfPTable(1);
		table.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
		table.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);

		Font font_Table_Data = new Font(bf, 12);
		font_Table_Data.setColor(Color.BLACK);
		Font font_Table_Data2 = new Font(bf, 8);
		font_Table_Data2.setColor(Color.BLACK);
		createNewCell(table, Color.WHITE, Color.WHITE, 1, "شلتــــــــــــــــــــــــــــــوت", font_Table_Data,
				PdfPCell.ALIGN_CENTER);
		createNewCell(table, Color.WHITE, Color.WHITE, 1, "(دوق واحكم)", font_Table_Data2, PdfPCell.ALIGN_CENTER);
		createNewCell(table, Color.WHITE, Color.WHITE, 1, "01101142636-01090903164", font_Table_Data2,
				PdfPCell.ALIGN_CENTER);

		document.add(table);
	}

	private static void preparHeaderData(Document document, CheuqeDTO dto, BaseFont bf)
			throws DocumentException, IOException {

		PdfPTable table = new PdfPTable(4);
		table.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
		table.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);

		Font font_Table_Data = new Font(bf, 6);
		font_Table_Data.setColor(Color.BLACK);

		createNewCell(table, Color.WHITE, Color.WHITE, 1, "رقم : ", font_Table_Data, PdfPCell.ALIGN_LEFT);
		createNewCell(table, Color.WHITE, Color.WHITE, 1, dto.getOrder().getId() + "", font_Table_Data,
				PdfPCell.ALIGN_LEFT);

		createNewCell(table, Color.WHITE, Color.WHITE, 1, "أسم : ", font_Table_Data, PdfPCell.ALIGN_LEFT);
		createNewCell(table, Color.WHITE, Color.WHITE, 1, dto.getClient().getName(), font_Table_Data,
				PdfPCell.ALIGN_LEFT);

		createNewCell(table, Color.WHITE, Color.WHITE, 1, "العنوان : ", font_Table_Data, PdfPCell.ALIGN_LEFT);
		createNewCell(table, Color.WHITE, Color.WHITE, 1, dto.getClient().getAddress(), font_Table_Data,
				PdfPCell.ALIGN_LEFT);

		createNewCell(table, Color.WHITE, Color.WHITE, 1, "موبيل : ", font_Table_Data, PdfPCell.ALIGN_LEFT);
		createNewCell(table, Color.WHITE, Color.WHITE, 1, dto.getClient().getMobile1(), font_Table_Data,
				PdfPCell.ALIGN_LEFT);

		createNewCell(table, Color.WHITE, Color.WHITE, 1, "الكاشير : ", font_Table_Data, PdfPCell.ALIGN_LEFT);
		createNewCell(table, Color.WHITE, Color.WHITE, 1, dto.getUser().getUserName(), font_Table_Data,
				PdfPCell.ALIGN_LEFT);

		createNewCell(table, Color.WHITE, Color.WHITE, 1, "التاريخ : ", font_Table_Data, PdfPCell.ALIGN_LEFT);
		createNewCell(table, Color.WHITE, Color.WHITE, 1, new Date() + "", font_Table_Data, PdfPCell.ALIGN_LEFT);
		table.setWidthPercentage(150f);
		table.setWidths(new float[] { 2.5f, .5f, 2.5f, .5f });
		// table.setSpacingBefore(10);
		document.add(table);

	}

	private static void preparDetailHeaderData(Document document, CheuqeDTO dto, BaseFont bf)
			throws DocumentException, IOException {

		PdfPTable table = new PdfPTable(2);
		table.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
		table.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);

		Font font_Table_Data = new Font(bf, 6);
		font_Table_Data.setColor(Color.BLACK);

		createNewCell(table, Color.WHITE, Color.WHITE, 1, "رقم : ", font_Table_Data, PdfPCell.ALIGN_LEFT);
		createNewCell(table, Color.WHITE, Color.WHITE, 1, dto.getOrder().getId() + "", font_Table_Data,
				PdfPCell.ALIGN_LEFT);

		createNewCell(table, Color.WHITE, Color.WHITE, 1, "التاريخ : ", font_Table_Data, PdfPCell.ALIGN_LEFT);
		createNewCell(table, Color.WHITE, Color.WHITE, 1, new Date() + "", font_Table_Data, PdfPCell.ALIGN_LEFT);
		table.setWidthPercentage(150f);
		table.setWidths(new float[] { 2.5f, .5f });
		// table.setSpacingBefore(10);
		document.add(table);

	}

	private static void preparTableData(Document document, CheuqeDTO dto, BaseFont bf)
			throws DocumentException, IOException {

		PdfPTable table = new PdfPTable(4);
		table.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
		table.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);

		Font font_Table_Header = new Font(bf, 10);
		font_Table_Header.setColor(Color.BLACK);

		Font font_Table_Data = new Font(bf, 10);
		font_Table_Data.setColor(Color.BLACK);

		createNewCell(table, Color.GRAY, Color.BLACK, 5, "الصنف", font_Table_Header, PdfPCell.ALIGN_CENTER);
		createNewCell(table, Color.GRAY, Color.BLACK, 5, "العدد", font_Table_Header, PdfPCell.ALIGN_CENTER);
		createNewCell(table, Color.GRAY, Color.BLACK, 5, "السعر", font_Table_Header, PdfPCell.ALIGN_CENTER);
		createNewCell(table, Color.GRAY, Color.BLACK, 5, "الاجمالى", font_Table_Header, PdfPCell.ALIGN_CENTER);

		List<FoodItemDataDTO> list = dto.getFoodItemData();
		for (FoodItemDataDTO d : list) {

			createNewCell(table, Color.WHITE, Color.BLACK, 5, d.getFoodMenuName(), font_Table_Data,
					PdfPCell.ALIGN_CENTER);
			createNewCell(table, Color.WHITE, Color.BLACK, 5, d.getQty() + "", font_Table_Data, PdfPCell.ALIGN_CENTER);
			createNewCell(table, Color.WHITE, Color.BLACK, 5, d.getPrice() + "", font_Table_Data,
					PdfPCell.ALIGN_CENTER);
			createNewCell(table, Color.WHITE, Color.BLACK, 5, d.getQty() * d.getPrice() + "", font_Table_Data,
					PdfPCell.ALIGN_CENTER);

		}

		table.setWidthPercentage(150f);
		table.setWidths(new float[] { 1.5f, 1f, 1f, 3f });
//		table.setSpacingBefore(10);

		document.add(table);

	}

	private static void addNewLine(Document document, int count) {
		StringBuilder bild = new StringBuilder("");
		for (int i = 0; i < count; i++)
			bild.append("\n  ");

		Paragraph p = new Paragraph(bild.toString());

		document.add(p);
	}

	private static void preparFooter(Document document, CheuqeDTO dto, BaseFont bf) {
		PdfPTable table = new PdfPTable(2);
		table.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
		table.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
		table.setWidthPercentage(100f);

		Font font_Table_Footer_Company = new Font(bf, 6);
		font_Table_Footer_Company.setColor(Color.BLACK);

		Font font_Table_Footer = new Font(bf, 12);
		font_Table_Footer.setColor(Color.BLACK);

		createNewCell(table, Color.GRAY, Color.WHITE, 5, " الاجمالى : ", font_Table_Footer, PdfPCell.ALIGN_CENTER);
		createNewCell(table, Color.GRAY, Color.WHITE, 5, dto.getOrder().getTotalPrice() + "  جنيه", font_Table_Footer,
				PdfPCell.ALIGN_CENTER);

		createNewCell(table, Color.WHITE, Color.WHITE, 5, "شركة Semi;Colon للبرمجيات ", font_Table_Footer_Company,
				PdfPCell.ALIGN_CENTER);
		createNewCell(table, Color.WHITE, Color.WHITE, 5, "01276867578  -  01110562621", font_Table_Footer_Company,
				PdfPCell.ALIGN_CENTER);

		document.add(table);
	}

	private static void export(CheuqeDTO dto, String path) throws DocumentException, IOException {

		Document document = new Document(PageSize.A7);
		BaseFont bf = BaseFont.createFont("arial.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
		document.open();

		preparTitle(document, dto, bf);
		preparHeaderData(document, dto, bf);
		preparTableData(document, dto, bf);
		preparFooter(document, dto, bf);

		document.close();

		writer.close();

	}

	private static void exportDetail(CheuqeDTO dto, String path) throws DocumentException, IOException {

		Document document = new Document(PageSize.A7);
		BaseFont bf = BaseFont.createFont("arial.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
		document.open();

		preparDetailHeaderData(document, dto, bf);
		preparTableData(document, dto, bf);

		document.close();

		writer.close();

	}

	private static void createPrintJob(String path) {
		try {
			PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
			DocPrintJob printJob = printService.createPrintJob();
			PDDocument pdDocument;

			pdDocument = PDDocument.load(new File(path));

			PDFPageable pdfPageable = new PDFPageable(pdDocument);
			SimpleDoc doc = new SimpleDoc(pdfPageable, DocFlavor.SERVICE_FORMATTED.PAGEABLE, null);
			printJob.print(doc, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void printCheque(CheuqeDTO dto) throws DocumentException, PrintException {
		try {
			String pathChq = "chq\\Chq_" + "_" + dto.getOrder().getId() + ".pdf";
			String pathChqDetail = "chq\\Chq_" + "_" + dto.getOrder().getId() + "_D.pdf";

			export(dto, pathChq);
			createPrintJob(pathChq);
			exportDetail(dto, pathChqDetail);
			createPrintJob(pathChqDetail);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
