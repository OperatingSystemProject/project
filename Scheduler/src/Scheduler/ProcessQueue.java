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
public class ProcessQueue{
    ArrayList<Process> processQueue;

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
}
