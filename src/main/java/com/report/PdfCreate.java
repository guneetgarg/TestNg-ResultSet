package com.report;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfCreate {
	static Document document;
	PdfWriter writer;

	public PdfCreate(String fileName) {
		document = new Document();
		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		document.open();
	}

	public void titlePdf(String val) {
		try {
			Font font1 = new Font(Font.FontFamily.COURIER, 20, Font.UNDERLINE);
			Chunk chunk = new Chunk(val, font1);
			Paragraph para1 = new Paragraph(chunk);
			para1.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(para1);
			Paragraph p = new Paragraph("  ", new Font(FontFamily.HELVETICA, 10));
			document.add(p);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public void addNewLine(Integer count) {
		try {
			for (int i = 0; i < count; i++) {
				document.add(new Phrase("\n"));
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public void newPage() {
		document.newPage();
	}

	public void createTable(LinkedHashMap<String, String> hmap) {

		try {
			document.add(createFirstTable(hmap));
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

	public static PdfPTable createFirstTable(LinkedHashMap<String, String> hmap) {
		// a table with three columns
		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100);
		table.getDefaultCell().setBorder(0);

		// the cell object
		PdfPCell cell;
		BaseColor color = WebColors.getRGBColor("#84CF96");

		// we add a cell with colspan 3
		cell = new PdfPCell(new Phrase("Statistics"));
		cell.setColspan(4);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBackgroundColor(color);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Passed"));
		cell.setColspan(1);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBackgroundColor(WebColors.getRGBColor("#C6E7CE"));
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Failed"));
		cell.setColspan(1);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBackgroundColor(WebColors.getRGBColor("#C6E7CE"));
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Skipped"));
		cell.setColspan(1);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBackgroundColor(WebColors.getRGBColor("#C6E7CE"));
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Percent"));
		cell.setColspan(1);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBackgroundColor(WebColors.getRGBColor("#C6E7CE"));
		table.addCell(cell);

		// table.addCell("Passed");
		// table.addCell("Skipped");
		// table.addCell("Failed");
		// table.addCell("Percent");

		// table.addCell(hmap.get("Passed"));
		// table.addCell(hmap.get("Skipped"));
		// table.addCell(hmap.get("Failed"));
		float aa = (Float.parseFloat(hmap.get("Passed")) / Float.parseFloat(hmap.get("Total"))) * 100;
		// table.addCell(String.valueOf(aa));

		cell = new PdfPCell(new Phrase(hmap.get("Passed")));
		cell.setColspan(1);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBackgroundColor(WebColors.getRGBColor("#CEFFCE"));
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(hmap.get("Failed")));
		cell.setColspan(1);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBackgroundColor(WebColors.getRGBColor("#CEFFCE"));
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(hmap.get("Skipped")));
		cell.setColspan(1);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBackgroundColor(WebColors.getRGBColor("#CEFFCE"));
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(String.valueOf(aa)));
		cell.setColspan(1);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBackgroundColor(WebColors.getRGBColor("#CEFFCE"));
		table.addCell(cell);

		return table;
	}

	public void addImage(String imagePath) {
		Image image1 = null;
		try {
			image1 = Image.getInstance(imagePath);
		} catch (BadElementException | IOException e) {
			e.printStackTrace();
		}
		try {
			document.add(image1);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public void closeDocument() {
		document.close();
	}

	public void writePassData(LinkedList<String> linkedList) {

		// a table with three columns
		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100);
		table.getDefaultCell().setBorder(0);

		// the cell object
		PdfPCell cell;
		BaseColor color = WebColors.getRGBColor("#009A31");

		// we add a cell with colspan 3
		cell = new PdfPCell(new Phrase("Passed"));
		cell.setColspan(4);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBackgroundColor(color);
		table.addCell(cell);

		table.addCell(tableHeading("Time"));

		table.addCell(tableHeading("Test Class Name"));
		table.addCell(tableHeading("Script Name"));

		table.addCell(tableHeading("Description"));

		// PdfPTable table = new PdfPTable(4);
		// table.setWidthPercentage(100);
		table.getDefaultCell().setBorder(2);

		addListToCell(linkedList, table);

		addTableToDocument(table);
	}

	public PdfPCell tableHeading(String str) {
		PdfPCell cell;
		cell = new PdfPCell(new Phrase(str));
		cell.setColspan(1);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBackgroundColor(WebColors.getRGBColor("#84CF96"));
		return cell;
	}

	public PdfPCell addListToCell(LinkedList<String> linkedList, PdfPTable table) {
		PdfPCell cell = null;
		int j = 0;
		System.out.println(linkedList.size());
		Iterator<String> itr = linkedList.iterator();
		while (itr.hasNext()) {
			cell = new PdfPCell(new Phrase(itr.next()));
			cell.setColspan(1);
			cell.setBorder(1);
			if (j < 4) {
				cell.setBackgroundColor(WebColors.getRGBColor("#C6E7CE"));
				j++;
			} else if (j > 4) {
				cell.setBackgroundColor(WebColors.getRGBColor("#CEFFCE"));
				j--;
			}
			if (j == 4) {
				j = 9;
			}
			if (j == 5) {
				j = 0;
			}
			table.addCell(cell);

		}
		return cell;

	}

	public void addTableToDocument(PdfPTable table) {
		try {
			document.add(table);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public void writeFailData(LinkedList<String> linkedList) {
		// a table with three columns
		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100);
		table.getDefaultCell().setBorder(0);

		// the cell object
		PdfPCell cell;

		// we add a cell with colspan 3
		cell = new PdfPCell(new Phrase("Failed"));
		cell.setColspan(4);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBackgroundColor(BaseColor.GRAY);
		table.addCell(cell);

		table.addCell(tableHeading("Time"));
		table.addCell(tableHeading("Test Class Name"));
		table.addCell(tableHeading("Script Name"));
		table.addCell(tableHeading("Description"));

		table.getDefaultCell().setBorder(2);
		addListToCell(linkedList, table);

		addTableToDocument(table);

	}

	public void writeSkipData(LinkedList<String> linkedList) {

		// a table with three columns
		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100);
		table.getDefaultCell().setBorder(0);

		// the cell object
		PdfPCell cell;

		// we add a cell with colspan 3
		cell = new PdfPCell(new Phrase("Skipped"));
		cell.setColspan(4);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBackgroundColor(BaseColor.RED);
		table.addCell(cell);

		table.addCell(tableHeading("Time"));
		table.addCell(tableHeading("Test Class Name"));
		table.addCell(tableHeading("Script Name"));
		table.addCell(tableHeading("Description"));

		table.getDefaultCell().setBorder(2);

		addListToCell(linkedList, table);
		addTableToDocument(table);

	}

}