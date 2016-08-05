package com.test.test;



import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.axis.ValueAxis;  
import org.jfree.chart.plot.XYPlot;  
import org.jfree.data.time.Millisecond;  
import org.jfree.data.time.TimeSeries;  
import org.jfree.data.time.TimeSeriesCollection;  

  
//Test.java  
import java.awt.BorderLayout;  
import java.awt.event.WindowAdapter;  
import java.awt.event.WindowEvent;  
import javax.swing.JFrame;  
  
public class test  
{  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args)  
    {  
    JFrame frame=new JFrame("Test Chart");  
    RealTimeChart rtcp=new RealTimeChart("Random Data","随机数","数值");  
    frame.getContentPane().add(rtcp,new BorderLayout().CENTER);  
    frame.pack();  
    frame.setVisible(true);  
    (new Thread(rtcp)).start();  
    frame.addWindowListener(new WindowAdapter()   
    {  
        public void windowClosing(WindowEvent windowevent)  
        {  
            System.exit(0);  
        }  
  
    });  
    }  
  
} 