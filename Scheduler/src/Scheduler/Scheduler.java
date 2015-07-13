/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduler;

import java.util.ArrayList;
import java.util.Queue;

/**
 *
 * @author hp pc
 */
public class Scheduler {
    public static String status; // play, pause, stop
    private ProcessQueue processQueue;
    private ProcessQueue ioQueue;

    public Scheduler(ProcessQueue processQueue) {
        this.processQueue=processQueue;
    }
    
    
}
