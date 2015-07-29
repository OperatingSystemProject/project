/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduler;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author hp pc
 */
public class Process implements Comparable<Process>{
    private final int SECOND_SCALE=1000; //number of milliseconds(True Time) in a second(Simulation Time)
    private String processId;
    private int arrivalTime;
    private int serviceTime;
    private ArrayList<Integer> ioWaitingList;
    private String status;
    private int timeRan=0;
    private ProcessView view;
    private Color color;
    

    public Process() {
    }
    public Process(String processId, int arrivalTime, int serviceTime, ArrayList<Integer> ioWaitingList, ProcessView view, String status,Color color) {
        this.processId = processId;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.ioWaitingList = ioWaitingList;
        this.status = status;
        this.view=view;
        this.color=color;
    }

    public ProcessView getView() {
        return view;
    }
    public void run(int quantum){
        view.run(quantum);
        timeRan++;
        if(timeRan==serviceTime){
           this.setStatus("finished");
        }else if(ioWaitingList.contains(timeRan)){
            this.setStatus("I/O Waiting");
        }
        
    }
    public void setView(ProcessView view) {
        this.view = view;
    }
    
    public ArrayList<Integer> getIoWaitingList() {
        return ioWaitingList;
    }

    public void setIoWaitingList(ArrayList<Integer> ioWaitingList) {
        this.ioWaitingList = ioWaitingList;
    }

    public int getTimeRan() {
        return timeRan;
    }
    
    public void setTimeRan(int timeRan) {
        this.timeRan = timeRan;
    }

    

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int compareTo(Process o) {
        if(this.arrivalTime<o.arrivalTime) return -1;
        else if(this.arrivalTime>o.arrivalTime) return 1;
        else return 0;
    }
    
    
}
