package com.report;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.text.DecimalFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleInsets;

public class Graph {
	public static void theme(JFreeChart chart) {
		String fontName = "Lucida Sans";
		StandardChartTheme theme = (StandardChartTheme) org.jfree.chart.StandardChartTheme.createJFreeTheme();
		theme.setTitlePaint(Color.decode("#4572a7"));
		theme.setExtraLargeFont(new Font(fontName, Font.PLAIN, 16)); // title
		theme.setLargeFont(new Font(fontName, Font.BOLD, 15)); // axis-title
		theme.setRegularFont(new Font(fontName, Font.PLAIN, 11));
		theme.setRangeGridlinePaint(Color.decode("#C0C0C0"));
		theme.setPlotBackgroundPaint(Color.white);
		theme.setChartBackgroundPaint(Color.white);
		theme.setGridBandPaint(Color.red);
		theme.setAxisOffset(new RectangleInsets(0, 0, 0, 0));
		theme.setBarPainter(new StandardBarPainter());
		theme.setAxisLabelPaint(Color.decode("#666666"));
		theme.apply(chart);
		chart.setTextAntiAlias(true);
		chart.setAntiAlias(true);
	}

	public void generateChart(DefaultPieDataset dataSet) {
		try {
			JFreeChart chart = ChartFactory.createPieChart("", dataSet, true, true, false);
			theme(chart);

			PiePlot plot = (PiePlot) chart.getPlot();
			plot.setForegroundAlpha(0.6f);
			plot.setCircular(true);
			plot.setSectionPaint("Passed", Color.decode("#33cc33"));
			plot.setSectionPaint("Failed", Color.decode("#8080ff"));
			plot.setSectionPaint("Skipped", Color.decode("#b35900"));
			Color transparent = new Color(0.0f, 0.0f, 0.0f, 0.0f);
			plot.setLabelOutlinePaint(transparent);
			plot.setLabelBackgroundPaint(transparent);
			plot.setLabelShadowPaint(transparent);
			plot.setLabelLinkPaint(Color.GRAY);
			Font font = new Font("SansSerif", Font.PLAIN, 10);
			plot.setLabelFont(font);

			PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator("{0}: {1} ({2})",
					new DecimalFormat("0"), new DecimalFormat("0%"));
			plot.setLabelGenerator(gen);
			ChartUtilities.saveChartAsPNG(new File("chart.png"), chart, 500, 200);
		} catch (Exception e) {
			e.printStackTrace(System.err);
			System.exit(-1);
		}
	}
}
