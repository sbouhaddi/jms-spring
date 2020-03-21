/**
 * 
 */
package com.sbouhaddi.sbjms.model;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bouhaddisabri
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HelloWorldMessage implements Serializable {
	
	private static final long serialVersionUID = -4601348110539848384L;
	private UUID id;
	private String message;

}
