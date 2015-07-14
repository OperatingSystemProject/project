/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduler;

import Scheduler.Process;
import java.util.ArrayList;

/**
 *
 * @author hp pc
 */
public class ProcessQueue{
    ArrayList<Process> processQueue;
    ArrayList<Process> tempProcessQueue;

    public ProcessQueue() {
        this.processQueue = new ArrayList<Process>();
    }
    
    public boolean enqueue(Process process){        
        return processQueue.add(process);
    }
    public Process dequeue(){
        if(size()!= 0){
            return processQueue.remove(0);
        }
        else{
            return null;
        }        
    }
    
    public int size(){
        return processQueue.size();
    }
    public Process get(int i){
        return processQueue.get(i);
    }
    public void sort(){
        processQueue.sort(null);
    }
    public boolean isEmpty(){
        return size()==0;
    }
    public Process peek(){
        return processQueue.get(0);
    }
}
