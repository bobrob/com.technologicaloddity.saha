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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

/**
 * @author Bob Robinson, http://technologicaloddity.com
 *
 */
public interface SpringAwareAjaxPageRenderer extends AjaxPageRenderer {

	String renderWithNestedModel(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response, String nestedModelAttributeName) throws Exception;
	
}
