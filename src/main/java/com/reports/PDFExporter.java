package com.reports;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
import com.restaurant.utils.JavaUtils;

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

	private static void preparTitle(Document document, CheuqeDTO dto, BaseFont bf, boolean isDetail) {
		if (!isDetail) {
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
	}

	private static void preparHeaderData(Document document, CheuqeDTO dto, BaseFont bf, boolean isDetail)
			throws DocumentException, IOException {

		PdfPTable table = new PdfPTable(2);
		table.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
		table.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);

		Font font_Table_Data = new Font(bf, 8);
		font_Table_Data.setColor(Color.BLACK);

		createNewCell(table, Color.WHITE, Color.WHITE, 1, "رقم : ", font_Table_Data, PdfPCell.ALIGN_LEFT);
		createNewCell(table, Color.WHITE, Color.WHITE, 1, dto.getOrder().getId() + "", font_Table_Data,
				PdfPCell.ALIGN_LEFT);
		if (!isDetail) {
			if (dto.getClient().getName() != null) {
				createNewCell(table, Color.WHITE, Color.WHITE, 1, "أسم : ", font_Table_Data, PdfPCell.ALIGN_LEFT);
				createNewCell(table, Color.WHITE, Color.WHITE, 1, dto.getClient().getName(), font_Table_Data,
						PdfPCell.ALIGN_LEFT);

				createNewCell(table, Color.WHITE, Color.WHITE, 1, "العنوان : ", font_Table_Data, PdfPCell.ALIGN_LEFT);
				createNewCell(table, Color.WHITE, Color.WHITE, 1, dto.getClient().getAddress(), font_Table_Data,
						PdfPCell.ALIGN_LEFT);

				createNewCell(table, Color.WHITE, Color.WHITE, 1, "موبيل : ", font_Table_Data, PdfPCell.ALIGN_LEFT);
				createNewCell(table, Color.WHITE, Color.WHITE, 1, dto.getClient().getMobile1(), font_Table_Data,
						PdfPCell.ALIGN_LEFT);
			}
			createNewCell(table, Color.WHITE, Color.WHITE, 1, "الكاشير : ", font_Table_Data, PdfPCell.ALIGN_LEFT);
			createNewCell(table, Color.WHITE, Color.WHITE, 1, dto.getUser().getUserName(), font_Table_Data,
					PdfPCell.ALIGN_LEFT);
		}
		createNewCell(table, Color.WHITE, Color.WHITE, 1, "التاريخ : ", font_Table_Data, PdfPCell.ALIGN_LEFT);
		createNewCell(table, Color.WHITE, Color.WHITE, 1, JavaUtils.getCurrentDateAsString(), font_Table_Data,
				PdfPCell.ALIGN_LEFT);
		table.setWidthPercentage(150f);
		table.setWidths(new float[] { 2.5f, .5f });
		// table.setSpacingBefore(10);
		document.add(table);

	}

	private static void preparTableData(Document document, CheuqeDTO dto, BaseFont bf, boolean isDetail)
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
			if (d.getFoodSizeId().equals(5L))
				createNewCell(table, Color.WHITE, Color.BLACK, 5, d.getFoodMenuName(), font_Table_Data,
						PdfPCell.ALIGN_CENTER);
			else
				createNewCell(table, Color.WHITE, Color.BLACK, 5, d.getFoodMenuName() + " ( " + d.getSize() + " ) ",
						font_Table_Data, PdfPCell.ALIGN_CENTER);

			createNewCell(table, Color.WHITE, Color.BLACK, 5, d.getQty() + "", font_Table_Data, PdfPCell.ALIGN_CENTER);
			createNewCell(table, Color.WHITE, Color.BLACK, 5, d.getPrice() + "", font_Table_Data,
					PdfPCell.ALIGN_CENTER);
			createNewCell(table, Color.WHITE, Color.BLACK, 5, d.getQty() * d.getPrice() + "", font_Table_Data,
					PdfPCell.ALIGN_CENTER);

		}

		if (!isDetail) {
			createNewCell(table, Color.GRAY, Color.GRAY, 5, "السعر الاجمالى", font_Table_Header, PdfPCell.ALIGN_CENTER);
			createNewCell(table, Color.GRAY, Color.GRAY, 5, "  ", font_Table_Header, PdfPCell.ALIGN_CENTER);
			createNewCell(table, Color.GRAY, Color.GRAY, 5, "  ", font_Table_Header, PdfPCell.ALIGN_CENTER);
			createNewCell(table, Color.GRAY, Color.GRAY, 5, dto.getOrder().getTotalPrice() + "ج ", font_Table_Header,
					PdfPCell.ALIGN_CENTER);
			addCompanyFooter(table, bf);
		}
		table.setWidthPercentage(150f);
		table.setWidths(new float[] { 1.5f, 1f, 1f, 3f });

		document.add(table);

	}

	private static void addCompanyFooter(PdfPTable table, BaseFont bf) {

		Font font_Company = new Font(bf, 6);
		font_Company.setColor(Color.BLACK);

		createNewCell(table, Color.WHITE, Color.WHITE, 1, "شركة Semi;Colon للبرمجيات", font_Company,
				PdfPCell.ALIGN_CENTER);

		createNewCell(table, Color.WHITE, Color.WHITE, 1, "", font_Company, PdfPCell.ALIGN_CENTER);
		createNewCell(table, Color.WHITE, Color.WHITE, 1, "", font_Company, PdfPCell.ALIGN_CENTER);
		createNewCell(table, Color.WHITE, Color.WHITE, 1, "", font_Company, PdfPCell.ALIGN_CENTER);

		createNewCell(table, Color.WHITE, Color.WHITE, 1, "01276867578 - 01110562621", font_Company,
				PdfPCell.ALIGN_CENTER);

		createNewCell(table, Color.WHITE, Color.WHITE, 1, "", font_Company, PdfPCell.ALIGN_CENTER);
		createNewCell(table, Color.WHITE, Color.WHITE, 1, "", font_Company, PdfPCell.ALIGN_CENTER);
		createNewCell(table, Color.WHITE, Color.WHITE, 1, "", font_Company, PdfPCell.ALIGN_CENTER);
	}

	private static void export(CheuqeDTO dto, String path, boolean isDetail) throws DocumentException, IOException {

		Document document = new Document(PageSize.A7);
		BaseFont bf = BaseFont.createFont("C:\\fonts\\arial.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
		document.open();

		preparTitle(document, dto, bf, isDetail);
		preparHeaderData(document, dto, bf, isDetail);
		preparTableData(document, dto, bf, isDetail);

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
			String pathChq = "C:\\chq\\Chq_" + "_" + dto.getOrder().getId() + ".pdf";
			String pathChqDetail = "C:\\chq\\Chq_" + "_" + dto.getOrder().getId() + "_D.pdf";

			export(dto, pathChq, false);
			createPrintJob(pathChq);
			export(dto, pathChqDetail, true);
			createPrintJob(pathChqDetail);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
