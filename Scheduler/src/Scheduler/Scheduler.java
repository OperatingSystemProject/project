
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author hp pc
 */
public class Scheduler implements ActionListener{
    public static String status="stop"; // play, pause, stop
    private ProcessQueue processQueue;
    private ProcessQueue ioQueue=new ProcessQueue();    
    public static String CURRENT_PROCESS_STATUS="stopped";
    private ProcessQueue readyQueue=new ProcessQueue();
    private int timeQuantum=2;
//    private int q=1;
    private int curentTimeSlot=0;
//    Timer timer;

    public Scheduler() {         
        //timer=new Timer(quantumSize*2000, this);
    }
    public Scheduler(ProcessQueue processQueue) {
//        this.processQueue=processQueue;
//        timer=new Timer(quantumSize*1000, this);        
    }
    public Scheduler(ProcessQueue processQueue,int q){
//        this.processQueue=processQueue;
//        this.q=q;
//        timer=new Timer(quantumSize*1000, this);
    }

    public ProcessQueue getProcessQueue() {
        return processQueue;
    }

    public void setProcessQueue(ProcessQueue processQueue) {
        this.processQueue = processQueue;        
    }
    public void play(){
        if(!status.equals("play")){
            status="play";
//            if(!timer.isRunning()){
//                timer.start();
//            }           
        }
    }   
    public void pause(){
        status="pause";
    }
    Thread thread=new Thread(new Runnable() {

        @Override
        public void run() {
            while(!processQueue.isEmpty() && processQueue.peek().getArrivalTime() == curentTimeSlot){
                readyQueue.enqueue(processQueue.dequeue());
            }
            while(true){  
                System.out.println(status);
                if(status.equals("play")){                    
                    while(CURRENT_PROCESS_STATUS.equals("running")){ 
                        System.out.println("  ");
                    }
                    Process currentProcess=null;
                    
                    if(readyQueue.size()!=0){
                        
                        currentProcess=readyQueue.dequeue();
                        if(!currentProcess.getIoWaitingList().isEmpty() && currentProcess.getTimeRan() == currentProcess.getIoWaitingList().get(0)){
                            ioQueue.enqueue(currentProcess);
                            currentProcess.getIoWaitingList().remove(0);
                            currentProcess = null;
                        }
                        if(currentProcess != null){                            
                            for(int i=0; i<timeQuantum;i++){
                                while(CURRENT_PROCESS_STATUS.equals("running")){                                    
                                }
                                CURRENT_PROCESS_STATUS="running";
                                currentProcess.run(curentTimeSlot+1);
                                curentTimeSlot++;
                                if(currentProcess.getStatus().equals("finished")){
                                    break;
                                }
                                if(!currentProcess.getIoWaitingList().isEmpty() && currentProcess.getTimeRan() == currentProcess.getIoWaitingList().get(0)){
                                    ioQueue.enqueue(currentProcess);
                                    currentProcess.getIoWaitingList().remove(0);
                                    currentProcess = null;
                                    break;
                                }                                
                                while(!processQueue.isEmpty() && processQueue.peek().getArrivalTime() == curentTimeSlot){
                                    readyQueue.enqueue(processQueue.dequeue());
                                }
                                
                            }
                            
                        }                       
                    }else{
                        try {
                            thread.sleep(1000);
                            curentTimeSlot++;
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Scheduler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    while(!processQueue.isEmpty() && processQueue.peek().getArrivalTime() == curentTimeSlot){
                        readyQueue.enqueue(processQueue.dequeue());
                    }
                    
                    if(currentProcess!=null && !currentProcess.getStatus().equals("finished")){
                            readyQueue.enqueue(currentProcess);
                    }  
                    
                }
            }
        }
    });
    public void startScheduling(){
        thread.start();
    }

    public ProcessQueue getIoQueue() {
        return ioQueue;
    }

    public ProcessQueue getReadyQueue() {
        return readyQueue;
    }

    public void setTimeQuantum(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // All the processes are in the processQueue (sorted according to the arrival time)
        //Each process has its view(gui) and you can call run method of the view to paint the relevant time quantum of that process    
                
    }
}

