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
package com.technologicaloddity.saha.util;

import java.util.Map;

import javax.servlet.http.*;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Bob Robinson, http://technologicaloddity.com
 *
 */
public abstract class AjaxService {

	@Autowired
	private SpringAwareAjaxPageRenderer ajaxPageRenderer;
	
	public String render(ModelAndView modelAndView) throws Exception {
		
		return ajaxPageRenderer.render(modelAndView, getRequest(), getResponse());
		
	}
	
	public String renderWithSpringModel(ModelAndView modelAndView, String nestedModelName) throws Exception {
		
		return ajaxPageRenderer.renderWithNestedModel(modelAndView, getRequest(), getResponse(), nestedModelName);
	}
	
	public void addJavascriptAfterRender(Map<String,String> result, String javascript) {
		if(result != null && javascript != null) {
			String current = result.get("javascriptAfterRender");
			if(current == null) {
				result.put("javascriptAfterRender", javascript);
			} else {
				result.put("javascriptAfterRender", current + javascript);
			}
		}		
	}
	
	public HttpServletRequest getRequest() {
		WebContext webContext = WebContextFactory.get();
		return webContext.getHttpServletRequest();
	}
	
	public HttpServletResponse getResponse() {
		WebContext webContext = WebContextFactory.get();
		return webContext.getHttpServletResponse();
	}

	public HttpSession getSession() {
		WebContext webContext = WebContextFactory.get();
		return webContext.getSession();
	}	
	
}
