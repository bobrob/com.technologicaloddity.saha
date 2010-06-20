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
package com.technologicaloddity.saha.ajax;

import java.util.HashMap;
import java.util.Map;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.technologicaloddity.saha.dao.MetadataDao;
import com.technologicaloddity.saha.model.Metadata;
import com.technologicaloddity.saha.util.AjaxService;

/**
 * @author Bob Robinson, http://technologicaloddity.com
 *
 */
@Service
@RemoteProxy(name="AjaxTestService")
public class AjaxTestService extends AjaxService {
	
	@Autowired
	private MetadataDao metadataDao;
	
	@RemoteMethod
	public Map<String,String> showHibernateTest(String viewName) {
		Map<String,String> result = new HashMap<String,String>();
		try {
			Metadata nameMetadata = metadataDao.getNameMetadata();
			ModelAndView modelAndView = new ModelAndView(viewName);
			modelAndView.addObject("nameMetadata", nameMetadata);
			result.put("content", render(modelAndView));
		} catch(Exception e) {
			result.put("content", "Rendering error:" + e.getMessage());
		}
		return result;
	}
	
	@RemoteMethod
	public Map<String,String> showContentPage(String viewName) {
		Map<String,String> result = new HashMap<String,String>();
		try {
			ModelAndView modelAndView = new ModelAndView(viewName);
			result.put("content", render(modelAndView));
		} catch(Exception e) {
			result.put("content", "Could not render page:" + e.getMessage());
		}
		return result;
	}
	
	@RemoteMethod
	public Map<String,String> removeName() {
		Map<String,String> result = new HashMap<String,String>();
		
		ModelAndView modelAndView = new ModelAndView("nameCleared");
		try {
			Metadata nameMetadata = metadataDao.getNameMetadata();
			if(nameMetadata.getId() != null) {
				metadataDao.delete(nameMetadata);
			}
			nameMetadata = metadataDao.getNameMetadata(); // get the fake one back for the model
			modelAndView.addObject("nameMetadata", nameMetadata);
			result.put("welcome", render(modelAndView));
		} catch(Exception e) {
			result.put("welcome", "Error removing name:" + e.getMessage());
		}
		return result;		
	}
	
	@RemoteMethod
	public Map<String,String> storeName(String newName) {
		Map<String,String> result = new HashMap<String,String>();
		
		ModelAndView modelAndView = new ModelAndView("nameSaved");
		try {
			Metadata nameMetadata = metadataDao.getNameMetadata();
			nameMetadata.setMetavalue(newName);
			metadataDao.saveOrUpdate(nameMetadata);
			modelAndView.addObject("nameMetadata", nameMetadata);
			result.put("welcome", render(modelAndView));
			addJavascriptAfterRender(result, "alert('Your name was saved to the database!');");
		} catch(Exception e) {
			result.put("welcome", "Error storing name:" + e.getMessage());
		}
		return result;
	}
	
	@RemoteMethod
	public String getServiceName() {
		return "AjaxTestService";
	}
	
	@RemoteMethod
	public Map<String,String> showMultiplicationTable(int targetNumber) {
		Map<String,String> result = new HashMap<String,String>();

		ModelAndView modelAndView = new ModelAndView("multiplicationTable");
		try {
			modelAndView.addObject("targetNumber", targetNumber);
			result.put("multiplicationTable", render(modelAndView));
		} catch(Exception e) {
			result.put("multiplicationTable", "Error generating table:" + e.getMessage());
		}
		return result;
	}
}
