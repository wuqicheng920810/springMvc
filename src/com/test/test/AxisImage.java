package com.test.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class AxisImage {

    private static int MARGIN = 10;
    private static int AXIS_TEXT_INTERVAL = 3;
    private static Font FONT_TITLE = new Font("Dialog", Font.BOLD, 20);
    private static Font FONT_DEFAULT = new Font("Dialog", Font.PLAIN, 12);
    private static Color COLOR_TITLE = Color.BLACK;
    private static Color COLOR_AXIS = Color.LIGHT_GRAY;
    private static Color COLOR_LINE = Color.BLACK;
    private static Color COLOR_POINT = Color.BLUE;
    private static int AXIS_HEIGHT = 8;
    private static DecimalFormat format = new DecimalFormat("0.##");
    private int width = 831;
    private int height = 544;
    //--------------
    private int leftBorderWidth, rightBorderWidth, topBorderHeight, bottomBorderHeight;
    private int yAxisLength, xAxisLength;
    private double xMin, xMax, xInterval;
    private double yMin, yMax, yInterval;
    private int xSecant = 8, ySecant = 8;
    //--------------
    private String imageTitle = "Dynamic Curve";
    private String xTitle = "Production Year", yTitle = "Production Rate";
    private String filePath;
    private ArrayList<Double> dataX, dataY;

    public AxisImage(String filePath, ArrayList<Double> dataX, ArrayList<Double> dataY) {
        this.filePath = filePath;
//        this.dataX = dataX;
//        this.dataY = dataY;
        initData2();
    }

    public static boolean isEmpty(String str) {
        if (str == null || str.equals("")) {
            return true;
        }
        return false;
    }

    private void initData2() {
        dataX = new ArrayList<Double>();
        dataX.add(2009d);
        dataX.add(2010d);
        dataX.add(2011d);
        dataX.add(2012d);
        dataX.add(2013d);
        dataX.add(2014d);
        dataX.add(2015d);
        dataX.add(2016d);

        dataY = new ArrayList<Double>();
        dataY.add(1000d);
        dataY.add(1100d);
        dataY.add(1200d);
        dataY.add(1300d);
        dataY.add(1400d);
        dataY.add(1500d);
        dataY.add(1600d);
        dataY.add(1900d);
    }

    private void initData() {
        dataX = new ArrayList<Double>();
        dataX.add(1970d);
        dataX.add(1971d);
        dataX.add(1972d);
        dataX.add(1973d);
        dataX.add(1974d);
        dataX.add(1975d);
        dataX.add(1976d);
        dataX.add(1977d);
        dataX.add(1978d);
        dataX.add(1979d);
        dataX.add(1980d);
        dataX.add(1981d);
        dataX.add(1982d);
        dataX.add(1983d);
        dataX.add(1984d);
        dataX.add(1985d);
        dataX.add(1986d);
        dataX.add(1987d);
        dataX.add(1988d);
        dataX.add(1989d);
        dataX.add(1990d);
        dataX.add(1991d);
        dataX.add(1992d);
        dataX.add(1993d);
        dataX.add(1994d);
        dataX.add(1995d);
        dataX.add(1996d);
        dataX.add(1997d);
        dataX.add(1998d);
        dataX.add(1999d);
        dataX.add(2000d);
        dataX.add(2001d);
        dataX.add(2002d);
        dataX.add(2003d);

        dataY = new ArrayList<Double>();
        dataY.add(2792.15);
        dataY.add(5278.07);
        dataY.add(5865.31);
        dataY.add(6646.68);
        dataY.add(5616.4);
        dataY.add(4714.56);
        dataY.add(4053.61);
        dataY.add(3981.79);
        dataY.add(3984.92);
        dataY.add(3815.58);
        dataY.add(3819.5);
        dataY.add(3423.39);
        dataY.add(3174.36);
        dataY.add(3417.84);
        dataY.add(3067.86);
        dataY.add(2743.75);
        dataY.add(2383.52);
        dataY.add(2456.8);
        dataY.add(2295.45);
        dataY.add(2284.7);
        dataY.add(3069.38);
        dataY.add(2596.44);
        dataY.add(2293.16);
        dataY.add(2145.34);
        dataY.add(2177.07);
        dataY.add(2094.92);
        dataY.add(1746.51);
        dataY.add(2126.63);
        dataY.add(2796.62);
        dataY.add(2954.27);
        dataY.add(3026.86);
        dataY.add(3667.41);
        dataY.add(4937.66);
        dataY.add(6000.18);
    }

    public String generate() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) image.getGraphics();
        paintImage(g);
        return saveFile(filePath, image);
    }

    private void paintImage(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //填充背景
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.BLACK);


        calculateMaxMin();
        //计算并校正坐标轴的起始值及其分隔
        adjustMaxMin();

        //计算坐标轴及边界范围
        calculateAxisLength();

        drawImageTitle(g);
        drawXTitle(g);
        drawYTitle(g);
        drawXAxis(g);
        drawYAxis(g);

        drawPoints(g);
    }

    private void drawImageTitle(Graphics2D g0) {
        if (isEmpty(imageTitle)) {
            return;
        }
        Graphics2D g = (Graphics2D) g0.create();
        g.setColor(COLOR_TITLE);
        g.setFont(FONT_TITLE);

        TextLayout layout = new TextLayout(imageTitle, g.getFont(), g.getFontRenderContext());
        int x = (int) ((width - layout.getBounds().getWidth()) / 2);
        int y = MARGIN + (int) layout.getAscent();
        g.drawString(imageTitle, x, y);
        g.dispose();
    }

    private void drawXTitle(Graphics2D g0) {
        if (isEmpty(xTitle)) {
            return;
        }
        Graphics2D gx = (Graphics2D) g0.create();
        gx.setColor(COLOR_TITLE);
        gx.setFont(FONT_TITLE);

        TextLayout layout = new TextLayout(xTitle, gx.getFont(), gx.getFontRenderContext());
        int x = (int) (leftBorderWidth + (xAxisLength - layout.getBounds().getWidth()) / 2);
        int y = topBorderHeight + yAxisLength + bottomBorderHeight - MARGIN - (int) layout.getDescent();
        gx.drawString(xTitle, x, y);
        gx.dispose();
    }

    private void drawYTitle(Graphics2D g0) {
        if (yTitle == null || yTitle.trim().equals("")) {
            return;
        }

        Graphics2D gy = (Graphics2D) g0.create();
        gy.setFont(FONT_TITLE);
        gy.setColor(COLOR_TITLE);


        AffineTransform at = new AffineTransform();
        at.setToRotation((Math.PI) / 2.0 * 3.0);
        gy.transform(at);

        TextLayout layout = new TextLayout(yTitle, gy.getFont(), gy.getFontRenderContext());
        int x = (int) -(topBorderHeight + (yAxisLength + layout.getBounds().getWidth()) / 2);
        int y = MARGIN + (int) layout.getAscent();
        gy.drawString(yTitle, x, y);
        gy.dispose();
    }

    private void drawXAxis(Graphics2D g0) {
        Graphics2D gx = (Graphics2D) g0.create();

        //计算每个坐标轴分割线之间的间距
        int xInterLen = xAxisLength / xSecant;

        for (int i = 0; i < xSecant + 1; i++) {
            //画X轴上面一个一个小的分割线
            gx.setColor(COLOR_AXIS);
            gx.drawLine(leftBorderWidth + i * xInterLen,
                    topBorderHeight + yAxisLength,
                    leftBorderWidth + i * xInterLen,
                    topBorderHeight + yAxisLength + AXIS_HEIGHT);

            //画一个一个小的分割线所表示的值
            gx.setColor(COLOR_TITLE);
            String axisText = format.format(xMin + i * xInterval);
            TextLayout layout = new TextLayout(axisText, gx.getFont(), new FontRenderContext(null, false, false));
            gx.drawString(axisText,
                    leftBorderWidth + i * xInterLen - (int) layout.getBounds().getWidth() / 2,
                    topBorderHeight + yAxisLength + AXIS_HEIGHT + layout.getAscent() + AXIS_TEXT_INTERVAL);
        }

        //画X轴方向上下两条轴线
        gx.setColor(COLOR_LINE);
        gx.drawLine(leftBorderWidth, topBorderHeight, leftBorderWidth + xAxisLength, topBorderHeight);
        gx.drawLine(leftBorderWidth, topBorderHeight + yAxisLength, leftBorderWidth + xAxisLength, topBorderHeight + yAxisLength);
        gx.dispose();
    }

    private void drawYAxis(Graphics2D g0) {
        Graphics2D gy = (Graphics2D) g0.create();
        //计算每个坐标轴分割线之间的间距
        int yInterLen = yAxisLength / ySecant;

        for (int i = 0; i < ySecant + 1; i++) {
            //画Y轴上面一个一个小的分割线
            gy.setColor(COLOR_AXIS);
            gy.drawLine(leftBorderWidth - AXIS_HEIGHT,
                    (int) (topBorderHeight + yAxisLength - i * yInterLen),
                    leftBorderWidth,
                    (int) (topBorderHeight + yAxisLength - i * yInterLen));

            //画Y轴上面坐标轴中间的水平的分割线
            if (i != 0 && i != ySecant) {
                gy.drawLine(leftBorderWidth,
                        (int) (topBorderHeight + yAxisLength - i * yInterLen),
                        leftBorderWidth + xAxisLength,
                        (int) (topBorderHeight + yAxisLength - i * yInterLen));
            }

            //画一个一个小的分割线所表示的值
            gy.setColor(COLOR_TITLE);
            gy.setFont(FONT_DEFAULT);
            String axisText = format.format(yMax - i * yInterval);
            TextLayout layout = new TextLayout(axisText, gy.getFont(), new FontRenderContext(null, false, false));
            gy.drawString(axisText,
                    leftBorderWidth - AXIS_HEIGHT - AXIS_TEXT_INTERVAL - (int) layout.getBounds().getWidth(),
                    topBorderHeight + i * yInterLen + (int) layout.getDescent());
        }

        //画Y轴方向左右两条轴线
        gy.setColor(COLOR_LINE);
        gy.drawLine(leftBorderWidth, topBorderHeight, leftBorderWidth, topBorderHeight + yAxisLength);
        gy.drawLine(leftBorderWidth + xAxisLength, topBorderHeight,
                leftBorderWidth + xAxisLength, topBorderHeight + yAxisLength);
        gy.dispose();
    }

    private void drawPoints(Graphics2D g0) {
        Graphics2D g = (Graphics2D) g0.create();
        double xScope = xMax - xMin;
        double yScope = yMax - yMin;

        int prevX = -1;
        int prevY = -1;
        g.setColor(COLOR_POINT);
        for (int i = 0; i < dataX.size(); i++) {
            Double xValue = dataX.get(i);
            Double yValue = dataY.get(i);

            if (xValue > xMax || xValue < xMin
                    || yValue > yMax || yValue < yMin) {
                continue;
            }

            int x = leftBorderWidth + (int) ((xValue - xMin) / xScope * xAxisLength);
            int y = topBorderHeight + yAxisLength - (int) ((yValue - yMin) / yScope * yAxisLength);
            g.fillOval(x - 5, y - 5, 10, 10);

            if (i != 0) {
                g.drawLine(x, y, prevX, prevY);
            }
            prevX = x;
            prevY = y;
        }
    }

    private String saveFile(String filePath, BufferedImage image) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(filePath));
            ImageIO.write(image, "jpg", fos);
            fos.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
            return "";
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return filePath;
    }

    private void calculateMaxMin() {
        int length = dataX.size();
        if (length != 0) {
            xMin = dataX.get(0);
            xMax = dataX.get(0);
            yMin = dataY.get(0);
            yMax = dataY.get(0);

            for (int i = 0; i < length; i++) {
                double xValue = dataX.get(i);
                xMin = Math.min(xMin, xValue);
                xMax = Math.max(xMax, xValue);

                double yValue = dataY.get(i);
                yMin = Math.min(yMin, yValue);
                yMax = Math.max(yMax, yValue);
            }
        }
    }

    private void adjustMaxMin() {
//        System.out.println("xMax = " + xMax + ", xMin = " + xMin + ", xInterval = " + xInterval + ", xSecant = " + xSecant);
        AxisImage.AxisAdjust adjustX = new AxisImage.AxisAdjust(xMax, xMin, xSecant);
        xMax = adjustX.getMax();
        xMin = adjustX.getMin();
        xInterval = adjustX.getInterval();
        xSecant = adjustX.getSecant();
//        System.out.println("xMax = " + xMax + ", xMin = " + xMin + ", xInterval = " + xInterval + ", xSecant = " + xSecant);

//        System.out.println("yMax = " + yMax + ", yMin = " + yMin + ", yInterval = " + yInterval + ", ySecant = " + ySecant);
        AxisImage.AxisAdjust adjustY = new AxisImage.AxisAdjust(yMax, yMin, ySecant);
        yMax = adjustY.getMax();
        yMin = adjustY.getMin();
        yInterval = adjustY.getInterval();
        ySecant = adjustY.getSecant();
//        System.out.println("yMax = " + yMax + ", yMin = " + yMin + ", yInterval = " + yInterval + ", ySecant = " + ySecant);
    }

    private void calculateAxisLength() {
        //初步计算边界里坐标轴的距离
        //四周空白+坐标轴标题高度，坐标轴标题和图片标题高度一致
        TextLayout layout1 = new TextLayout(xTitle, FONT_TITLE, new FontRenderContext(null, false, false));
        int borderWidth1 = (int) Math.ceil(layout1.getAscent() + layout1.getDescent()) + MARGIN * 2;
        leftBorderWidth = borderWidth1;
        rightBorderWidth = borderWidth1;
        topBorderHeight = borderWidth1;
        bottomBorderHeight = borderWidth1;

        //下方再加上坐标轴上的各小分割线上值的高度
        TextLayout layout2 = new TextLayout("1980", FONT_DEFAULT, new FontRenderContext(null, false, false));
        int borderWidth2 = (int) Math.ceil(layout2.getAscent() + layout2.getDescent()) + AXIS_TEXT_INTERVAL * 2;
        bottomBorderHeight += borderWidth2;


        //左方要加上各个数字的最大宽度
        //找到最宽的数字，然后计算其高度
        String maxStr = format.format(yMin);
        for (int i = 1; i < ySecant + 1; i++) {
            String str = format.format(yMin + i * yInterval);
            if (str.length() > maxStr.length()) {
                maxStr = str;
            }
        }
        TextLayout layout3 = new TextLayout(maxStr, FONT_DEFAULT, new FontRenderContext(null, false, false));
        int borderWidth3 = (int) Math.ceil(layout3.getBounds().getWidth()) + AXIS_TEXT_INTERVAL * 2;
        leftBorderWidth += borderWidth3;


        //初步计算坐标轴的长度
        yAxisLength = height - topBorderHeight - bottomBorderHeight;
        xAxisLength = width - leftBorderWidth - rightBorderWidth;

        //对坐标轴和边界数字进行校正
        int lessX = xAxisLength % xSecant;
        xAxisLength -= lessX;
        bottomBorderHeight += lessX;

        int lessY = yAxisLength % ySecant;
        yAxisLength -= lessY;
        rightBorderWidth += lessY;
    }

    public static void main(String[] args) {
        AxisImage axisImage = new AxisImage("d:/1.jpg", new ArrayList<Double>(), new ArrayList<Double>());
        System.out.println(axisImage.generate());
    }

    private class AxisAdjust {

        private double max;
        private double min;
        private int secant;
        private double interval;

        public AxisAdjust(double max, double min, int groupNo) {
            this.max = max;
            this.min = min;
            this.secant = groupNo;
            adjust();
        }

        public double getInterval() {
            return interval;
        }

        public double getMax() {
            return max;
        }

        public double getMin() {
            return min;
        }

        public int getSecant() {
            return secant;
        }

        private void adjust2() {
            //1 计算间隔大小
            interval = (max - min) / secant;
//        System.out.println("interval = " + interval);

            //2 看看是10的多少次方（取整），同时计算出10的当前次方的一半作为标准值用于校正
            double m10 = Math.floor(Math.log10(interval));
            double standardValue = 5 * Math.pow(10, m10 - 1);
//        System.out.println("m10 = " + m10 + ", standardValue = " + standardValue);

            //3 间隔值取出最高位剩下的余数
            double yInterval1 = interval % Math.pow(10, Math.floor(m10));
//        System.out.println("interval1 = " + yInterval1);

            //4 对interval的值进行校正
            //比如m10=2，那么standardValue = 50
            //对于余数：
            //(a)当大于50时，在50-100的区间内舍入（75以下舍到50，75及其以上入到100）
            //(b)当小于50是，在0-50的区间内舍入（25以下舍到0，25及其以上入到50）
            //(c)同时，如果是舍去，secant间隔数加1
            double d;
            if (yInterval1 > standardValue) {
//            System.out.println(">");
                d = Math.round((yInterval1 - standardValue) * 2 / Math.pow(10, m10));
                if (d == 0) {
                    secant += 1;
                    interval = (Math.floor(interval / Math.pow(10, Math.floor(m10))) + 0.5) * Math.pow(10, m10);
                } else {
                    interval = (Math.floor(interval / Math.pow(10, Math.floor(m10))) + 1) * Math.pow(10, m10);
                }
            } else {
//            System.out.println("<");
                d = Math.round(yInterval1 * 2 / Math.pow(10, m10));
                if (d == 0) {
                    secant += 1;
                    interval = Math.floor(interval / Math.pow(10, m10)) * Math.pow(10, m10);
                } else {
                    interval = (Math.floor(interval / Math.pow(10, m10)) + 0.5) * Math.pow(10, m10);
                }
            }
//        System.out.println("d = " + d);
            System.out.println("interval = " + interval);

            //5 根据新计算的interval重新校正min，max的值
//            min = Math.floor(min / interval) * interval;
//            max = Math.ceil(max / interval) * interval;
            max = min + interval * secant;
            System.out.println("max = " + max + ", min = " + min);
        }

        private void adjust() {
            //1 初步计算大概区分多少个区间，如果区间大于10，向上取一半
            double scope = max - min;
            secant = (int) (scope / (5 * Math.pow(10, Math.floor(Math.log10(scope)) - 1)));
//            System.out.println("secant = " + secant);
            if (secant > 10) {
                secant = (secant + 1) / 2;
            }

            //2 计算间隔大小
            interval = (max - min) / secant;
//            System.out.println("interval = " + interval);

            //3 看看是10的多少次方（取整），同时计算出10的当前次方的一半作为标准值用于校正
            double m10 = Math.floor(Math.log10(interval));
            double standardValue = 5 * Math.pow(10, m10 - 1);
//            System.out.println("m10 = " + m10 + ", standardValue = " + standardValue);

            //4 间隔值取出最高位剩下的余数
            double yInterval1 = 0;
            if (m10 > 0) {
                yInterval1 = interval % Math.pow(10, Math.floor(m10));
            } else {
                double temp = Math.pow(10, -m10);
                yInterval1 = (interval * temp) % (Math.pow(10, Math.floor(m10)) * temp) / temp;
            }
//            System.out.println("interval1 = " + yInterval1);

            //5 对interval的值进行校正
            //比如m10=2，那么standardValue = 50
            //对于余数：
            //(a)当大于50时，在50-100的区间内舍入（75以下舍到50，75及其以上入到100）
            //(b)当小于50是，在0-50的区间内舍入（25以下舍到0，25及其以上入到50）
            //(c)同时，如果是舍去，secant间隔数加1
            double d = 0;
            if (yInterval1 == 0 || yInterval1 == standardValue) {
            } else if (yInterval1 > standardValue) {
//                System.out.println(">");
                d = Math.round((yInterval1 - standardValue) * 2 / Math.pow(10, m10));
                if (d == 0) {
                    secant++;
                    interval = (Math.floor(interval / Math.pow(10, Math.floor(m10))) + 0.5) * Math.pow(10, m10);
                } else {
                    interval = (Math.floor(interval / Math.pow(10, Math.floor(m10))) + 1) * Math.pow(10, m10);
                }
            } else {
//                System.out.println("<");
                d = Math.round(yInterval1 * 2 / Math.pow(10, m10));
                if (d == 0) {
                    secant++;
                    interval = Math.floor(interval / Math.pow(10, m10)) * Math.pow(10, m10);
                } else {
                    interval = (Math.floor(interval / Math.pow(10, m10)) + 0.5) * Math.pow(10, m10);
                }
            }
//            System.out.println("d = " + d);
//            System.out.println("interval = " + interval);

            //6 根据新计算的interval重新校正min、max的值
            //  同时需要验证所划分间隔总数是否能将原始数据全部包含，否则再添加一个间隔区间
            min = Math.floor(min / interval) * interval;
            max = Math.ceil(max / interval) * interval;
            if (interval * secant < scope) {
                secant++;
            }
//            System.out.println("max = " + max + ", min = " + min);
        }
    }
}
