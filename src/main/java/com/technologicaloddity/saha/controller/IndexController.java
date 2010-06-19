/**
 * (c) 2010 Technological Oddity
 *     http://technologicaloddity.com
 *
 * I, Bob Robinson, the author of this work hereby release it
 * under the Creative Commons-By Attribution 3.0 license for
 * both commercial and non-commercial purposes.
 * See the license at:
 * http://creativecommons.org/licenses/by/3.0/
 */
package com.technologicaloddity.saha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.technologicaloddity.saha.dao.MetadataDao;
import com.technologicaloddity.saha.model.Metadata;

/**
 * @author Bob Robinson, http://technologicaloddity.com
 *
 */
@Controller
public class IndexController {

	@Autowired
	private MetadataDao metadataDao;
	
	@RequestMapping("/index.html")
	public ModelAndView handleRequest(Model model) {
		Metadata nameMetadata = metadataDao.getNameMetadata();
		
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("nameMetadata", nameMetadata);
		return modelAndView;
	}
	
}
