/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testdf.testdf.exception;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Kd-PC
 */
@Data
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
	
    public ErrorDetails(Date timestamp, String message, String details) {
            super();
            this.timestamp = timestamp;
            this.message = message;
            this.details = details;
    }
}
