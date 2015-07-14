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
import javax.swing.Timer;

/**
 *
 * @author hp pc
 */
public class Scheduler implements ActionListener{
    public static String status="stop"; // play, pause, stop
    private ProcessQueue processQueue;
    private ProcessQueue ioQueue=new ProcessQueue();
    public static int quantumSize=1;
    public static String CURRENT_PROCESS_STATUS="stopped";
    private ProcessQueue runningQueue=new ProcessQueue();
    private int q=1;
    private int currentQuantum=0;
    Timer timer;

    public Scheduler() {      
        timer=new Timer(quantumSize*2000, this);
    }
    public Scheduler(ProcessQueue processQueue) {
        this.processQueue=processQueue;
        timer=new Timer(quantumSize*1000, this);        
    }
    public Scheduler(ProcessQueue processQueue,int q){
        this.processQueue=processQueue;
        this.q=q;
        timer=new Timer(quantumSize*1000, this);
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
            if(!timer.isRunning()){
                timer.start();
            }           
        }
    }   
    public void pause(){
        status="pause";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // All the processes are in the processQueue (sorted according to the arrival time)
        //Each process has its view(gui) and you can call run method of the view to paint the relevant time quantum of that process    
        
        while(CURRENT_PROCESS_STATUS.equals("running")){            
        }
        CURRENT_PROCESS_STATUS="running";
        
        Process currentProcess=null;
        if(runningQueue.size()>0){
            currentProcess=runningQueue.dequeue();            
            if(currentProcess.getIoWaitingList().contains(currentProcess.getTimeRan()+1)){
                ioQueue.enqueue(currentProcess);
            }
            currentProcess.run(currentQuantum);                 
        }else{
            CURRENT_PROCESS_STATUS="stopped";
        }            
        while(!processQueue.isEmpty() && processQueue.peek().getArrivalTime()==currentQuantum){
            runningQueue.enqueue(processQueue.dequeue());
        }
        if(currentProcess!=null && currentProcess.getTimeRan()+1 != currentProcess.getServiceTime()){
            runningQueue.enqueue(currentProcess);
        }
        currentQuantum++;
        if(runningQueue.size()>0 || processQueue.size()>0 || ioQueue.size()>0){ 
            CURRENT_PROCESS_STATUS="stopped";
        }else{
            timer.stop();
        }
    }
}
