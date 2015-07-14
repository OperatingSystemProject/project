/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduler;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author hp pc
 */
public class ProcessView extends javax.swing.JPanel {
    private Process process;    
    private Color color;    
    Timer timer; 
    int a=1;
    /**
     * Creates new form ProcessMiddleView
     */
    public ProcessView(Color color , String processName){
        initComponents();
        this.color=color;
        this.jLabel2.setText(processName);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(3090, 42); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void run(int quantum){ //quantum = the number of the quantum
        JLabel current=cellList.get(quantum);
        JLabel previous=cellList.get(quantum-1);
        int currentX=current.getX();
        int currentY=current.getY();
        int previousX=previous.getX();
        if(previousX!=currentX){
            previous.setLocation(current.getLocation());
        }
        current.setBackground(color);   
        timer=  new Timer(1000*Scheduler.quantumSize/32,new ActionListener() {                        
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            while(!Scheduler.status.equals("play")){
                            }
                            current.setLocation(current.getX()+1,currentY);
                            if(current.getX()==currentX+36){
                                Scheduler.CURRENT_PROCESS_STATUS="stopped";                                
                                timer.stop();
                            }
                        }
                    });
        timer.start();
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cellList=new java.util.ArrayList<JLabel>();
        

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/process_middle.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 3090, 42);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Process ID");
        add(jLabel2);
        jLabel2.setBounds(10, 5, 140, 30);

        
        
        int x=118;
        for(int i=0;i<81;i++){
			JLabel label=new JLabel();
			label.setBackground(new java.awt.Color(255, 255, 255));
			label.setOpaque(true);
			add(label);
			label.setBounds(x, 4, 32, 35);
			cellList.add(label);
			x+=36;
		}
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private java.util.ArrayList<JLabel> cellList;
    // End of variables declaration//GEN-END:variables
}