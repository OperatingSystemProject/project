/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduler;

import java.util.ArrayList;

/**
 *
 * @author hp pc
 */
public class ProcessDetail {
    private final int SECOND_SCALE=1000; //number of milliseconds(True Time) in a second(Simulation Time)
    private String processId;
    private int arrivalTime;
    private int serviceTime;
    private ArrayList<IOWaiting> ioWaitingList;
    private int status;
    private int timeRan;

    public ProcessDetail() {
    }
    public ProcessDetail(String processId, int arrivalTime, int serviceTime, ArrayList<IOWaiting> ioWaitingList, int status) {
        this.processId = processId;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.ioWaitingList = ioWaitingList;
        this.status = status;
    }
    
    public ArrayList<IOWaiting> getIoWaitingList() {
        return ioWaitingList;
    }

    public void setIoWaitingList(ArrayList<IOWaiting> ioWaitingList) {
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

    public ArrayList<IOWaiting> getIoInterrupts() {
        return ioWaitingList;
    }

    public void setIoInterrupts(ArrayList<IOWaiting> ioInterrupts) {
        this.ioWaitingList = ioInterrupts;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
