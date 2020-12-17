package com.restaurant.utils;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.restaurant.model.dto.CheuqeDTO;
import com.restaurant.model.eo.OrderItems;
import com.restaurant.model.eo.Orders;

public class PrintCheque extends JFrame {

	CheuqeDTO cheq = new CheuqeDTO();

	Double totalAmount = 0.0;
	Double cash = 0.0;
	Double balance = 0.0;
	Double bHeight = 0.0;

	ArrayList<String> itemName = new ArrayList<>();
	ArrayList<String> quantity = new ArrayList<>();
	ArrayList<String> itemPrice = new ArrayList<>();
	ArrayList<String> subtotal = new ArrayList<>();

	public PrintCheque(CheuqeDTO cheq) {
		super();
		this.cheq = cheq;
	}
	public static void main(String[] args) {
		
	}

	public void printAction() {
		bHeight = Double.valueOf(cheq.getFoodItemData().size());
		// JOptionPane.showMessageDialog(rootPane, bHeight);

		PrinterJob pj = PrinterJob.getPrinterJob();
		pj.setPrintable(new BillPrintable(), getPageFormat(pj));

		try {
			pj.print();

		} catch (PrinterException ex) {
			ex.printStackTrace();
		}
	}

	public PageFormat getPageFormat(PrinterJob pj) {

		PageFormat pf = pj.defaultPage();
		Paper paper = pf.getPaper();

		double bodyHeight = bHeight;
		double headerHeight = 5.0;
		double footerHeight = 5.0;
		double width = cm_to_pp(8);
		double height = cm_to_pp(headerHeight + bodyHeight + footerHeight);
		paper.setSize(width, height);
		paper.setImageableArea(0, 10, width, height - cm_to_pp(1));

		pf.setOrientation(PageFormat.PORTRAIT);
		pf.setPaper(paper);

		return pf;
	}

	protected static double cm_to_pp(double cm) {
		return toPPI(cm * 0.393600787);
	}

	protected static double toPPI(double inch) {
		return inch * 72d;
	}

	/**
	 * @param args the command line arguments
	 */
	public class BillPrintable implements Printable {

		public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
			int r = cheq.getFoodItemData().size();

			ImageIcon icon = new ImageIcon("resources/images/logo.png");
			int result = NO_SUCH_PAGE;
			if (pageIndex == 0) {
				
				Graphics2D g2d = (Graphics2D) graphics;
			
				double width = pageFormat.getImageableWidth();
				g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

				try {
					int y = 20;
					int yShift = 10;
					int headerRectHeight = 15;

					g2d.setFont(new Font("Arail", Font.PLAIN, 9));
					g2d.drawImage(icon.getImage(), 50, 20, 90, 30, rootPane);
					y += yShift;
					g2d.drawString(cheq.getOrder().getId() +" :رقم الفاتورء", 12, y);
					y += yShift + 30;
					g2d.drawString("_____________________________________", 12, y);
					y += yShift;
					g2d.drawString(cheq.getClient().getName() + " :ألاسم ", 12, y);
					y += yShift;
					g2d.drawString(cheq.getClient().getAddress() + " :العنوان ", 12, y);
					y += yShift;
					g2d.drawString(cheq.getClient().getMobile1() + " : التليفون  ", 12, y);
					y += yShift;
					g2d.drawString(cheq.getClient().getNotes() + " : ملاحظات ", 12, y);
					y += yShift;
					g2d.drawString(cheq.getUser().getFullName() + " : الكاشير ", 12, y);
					y += yShift;
					g2d.drawString(new Date() + " : الوقت ", 12, y);
					y += yShift;
					g2d.drawString(cheq.getOrder().getClientId() == null ? "تيك اوى" : "دليفرى"+ " : النوع ", 12, y);
					y += yShift;
					g2d.drawString("_____________________________________", 12, y);
					y += headerRectHeight;

					g2d.drawString("|     الصنف        |  العدد   |  السعر  | الاجمالى |", 10, y);
					y += yShift;
					g2d.drawString("_____________________________________", 10, y);
					y += headerRectHeight;

					for (int s = 0; s < cheq.getFoodItemData().size(); s++) {
						g2d.drawString(""+ cheq.getFoodItemData().get(s).getFoodMenuName() +" | "+ cheq.getFoodItemData().get(s).getQty() +" |   | الاجمالى |", 10, y);
						y += yShift;
						g2d.drawString("      " + quantity.get(s) + " * " + itemPrice.get(s), 10, y);
						g2d.drawString(subtotal.get(s), 160, y);
						y += yShift;

					}

					g2d.drawString("-------------------------------------", 10, y);
					y += yShift;
					g2d.drawString(" Total amount:               " + "T_123" + "   ", 10, y);
					y += yShift;
					g2d.drawString("-------------------------------------", 10, y);
					y += yShift;
					g2d.drawString(" Cash      :                 " + "T_dedo" + "   ", 10, y);
					y += yShift;
					g2d.drawString("-------------------------------------", 10, y);
					y += yShift;
					g2d.drawString(" Balance   :                 " + "T_1234" + "   ", 10, y);
					y += yShift;

					g2d.drawString("*************", 10, y);
					y += yShift;
					g2d.drawString("       THANK YOU COME AGAIN            ", 10, y);
					y += yShift;
					g2d.drawString("*************", 10, y);
					y += yShift;
					g2d.drawString("       SOFTWARE BY:CODEGUID          ", 10, y);
					y += yShift;
					g2d.drawString("   CONTACT: contact@codeguid.com       ", 10, y);
					y += yShift;

				} catch (Exception e) {
					e.printStackTrace();
				}

				result = PAGE_EXISTS;
			}
			return result;
		}
	}

}