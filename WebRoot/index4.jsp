<%@ page language="java" contentType="image/jpeg;charset=GBK"
 import="java.awt.*, java.awt.image.*, com.sun.image.codec.jpeg.*"%>
<%
 // �ڃȴ��д���ͼ��
 int width  = 700;
 int height = 500;
 BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

 // ����ͼ��
 Graphics g = image.getGraphics();
 Graphics2D g2d = (Graphics2D) g;
 // ����ɫ
 g.setColor(new Color(240, 249, 255));

 g.fillRect(0, 0, width, height);
 // ������ɫ
 g.setColor(Color.BLACK);
 g.setFont(new Font("����", Font.PLAIN, 22));
 g.drawString("java��ͼ", 15, 25);
 int visit[] = new int[7];
 for (int i = 0; i < visit.length; i++) {
     visit[i] = 1 + (int) (Math.random() * 100);
 }

 String mongth[] = { "1��", "2��", "3��", "4��", "5��", "6��","7��" };

 g.setFont(new Font("����", Font.BOLD, 16));
 g.drawString("����", 20, 50);
 g.drawString("�·�", 550, 465);
 g.setFont(new Font("SanSSerif", Font.PLAIN, 12));

 int visitValue = 0;
 //������
 for (int i = 418; i > 0; i -= 38) {
     g.setColor(Color.BLACK);
     g.drawString("" + visitValue, 36, (i + 27));
     g.setColor(Color.LIGHT_GRAY);
     g.drawLine(80, (i + 27), 520, (i + 27));
     visitValue += 10;
 }
 g.setColor(Color.BLACK);
 g.drawLine(80, 40, 80, 445);
 g.drawLine(80, 445, 550, 445);
 int drawHigh[] = new int[mongth.length];
 int drawwidth[] = new int[mongth.length];

 //�۵�����
 for (int i = 0; i < mongth.length; i++) {
    drawHigh[i] = 445 - (int) (Math.ceil(visit[i] * 3.8));
  drawwidth[i] = 110 + i * 80;
   g.drawString(mongth[i], 110 + i * 80, 465);

 }

 //g2d.setXORMode(Color.WHITE);
 //���ߴ�ϸ
 g2d.setStroke(new BasicStroke(3.0f));
 //���ߵ���ɫ
 g2d.setPaint(Color.RED);
 //������
 g2d.drawPolyline(drawwidth, drawHigh, mongth.length);
 // ����ͼ��
 g.dispose();

 ServletOutputStream sos = response.getOutputStream();
 JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(sos);
 encoder.encode(image);
 
 out.clear();
 out = pageContext.pushBody();
%>