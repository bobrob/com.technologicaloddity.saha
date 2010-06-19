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

import java.io.StringWriter;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.directwebremoting.util.SwallowingHttpServletResponse;
import org.springframework.beans.PropertyAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.tags.NestedPathTag;
import org.springframework.web.servlet.tags.form.FormTag;

/**
 * @author Bob Robinson, http://technologicaloddity.com
 *
 */
@Component
public class AjaxPageRendererImpl implements SpringAwareAjaxPageRenderer {
	@Autowired
	private LocaleResolver localeResolver;
	@Autowired
	private ViewResolver viewResolver;

	public String render(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) {
		String result = null;

		StringWriter sout = new StringWriter();
		StringBuffer buffer = sout.getBuffer();

		HttpServletResponse fakeResponse = new SwallowingHttpServletResponse(response, sout, response.getCharacterEncoding());

		Locale locale = this.localeResolver.resolveLocale(request);
		fakeResponse.setLocale(locale);

		request.setAttribute(DispatcherServlet.LOCALE_RESOLVER_ATTRIBUTE, this.localeResolver);
		try {
			View view = viewResolver.resolveViewName(modelAndView.getViewName(), locale);
			view.render(modelAndView.getModel(), request, fakeResponse);
			result = buffer.toString();
		} catch(Exception e) {
			result = "Ajax render error:" + e.getMessage();
		}
		return result;
	}
	
	public String renderWithNestedModel(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response, String nestedModelAttributeName) {
		request.setAttribute(FormTag.MODEL_ATTRIBUTE_VARIABLE_NAME, nestedModelAttributeName);
		request.setAttribute(NestedPathTag.NESTED_PATH_VARIABLE_NAME, nestedModelAttributeName+PropertyAccessor.NESTED_PROPERTY_SEPARATOR);
		return render(modelAndView, request, response);
	}

}
