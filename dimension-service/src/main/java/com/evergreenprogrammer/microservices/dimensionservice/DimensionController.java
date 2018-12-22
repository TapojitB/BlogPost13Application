/**
 * 
 */
package com.evergreenprogrammer.microservices.dimensionservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author TapojitBhattacharya
 *
 */
@RestController
public class DimensionController {

	
	@Autowired
	private Dimension dimension;

	private Logger logger = LoggerFactory.getLogger(DimensionController.class);

	@HystrixCommand(fallbackMethod = "retrieveDimensionFallBack")
	@GetMapping("/dimensions")
	public Dimension retrieveDimension() {
		return new Dimension(dimension.getLength(), dimension.getBreadth(), dimension.getHeight());

	}

	public Dimension retrieveDimensionFallBack() {
		logger.info("DimensionController.retrieveDimensionFallBack---> {}");
		return new Dimension(0, 0, 0);

	}

}
